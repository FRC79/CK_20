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
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.Position);
	}
	
	protected void execute(){
		Robot.driveTrain.FrontLeft.set(distance/RobotMap.WHEEL_CIRCUMFERENCE);
		Robot.driveTrain.FrontRight.set(distance/RobotMap.WHEEL_CIRCUMFERENCE);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
