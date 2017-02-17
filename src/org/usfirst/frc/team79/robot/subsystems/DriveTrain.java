package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.CheezyDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	public CANTalon FrontLeft, BackLeft, FrontRight, BackRight;
	public AHRS gyro;

	public DriveTrain() {

		FrontLeft = new CANTalon(RobotMap.FrontLeftMotor);
		BackLeft = new CANTalon(RobotMap.BackLeftMotor);
		FrontRight = new CANTalon(RobotMap.FrontRightMotor);
		BackRight = new CANTalon(RobotMap.BackRightMotor);

		// slaves back Talons to front Talons
		BackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		BackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		
		BackRight.set(FrontRight.getDeviceID());
		BackLeft.set(FrontLeft.getDeviceID());

		FrontLeft.setInverted(true);
		FrontRight.setInverted(false);
		
		FrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		FrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		FrontLeft.configEncoderCodesPerRev(RobotMap.TICKS_PER_REV);
		FrontRight.configEncoderCodesPerRev(RobotMap.TICKS_PER_REV);
		FrontRight.setProfile(0);
		FrontLeft.setProfile(0);
		FrontLeft.reverseSensor(true);
		FrontRight.reverseSensor(false);
		
		FrontLeft.clearMotionProfileTrajectories();
		FrontRight.clearMotionProfileTrajectories();

		// gyro
		gyro = new AHRS(SerialPort.Port.kMXP);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheezyDrive());
	}

	// gyros

	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public double getNormalAngle() {
		return ((gyro.getAngle() % 360) / 360);
	}

	public void resetGyro() {
		gyro.reset();
	}

	public double pidValue() {

		double gyroRead = getGyroAngle() % 360;
		double returnValue;

		if (gyroRead < -180D) {
			returnValue = 360D + gyroRead;
		} else if (gyroRead > 180D) {
			returnValue = -360D + gyroRead;
		} else {
			returnValue = gyroRead;
		}

		return returnValue / 180;

	}

	// driveTrain

	public void stop() {
		FrontLeft.set(0);
		FrontRight.set(0);
	}

	public void arcadeDrive(Joystick stick) {
		arcadeDrive(stick);
	}

	public void arcadeDrive(double x, double y) {
		arcadeDrive(x, y);
	}

	public double maxSpeed(double speed) {
		return speed > 0.8 ? 0.8 : speed;
	}

	public void arcadeDriveScaled(Joystick joy) {
		arcadeDriveScaled(joy.getX(), joy.getY(), 1.0);
	}

	public void arcadeDriveScaled(Joystick joy, double scalar) {
		arcadeDriveScaled(joy.getX(), joy.getY(), scalar);
	}

	public void arcadeDriveScaled(double x, double y, double scalar) {
		if (scalar > 1) {
			scalar = 1;
		}
		arcadeDrive((x * scalar), (y * scalar));
	}

	public double getTurningConstant() {
		return RobotMap.driveTurningConstant;
	}
}
