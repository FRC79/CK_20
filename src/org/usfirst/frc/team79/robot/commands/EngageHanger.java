package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class EngageHanger extends Command {
	
	/**
	 * Engages the hanger to be controlled by the shooter motor.
	 */
	public EngageHanger(){}
	
	protected void execute() {
		Robot.shooter.solenoidShift.set(DoubleSolenoid.Value.kReverse);
	}

	protected boolean isFinished() {
		return true;
	}
}
