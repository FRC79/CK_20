package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.pathfinding.FWaypoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitAuton extends CommandGroup{
	
	public InitAuton(){
		GenerateMotionProfile.generate(new FWaypoint(0,0,0), new FWaypoint(1,2,10), new FWaypoint(3,0,-20));
		this.addSequential(new ExecuteMotionProfile());
	}

}
