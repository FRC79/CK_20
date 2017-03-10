package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team79.robot.commands.CheezyDrive;

public class DriveTrain extends Subsystem {
	public CANTalon FrontLeft;
	public CANTalon BackLeft;
	public CANTalon FrontRight;
	public CANTalon BackRight;
	public AHRS gyro;

	public DriveTrain() {
		this.FrontLeft = new CANTalon(1);
		this.BackLeft = new CANTalon(3);
		this.FrontRight = new CANTalon(2);
		this.BackRight = new CANTalon(4);

		this.BackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		this.BackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);

		this.BackRight.set(this.FrontRight.getDeviceID());
		this.BackLeft.set(this.FrontLeft.getDeviceID());

		this.FrontLeft.setInverted(true);
		this.FrontRight.setInverted(false);

		this.FrontLeft.enableBrakeMode(false);
		this.FrontRight.enableBrakeMode(false);
		this.FrontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		this.FrontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		this.FrontLeft.configEncoderCodesPerRev(360);
		this.FrontRight.configEncoderCodesPerRev(360);
		this.FrontRight.setProfile(0);
		this.FrontLeft.setProfile(0);
		this.FrontLeft.reverseSensor(true);
		this.FrontRight.reverseSensor(false);

		this.FrontLeft.clearMotionProfileTrajectories();
		this.FrontRight.clearMotionProfileTrajectories();

		this.gyro = new AHRS(Port.kMXP);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheezyDrive());
	}

	public double getGyroAngle() {
		return this.gyro.getAngle();
	}

	public double getNormalAngle() {
		return this.gyro.getAngle() % 360.0D / 360.0D;
	}

	public void resetGyro() {
		this.gyro.reset();
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

	public void stop() {
		this.FrontLeft.set(0.0D);
		this.FrontRight.set(0.0D);
	}

	public void arcadeDrive(Joystick stick) {
		arcadeDrive(stick);
	}

	public void arcadeDrive(double x, double y) {
		arcadeDrive(x, y);
	}

	public double maxSpeed(double speed) {
		return speed > 0.8D ? 0.8D : speed;
	}

	public void arcadeDriveScaled(Joystick joy) {
		arcadeDriveScaled(joy.getX(), joy.getY(), 1.0D);
	}

	public void arcadeDriveScaled(Joystick joy, double scalar) {
		arcadeDriveScaled(joy.getX(), joy.getY(), scalar);
	}

	public void arcadeDriveScaled(double x, double y, double scalar) {
		if (scalar > 1.0D) {
			scalar = 1.0D;
		}
		arcadeDrive(x * scalar, y * scalar);
	}

	public double getTurningConstant() {
		return 0.6D;
	}
}
