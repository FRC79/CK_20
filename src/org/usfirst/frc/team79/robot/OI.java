package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.DriveDistance;
import org.usfirst.frc.team79.robot.commands.DriveSpeed;
import org.usfirst.frc.team79.robot.commands.StartIntake;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.commands.auton.AlignShooter;
import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

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
	public Button intakeButton = new JoystickButton(throttleStick, 6);
	public Button feederButton = new JoystickButton(throttleStick, 7);
	public Button conveyerButton = new JoystickButton(throttleStick, 8);
	public Button shootButton = new JoystickButton(throttleStick, 4);
	
	public OI(){
		this.gripButton.toggleWhenPressed(new AlignShooter());
		this.intakeButton.toggleWhenPressed(new StartIntake());
		this.feederButton.toggleWhenPressed(new StartFeeder());
		this.conveyerButton.toggleWhenPressed(new StartConveyer());
		this.shootButton.toggleWhenPressed(new StartShooter());
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
