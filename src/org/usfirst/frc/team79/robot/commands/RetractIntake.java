package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class RetractIntake extends Command{
	
	public RetractIntake(){
		requires(Robot.intake);
	}

	protected void execute(){
		if(Robot.feeder.conveyer.get()==0) Robot.intake.deploy.set(DoubleSolenoid.Value.kReverse);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
