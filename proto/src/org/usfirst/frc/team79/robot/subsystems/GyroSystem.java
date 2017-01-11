package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
 
public class GyroSystem extends Subsystem {

	public AnalogGyro gyro;
	
	public GyroSystem(){
		super();
		gyro = new AnalogGyro(RobotMap.GYRO);
		resetGyro();
	}
	
    public double GetGyroAngle() {
    	return gyro.getAngle();
    }
    
    public double getNormalAngle() {
    	double angle = gyro.getAngle() % 360;
    	return angle / 360;
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
