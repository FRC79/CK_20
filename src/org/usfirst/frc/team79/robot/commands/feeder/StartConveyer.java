package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartConveyer extends Command {

	private double invert;
	
	/**
	 * Toggles the conveyer.
	 */
    public StartConveyer() {
    	this(false);
    }
    
    public StartConveyer(boolean invert){
    	requires(Robot.feeder);
    	this.invert = invert ? -0.6 : 1;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.feeder.conveyer.set(-1.0*invert);
    }

    protected boolean isFinished() {
        return true;
    }
}
