package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

public class RunFeederConveyer extends CommandGroup {
	public RunFeederConveyer(boolean invert) {
		addParallel(new StartFeeder(invert));
		addParallel(new StartConveyer(invert));
	}
}
