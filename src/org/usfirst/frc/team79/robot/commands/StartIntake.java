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
    	if(Robot.intake.intake.get() != 0.0){
    		Robot.intake.intake.set(0.0);
    	}else Robot.intake.intake.set(1.0);
    }

    public boolean isFinished() {
      return false;
    }
}
