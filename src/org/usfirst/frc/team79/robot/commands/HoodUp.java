package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;

public class HoodUp extends Command {
	
	/**
	 * Puts the hood up.
	 */
	public HoodUp() {
		requires(Robot.shooter);
	}

	protected void execute() {
		Robot.shooter.hoodController.set(true);
	}

	protected boolean isFinished() {
		return true;
	}
}
