package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopIntake extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StopIntake(){
		requires(Robot.intake);
	}
	
	public void execute(){
		Robot.intake.intake.set(0);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	protected void end(){
		Robot.intake.intake.set(0);
	}
}