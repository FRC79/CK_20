package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoodDown extends Command{

	public HoodDown(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		Robot.shooter.hoodController.set(false);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
