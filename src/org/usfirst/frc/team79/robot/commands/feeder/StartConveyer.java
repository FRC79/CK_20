package org.usfirst.frc.team79.robot.commands.feeder;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

public class StartConveyer extends Command {
	private double invert;

	public StartConveyer() {
		this(false);
	}

	public StartConveyer(boolean invert) {
		this.invert = (invert ? -0.6D : 1.0D);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.feeder.conveyer.set(-1.0D * this.invert);
	}

	protected boolean isFinished() {
		return true;
	}
}
