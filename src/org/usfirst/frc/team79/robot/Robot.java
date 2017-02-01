
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.Intake;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
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

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Feeder feeder;
	public static Intake intake;

	CameraServer server;

	public void robotInit() {
		driveTrain = new DriveTrain();
		feeder = new Feeder();
		intake = new Intake();
		oi = new OI();

		UsbCamera camera = new UsbCamera("cam0", 0);
		camera.setBrightness(15);
		server = CameraServer.getInstance();
		server.startAutomaticCapture(camera);

		SmartDashboard.putNumber("Heading to Boiler", 0);
		SmartDashboard.putNumber("Center X", 0);
		SmartDashboard.putNumber("Center Y", 0);
		SmartDashboard.putNumber("Left Encoder", 0);
		SmartDashboard.putNumber("Right Encoder", 0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", driveTrain.getGyroAngle());
		SmartDashboard.putNumber("Left Encoder", driveTrain.FrontLeft.getPosition());
		SmartDashboard.putNumber("Right Encoder", driveTrain.FrontRight.getPosition());
		SmartDashboard.putNumber("Right Encoder", 0);
	}

	public void testPeriodic() {

	}
}
