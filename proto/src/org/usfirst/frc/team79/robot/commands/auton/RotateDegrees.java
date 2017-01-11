package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class RotateDegrees extends CommandBase {

	double degrees;
	boolean done;
	public RotateDegrees(double degrees) {
		requires(gyro);
		requires(arcadeDrive);
		this.degrees = degrees;
	}
	
	protected void initialize() {
		
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		
		if(degrees < 0){
			arcadeDrive.arcadeDrive(0, -1);
		} else {
			arcadeDrive.arcadeDrive(0, 1);
		}
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
//		if(degrees < gyro.GetGyroAngle() + .4 && degrees > gyro.GetGyroAngle() - .4)
//		{
//			done = true;
//		}
		if(degrees < 0){
			return degrees >= gyro.GetGyroAngle();
		}else{
			return degrees <= gyro.GetGyroAngle();
		}
	}

	protected void end() {
		// TODO Auto-generated method stub
		arcadeDrive.arcadeDrive(0, 0);
		done = false;
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
