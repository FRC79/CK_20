package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopConveyer extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StopConveyer(){
		requires(Robot.feeder);
	}
	
	public void execute(){
		Robot.feeder.conveyer.set(0);
		Robot.feeder.feeder.set(0);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	protected void end(){
		Robot.feeder.conveyer.set(0);
		Robot.feeder.feeder.set(0);
	}
}
