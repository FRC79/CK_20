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
		Contour tape = getSingleContour();
		double headingToTarget = 0;
		if(tape != null){
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
		Contour tape = getSingleContour();
		double distance = 0;
		if(tape != null){
			double pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY-RobotMap.CY)/RobotMap.FOCAL_LENGTH));
			distance = (RobotMap.BOILER_HEIGHT-RobotMap.CAMERA_HEIGHT)/Math.toDegrees(Math.tan(RobotMap.CAMERA_ANGLE + pitchHeading));
			SmartDashboard.putNumber("Distance to Boiler", distance);
		}else SmartDashboard.putNumber("Distance to Boiler", 0);
		return distance;
	}
	
	/**
	 * Gets angle displacement between the angle of the camera and the angle it should face to be directly pointed at the tape.
	 * @return Heading in degrees
	 */
	public static double getPitchHeading(){
		Contour tape = getSingleContour();
		double pitchHeading = 0;
		if(tape != null){
			pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY-RobotMap.CY)/RobotMap.FOCAL_LENGTH));
			SmartDashboard.putNumber("Pitch Heading to Boiler", pitchHeading);
		}else SmartDashboard.putNumber("Pitch Heading to Boiler", 0);
		return pitchHeading;
	}
	
	/**
	 * Grabs the contour of the greatest area in one iteration.
	 * @return GRIP Contour
	 */
	private static Contour getSingleContour(){
		ITable gripSub = grip.getSubTable("reflectiveTapeReport");
		double[] areas = gripSub.getNumberArray("area", new double[0]);
		double[] centerX = gripSub.getNumberArray("centerX", new double[0]);
		double[] centerY = gripSub.getNumberArray("centerY", new double[0]);
		Contour[] contours = new Contour[areas.length];
		int winner = -1;
		double area = 0;
		for(int i=0; i<contours.length; i++){
			if(areas[i] > area){
				winner = i;
				area = contours[i].area;
			}
		}
		if(winner == -1) return null;
		return new Contour(areas[winner], centerX[winner], centerY[winner]);
	}

}
