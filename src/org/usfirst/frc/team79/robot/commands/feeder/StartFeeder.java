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
    	if(Robot.feeder.feeder.get() != 0){
    		Robot.feeder.feeder.set(0);
    	} else Robot.feeder.feeder.set(1);
    }
    
    protected boolean isFinished() {
        return true;
    }

 

    protected void interrupted() {
    }
}
