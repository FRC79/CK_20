package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StopFiringSubsystems extends CommandGroup {
	public StopFiringSubsystems() {
		addSequential(new StopConveyer());
		addSequential(new StopFeeder());
		addSequential(new StopShooter());
	}
}
