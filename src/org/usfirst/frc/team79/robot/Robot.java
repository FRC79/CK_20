
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
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
	public static DriveTrain drivetrain = new DriveTrain();
	public static Feeder conveyer = new Feeder();

	CameraServer server;
	
//	UsbCamera camera;
//	MjpegServer inputstream;

    public void robotInit() {
    	oi = new OI();
    	server = CameraServer.getInstance();
		server.startAutomaticCapture("Cam0", 0);
//		camera = new UsbCamera("cam0", 0);
//		inputstream = new MjpegServer("Server", streamPort);
//		inputstream.setSource(camera);
    
    }

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
