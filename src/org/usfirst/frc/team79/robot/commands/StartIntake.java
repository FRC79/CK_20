package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Intake;

public class StartIntake extends Command {
	private double invert;

	public StartIntake() {
		this(false);
	}

	public StartIntake(boolean invert) {
		requires(Robot.intake);
		this.invert = (invert ? -1.0D : 1.0D);
	}

	public void execute() {
		Robot.intake.intake.set(-1.0D * this.invert);
	}

	public boolean isFinished() {
		return true;
	}
}
