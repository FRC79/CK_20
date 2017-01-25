package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProcessGripData extends CommandBase{
	
	public NetworkTable grip;
	
	//Calcualtes FOV and Focal length of camera. May be inaccurate due to possible automatic scaling by GRIP.
	public static final double DIAGONAL_FOV = 68.5; //degrees
	public static final double HORIZONTAL_ASPECT_RATIO = 4;
	public static final double VERTICAL_ASPECT_RATIO = 3;
	public static final double IMAGE_WIDTH = 640; //pixels
	public static final double IMAGE_HEIGHT = 480; //pixels
	public static final double HORIZONTAL_FOV = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(DIAGONAL_FOV/2))*(4/Math.sqrt(Math.pow(HORIZONTAL_ASPECT_RATIO, 2) + Math.pow(VERTICAL_ASPECT_RATIO, 2))))*2);; //degrees
	public static final double FOCAL_LENGTH = IMAGE_WIDTH / (2*Math.tan(Math.toRadians(HORIZONTAL_FOV/2))); //pixels
	
	public static final double CX = IMAGE_WIDTH/2 -.5;
	public static final double CY = IMAGE_HEIGHT/2 -.5;
	
	private boolean finished;
	
	/**
	 * Asks the driver station to process the video feed using GRIP pipeline.
	 */
	public ProcessGripData(){
		grip = NetworkTable.getTable("grip");
	}
	
	@Override
	protected void execute(){
		Contour tape = this.getGreatestContour(getContours());
		double headerToTarget = Math.toDegrees(Math.atan(Math.toRadians((tape.centerX-CX)/FOCAL_LENGTH)));
		//Sends the header to the dashboard to be used in the RotateDegrees command.
		SmartDashboard.putNumber("boilerHeader", headerToTarget);
		finished = true;
	}
	
	/**
	 * Grabs the individual bits of contour data from the NetworkTable and creates a list of objects from it. 
	 * @return
	 */
	private Contour[] getContours(){
		double[] areas = grip.getNumberArray("reflectiveTapeReport/area", new double[0]);
		double[] centerX = grip.getNumberArray("reflectiveTapeReport/centerX", new double[0]);
		double[] centerY = grip.getNumberArray("reflectiveTapeReport/centerY", new double[0]);
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
	private Contour getGreatestContour(Contour[] contours){
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

	@Override
	protected boolean isFinished() {
		return finished;
	}
	
	public class Contour{
		
		public double area, centerX, centerY;
		
		public Contour(double area, double centerX, double centerY){
			this.area = area;
			this.centerX = centerX;
			this.centerY = centerY;
		}
		
	}

}
