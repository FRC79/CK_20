package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartConveyer extends Command {

	/**
	 * Toggles the conveyer.
	 */
    public StartConveyer() {
    	requires(Robot.feeder);

    }

    protected void initialize() {
    	
    }

    protected void execute() {
    		Robot.feeder.conveyer.set(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
		Robot.feeder.conveyer.set(0);

    }

    protected void interrupted() {
    }
}
