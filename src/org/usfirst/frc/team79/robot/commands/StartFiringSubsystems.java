package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

public class StartFiringSubsystems extends CommandGroup {
	public StartFiringSubsystems() {
		this(false);
	}

	public StartFiringSubsystems(boolean invert) {
		addSequential(new StartShooter(3500, true));
		addSequential(new StartFeeder(invert));
		addSequential(new StartConveyer(invert));
	}
}
