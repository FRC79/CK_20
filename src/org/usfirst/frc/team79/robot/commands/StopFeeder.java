package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

public class StopFeeder extends Command {
	public void execute() {
		Robot.feeder.feeder.set(0.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}
