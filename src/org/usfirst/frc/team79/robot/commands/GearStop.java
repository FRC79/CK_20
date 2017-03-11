package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;

public class GearStop extends Command {
	
	/**
	 * Stops the gear motor for intaking.
	 */
	public GearStop(){}
	
	protected void execute() {
		Robot.gearManipulator.intake.set(0.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}
