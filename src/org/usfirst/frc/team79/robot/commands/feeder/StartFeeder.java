package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartFeeder extends Command {

	/**
	 * Toggles the feeder
	 */
    public StartFeeder() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.feeder.feeder.set(1);
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.feeder.feeder.set(0);
    }

 

    protected void interrupted() {
    }
}
