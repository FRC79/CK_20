package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProcessGripData extends Command{
	
	public static volatile double gripX = 0.0;
	public static volatile double gripWidth = 0.0;
	public static volatile double[] centerXArray;
	public static volatile double[] widthArray;
	private static volatile double[] gripAreaArray;
	public static volatile double lastUsedAngle = 0.0;


	
	public final NetworkTable grip = NetworkTable.getTable("Grip");
	
	private boolean finished;
	
	/**
	 * Asks the driver station to process the video feed using GRIP pipeline.
	 */
	
	@Override
	protected void execute(){
		UpdateGrip();
		double headerToTarget = Math.toDegrees(Math.atan(Math.toRadians((gripX-RobotMap.CX)/RobotMap.FOCAL_LENGTH)));
		//Sends the header to the dashboard to be used in the RotateDegrees command.
		SmartDashboard.putNumber("boilerHeader", headerToTarget);
//		System.out.println(headerToTarget);

		finished = true;
	}
	private void UpdateGrip(){
		centerXArray = grip.getSubTable("myContoursReport").getNumberArray("centerX", new double[0]);
		widthArray = grip.getSubTable("myContoursReport").getNumberArray("height", new double[0]);
		gripAreaArray = grip.getSubTable("myContoursReport").getNumberArray("area", new double[0]);
		if(centerXArray.length != gripAreaArray.length && widthArray.length != gripAreaArray.length){
			return;
		}
		if(centerXArray.length != 0){
			System.out.println();
			double maxArea = 0;
			int maxIndex = 0;
			for(int i =0; i< gripAreaArray.length; i++ ){
				if(gripAreaArray[i]>maxArea){
					maxArea = gripAreaArray[i];
					maxIndex = i;
				}
			}
			gripX = centerXArray[maxIndex];
			gripWidth = widthArray[maxIndex];
		}
		else{
			gripX = 0.0;
			gripWidth = 0.0;
				
		}
	}
	/**
	 * Grabs the individual bits of contour data from the NetworkTable and creates a list of objects from it. 
	 * @return
	 */	
	
	/**
	 * Given a list of contours, this will select the one with the largest area. Should remove extraneous, non-tape contours.
	 * @return
	 */
	
	@Override
	protected boolean isFinished() {
		return finished;
	}

}
