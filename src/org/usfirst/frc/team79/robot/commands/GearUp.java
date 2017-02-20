package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class GearUp extends Command{

	public GearUp(){
		
	}
	
	protected void execute(){
		Robot.gearManipulator.deploy.set(Value.kReverse);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
