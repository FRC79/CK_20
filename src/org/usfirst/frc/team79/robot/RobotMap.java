package org.usfirst.frc.team79.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//motors
	public static int FrontLeftMotor = 3;
	public static int BackLeftMotor = 2;
	public static int FrontRightMotor = 4;
	public static int BackRightMotor = 1;
	public static int INATKE_MOTOR =5;
	//encoders
	public static int LEFT_WHEEL_ENCODER_A = 1;
	public static int LEFT_WHEEL_ENCODER_B = 2;

	public static int RIGHT_WHEEL_ENCODER_A = 1;
	public static int RIGHT_WHEEL_ENCODER_B = 2;


	// Drivetrain Constants
	public static double driveTurningConstant = 0.6;
}
