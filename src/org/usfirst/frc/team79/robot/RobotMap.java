package org.usfirst.frc.team79.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//motors
	public static int FrontLeftMotor = 2;
	public static int BackLeftMotor = 1;
	public static int FrontRightMotor = 3;
	public static int BackRightMotor = 4;
	public static int INTAKE_MOTOR =5;
	public static int FEEDER_MOTOR = 8;
	public static int CONVEYER_MOTOR = 7;
	//encoders
	
	public static int LEFT_WHEEL_ENCODER_A = 1;
	public static int LEFT_WHEEL_ENCODER_B = 2;

	public static int RIGHT_WHEEL_ENCODER_A = 1;
	public static int RIGHT_WHEEL_ENCODER_B = 2;


	// Drivetrain Constants
	public static double driveTurningConstant = 0.6;
	
	//Camera Constants
	// Calcualtes FOV and Focal length of camera. May be inaccurate due to possible automatic scaling by GRIP.
	public static final double DIAGONAL_FOV = 68.5; // degrees
	public static final double HORIZONTAL_ASPECT_RATIO = 4;
	public static final double VERTICAL_ASPECT_RATIO = 3;
	public static final double IMAGE_WIDTH = 160; // pixels
	public static final double IMAGE_HEIGHT = 120; // pixels
	public static final double HORIZONTAL_FOV = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(DIAGONAL_FOV / 2)) * (4 / Math.sqrt(Math.pow(HORIZONTAL_ASPECT_RATIO, 2) + Math.pow(VERTICAL_ASPECT_RATIO, 2)))) * 2);; // degrees
	public static final double FOCAL_LENGTH = IMAGE_WIDTH / Math.toDegrees((2 * Math.tan(Math.toRadians(HORIZONTAL_FOV / 2)))); // pixels
	//Center of camera image.
	public static final double CX = IMAGE_WIDTH / 2 - .5;
	public static final double CY = IMAGE_HEIGHT / 2 - .5;
	
	public static final double WHEEL_CIRCUMFERENCE = 4 * Math.PI;
}
