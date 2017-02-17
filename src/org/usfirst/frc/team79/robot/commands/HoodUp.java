package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoodUp extends Command{

	public HoodUp(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		Robot.shooter.hoodController.set(true);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
