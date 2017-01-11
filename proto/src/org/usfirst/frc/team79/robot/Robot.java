
package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.Autono;
import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.Drive;

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
	public static Drive drive;
	
    Command autonomousCommand;
    Command firstcommand;
    
    CameraServer server;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	CommandBase.init();
    	
		oi = new OI();
		drive = new Drive();
		
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
    	
    	autonomousCommand = new Autono();

    	
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
    }
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro Angle", CommandBase.gyro.GetGyroAngle());

    }

    public void teleopInit() { 
    	
    	Robot.drive.start();
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro Angle", CommandBase.gyro.GetGyroAngle());

    }
    
    public void testPeriodic() {
    	
    }
}
