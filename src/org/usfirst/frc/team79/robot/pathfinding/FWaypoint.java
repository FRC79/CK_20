package org.usfirst.frc.team79.robot.pathfinding;

import jaci.pathfinder.Waypoint;

public class FWaypoint extends Waypoint {
	
	/**
	 * Like Waypoint, but in feet and degrees.
	 * @param x feet
	 * @param y feet
	 * @param angle degrees
	 */
	public FWaypoint(double x, double y, double angle) {
		super(x * 0.3048D, y * 0.3048D, Math.toRadians(angle));
	}
}
