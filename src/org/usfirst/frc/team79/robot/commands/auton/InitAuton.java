package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.pathfinding.FWaypoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitAuton extends CommandGroup{
	
	public InitAuton(){
		GenerateMotionProfile.generate(new FWaypoint(0,0,0), new FWaypoint(10,-1,0));
		this.addSequential(new ExecuteMotionProfile());
	}

}
