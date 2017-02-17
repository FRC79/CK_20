package org.usfirst.frc.team79.robot.pathfinding;

import jaci.pathfinder.Waypoint;

public class FWaypoint extends Waypoint{
	
	/**
	 * Same as jaci.pathfinder.Waypoint, but takes feet in the constructor instead of meters and degrees instead of radians.
	 * @param x in feet
	 * @param y in feet
	 * @param angle in degrees
	 */
	public FWaypoint(double x, double y, double angle){
		super(x*0.3048, y*0.3048, Math.toRadians(angle));
	}

}
