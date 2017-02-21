package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearStop extends Command{
	
	public GearStop(){
		
	}
	
	protected void execute(){
		Robot.gearManipulator.intake.set(0);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
