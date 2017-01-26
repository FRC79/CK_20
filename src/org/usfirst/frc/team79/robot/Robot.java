
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

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
	public static Feeder conveyer = new Feeder();

    Command autonomousCommand;

    CameraServer server;

    public void robotInit() {
			server = CameraServer.getInstance();
			server.startAutomaticCapture("Cam0", 0);
    }
	// this is dank code

    public void disabledInit(){

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

    }

    public void testPeriodic() {

    }
}
