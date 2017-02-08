package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class ExecuteMotionProfile extends Command{
	
	private MotionProfileStatus lStatus = new MotionProfileStatus();
	private MotionProfileStatus rStatus = new MotionProfileStatus();
	
	public ExecuteMotionProfile(){
		requires(Robot.driveTrain);
	}
	
	protected void initialize(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.MotionProfile);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.MotionProfile);
		Robot.driveTrain.FrontLeft.set(1);
		Robot.driveTrain.FrontRight.set(1);
	}
	
	protected void execute(){
		Robot.driveTrain.FrontLeft.processMotionProfileBuffer();
		Robot.driveTrain.FrontRight.processMotionProfileBuffer();
		Robot.driveTrain.FrontLeft.getMotionProfileStatus(lStatus);
	}
	
	protected void end(){
		Robot.driveTrain.FrontLeft.set(0);
		Robot.driveTrain.FrontRight.set(0);
	}
	
	@Override
	protected boolean isFinished() {
		Robot.driveTrain.FrontLeft.getMotionProfileStatus(lStatus);
		Robot.driveTrain.FrontRight.getMotionProfileStatus(rStatus);
		return lStatus.activePoint.isLastPoint && rStatus.activePoint.isLastPoint;
	}

}
