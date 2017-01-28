package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateDegrees extends Command {

	double degrees;
	boolean finished;
	boolean grip;
	
	/**
	 * Rotates based off the angle given. Positive = right.
	 * @param degrees
	 */
	public RotateDegrees(double degrees){
		requires(Robot.driveTrain);
		this.degrees = degrees + Robot.driveTrain.getGyroAngle();
	}
	
	/**
	 * Rotates based off of GRIP data.
	 */
	public RotateDegrees(){
		requires(Robot.driveTrain);
		grip = true;
	}
	
	protected void initialize(){
		if(grip) degrees = SmartDashboard.getNumber("Heading to Boiler", 0) + Robot.driveTrain.getGyroAngle();
	}

	protected void execute() {
		double displacement = degrees - Robot.driveTrain.getGyroAngle();
		double speed = 0.3d * displacement;
		Robot.driveTrain.FrontLeft.set(speed);
		Robot.driveTrain.FrontRight.set(-speed);
		finished = Math.abs(displacement) < .4d;
	}

	protected boolean isFinished() {
		return finished;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		
	}

}
