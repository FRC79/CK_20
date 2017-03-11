package org.usfirst.frc.team79.robot.pathfinding;

public class IWaypoint extends FWaypoint {
	
	/**
	 * Like Waypoint, but in inches and degrees
	 * @param x inches
	 * @param y inches
	 * @param angle degrees
	 */
	public IWaypoint(double x, double y, double angle) {
		super(x / 12.0D, y / 12.0D, angle);
	}
}
