
package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.TrajectoryPoint;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Trajectory.Segment;
import jaci.pathfinder.modifiers.TankModifier;

public class GenerateMotionProfile{
	
	public final static Config config = new Config(Trajectory.FitMethod.HERMITE_CUBIC, Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0); //TODO Will need tuning
	
	/**
	 * Generates points needed for motion profiling and sends them to the Talon.
	 * @param points Use FWaypoint for feet and Waypoint for meters.
	 */
	public static void generate(Waypoint... points){
		//TODO wheelbase needed. Distance (meters) between the 2 sides of the drive train.
		double wheelbase = 2.0;
		TankModifier modifier = new TankModifier(Pathfinder.generate(points, config)).modify(wheelbase);
		Trajectory left = modifier.getLeftTrajectory();
		Trajectory right = modifier.getRightTrajectory();
		for(int i=0; i<left.segments.length; i++){
			Segment segment = left.segments[i];
			TrajectoryPoint point = new TrajectoryPoint();
			point.position = segment.position;
			point.velocity = segment.velocity;
			point.timeDurMs = (int) (segment.dt * 1000);
			point.profileSlotSelect = 0;
			if(i==0) point.zeroPos = true;
			if(i+1 == left.segments.length) point.isLastPoint = true;
			Robot.driveTrain.FrontLeft.pushMotionProfileTrajectory(point);
		}
		for(int i=0; i<right.segments.length; i++){
			Segment segment = left.segments[i];
			TrajectoryPoint point = new TrajectoryPoint();
			point.position = segment.position;
			point.velocity = segment.velocity;
			point.timeDurMs = (int) (segment.dt * 1000);
			point.profileSlotSelect = 0;
			if(i==0) point.zeroPos = true;
			if(i+1 == left.segments.length) point.isLastPoint = true;
			Robot.driveTrain.FrontRight.pushMotionProfileTrajectory(point);
		}
	}

}
