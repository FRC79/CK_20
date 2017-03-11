package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import java.io.PrintStream;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.grip.Contour;

public class ProcessGripData {
	public static NetworkTable grip = NetworkTable.getTable("GRIP");

	/**
	 * Gets the heading to rotate to the GRIP target.
	 * @return Angle in degrees
	 */
	public static double getHeading() {
		Contour tape = getSingleContour();
		return getHeading(tape);
	}

	/**
	 * Gets the heading to rotate to the GRIP target.
	 * @param tape Contour if you already have it.
	 * @return Angle in degrees
	 */
	public static double getHeading(Contour tape) {
		double headingToTarget = 0.0D;
		if (tape != null) {
			double distance = getDistance(tape);
			double angularOffset = Math.atan(5.25D / distance);
			double cx = Math.sin(angularOffset) * 120.0D / 2.0D + 59.5D;
			headingToTarget = Math.toDegrees(Math.atan(Math.toRadians((tape.centerX - cx) / RobotMap.FOCAL_LENGTH)));
			SmartDashboard.putNumber("Heading to Boiler", headingToTarget);
			System.out.println("Heading: " + headingToTarget);
			SmartDashboard.putNumber("Center X", tape.centerX);
			SmartDashboard.putNumber("Center Y", tape.centerY);
		} else {
			SmartDashboard.putNumber("Heading to Boiler", 0.0D);
		}
		return headingToTarget;
	}

	/**
	 * Gets the distance to the target
	 * @return distance in feet.
	 */
	public static double getDistance() {
		Contour tape = getSingleContour();
		return getDistance(tape);
	}

	/**
	 * Gets the distance to the target
	 * @param tape Contour if you already have it.
	 * @return distance in feet.
	 */
	public static double getDistance(Contour tape) {
		double distance = 0.0D;
		if (tape != null) {
			double pitchHeading = Math
					.toDegrees(Math.atan(Math.toRadians(tape.centerY - 79.5D) / RobotMap.FOCAL_LENGTH));
			distance = 6.058333333333334D / Math.toDegrees(Math.tan(44.0D + pitchHeading));
			SmartDashboard.putNumber("Distance to Boiler", distance);
		} else {
			SmartDashboard.putNumber("Distance to Boiler", 0.0D);
		}
		return distance;
	}

	/**
	 * Gets the pitch heading to the GRIP target.
	 * @return Angle in degrees
	 */
	public static double getPitchHeading() {
		Contour tape = getSingleContour();
		return getPitchHeading(tape);
	}

	/**
	 * Gets the pitch heading to the GRIP target.
	 * @param tape Contour if you already have it.
	 * @return Angle in degrees
	 */
	public static double getPitchHeading(Contour tape) {
		double pitchHeading = 0.0D;
		if (tape != null) {
			pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY - 79.5D) / RobotMap.FOCAL_LENGTH));
			SmartDashboard.putNumber("Pitch Heading to Boiler", pitchHeading);
		} else {
			SmartDashboard.putNumber("Pitch Heading to Boiler", 0.0D);
		}
		return pitchHeading;
	}

	public static double getBoilerPitchHeading() {
		Contour tape = getSingleContour();
		double boilerPitchHeading = 0.0D;
		if (tape != null) {
			double distance = getDistance(tape);
			boilerPitchHeading = Math.toDegrees(Math.atan(8.0D / distance));
		}
		return boilerPitchHeading;
	}

	/**
	 * Gets the contour of the greatest area reported by GRIP.
	 * @return The greatest Contour
	 */
	private static Contour getSingleContour() {
		ITable gripSub = grip.getSubTable("reflectiveTapeReport");
		double[] areas = gripSub.getNumberArray("area", new double[0]);
		double[] centerX = gripSub.getNumberArray("centerX", new double[0]);
		double[] centerY = gripSub.getNumberArray("centerY", new double[0]);
		Contour[] contours = new Contour[areas.length];
		int winner = -1;
		double area = 0.0D;
		for (int i = 0; i < contours.length; i++) {
			if (areas[i] > area) {
				winner = i;
				area = areas[i];
			}
		}
		if (winner == -1) {
			return null;
		}
		return new Contour(areas[winner], centerX[winner], centerY[winner]);
	}
}
