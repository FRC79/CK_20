package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class DriveStraight extends CommandBase {
	
	private double k = 1.0;
	private double speed;
	
	public DriveStraight(double time) {
		requires(arcadeDrive);
		requires(gyro);

		setTimeout(time);
		this.speed = 1;
	}
	
	public DriveStraight(double time, double speed) {
		
		requires(arcadeDrive);
		requires(gyro);

		setTimeout(time);
		this.speed = speed;
		
	}

	protected void initialize() {
		
	}

	protected void execute() {
		arcadeDrive.arcadeDrive(speed, -k * gyro.getNormalAngle());
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		arcadeDrive.arcadeDrive(0, 0);
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
