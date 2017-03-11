package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;

public class GearUp extends Command {

	/**
	 * Retracts the gear manipulator.
	 */
	public void GearUp(){}
	
	protected void execute() {
		Robot.gearManipulator.deploy.set(DoubleSolenoid.Value.kReverse);
	}

	protected boolean isFinished() {
		return true;
	}
}
