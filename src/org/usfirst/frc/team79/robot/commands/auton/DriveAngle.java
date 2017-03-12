package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class DriveAngle extends PIDCommand {
	
	public Timer timer;
	public double speed;
	public double angle;
	public double time;
	public boolean useCurrent;

	/**
	 * Drive along a fixed angle for a certain time at a certain speed.
	 * @param speed Percent
	 * @param angle Degrees
	 * @param time Seconds
	 */
	public DriveAngle(double speed, double angle, double time) {
		super(0.1D, 0.0D, 0.0D, 0.001);
		this.speed = speed;
		this.angle = angle;
		this.time = time;
	}
	
	/**
	 * Drive along the current gyro angle for a certain time at a certain speed.
	 * @param speed Percent
	 * @param time Seconds
	 */
	public DriveAngle(double speed, double time){
		this(speed, 0, time);
		this.useCurrent = true;
	}

	public void initialize() {
		if(useCurrent) angle = Robot.driveTrain.getGyroAngle();
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		getPIDController().setPID(0.006, 0, 0);
		this.timer = new Timer();
		this.timer.start();
	}

	public void execute() {
		setInputRange(this.angle - 0.1D, this.angle + 0.1D);
	}

	protected boolean isFinished() {
		return this.timer.hasPeriodPassed(this.time);
	}

	protected double returnPIDInput() {
		return Robot.driveTrain.gyro.getAngle();
	}

	protected void usePIDOutput(double output) {
		double left = output > 0.0D ? this.speed + output : this.speed;
		double right = output < 0.0D ? this.speed - output : this.speed;
		left = -left;
		right = -right;
		SmartDashboard.putNumber("PID output", output);
		System.out.println(left + " " + right);
		Robot.driveTrain.FrontLeft.set(left);
		Robot.driveTrain.FrontRight.set(right);
	}
}
