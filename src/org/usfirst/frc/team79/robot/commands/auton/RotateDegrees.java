package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.utilities.GyroPIDOutput;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateDegrees extends Command {

	double degrees;
	public PIDController gyroPID;
	
	/**
	 * Rotates based off the angle given. Positive = right.
	 * @param degrees
	 */
	public RotateDegrees(double degrees){
		requires(Robot.driveTrain);
		this.degrees = degrees + Robot.driveTrain.getGyroAngle();
		gyroPID = new PIDController(.2, 0, .2, Robot.driveTrain.gyro, new GyroPIDOutput());
	}
	
	protected void initialize(){
		gyroPID.setAbsoluteTolerance(0.5);
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		gyroPID.setSetpoint(degrees);
	}

	protected boolean isFinished() {
		return gyroPID.onTarget();
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		
	}

}
