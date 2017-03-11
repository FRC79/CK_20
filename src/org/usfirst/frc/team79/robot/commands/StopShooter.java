package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class StopShooter extends Command {
	
	/**
	 * Stops the shooter.
	 */
	public StopShooter() {
		requires(Robot.shooter);
	}

	public void execute() {
		Robot.shooter.shooterWheel.set(0.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}
