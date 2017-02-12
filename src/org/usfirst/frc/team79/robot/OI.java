package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.DriveDistance;
import org.usfirst.frc.team79.robot.commands.DriveSpeed;
import org.usfirst.frc.team79.robot.commands.StartIntake;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.commands.StopConveyer;
import org.usfirst.frc.team79.robot.commands.StopFeeder;
import org.usfirst.frc.team79.robot.commands.StopIntake;
import org.usfirst.frc.team79.robot.commands.StopShooter;
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

//	public Button gripButton = new JoystickButton(throttleStick, 5);
	public Button intakeButton = new JoystickButton(throttleStick, 2);
	public Button feederButton = new JoystickButton(throttleStick, 4);
	public Button conveyerButton = new JoystickButton(throttleStick, 3);
	public Button shootButton = new JoystickButton(throttleStick, 8);
	
	public OI(){
//		this.gripButton.toggleWhenPressed(new AlignShooter());
		this.intakeButton.whenActive(new StartIntake());
		this.feederButton.whenActive(new StartFeeder());
		this.conveyerButton.whenActive(new StartConveyer());
		this.shootButton.whenActive(new StartShooter());
		
		this.intakeButton.whenReleased(new StopIntake());
		this.feederButton.whenReleased(new StopFeeder());
		this.conveyerButton.whenReleased(new StopConveyer());
		this.shootButton.whenReleased(new StopShooter());
		
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
