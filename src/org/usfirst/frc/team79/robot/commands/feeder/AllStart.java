package org.usfirst.frc.team79.robot.commands.feeder;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

public class AllStart extends Command {
	public AllStart() {
		requires(Robot.feeder);
	}

	protected void initialize() {
	}

	protected void execute() {
		if ((Robot.feeder.conveyer.get() != 0.0D) || (Robot.feeder.feeder.get() != 0.0D)) {
			Robot.feeder.conveyer.set(0.0D);
			Robot.feeder.feeder.set(0.0D);
		} else {
			Robot.feeder.conveyer.set(1.0D);
			Robot.feeder.feeder.set(1.0D);
		}
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
