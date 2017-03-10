package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team79.robot.commands.DeployIntake;
import org.usfirst.frc.team79.robot.commands.EngageHanger;
import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearIn;
import org.usfirst.frc.team79.robot.commands.GearOut;
import org.usfirst.frc.team79.robot.commands.GearStop;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.HoodDown;
import org.usfirst.frc.team79.robot.commands.HoodUp;
import org.usfirst.frc.team79.robot.commands.ManualShooterControl;
import org.usfirst.frc.team79.robot.commands.RetractIntake;
import org.usfirst.frc.team79.robot.commands.RunFeederConveyer;
import org.usfirst.frc.team79.robot.commands.StartFiringSubsystems;
import org.usfirst.frc.team79.robot.commands.StartIntake;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.commands.StopFeederConveyer;
import org.usfirst.frc.team79.robot.commands.StopFiringSubsystems;
import org.usfirst.frc.team79.robot.commands.StopIntake;
import org.usfirst.frc.team79.robot.commands.StopShooter;
import org.usfirst.frc.team79.robot.commands.UnengageHanger;
import org.usfirst.frc.team79.robot.commands.auton.RotateDegrees;
import org.usfirst.frc.team79.robot.utilities.AxisButton;
import org.usfirst.frc.team79.robot.utilities.POVButton;

public class OI {
	public Joystick throttleStick = new Joystick(0);
	
	public Button intakeDeploy = new JoystickButton(this.throttleStick, 2);
	public Button intakeRetract = new JoystickButton(this.throttleStick, 4);
	public Button autoAlignWithBoiler = new JoystickButton(this.throttleStick, 3);
	public Button intakeReverse = new JoystickButton(this.throttleStick, 8);
	public Button intakeRun = new JoystickButton(this.throttleStick, 6);
	public Button startShooter = new JoystickButton(this.throttleStick, 5);
	public Button startConveyers = new JoystickButton(this.throttleStick, 7);
	
	public Joystick operatorStick = new Joystick(1);
	
	public Button gearIntake = new JoystickButton(this.operatorStick, 1);
	public Button gearReject = new JoystickButton(this.operatorStick, 3);
	public Button gearUp = new JoystickButton(this.operatorStick, 4);
	public Button gearDown = new JoystickButton(this.operatorStick, 2);
	public Button reverseShootRoutine = new JoystickButton(this.operatorStick, 5);
	public Button unengageHanger = new JoystickButton(this.operatorStick, 7);
	public Button engageHanger = new JoystickButton(this.operatorStick, 8);
	public AxisButton manualShooterControl = new AxisButton(this.operatorStick, 1);
	public AxisButton conveyer_FeederRun = new AxisButton(this.operatorStick, 3);
	public POVButton hoodControl = new POVButton(this.operatorStick);

	public OI() {
		this.autoAlignWithBoiler.toggleWhenActive(new RotateDegrees(45.0D));

		this.intakeReverse.whenPressed(new StartIntake(true));
		this.intakeReverse.whenReleased(new StopIntake());

		this.intakeRun.whenPressed(new StartIntake());
		this.intakeRun.whenReleased(new StopIntake());

		this.intakeDeploy.whenPressed(new DeployIntake());
		this.intakeRetract.whenPressed(new RetractIntake());

		this.startShooter.whileActive(new StartShooter(3500, false));
		this.startShooter.whenInactive(new StopShooter());

		this.startConveyers.whenActive(new RunFeederConveyer(false));
		this.startConveyers.whenInactive(new StopFeederConveyer());

		this.hoodControl.whenActive(new HoodUp(), 0);
		this.hoodControl.whenActive(new HoodDown(), 180);

		this.manualShooterControl.whileActive(new ManualShooterControl(), -1.0D, 0.87D);
		this.manualShooterControl.whenActive(new StopShooter(), 0.0D, 0.1D);

		this.engageHanger.whenPressed(new EngageHanger());
		this.unengageHanger.whenPressed(new UnengageHanger());

		this.conveyer_FeederRun.whenActive(new RunFeederConveyer(true), 1.0D, 0.8D);
		this.conveyer_FeederRun.whenActive(new RunFeederConveyer(false), -1.0D, 0.8D);
		this.conveyer_FeederRun.whenActive(new StopFeederConveyer(), 0.0D, 0.1D);

		this.reverseShootRoutine.whenPressed(new StartFiringSubsystems(true));
		this.reverseShootRoutine.whenReleased(new StopFiringSubsystems());

		this.gearIntake.whenPressed(new GearIn());
		this.gearIntake.whenReleased(new GearStop());

		this.gearReject.whenPressed(new GearOut());
		this.gearReject.whenReleased(new GearStop());

		this.gearUp.whenPressed(new GearUp());
		this.gearDown.whenPressed(new GearDown());
	}

	public Joystick getJoystick() {
		return this.throttleStick;
	}

	public double getThrottle() {
		return this.throttleStick.getY();
	}

	public double getSteering() {
		return this.throttleStick.getZ();
	}

	public boolean getSlowDrivingMode() {
		return this.throttleStick.getTrigger();
	}
}
