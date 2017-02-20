package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.DeployIntake;
import org.usfirst.frc.team79.robot.commands.EngageHanger;
import org.usfirst.frc.team79.robot.commands.HoodDown;
import org.usfirst.frc.team79.robot.commands.HoodUp;
import org.usfirst.frc.team79.robot.commands.RetractIntake;
import org.usfirst.frc.team79.robot.commands.RunFeederConveyer;
import org.usfirst.frc.team79.robot.commands.StartFiringSubsystems;
import org.usfirst.frc.team79.robot.commands.StartIntake;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.commands.StopFeederConveyer;
import org.usfirst.frc.team79.robot.commands.StopFiringSubsystems;
import org.usfirst.frc.team79.robot.commands.StopIntake;
import org.usfirst.frc.team79.robot.commands.UnengageHanger;
import org.usfirst.frc.team79.robot.commands.auton.AlignShooter;
import org.usfirst.frc.team79.robot.utilities.AxisButton;
import org.usfirst.frc.team79.robot.utilities.POVButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick throttleStick = new Joystick(0);
	
	public Button intakeDeploy = new JoystickButton(throttleStick, 2);
	public Button intakeRetract = new JoystickButton(throttleStick, 4);
	public Button autoAlignWithBoiler = new JoystickButton(throttleStick, 3);
	public Button intakeReverse = new JoystickButton(throttleStick, 5);
	public Button intakeRun = new JoystickButton(throttleStick, 6);
	
	public Joystick operatorStick = new Joystick(1);
	
	public Button gearIntake = new JoystickButton(operatorStick, 1);
	public Button gearReject = new JoystickButton(operatorStick, 3);
	public Button gearUp = new JoystickButton(operatorStick, 2);
	public Button gearDown = new JoystickButton(operatorStick, 4);
	public Button reverseShootRoutine = new JoystickButton(operatorStick, 5);
	public Button shootRoutine = new JoystickButton(operatorStick, 6);
	public Button unengageHanger = new JoystickButton(operatorStick, 7);
	public Button engageHanger = new JoystickButton(operatorStick, 8);
	
	public AxisButton manualShooterControl = new AxisButton(operatorStick, 1);
	public AxisButton conveyer_FeederRun = new AxisButton(operatorStick, 3);
	public POVButton hoodControl = new POVButton(operatorStick);
	
	public OI(){
		//Driving controller
		autoAlignWithBoiler.toggleWhenActive(new AlignShooter());
		
		intakeReverse.whenPressed(new StartIntake(true));
		intakeReverse.whenReleased(new StopIntake());
		
		intakeRun.whenPressed(new StartIntake());
		intakeRun.whenReleased(new StopIntake());
		
		intakeDeploy.whenPressed(new DeployIntake());
		intakeRetract.whenPressed(new RetractIntake());
		
		//Operator controller
		hoodControl.whenActive(new HoodUp(), 0);
		hoodControl.whenActive(new HoodDown(), 180);
		
		manualShooterControl.whileActive(new StartShooter(0), -1, 1);
		
		engageHanger.whenPressed(new EngageHanger());
		unengageHanger.whenPressed(new UnengageHanger());
		
		conveyer_FeederRun.whenActive(new RunFeederConveyer(true), 1, .8);
		conveyer_FeederRun.whenActive(new RunFeederConveyer(false), -1, .8);
		conveyer_FeederRun.whenActive(new StopFeederConveyer(), 0, 0.1);
		
		reverseShootRoutine.whenPressed(new StartFiringSubsystems(true));
		reverseShootRoutine.whenReleased(new StopFiringSubsystems());
		
		shootRoutine.whenPressed(new StartFiringSubsystems());
		shootRoutine.whenReleased(new StopFiringSubsystems());
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
