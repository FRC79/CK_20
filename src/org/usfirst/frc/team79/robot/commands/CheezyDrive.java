package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class CheezyDrive extends Command {
	public CheezyDrive() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	protected void execute() {
		double coeff = 1.0D;
		double invert = 1.0D;
		if (Robot.oi.getSlowDrivingMode()) {
			coeff = 0.7D;
		}
		Robot.driveTrain.FrontLeft
				.set(Robot.oi.getThrottle() * invert - Robot.oi.getSteering() * Robot.driveTrain.getTurningConstant());

		Robot.driveTrain.FrontRight
				.set(Robot.oi.getThrottle() * invert + Robot.oi.getSteering() * Robot.driveTrain.getTurningConstant());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
