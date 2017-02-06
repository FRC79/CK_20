package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.grip.Contour;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

public class ProcessGripData{
	
	public static NetworkTable grip = NetworkTable.getTable("GRIP");
	
	public static double getHeading(){
		Contour[] contours = getContours();
		double headingToTarget = 0;
		if(contours.length > 0){
			Contour tape = getGreatestContour(contours);
			headingToTarget = Math.toDegrees(Math.atan(Math.toRadians((tape.centerX-RobotMap.CX)/RobotMap.FOCAL_LENGTH)));
			double pitchHeading = Math.toDegrees(Math.atan(Math.toRadians(tape.centerY-RobotMap.CY)/RobotMap.FOCAL_LENGTH));
			//Sends the header to the dashboard to be used in the RotateDegrees command.
			SmartDashboard.putNumber("Heading to Boiler", headingToTarget);
			SmartDashboard.putNumber("Pitch Heading to Boiler", pitchHeading);
			SmartDashboard.putNumber("Center X", tape.centerX);
			SmartDashboard.putNumber("Center Y", tape.centerY);
		}else SmartDashboard.putNumber("Header to Boiler", 0);
		return headingToTarget;
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
