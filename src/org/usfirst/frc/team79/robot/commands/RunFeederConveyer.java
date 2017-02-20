package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.commands.feeder.StartConveyer;
import org.usfirst.frc.team79.robot.commands.feeder.StartFeeder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunFeederConveyer extends CommandGroup{
	
	public RunFeederConveyer(boolean invert){
		requires(Robot.feeder);
		this.addParallel(new StartFeeder(invert));
		this.addParallel(new StartConveyer(invert));
	}

}
