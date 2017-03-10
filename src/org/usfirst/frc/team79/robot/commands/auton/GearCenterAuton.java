package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.WaitForIt;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearCenterAuton extends CommandGroup{
	
	public GearCenterAuton(){
		this.addSequential(new ExecuteMotionProfile("Gear"));
		this.addSequential(new WaitForIt(.2));
		this.addSequential(new GearDown());
		this.addSequential(new WaitForIt(.2));
		this.addSequential(new ExecuteMotionProfile("GearSidePart3"));
		this.addSequential(new GearUp());
	}

}
