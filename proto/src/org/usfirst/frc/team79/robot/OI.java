package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public  Joystick stick = new Joystick(0);
	
	public Joystick getJoystick(){
		
		return stick;
		//so much stick
	}
	
}