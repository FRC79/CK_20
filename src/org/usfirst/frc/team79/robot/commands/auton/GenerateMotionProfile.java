
package org.usfirst.frc.team79.robot.commands.auton;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.modifiers.TankModifier;

public class GenerateMotionProfile{
	
	public final static Config config = new Config(Trajectory.FitMethod.HERMITE_CUBIC, Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0); //TODO Will need tuning
	public static Trajectory left, right;
	
	/**
	 * Generates points needed for motion profiling and sends them to the Talon.
	 * @param points Use FWaypoint for feet and Waypoint for meters.
	 */
	public static void generate(Waypoint... points){
		//TODO wheelbase needed. Distance (meters) between the 2 sides of the drive train.
		double wheelbase = 1.0;
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(wheelbase);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
	}

}
