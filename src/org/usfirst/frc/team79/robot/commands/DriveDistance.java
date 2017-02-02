package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{

	public double rotations;
	
	/**
	 * Drives a distance in feet.
	 * @param distance in feet.
	 */
	public DriveDistance(double distance){
		this.rotations = distance/RobotMap.WHEEL_CIRCUMFERENCE;
	}
	
	protected void initialize(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontLeft.setEncPosition(0);;
		Robot.driveTrain.FrontRight.setEncPosition(0);
		
	}
	
	protected void execute(){
		Robot.driveTrain.FrontLeft.set(rotations);
		Robot.driveTrain.FrontRight.set(rotations);
	}
	
	public void end(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
	    Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	@Override
	protected boolean isFinished() {
		double errorL = Math.abs(Robot.driveTrain.FrontLeft.getPosition()-rotations);
		double errorR = Math.abs(Robot.driveTrain.FrontRight.getPosition()-rotations);
		return false;
	}

}
