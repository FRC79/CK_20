package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class HoodUp extends Command {
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
