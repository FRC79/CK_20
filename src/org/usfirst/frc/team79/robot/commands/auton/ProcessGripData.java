package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.grip.Contour;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

public class ProcessGripData{
	
	public static NetworkTable grip = NetworkTable.getTable("GRIP");
	
	/**
	 * Determines the angle displacement to the boiler target. 
	 * @return Heading in degrees.
	 */
	public static double getHeading(){
		Contour[] contours = getContours();
		double headingToTarget = 0;
		if(contours.length > 0){
			Contour tape = getGreatestContour(contours);
			headingToTarget = Math.toDegrees(Math.atan(Math.toRadians((tape.centerX-RobotMap.CX)/RobotMap.FOCAL_LENGTH)));
			SmartDashboard.putNumber("Heading to Boiler", headingToTarget);
		}else SmartDashboard.putNumber("Heading to Boiler", 0);
		return headingToTarget;
	}
	
	/**
	 * Determines the horizontal distance between the robot and the boiler.
	 * @return Distance in feet.
	 */
	public static double getDistance(){
		Contour[] contours = getContours();
		double distance = 0;
		if(contours.length > 0){
			Contour tape = getGreatestContour(contours);
			double pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY-RobotMap.CY)/RobotMap.FOCAL_LENGTH));
			distance = (RobotMap.BOILER_HEIGHT-RobotMap.CAMERA_HEIGHT)/Math.toDegrees(Math.tan(RobotMap.CAMERA_ANGLE + pitchHeading));
			SmartDashboard.putNumber("Distance to Boiler", distance);
		}else SmartDashboard.putNumber("Distance to Boiler", 0);
		return distance;
	}
	
	public static double getPitchHeading(){
		Contour[] contours = getContours();
		double pitchHeading = 0;
		if(contours.length > 0){
			Contour tape = getGreatestContour(contours);
			pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY-RobotMap.CY)/RobotMap.FOCAL_LENGTH));
			SmartDashboard.putNumber("Pitch Heading to Boiler", pitchHeading);
		}else SmartDashboard.putNumber("Pitch Heading to Boiler", 0);
		return pitchHeading;
	}
	
	/**
	 * Grabs the individual bits of contour data from the NetworkTable and creates a list of objects from it. 
	 * @return
	 */
	private static Contour[] getContours(){
		ITable gripSub = grip.getSubTable("reflectiveTapeReport");
		double[] areas = gripSub.getNumberArray("area", new double[0]);
		double[] centerX = gripSub.getNumberArray("centerX", new double[0]);
		double[] centerY = gripSub.getNumberArray("centerY", new double[0]);
		Contour[] contours = new Contour[areas.length];
		for(int i=0; i<contours.length; i++){
			contours[i] = new Contour(areas[i], centerX[i], centerY[i]);
		}
		return contours;
	}
	
	/**
	 * Given a list of contours, this will select the one with the largest area. Should remove extraneous, non-tape contours.
	 * @return
	 */
	private static Contour getGreatestContour(Contour[] contours){
		int winner = 0;
		double greatest = 0;
		for(int i=0; i<contours.length; i++){
			if(contours[i].area > greatest){
				greatest = contours[i].area;
				winner = i;
			}
		}
		return contours[winner];
	}

}
