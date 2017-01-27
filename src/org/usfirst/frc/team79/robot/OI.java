package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.ProcessGripData;

//import org.usfirst.frc.team79.robot.commands.feeder.AllStart;
//import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
//import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {

	public Joystick throttleStick = new Joystick(0);
	public Joystick steeringStick = new Joystick(1);
	public JoystickButton startAll = new JoystickButton(steeringStick, 2);
	public JoystickButton feederStart = new JoystickButton(steeringStick, 3);
	public JoystickButton conveyerStart = new JoystickButton(steeringStick, 4);

	private Button gripButton = new JoystickButton(throttleStick, 5);

	
	public OI(){
		
		this.gripButton.toggleWhenPressed(new ProcessGripData());
		
//		startAll.whenPressed(new AllStart());
//		feederStart.whenPressed(new StartFeeder());
//		conveyerStart.whenPressed(new StartConveyer());
	}
	
	public Joystick getJoystick() {
		return throttleStick;
	}

	public double getThrottle() {
		return throttleStick.getY();
	}

	public double getSteering() {
		return throttleStick.getX();
	}

	public boolean getSlowDrivingMode() {
		return throttleStick.getTrigger();
	}
}
