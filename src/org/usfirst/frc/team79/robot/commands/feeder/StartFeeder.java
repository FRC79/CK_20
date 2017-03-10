package org.usfirst.frc.team79.robot.commands.feeder;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

public class StartFeeder extends Command {
	private double invert;

	public StartFeeder() {
		this(false);
	}

	public StartFeeder(boolean invert) {
		this.invert = (invert ? -0.15D : 1.0D);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.feeder.feeder.set(1.0D * this.invert);
	}

	protected boolean isFinished() {
		return true;
	}
}
