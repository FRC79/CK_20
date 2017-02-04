package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

		public CANTalon shooterWheel = new CANTalon(RobotMap.SHOOTER_MOTOR_1);
		public CANTalon shooterWheelSlave = new CANTalon(RobotMap.SHOOTER_MOTOR_2);

    public Shooter() {
      shooterWheelSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
      shooterWheelSlave.set(shooterWheel.getDeviceID());
      shooterWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
      shooterWheel.configEncoderCodesPerRev(RobotMap.SHOOTER_TICKS_PER_REV);

    }

    public void initDefaultCommand() {

    }

}
