package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.CheezyDrive;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	public CANTalon FrontLeft, BackLeft, FrontRight, BackRight;
	public AHRS gyro;
	public Encoder leftWheelEncoder, rightWheelEncoder;

public DriveTrain(){

  FrontLeft = new CANTalon(RobotMap.FrontLeftMotor);
  BackLeft = new CANTalon(RobotMap.BackLeftMotor);
  FrontRight = new CANTalon(RobotMap.FrontRightMotor);
  BackRight = new CANTalon(RobotMap.BackRightMotor);

  //slaves back Talons to front Talons
  BackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
  BackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);

  BackRight.set(FrontRight.getDeviceID());
  BackLeft.set(FrontLeft.getDeviceID());
  
  FrontLeft.setInverted(true);
  FrontRight.setInverted(false);
  
  // gyro
  gyro = new AHRS(SerialPort.Port.kMXP);

  //encoders
  //		leftWheelEncoder = new Encoder(RobotMap.LEFT_WHEEL_ENCODER_A,RobotMap.RIGHT_WHEEL_ENCODER_B);
  //		rightWheelEncoder = new Encoder(RobotMap.RIGHT_WHEEL_ENCODER_A,RobotMap.RIGHT_WHEEL_ENCODER_B);

	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CheezyDrive());
    }


    public double getTurningConstant(){
      return RobotMap.driveTurningConstant;
    }
}
