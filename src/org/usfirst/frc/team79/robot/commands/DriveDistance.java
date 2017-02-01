package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{

	public double distance;
	
	/**
	 * Drives a distance in feet.
	 * @param distance in feet.
	 */
	public DriveDistance(double distance){
		this.distance = distance;
	}
	
	protected void initialize(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontLeft.setPosition(0);
		Robot.driveTrain.FrontRight.setPosition(0);
	}
	
	protected void execute(){
		System.out.println("Hey. I'm executing drive distance code.");
		Robot.driveTrain.FrontLeft.set(distance/RobotMap.WHEEL_CIRCUMFERENCE);
		Robot.driveTrain.FrontRight.set(distance/RobotMap.WHEEL_CIRCUMFERENCE);
	}
	
	public void end(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
	    Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
