package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Intake;

public class StopIntake extends Command {
	
	/**
	 * Stops the intake.
	 */
	public StopIntake() {
		requires(Robot.intake);
	}

	public void execute() {
		Robot.intake.intake.set(0.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}
