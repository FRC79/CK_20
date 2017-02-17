package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartIntake extends Command {
	
	private double invert;

	/**
	 * Toggles the intake
	 */
    public StartIntake(){
    	this(false);
    }
    
    public StartIntake(boolean invert){
    	requires(Robot.intake);
    	this.invert = invert ? -0.15 : 1;
    }
    
    public void execute() {
    	Robot.intake.intake.set(-1.0*invert);
    }

    public boolean isFinished() {
      return true;
    }
}
