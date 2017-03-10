package org.usfirst.frc.team79.robot.commands.auton;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Trajectory.FitMethod;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import java.io.File;
import java.io.PrintStream;

public class GenerateMotionProfile {
	public static final Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, 1000,
			0.05D, 1.2D, 2.0D, 60.0D);
	public static Trajectory left;
	public static Trajectory right;

	public static void generate(String name, Waypoint... points) {
		System.out.println("Generating motion profile for " + name);
		File lFile = new File("/home/lvuser/" + name + "Left.traj");
		File rFile = new File("/home/lvuser/" + name + "Right.traj");
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(0.7112D);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
		Pathfinder.writeToFile(lFile, left);
		Pathfinder.writeToFile(rFile, right);
		System.out.println("Generation for " + name + " has finished.");
	}

	public static void generate(Waypoint... points) {
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(0.7112D);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
	}

	public static void load(String name) {
		File lFile = new File("/home/lvuser/" + name + "Left.traj");
		File rFile = new File("/home/lvuser/" + name + "Right.traj");
		left = Pathfinder.readFromFile(lFile);
		right = Pathfinder.readFromFile(rFile);
	}

	public static boolean motionProfileExists(String name) {
		File lFile = new File("/home/lvuser/" + name + "Left.traj");
		File rFile = new File("/home/lvuser/" + name + "Right.traj");
		System.out.println("Exists: " + ((lFile.exists()) && (rFile.exists())));
		return (lFile.exists()) && (rFile.exists());
	}
}
