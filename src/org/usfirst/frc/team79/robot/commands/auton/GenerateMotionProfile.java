package org.usfirst.frc.team79.robot.commands.auton;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Trajectory.FitMethod;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import java.io.File;
import java.io.PrintStream;

import org.usfirst.frc.team79.robot.RobotMap;

public class GenerateMotionProfile {
	public static final Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, 1000,
			0.05D, 1.2D, 2.0D, 60.0D);
	public volatile static Trajectory left;
	public volatile static Trajectory right;
	
	public static final String PATHNAME = "/home/lvuser/trajectory/";

	public static void generate(String name, Waypoint... points) {
		System.out.println("Generating motion profile for " + name);
		File lFile = new File(PATHNAME + name + "Left.traj");
		File rFile = new File(PATHNAME + name + "Right.traj");
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(RobotMap.WHEEL_BASE);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
		Pathfinder.writeToFile(lFile, left);
		Pathfinder.writeToFile(rFile, right);
		System.out.println("Generation for " + name + " has finished.");
	}

	public static void generate(Waypoint... points) {
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(RobotMap.WHEEL_BASE);
		left = modifier.getLeftTrajectory();
		right = modifier.getRightTrajectory();
	}

	public static void load(String name) {
		File lFile = new File(PATHNAME + name + "Left.traj");
		File rFile = new File(PATHNAME + name + "Right.traj");
		left = Pathfinder.readFromFile(lFile);
		right = Pathfinder.readFromFile(rFile);
		System.out.println("Finished loading home dog");
		System.out.println("Here's what you got: ");
		if(left!=null) System.out.println(left.segments[5].position);
		if(right!=null) System.out.println(right.segments[5].position);
	}

	public static boolean motionProfileExists(String name) {
		File lFile = new File(PATHNAME + name + "Left.traj");
		File rFile = new File(PATHNAME + name + "Right.traj");
		System.out.println("Exists: " + ((lFile.exists()) && (rFile.exists())));
		return (lFile.exists()) && (rFile.exists());
	}
}
