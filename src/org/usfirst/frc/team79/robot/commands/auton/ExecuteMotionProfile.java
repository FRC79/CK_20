package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Trajectory;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class ExecuteMotionProfile extends Command {
	MotionProfileFollower left;
	MotionProfileFollower right;
	CANTalon.MotionProfileStatus lStatus;
	CANTalon.MotionProfileStatus rStatus;
	String filename;
	boolean loadFile;

	/**
	 * Executes the current motion profile stored in GenerateMotionProfile.
	 */
	public ExecuteMotionProfile() {
	}

	/**
	 * Executes the motion profile from a file on the rio.
	 * @param name
	 */
	public ExecuteMotionProfile(String name) {
		this.filename = name;
		loadFile = true;
	}

	protected void initialize() {
		if (loadFile) {
			GenerateMotionProfile.load(this.filename);
		}
		this.lStatus = new CANTalon.MotionProfileStatus();
		this.rStatus = new CANTalon.MotionProfileStatus();
		Robot.driveTrain.FrontLeft.setEncPosition(0);
		Robot.driveTrain.FrontRight.setEncPosition(0);
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
		this.left = new MotionProfileFollower(Robot.driveTrain.FrontLeft, GenerateMotionProfile.left.segments);
		this.right = new MotionProfileFollower(Robot.driveTrain.FrontRight, GenerateMotionProfile.right.segments);
		this.left.startMotionProfile();
		this.right.startMotionProfile();
		Robot.driveTrain.FrontRight.reverseOutput(true);
	}

	protected void execute() {
		this.left.control();
		this.right.control();
		Robot.driveTrain.FrontLeft.set(this.left.getSetValue().value);
		Robot.driveTrain.FrontRight.set(this.right.getSetValue().value);
	}

	protected void end() {
		this.left.reset();
		this.right.reset();
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.reverseOutput(false);
	}

	protected boolean isFinished() {
		return (this.left.isFinished()) && (this.right.isFinished());
	}
}
