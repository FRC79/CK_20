
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi = new OI();
	public static DriveTrain drivetrain = new DriveTrain();
	public static Intake intake = new Intake();

    Command autonomousCommand;

    CameraServer server;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
			server = CameraServer.getInstance();
			server.startAutomaticCapture("Cam0", 0);
//        chooser.addObject("My Auto", new MyAutoCommand());
    }
	// this is dank code
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		// SmartDashboard.putNumber("Gyro Angle", CommandBase.driveTrain.getGyroAngle());
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
		// SmartDashboard.putNumber("Gyro Angle", CommandBase.driveTrain.getGyroAngle());

    }

    public void testPeriodic() {

    }
}
