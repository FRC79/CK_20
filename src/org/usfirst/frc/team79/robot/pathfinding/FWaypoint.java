package org.usfirst.frc.team79.robot.pathfinding;

import jaci.pathfinder.Waypoint;

public class FWaypoint extends Waypoint {
	public FWaypoint(double x, double y, double angle) {
		super(x * 0.3048D, y * 0.3048D, Math.toRadians(angle));
	}
}
