package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.DriveDistance;
import org.usfirst.frc.team79.robot.commands.DriveSpeed;
import org.usfirst.frc.team79.robot.commands.auton.AlignShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick throttleStick = new Joystick(0);

	public Button gripButton = new JoystickButton(throttleStick, 5);
	public Button driveButton = new JoystickButton(throttleStick, 8);
	
	public OI(){
		this.gripButton.toggleWhenPressed(new AlignShooter());
		this.driveButton.toggleWhenPressed(new DriveDistance(120));
	}
	
	public Joystick getJoystick() {
		return throttleStick;
	}

	public double getThrottle() {
		return throttleStick.getY();
	}

	public double getSteering() {
		return throttleStick.getZ();
	}

	public boolean getSlowDrivingMode() {
		return throttleStick.getTrigger();
	}
}
