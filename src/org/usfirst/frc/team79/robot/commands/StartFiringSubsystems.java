package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartFiringSubsystems extends CommandGroup{
	
	public StartFiringSubsystems(){
		this.addSequential(new StartShooter());
		this.addSequential(new WaitForIt(0.25));
		this.addSequential(new StartFeeder());
		this.addSequential(new StartConveyer());
	}

}
