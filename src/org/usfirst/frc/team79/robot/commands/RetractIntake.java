package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.Intake;

public class RetractIntake extends Command {
	public RetractIntake() {
		requires(Robot.intake);
	}

	protected void execute() {
		if (Robot.feeder.conveyer.get() == 0.0D) {
			Robot.intake.deploy.set(DoubleSolenoid.Value.kForward);
		}
	}

	protected boolean isFinished() {
		return true;
	}
}
