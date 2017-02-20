
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.auton.InitAuton;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;
import org.usfirst.frc.team79.robot.subsystems.Intake;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public Compressor pump;
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Feeder feeder;
	public static Intake intake;
	public static Shooter shooter;
	public static GearManipulator gearManipulator;

	CameraServer server;

	public void robotInit() {
		driveTrain = new DriveTrain();
		feeder = new Feeder();
		intake = new Intake();
		shooter = new Shooter();
		gearManipulator = new GearManipulator();
		oi = new OI();
		
		pump = new Compressor();
		//pump.setClosedLoopControl(true);
		
		UsbCamera camera = new UsbCamera("cam0", 0);
		camera.setBrightness(15);
		server = CameraServer.getInstance();
		server.startAutomaticCapture(camera);
    
		SmartDashboard.putNumber("Heading to Boiler", 0);
		SmartDashboard.putNumber("Center X", 0);
		SmartDashboard.putNumber("Center Y", 0);

		SmartDashboard.putNumber("Turn P", 0);
		SmartDashboard.putNumber("Turn I", 0);
		SmartDashboard.putNumber("Turn D", 0);
		
		SmartDashboard.putNumber("Shooter Velocity", 0);
			SmartDashboard.putNumber("Heading to Boiler", 0);
			SmartDashboard.putNumber("Center X", 0);
			SmartDashboard.putNumber("Center Y", 0);
			
			SmartDashboard.putNumber("Turn P", 0);
			SmartDashboard.putNumber("Turn I", 0);
			SmartDashboard.putNumber("Turn D", 0);
			SmartDashboard.putNumber("Velocity", 0);
			SmartDashboard.putNumber("Set Shooter Speed", 0.8);
			SmartDashboard.putBoolean("Use Auto Shoot", false);
		}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		Robot.driveTrain.FrontLeft.clearMotionProfileTrajectories();
		Robot.driveTrain.FrontRight.clearMotionProfileTrajectories();
		Robot.driveTrain.FrontLeft.setEncPosition(0);
		Robot.driveTrain.FrontRight.setEncPosition(0);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		Scheduler.getInstance().add(new InitAuton());
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", driveTrain.FrontLeft.getPosition());
		SmartDashboard.putNumber("Right Encoder", driveTrain.FrontRight.getPosition());
	}

	public void teleopInit() {
		pump.setClosedLoopControl(true);
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", driveTrain.getGyroAngle());
		SmartDashboard.putNumber("Left Encoder", driveTrain.FrontLeft.getPosition());
		SmartDashboard.putNumber("Right Encoder", driveTrain.FrontRight.getPosition());
		SmartDashboard.putNumber("Velocity", driveTrain.FrontLeft.getSpeed());
		SmartDashboard.putNumber("Shooter Velocity", shooter.shooterWheel.getSpeed());
	}

	public void testPeriodic() {

	}
}
