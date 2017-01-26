package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.IntakeStart;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick throttleStick = new Joystick(0);
	public Joystick steeringStick = new Joystick(1);
	
	public JoystickButton intakeStart = new JoystickButton(throttleStick,1);

	
	public OI(){
		intakeStart.whenActive(new IntakeStart());
	}
	
	public Joystick getJoystick() {
		return throttleStick;
	}

	public double getThrottle() {
		return throttleStick.getY();
	}

	public double getSteering() {
		return steeringStick.getX();
	}

	public boolean getSlowDrivingMode() {
		return throttleStick.getTrigger();
	}

}
