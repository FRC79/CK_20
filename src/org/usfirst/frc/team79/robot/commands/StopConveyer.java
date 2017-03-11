package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;

public class StopConveyer extends Command {
	
	/**
	 * Stops the conveyer.
	 */
	public StopConveyer(){}
	
	public void execute() {
		Robot.feeder.conveyer.set(0.0D);
	}

	protected boolean isFinished() {
		return true;
	}
}
