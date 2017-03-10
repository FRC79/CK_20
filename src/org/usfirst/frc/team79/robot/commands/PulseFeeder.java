package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class PulseFeeder extends Command {
	public void execute() {
		if (Robot.shooter.shooterWheel.getEncVelocity() > SmartDashboard.getNumber("Set Shooter Speed", 0.0D)) {
			Robot.feeder.feeder.set(1.0D);
			Robot.feeder.conveyer.set(-1.0D);
		} else {
			Robot.feeder.feeder.set(0.0D);
			Robot.feeder.conveyer.set(0.0D);
		}
	}

	protected boolean isFinished() {
		return true;
	}
}