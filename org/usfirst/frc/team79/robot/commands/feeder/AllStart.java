package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AllStart extends Command {

	/**
	 * Starts the feeder and conveyer, or turns them both off if one is on.
	 */
    public AllStart() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if(Robot.feeder.conveyer.get() != 0 || Robot.feeder.feeder.get() != 0){
    		Robot.feeder.conveyer.set(0);
    		Robot.feeder.feeder.set(0);
    	} else{
    		Robot.feeder.conveyer.set(1);
    		Robot.feeder.feeder.set(1);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    }
}
