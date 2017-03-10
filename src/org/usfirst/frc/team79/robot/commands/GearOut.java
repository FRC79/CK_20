package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;

public class GearOut extends Command {
	protected void execute() {
		Robot.gearManipulator.intake.set(1.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}