package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.utilities.GyroPIDOutput;
import org.usfirst.frc.team79.robot.utilities.GyroPIDSource;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
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
		Robot.driveTrain.gyro.zeroYaw(); //Temporary for testing
		this.degrees = degrees + Robot.driveTrain.getGyroAngle();
		gyroPID = new PIDController(0, 0, 0, new GyroPIDSource(), new GyroPIDOutput());
		}
	
	protected void initialize(){
		System.out.println("Initializing command");
		gyroPID.setPID(SmartDashboard.getNumber("Turn P", 0), SmartDashboard.getNumber("Turn I", 0), SmartDashboard.getNumber("Turn D", 0));
		gyroPID.setContinuous();
		gyroPID.setAbsoluteTolerance(0.9);
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
		gyroPID.setSetpoint(degrees);
		gyroPID.enable();
	}

	protected void execute() {
		System.out.println("Running command");
	}

	protected boolean isFinished() {
		return gyroPID.onTarget();
	}

	protected void end() {
		gyroPID.disable();
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		gyroPID.disable();
		Robot.driveTrain.stop();
	}

}
