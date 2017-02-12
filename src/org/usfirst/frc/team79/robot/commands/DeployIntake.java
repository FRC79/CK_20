package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class DeployIntake extends Command{

	public DeployIntake(){
		requires(Robot.intake);
	}

	protected void execute(){
		Robot.intake.deploy.set(DoubleSolenoid.Value.kForward);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
}

