package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;


/**
 *
 */
public class Drive extends CommandBase {

    public Drive() {
    	requires(arcadeDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		arcadeDrive.arcadeDrive(Robot.oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
