package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.WaitForIt;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearRightAuton extends CommandGroup{
	
	public GearRightAuton(){
		this.addSequential(new ExecuteMotionProfile("GearSidePart1"));
		this.addSequential(new RotateDegrees(45));
		this.addSequential(new ExecuteMotionProfile("GearSidePart2"));
		this.addSequential(new WaitForIt(.2));
		this.addSequential(new GearDown());
		this.addSequential(new WaitForIt(.2));
		this.addSequential(new ExecuteMotionProfile("GearSidePart3"));
		this.addSequential(new GearUp());
	}

}
