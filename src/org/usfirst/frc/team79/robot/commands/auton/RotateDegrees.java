package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.utilities.GyroPIDOutput;
import org.usfirst.frc.team79.robot.utilities.GyroPIDSource;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateDegrees extends Command {

	double degrees;
	public PIDController gyroPID;
	private boolean grip;
	
	/**
	 * Rotates based off the angle given. Positive = right.
	 * @param degrees
	 */
	public RotateDegrees(double degrees){
		requires(Robot.driveTrain);
		this.degrees = degrees + Robot.driveTrain.getGyroAngle();
		gyroPID = new PIDController(0, 0, 0, new GyroPIDSource(), new GyroPIDOutput(), 0.01);
	}
	
	public RotateDegrees(){
		this.grip = true;
		gyroPID = new PIDController(0, 0, 0, new GyroPIDSource(), new GyroPIDOutput(), 0.01);
	}
	
	protected void initialize(){
		if(grip) degrees = ProcessGripData.getHeading() + Robot.driveTrain.getGyroAngle();
		gyroPID.setPID(SmartDashboard.getNumber("Turn P", 0), SmartDashboard.getNumber("Turn I", 0), SmartDashboard.getNumber("Turn D", 0));
		gyroPID.setContinuous();
		gyroPID.setAbsoluteTolerance(0.25);
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
		gyroPID.setSetpoint(degrees);
		gyroPID.enable();
		System.out.println("Running RotateDegrees " + degrees);
	}

	protected void execute() {
		System.out.println("Error: " + gyroPID.getError());
	}

	protected boolean isFinished() {
		boolean flag;
		flag = gyroPID.onTarget();
		if(grip && !flag) flag = Math.abs(Robot.oi.throttleStick.getY())>0.12 || Math.abs(Robot.oi.throttleStick.getX())>0.12;
		return flag;
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
