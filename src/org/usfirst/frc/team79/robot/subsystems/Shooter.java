package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StopShooter;

public class Shooter extends Subsystem {
	
	public CANTalon shooterWheel = new CANTalon(RobotMap.SHOOTER_MOTOR_1);
	public CANTalon shooterWheelSlave = new CANTalon(RobotMap.SHOOTER_MOTOR_2);
	public DoubleSolenoid solenoidShift = new DoubleSolenoid(RobotMap.SHIFT_SHOOTER, RobotMap.SHIFT_CLIMBER);
	public Solenoid hoodController = new Solenoid(RobotMap.HOOD_CONTROLLER);

	/**
	 * Initializes the shooter motors, hanger-shifter double solenoid, and hood solenoid.
	 */
	public Shooter() {
		this.shooterWheelSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		this.shooterWheelSlave.set(this.shooterWheel.getDeviceID());
		this.shooterWheel.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		this.shooterWheel.configEncoderCodesPerRev(RobotMap.SHOOTER_TICKS_PER_REV);
	}

	public void initDefaultCommand() {
		
	}
}
