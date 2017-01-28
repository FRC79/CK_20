package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateDegrees extends CommandBase {

	double degrees;
	boolean finished;
	boolean grip;
	
	/**
	 * Rotates based off the angle given. Positive = right.
	 * @param degrees
	 */
	public RotateDegrees(double degrees){
		requires(driveTrain);
		this.degrees = degrees + driveTrain.getGyroAngle();
	}
	
	/**
	 * Rotates based off of GRIP data.
	 */
	public RotateDegrees(){
		requires(driveTrain);
		grip = true;
	}
	
	protected void initialize(){
		if(grip) degrees = SmartDashboard.getNumber("Heading to Boiler", 0) + driveTrain.getGyroAngle();
	}

	protected void execute() {
		double displacement = degrees - driveTrain.getGyroAngle();
		double speed = 0.3d * displacement;
		driveTrain.FrontLeft.set(speed);
		driveTrain.FrontRight.set(-speed);
		finished = Math.abs(displacement) < .4d;
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		driveTrain.stop();
	}

	protected void interrupted() {
		
	}

}
