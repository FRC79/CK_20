package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.Intake;

public class DeployIntake extends Command {
	
	/**
	 * Deploys the intake. Just like that.
	 */
	public DeployIntake() {
		requires(Robot.intake);
	}

	protected void execute() {
		if (Robot.feeder.conveyer.get() == 0.0D) {
			Robot.intake.deploy.set(DoubleSolenoid.Value.kReverse);
		}
	}

	protected boolean isFinished() {
		return true;
	}
}
