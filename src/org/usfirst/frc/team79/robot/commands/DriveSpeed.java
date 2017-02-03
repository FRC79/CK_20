package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSpeed extends Command {
	
	double speed;

    public DriveSpeed(double speed) {
    	this.speed = (1440 * speed)/60;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.Speed);
    	Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.Speed);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.FrontLeft.set(speed);
    	Robot.driveTrain.FrontRight.set(-speed);

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
