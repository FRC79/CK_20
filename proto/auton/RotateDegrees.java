package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class RotateDegrees extends CommandBase {

	double degrees;
	
	public RotateDegrees(double degrees) {
		requires(driveTrain);
		this.degrees = degrees;
	}

	protected void execute() {
		//TODO:
	}

	protected boolean isFinished() {
		return false; //TODO:
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
