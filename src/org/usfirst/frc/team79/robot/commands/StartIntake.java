package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartIntake extends Command {

	/**
	 * Toggles the intake
	 */
    public StartIntake(){
    	requires(Robot.intake);
    }
    
    public void execute() {
    		Robot.intake.intake.set(-0.6);
    }

    public boolean isFinished() {
      return true;
    }
}
