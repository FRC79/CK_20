package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class RotateDegrees extends CommandBase {

	double degrees;
	boolean finished;
	
	public RotateDegrees(double degrees){
		requires(driveTrain);
		this.degrees = degrees + driveTrain.getGyroAngle();
	}

	protected void execute() {
		double displacement = degrees - driveTrain.getGyroAngle();
		double speed = 0.3d * displacement;
		driveTrain.FrontLeft.set(speed);
		driveTrain.FrontRight.set(-speed);
		finished = Math.abs(displacement) < .2d;
	}

	protected boolean isFinished() {
		return finished; //TODO:
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
