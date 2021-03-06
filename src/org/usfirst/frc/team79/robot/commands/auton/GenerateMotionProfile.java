
package org.usfirst.frc.team79.robot.commands.auton;

import java.io.File;
import java.io.IOException;

import org.usfirst.frc.team79.robot.RobotMap;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.modifiers.TankModifier;

public class GenerateMotionProfile{
	
	public final static Config config = new Config(Trajectory.FitMethod.HERMITE_CUBIC, Config.SAMPLES_FAST, 0.05, 1.2, 2.0, 60.0); //TODO Will need tuning
	public static Trajectory left, right;
	
	/**
	 * Generates points needed for motion profiling and sends them to the Talon.
	 * @param points Use FWaypoint for feet and Waypoint for meters.
	 */
	public static void generate(Waypoint... points){
		File file = new File("/home/lvuser/trajectory.csv");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(RobotMap.WHEEL_BASE);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
		Pathfinder.writeToCSV(file, left);
	}

}
