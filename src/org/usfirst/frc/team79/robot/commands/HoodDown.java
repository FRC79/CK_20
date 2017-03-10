package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class HoodDown extends Command {
	public HoodDown() {
		requires(Robot.shooter);
	}

	protected void execute() {
		Robot.shooter.hoodController.set(false);
	}

	protected boolean isFinished() {
		return true;
	}
}
