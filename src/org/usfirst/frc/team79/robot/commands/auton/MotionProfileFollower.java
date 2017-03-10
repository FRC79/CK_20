package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon.TrajectoryPoint;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Segment;
import org.usfirst.frc.team79.robot.utilities.MPOutput;

public class MotionProfileFollower {
	private Trajectory.Segment[] segments;
	private CANTalon.MotionProfileStatus status = new CANTalon.MotionProfileStatus();
	private CANTalon talon;
	private int state = 0;
	private int loopTimeout = -1;
	private boolean bStart = false;
	private CANTalon.SetValueMotionProfile _setValue = CANTalon.SetValueMotionProfile.Disable;
	private static final int kMinPointsInTalon = 5;
	private static final int kNumLoopsTimeout = 10;

	class PeriodicRunnable implements Runnable {
		PeriodicRunnable() {
		}

		public void run() {
			MotionProfileFollower.this.talon.processMotionProfileBuffer();
		}
	}

	Notifier _notifer = new Notifier(new PeriodicRunnable());
	private boolean bFin = false;
	private int timeouts = 0;

	public MotionProfileFollower(CANTalon talon, Trajectory.Segment[] segments) {
		this.talon = talon;
		this.segments = segments;

		this.talon.changeMotionControlFramePeriod(25);
		this._notifer.startPeriodic(0.025D);
	}

	public void reset() {
		this.talon.clearMotionProfileTrajectories();

		this._setValue = CANTalon.SetValueMotionProfile.Disable;

		this.state = 0;
		this.loopTimeout = -1;

		this.bStart = false;
	}

	public void control() {
		this.talon.getMotionProfileStatus(this.status);
		if (this.loopTimeout >= 0) {
			if (this.loopTimeout == 0) {
				MPOutput.OnNoProgress();
			} else {
				this.loopTimeout -= 1;
			}
		}
		if (this.talon.getControlMode() != CANTalon.TalonControlMode.MotionProfile) {
			this.state = 0;
			this.loopTimeout = -1;
		} else {
			switch (this.state) {
			case 0:
				if (this.bStart) {
					this.bStart = false;

					this._setValue = CANTalon.SetValueMotionProfile.Disable;
					startFilling();

					this.state = 1;
					this.loopTimeout = 10;
				}
				break;
			case 1:
				if (this.status.btmBufferCnt > 5) {
					this._setValue = CANTalon.SetValueMotionProfile.Enable;

					this.state = 2;
					this.loopTimeout = 10;
				}
				break;
			case 2:
				if (!this.status.isUnderrun) {
					this.loopTimeout = 10;
				}
				if ((this.status.activePointValid) && (this.status.activePoint.isLastPoint)) {
					this._setValue = CANTalon.SetValueMotionProfile.Hold;
					this.state = 0;
					this.loopTimeout = -1;
					this.bFin = true;
				}
				break;
			}
		}
		MPOutput.process(this.status);
	}

	private void startFilling() {
		CANTalon.TrajectoryPoint point = new CANTalon.TrajectoryPoint();
		if (this.status.hasUnderrun) {
			MPOutput.OnUnderrun();

			this.talon.clearMotionProfileHasUnderrun();
		}
		this.talon.clearMotionProfileTrajectories();
		for (int i = 0; i < this.segments.length; i++) {
			point.position = (this.segments[i].position * 3.280841666666667D / 1.0471975511965976D);
			point.velocity = (this.segments[i].velocity * 3.280841666666667D / 1.0471975511965976D * 60.0D);
			point.timeDurMs = ((int) (this.segments[i].dt * 1000.0D));
			point.profileSlotSelect = 0;
			point.velocityOnly = false;
			point.zeroPos = false;
			if (i == 0) {
				point.zeroPos = true;
			}
			point.isLastPoint = false;
			if (i + 1 == this.segments.length) {
				point.isLastPoint = true;
			}
			this.talon.pushMotionProfileTrajectory(point);
		}
	}

	public void startMotionProfile() {
		this.bStart = true;
		this.bFin = false;
		this.timeouts = 0;
	}

	public boolean isFinished() {
		return this.bFin;
	}

	public int getTimeoutCnt() {
		return this.timeouts;
	}

	public CANTalon.SetValueMotionProfile getSetValue() {
		return this._setValue;
	}
}
