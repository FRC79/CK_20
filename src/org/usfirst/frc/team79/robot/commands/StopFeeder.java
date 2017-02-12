package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopFeeder extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StopFeeder(){
		requires(Robot.feeder);
	}
	
	public void execute(){
		Robot.feeder.feeder.set(0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	protected void end(){
		Robot.feeder.feeder.set(0);
	}
}