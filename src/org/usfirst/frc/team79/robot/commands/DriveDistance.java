package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{

	public double rotations;
	
	/**
	 * Drives a distance in inches.
	 * @param distance in inches.
	 */
	public DriveDistance(double distance){
		this.rotations = distance/RobotMap.WHEEL_CIRCUMFERENCE;
	}
	
	protected void initialize(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.Position);
		Robot.driveTrain.FrontLeft.setEncPosition(0);;
		Robot.driveTrain.FrontRight.setEncPosition(0);
		Robot.driveTrain.FrontRight.setAllowableClosedLoopErr(360);
		Robot.driveTrain.FrontLeft.setAllowableClosedLoopErr(360);

		
	}
	
	protected void execute(){
		Robot.driveTrain.FrontLeft.set(rotations);
		Robot.driveTrain.FrontRight.set(-rotations);
		System.out.println("Driving Distance");
	}
	
	public void end(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
	    Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	@Override
	protected boolean isFinished() {
		//return Robot.driveTrain.FrontLeft.getClosedLoopError() < 0.5;
		return false;
	}

}
