package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AlignShooter extends CommandGroup {
	
	/**
	 * Theorectically aligns the robot to the boiler.
	 */
	public AlignShooter() {
		addSequential(new RotateDegrees());
	}
}
