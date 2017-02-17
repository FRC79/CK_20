package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class ExecuteMotionProfile extends Command{
	
	MotionProfileFollower left;
	MotionProfileFollower right;
	
	MotionProfileStatus lStatus, rStatus;
	
	public ExecuteMotionProfile(){
		requires(Robot.driveTrain);
	}
	
	protected void initialize(){
		lStatus = new MotionProfileStatus();
		rStatus = new MotionProfileStatus();
		Robot.driveTrain.FrontLeft.setEncPosition(0);
		Robot.driveTrain.FrontRight.setEncPosition(0);
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.MotionProfile);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.MotionProfile);
		left = new MotionProfileFollower(Robot.driveTrain.FrontLeft, GenerateMotionProfile.left.segments);
		right = new MotionProfileFollower(Robot.driveTrain.FrontRight, GenerateMotionProfile.right.segments);
		left.startMotionProfile();
		right.startMotionProfile();
		Robot.driveTrain.FrontRight.reverseOutput(true);
	}
	
	protected void execute(){
		left.control();
		right.control();
		Robot.driveTrain.FrontLeft.set(left.getSetValue().value);
		Robot.driveTrain.FrontRight.set(right.getSetValue().value);
	}
	
	protected void end(){
		left.reset();
		right.reset();
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.reverseOutput(false);
	}
	
	@Override
	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
	}

}
