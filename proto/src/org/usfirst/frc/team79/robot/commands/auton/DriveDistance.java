package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.AutonData;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.PIDController;

/**
 *
 */
public class DriveDistance extends CommandBase {

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

//	PIDController gyroController;
//	double speedVector;
//	double distance;
//	
//    public DriveDistance(double speedVector, double distance) {
//		requires(arcadeDrive);
//		requires(gyro);
//		gyroController = new PIDController(0, AutonData.kp, AutonData.ki, AutonData.kd, null, null);
//		this.speedVector = speedVector;
//		this.distance = distance;
//    }
//    public DriveDistance(double speedVector, double distance, double kp, double ki, double kd) {
//		this(speedVector, distance);
//		gyroController.setPID(kp, ki, kd);
//	}
//    
//
//    protected void initialize() {
//    }
//
//    protected void execute() {
//    	gyroController.setPID(AutonData.kp, AutonData.ki, AutonData.kd);
//
//    }
//
//    protected boolean isFinished() {
//		return (arcadeDrive.getRightEncoder() >= distance);
//    }
//
//    protected void end() {
//		arcadeDrive.arcadeDrive(0, 0);
//
//    }
//
//    protected void interrupted() {
//    }
}
