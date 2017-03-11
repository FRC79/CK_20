package org.usfirst.frc.team79.robot.grip;

public class Contour {
	public double area;
	public double centerX;
	public double centerY;

	/**
	 * GRIP contour data. Easy storage for clean reference.
	 * @param area
	 * @param centerX
	 * @param centerY
	 */
	public Contour(double area, double centerX, double centerY) {
		this.area = area;
		this.centerX = centerX;
		this.centerY = centerY;
	}
}
