package org.usfirst.frc.team79.robot;

public class RobotMap {
	
	//Talons
	public static final int FrontLeftMotor = 1;
	public static final int FrontRightMotor = 2;
	public static final int BackLeftMotor = 3;
	public static final int BackRightMotor = 4;
	public static final int SHOOTER_MOTOR_1 = 5;
	public static final int SHOOTER_MOTOR_2 = 6;
	public static final int INTAKE_MOTOR = 7;
	public static final int FEEDER_MOTOR = 8;
	public static final int CONVEYER_MOTOR = 9;
	public static final int GEAR_INTAKE = 10;
	
	//PCM
	public static final int INTAKE_DEPLOY_DOWN = 0;
	public static final int INTAKE_DEPLOY_UP = 1;
	public static final int GEAR_UP = 2;
	public static final int GEAR_DOWN = 3;
	public static final int SHIFT_CLIMBER = 6;
	public static final int SHIFT_SHOOTER = 7;
	public static final int HOOD_CONTROLLER = 4;
	
	public static final double driveTurningConstant = 0.6D;
	
	//Camera constants
	public static final double CAMERAOFFSET = 5.25D;
	public static final double DIAGONAL_FOV = 68.5D;
	public static final double HORIZONTAL_ASPECT_RATIO = 4.0D;
	public static final double VERTICAL_ASPECT_RATIO = 3.0D;
	public static final double IMAGE_WIDTH = 120.0D;
	public static final double IMAGE_HEIGHT = 160.0D;
	public static final double HORIZONTAL_FOV = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(DIAGONAL_FOV / 2)) * (4 / Math.sqrt(Math.pow(HORIZONTAL_ASPECT_RATIO, 2) + Math.pow(VERTICAL_ASPECT_RATIO, 2)))) * 2);
	public static final double FOCAL_LENGTH = IMAGE_WIDTH / Math.toDegrees((2 * Math.tan(Math.toRadians(HORIZONTAL_FOV / 2))));
	public static final double CX = 59.5D;
	public static final double CY = 79.5D;
	public static final double CAMERA_ANGLE = 44.0D;
	public static final double CAMERA_HEIGHT = 1.9416666666666667D;
	
	//Robot constants
	public static final double SHOOTER_MAX_VELOCITY = 5000.0D;
	public static final double SHOOTER_WHEEL_RADIUS = 1.0D;
	public static final double WHEEL_CIRCUMFERENCE = 1.0471975511965976D;
	public static final double WHEEL_BASE = 0.7112D;
	public static final int TICKS_PER_REV = 360;
	public static final int SHOOTER_TICKS_PER_REV = 1024;
	public static final double DRIVE_MAX_VELOCITY = 9.42477796076938D;
	public static final double HOOD_UP_ANGLE = 80.0D;
	public static final double HOOD_DOWN_ANGLE = 70.0D;
	public static final double BOILER_HEIGHT = 8.0D;
	public static final double ROBOT_WIDTH = 40.0D;
	public static final double ROBOT_LENGTH = 36.0D;
	public static final double ROBOT_HEIGHT = 24.0D;
	public static final double TURN_P = 0.025D;
	public static final double TURN_I = 0.0D;
	public static final double TURN_D = 0.0D;
}
