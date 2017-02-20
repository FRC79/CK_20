package org.usfirst.frc.team79.robot.commands.feeder;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartFeeder extends Command {

	private double invert;
	
	/**
	 * Toggles the feeder
	 */
    public StartFeeder() {
    	this(false);
    }
    
    public StartFeeder(boolean invert){
    	requires(Robot.feeder);
    	this.invert = invert ? -0.15 : 1;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.feeder.feeder.set(1.0*invert);
    }
    
    protected boolean isFinished() {
        return true;
    }
}
