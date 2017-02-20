package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearIn extends Command{
	
	public GearIn(){
		
	}
	
	protected void execute(){
		Robot.gearManipulator.intake.set(1);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
