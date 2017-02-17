package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.utilities.MPOutput;
import org.usfirst.frc.team79.robot.utilities.Units;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Trajectory.Segment;
import jaci.pathfinder.modifiers.TankModifier;

import com.ctre.CANTalon.TalonControlMode;

public class MotionProfileFollower {
	
	private Segment[] segments;

	/**
	 * The status of the motion profile executer and buffer inside the Talon.
	 * Instead of creating a new one every time we call getMotionProfileStatus,
	 * keep one copy.
	 */
	private CANTalon.MotionProfileStatus status = new CANTalon.MotionProfileStatus();
	
	/**
	 * reference to the talon we plan on manipulating. We will not changeMode()
	 * or call set(), just get motion profile status and make decisions based on
	 * motion profile.
	 */
	private CANTalon talon;
	/**
	 * State machine to make sure we let enough of the motion profile stream to
	 * talon before we fire it.
	 */
	private int state = 0;
	/**
	 * Any time you have a state machine that waits for external events, its a
	 * good idea to add a timeout. Set to -1 to disable. Set to nonzero to count
	 * down to '0' which will print an error message. Counting loops is not a
	 * very accurate method of tracking timeout, but this is just conservative
	 * timeout. Getting time-stamps would certainly work too, this is just
	 * simple (no need to worry about timer overflows).
	 */
	private int loopTimeout = -1;
	/**
	 * If start() gets called, this flag is set and in the control() we will
	 * service it.
	 */
	private boolean bStart = false;

	/**
	 * Since the CANTalon.set() routine is mode specific, deduce what we want
	 * the set value to be and let the calling module apply it whenever we
	 * decide to switch to MP mode.
	 */
	private CANTalon.SetValueMotionProfile _setValue = CANTalon.SetValueMotionProfile.Disable;
	/**
	 * How many trajectory points do we wait for before firing the motion
	 * profile.
	 */
	private static final int kMinPointsInTalon = 5;
	/**
	 * Just a state timeout to make sure we don't get stuck anywhere. Each loop
	 * is about 20ms.
	 */
	private static final int kNumLoopsTimeout = 10;
	
	/**
	 * Lets create a periodic task to funnel our trajectory points into our talon.
	 * It doesn't need to be very accurate, just needs to keep pace with the motion
	 * profiler executer.  Now if you're trajectory points are slow, there is no need
	 * to do this, just call this.talon.processMotionProfileBuffer() in your teleop loop.
	 * Generally speaking you want to call it at least twice as fast as the duration
	 * of your trajectory points.  So if they are firing every 20ms, you should call 
	 * every 10ms.
	 */
	class PeriodicRunnable implements java.lang.Runnable {
	    public void run() {  talon.processMotionProfileBuffer();    }
	}
	Notifier _notifer = new Notifier(new PeriodicRunnable());
	
	private boolean bFin = false;
	private int timeouts = 0;
	

	/**
	 * C'tor
	 * 
	 * @param talon
	 *            reference to Talon object to fetch motion profile status from.
	 */
	public MotionProfileFollower(CANTalon talon, Segment[] segments) {
		this.talon = talon;
		this.segments = segments;
		/*
		 * since our MP is 10ms per point, set the control frame rate and the
		 * notifer to half that
		 */
		this.talon.changeMotionControlFramePeriod(25);
		_notifer.startPeriodic(0.025);
	}

	/**
	 * Called to clear Motion profile buffer and reset state info during
	 * disabled and when Talon is not in MP control mode.
	 */
	public void reset() {
		/*
		 * Let's clear the buffer just in case user decided to disable in the
		 * middle of an MP, and now we have the second half of a profile just
		 * sitting in memory.
		 */
		this.talon.clearMotionProfileTrajectories();
		/* When we do re-enter motionProfile control mode, stay disabled. */
		_setValue = CANTalon.SetValueMotionProfile.Disable;
		/* When we do start running our state machine start at the beginning. */
		state = 0;
		loopTimeout = -1;
		/*
		 * If application wanted to start an MP before, ignore and wait for next
		 * button press
		 */
		bStart = false;
	}

	/**
	 * Called every loop.
	 */
	public void control() {
		/* Get the motion profile status every loop */
		this.talon.getMotionProfileStatus(status);

		/*
		 * track time, this is rudimentary but that's okay, we just want to make
		 * sure things never get stuck.
		 */
		if (loopTimeout < 0) {
			/* do nothing, timeout is disabled */
		} else {
			/* our timeout is nonzero */
			if (loopTimeout == 0) {
				/*
				 * something is wrong. Talon is not present, unplugged, breaker
				 * tripped
				 */
				MPOutput.OnNoProgress();
			} else {
				--loopTimeout;
			}
		}

		/* first check if we are in MP mode */
		if (this.talon.getControlMode() != TalonControlMode.MotionProfile) {
			/*
			 * we are not in MP mode. We are probably driving the robot around
			 * using gamepads or some other mode.
			 */
			state = 0;
			loopTimeout = -1;
		} else {
			/*
			 * we are in MP control mode. That means: starting Mps, checking Mp
			 * progress, and possibly interrupting MPs if thats what you want to
			 * do.
			 */
			switch (state) {
				case 0: /* wait for application to tell us to start an MP */
					if (bStart) {
						bStart = false;
	
						_setValue = CANTalon.SetValueMotionProfile.Disable;
						startFilling();
						/*
						 * MP is being sent to CAN bus, wait a small amount of time
						 */
						state = 1;
						loopTimeout = kNumLoopsTimeout;
					}
					break;
				case 1: /*
						 * wait for MP to stream to Talon, really just the first few
						 * points
						 */
					/* do we have a minimum numberof points in Talon */
					if (status.btmBufferCnt > kMinPointsInTalon) {
						/* start (once) the motion profile */
						_setValue = CANTalon.SetValueMotionProfile.Enable;
						/* MP will start once the control frame gets scheduled */
						state = 2;
						loopTimeout = kNumLoopsTimeout;
					}
					break;
				case 2: /* check the status of the MP */
					/*
					 * if talon is reporting things are good, keep adding to our
					 * timeout. Really this is so that you can unplug your talon in
					 * the middle of an MP and react to it.
					 */
					if (status.isUnderrun == false) {
						loopTimeout = kNumLoopsTimeout;
					}
					/*
					 * If we are executing an MP and the MP finished, start loading
					 * another. We will go into hold state so robot servo's
					 * position.
					 */
					if (status.activePointValid && status.activePoint.isLastPoint) {
						/*
						 * because we set the last point's isLast to true, we will
						 * get here when the MP is done
						 */
						_setValue = CANTalon.SetValueMotionProfile.Hold;
						state = 0;
						loopTimeout = -1;
						bFin = true;//add this to make the command finish-Joshua 1/29/17
					}
					break;
			}
		}
		/* printfs and/or logging */
		MPOutput.process(status);
	}

	/** Start filling the MPs to all of the involved Talons. */
	private void startFilling() {
		/* create an empty point */
		CANTalon.TrajectoryPoint point = new CANTalon.TrajectoryPoint();

		/* did we get an underrun condition since last time we checked ? */
		if (status.hasUnderrun) {
			/* better log it so we know about it */
			MPOutput.OnUnderrun();
			/*
			 * clear the error. This flag does not auto clear, this way 
			 * we never miss logging it.
			 */
			this.talon.clearMotionProfileHasUnderrun();
		}
		/*
		 * just in case we are interrupting another MP and there is still buffer
		 * points in memory, clear it.
		 */
		this.talon.clearMotionProfileTrajectories();

		for (int i = 0; i < segments.length; ++i) {
			point.position = segments[i].position*Units.FEET/RobotMap.WHEEL_CIRCUMFERENCE; //meters to rotations
			point.velocity = segments[i].velocity*Units.FEET/RobotMap.WHEEL_CIRCUMFERENCE*60; //meters/second to RPM
			point.timeDurMs = (int) (segments[i].dt * 1000);
			point.profileSlotSelect = 0;
			point.velocityOnly = false;
			point.zeroPos = false;
			if (i == 0)
				point.zeroPos = true;

			point.isLastPoint = false;
			if ((i + 1) == segments.length)
				point.isLastPoint = true;

			this.talon.pushMotionProfileTrajectory(point);
		}
	}

	/**
	 * Called by application to signal Talon to start the buffered MP (when it's
	 * able to).
	 */
	public void startMotionProfile() {
		bStart = true;
		bFin = false;
		timeouts = 0;
	}
	
	public boolean isFinished () {
		return bFin;
	}
	public int getTimeoutCnt () {
		return timeouts;
	}
	
	/**
	 * 
	 * @return the output value to pass to Talon's set() routine. 0 for disable
	 *         motion-profile output, 1 for enable motion-profile, 2 for hold
	 *         current motion profile trajectory point.
	 */
	public CANTalon.SetValueMotionProfile getSetValue() {
		return _setValue;
	}
}
