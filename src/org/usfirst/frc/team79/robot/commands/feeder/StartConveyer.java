package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartConveyer extends Command {

    public StartConveyer() {
    	requires(Robot.conveyer);

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.conveyer.Conveyer.get() != 0 && Robot.conveyer.Feeder.get() != 0) {
    		Robot.conveyer.Conveyer.set(0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(Robot.oi.startAll.equals(true)){
//        	Robot.conveyer.Conveyer.set(0);
//    	}else{
//        	Robot.conveyer.Conveyer.set(1);
//
//    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.conveyerStart.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
