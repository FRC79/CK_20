package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;

public class ManualShooterControl extends Command {
	
	/**
	 * Uses the operator left axis to control the shooter. Used for hanging.
	 */
	public ManualShooterControl() {
		requires(Robot.shooter);
	}

	public void initialize() {
		Robot.shooter.shooterWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public void execute() {
		Robot.shooter.shooterWheel.set(-Robot.oi.operatorStick.getRawAxis(1));
	}

	protected boolean isFinished() {
		return true;
	}
}
