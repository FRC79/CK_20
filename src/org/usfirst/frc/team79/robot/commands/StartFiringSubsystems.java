package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartFiringSubsystems extends CommandGroup{
	
	public StartFiringSubsystems(){
		this(false);
	}
	
	public StartFiringSubsystems(boolean invert){
		this.addSequential(new StartShooter(invert));
		this.addSequential(new WaitForIt(0.4));
		this.addSequential(new StartFeeder(invert));
		this.addSequential(new StartConveyer(invert));
	}

}
