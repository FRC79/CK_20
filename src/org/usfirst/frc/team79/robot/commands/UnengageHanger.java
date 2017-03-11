package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import java.io.PrintStream;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class UnengageHanger extends Command {
	
	/**
	 * Disengages the hanger from being controlled by the shooter motor.
	 */
	public UnengageHanger(){
		
	}
	
	protected void execute() {
		System.out.println("Backwards");
		Robot.shooter.solenoidShift.set(DoubleSolenoid.Value.kForward);
	}

	protected boolean isFinished() {
		return true;
	}
}
