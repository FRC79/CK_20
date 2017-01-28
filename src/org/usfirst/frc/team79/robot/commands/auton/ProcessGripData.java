package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.grip.Contour;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProcessGripData extends Command{
	
	public NetworkTable grip;
	
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
		double headerToTarget = Math.toDegrees(Math.atan(Math.toRadians((tape.centerX-RobotMap.CX)/RobotMap.FOCAL_LENGTH)));
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

}