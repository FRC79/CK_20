package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StopFeederConveyer extends CommandGroup {
	
	/**
	 * Stops the feeder and conveyer.
	 */
	public StopFeederConveyer() {
		addParallel(new StopFeeder());
		addParallel(new StopConveyer());
	}
}
