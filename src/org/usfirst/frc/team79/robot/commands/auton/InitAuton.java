package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.pathfinding.FWaypoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitAuton extends CommandGroup{
	
	public InitAuton(){
		GenerateMotionProfile.generate(new FWaypoint(0,0,0), new FWaypoint(3,1,60), new FWaypoint(8,2,120), new FWaypoint(10, 3, 180));
		this.addSequential(new ExecuteMotionProfile());
	}

}
