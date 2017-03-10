package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class EngageHanger extends Command {
	protected void execute() {
		Robot.shooter.solenoidShift.set(DoubleSolenoid.Value.kForward);
	}

	protected boolean isFinished() {
		return true;
	}
}
