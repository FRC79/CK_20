package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
	private RobotDrive Drive;
	public CANTalon FrontLeft, BackLeft, FrontRight, BackRight;
	public AHRS gyro;
	public Encoder leftWheelEncoder, rightWheelEncoder;

public DriveTrain(){
		
		FrontLeft = new CANTalon(RobotMap.ForntLeftMotor);
		BackLeft = new CANTalon(RobotMap.BackLeftMotor);
	    FrontRight = new CANTalon(RobotMap.FrontRightMotor);
	    BackRight = new CANTalon(RobotMap.BackRightMotor);
	    
	    Drive = new RobotDrive(FrontLeft, FrontRight);
	    
	    //slaves back Talons to front Talons
	    //MASTA PLEASE!!!!!!!!!!!
	    BackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
    	BackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
    	
    	BackRight.set(FrontRight.getDeviceID());
    	BackLeft.set(FrontLeft.getDeviceID());
 
    	//Inverts motors
    	FrontLeft.setInverted(true);
    	FrontRight.setInverted(false);
    	
    	// gyro
		gyro = new AHRS(SerialPort.Port.kMXP);
		
		//encoders
//		leftWheelEncoder = new Encoder(RobotMap.LEFT_WHEEL_ENCODER_A,RobotMap.RIGHT_WHEEL_ENCODER_B);
//		rightWheelEncoder = new Encoder(RobotMap.RIGHT_WHEEL_ENCODER_A,RobotMap.RIGHT_WHEEL_ENCODER_B);

	}

    public void initDefaultCommand() {
    	
    }
    
    //gyros

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
	
		if(gyroRead < -180D) {
			returnValue = 360D + gyroRead;
		} else if(gyroRead > 180D) {
			returnValue = -360D + gyroRead;
		} else {
			returnValue = gyroRead;
		}
	
		return returnValue / 180;
		
	}
    
    //driveTrain
    
    public void stop() {
    	Drive.arcadeDrive(0, 0);
    }

    public void arcadeDrive(Joystick stick){
    	Drive.arcadeDrive(stick);
    }
    
    public void arcadeDrive(double x, double y) {
    	Drive.arcadeDrive(x, y);
    }
    
    public double maxSpeed(double speed){
    	return speed > 0.8 ? 0.8 : speed;
    }
    
    public void arcadeDriveScaled(Joystick joy) {
    	arcadeDriveScaled(joy.getX(), joy.getY(), 1.0);
    }
    
    public void arcadeDriveScaled(Joystick joy, double scalar) {
    	arcadeDriveScaled(joy.getX(), joy.getY(), scalar);
    }
    
    public void arcadeDriveScaled(double x, double y, double scalar) {
    	if(scalar > 1) {
    		scalar = 1;
    	}
    	Drive.arcadeDrive((x * scalar), (y * scalar));
    }

    //ecncoders
    
//	public double getLeftEncoder() {
//		return ((leftWheelEncoder.getDistance() * 25.13) / 254) / 12;
//	}
//	
//	public double getRightEncoder() {
//		return ((rightWheelEncoder.getDistance() * 25.13) / 254) / 12;
//	}
	
//	public void resetEncoders() {
//		leftWheelEncoder.reset();
//		rightWheelEncoder.reset();
//	}
}