package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
private RobotDrive Drive;

public static CANTalon FrontLeft, BackLeft, FrontRight, BackRight , MiddleLeft, MiddleRight;
	
public DriveTrain(){
		
		FrontLeft = new CANTalon(RobotMap.ForntLeftMotor);
		BackLeft = new CANTalon(RobotMap.BackLeftMotor);
	    FrontRight = new CANTalon(RobotMap.FrontRightMotor);
	    BackRight = new CANTalon(RobotMap.BackRightMotor);
	    
	    Drive = new RobotDrive(BackLeft, FrontLeft, BackRight, FrontRight);
	    
	  //slaves middle Talons to front Talons
	    
//    	MiddleRight.changeControlMode(CANTalon.TalonControlMode.Follower);
//    	MiddleLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
//    	
//    	MiddleRight.set(FrontRight.getDeviceID());
//    	MiddleLeft.set(FrontLeft.getDeviceID());
	    // MEMES
//	    FrontLeft.reverseOutput(true);
//	    MiddleLeft.reverseOutput(true);
//	    BackLeft.reverseOutput(true);
//	    
	    
//    }
//    
	}

    public void initDefaultCommand() {
    	
    }

    public void arcadeDrive(Joystick stick){
    	Drive.arcadeDrive(stick);
    }
    
    public void arcadeDrive(double x, double y) {
    	Drive.arcadeDrive(x, y);
    }

}