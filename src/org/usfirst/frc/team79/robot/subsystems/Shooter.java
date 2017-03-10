package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team79.robot.commands.StopShooter;

public class Shooter extends Subsystem {
	public CANTalon shooterWheel = new CANTalon(5);
	public CANTalon shooterWheelSlave = new CANTalon(6);
	public DoubleSolenoid solenoidShift = new DoubleSolenoid(7, 6);
	public Solenoid hoodController = new Solenoid(4);

	public Shooter() {
		this.shooterWheelSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		this.shooterWheelSlave.set(this.shooterWheel.getDeviceID());
		this.shooterWheel.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		this.shooterWheel.configEncoderCodesPerRev(1024);
	}

	public void initDefaultCommand() {
		new StopShooter();
	}
}
