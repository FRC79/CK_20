package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.PrintStream;
import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.utilities.GyroPIDOutput;
import org.usfirst.frc.team79.robot.utilities.GyroPIDSource;

public class RotateDegrees extends Command {
	double deltaDegrees;
	public PIDController gyroPID;
	private boolean grip;

	/**
	 * Rotates to the specified degree offset.
	 * @param degrees offset.
	 */
	public RotateDegrees(double degrees) {
		requires(Robot.driveTrain);
		this.deltaDegrees = (degrees + Robot.driveTrain.getGyroAngle());
		this.gyroPID = new PIDController(0.0D, 0.0D, 0.0D, new GyroPIDSource(), new GyroPIDOutput(), 0.01D);
	}

	/**
	 * Rotates based off of GRIP data.
	 */
	public RotateDegrees() {
		this.grip = true;
		this.gyroPID = new PIDController(0.0D, 0.0D, 0.0D, new GyroPIDSource(), new GyroPIDOutput(), 0.01D);
	}

	protected void initialize() {
		Robot.driveTrain.FrontLeft.enableBrakeMode(true);
		Robot.driveTrain.FrontRight.enableBrakeMode(true);
		double degrees = 0;
		if (this.grip) {
			degrees = (ProcessGripData.getHeading() + Robot.driveTrain.getGyroAngle());
		}else degrees = deltaDegrees + Robot.driveTrain.getGyroAngle();
		this.gyroPID.setPID(SmartDashboard.getNumber("Turn P", 0.0D), SmartDashboard.getNumber("Turn I", 0.0D),
				SmartDashboard.getNumber("Turn D", 0.0D));
		this.gyroPID.setContinuous();
		this.gyroPID.setAbsoluteTolerance(0.25D);
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		this.gyroPID.setSetpoint(degrees);
		this.gyroPID.enable();
		System.out.println("Running RotateDegrees " + degrees);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		boolean flag = this.gyroPID.onTarget() && Math.abs(gyroPID.get()) < .09;
		if ((this.grip) && (!flag)) {
			flag = (Math.abs(Robot.oi.throttleStick.getY()) > 0.12D)
					|| (Math.abs(Robot.oi.throttleStick.getX()) > 0.12D);
		}
		return flag;
	}

	protected void end() {
		this.gyroPID.disable();
		Robot.driveTrain.stop();
		Robot.driveTrain.FrontLeft.enableBrakeMode(false);
		Robot.driveTrain.FrontLeft.enableBrakeMode(false);
	}

	protected void interrupted() {
		this.gyroPID.disable();
		Robot.driveTrain.stop();
	}
}
