package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;

public class GearDown extends Command {
	
	/**
	 * Deploys the gear manipulator.
	 */
	public GearDown(){}
	
	protected void execute() {
		Robot.gearManipulator.deploy.set(DoubleSolenoid.Value.kForward);
	}

	protected boolean isFinished() {
		return true;
	}
}
