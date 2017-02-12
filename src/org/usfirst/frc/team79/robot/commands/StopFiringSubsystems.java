package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StopFiringSubsystems extends CommandGroup{
	
	public StopFiringSubsystems(){
		this.addSequential(new StopConveyer());
		this.addSequential(new StopFeeder());
		this.addSequential(new StopShooter());
	}

}
