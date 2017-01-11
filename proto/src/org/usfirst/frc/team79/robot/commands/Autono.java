package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team79.robot.commands.auton.RotateDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autono extends CommandGroup {
	
	public Autono() {
		//addSequential(new DriveStraight(10));
		//addSequential(new DriveStraight(5, 0.5));
		addSequential(new RotateDegrees(30));
		//addSequential(new DriveStraight(5, 0.5));
		addSequential(new RotateDegrees(-30));
		//addSequential(new RotateDegrees(666));
		
	}

}