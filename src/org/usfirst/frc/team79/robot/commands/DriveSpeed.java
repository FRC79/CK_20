package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class DriveSpeed extends Command {
	double speed;

	public DriveSpeed(double speed) {
		this.speed = (1440.0D * speed / 60.0D);
	}

	protected void initialize() {
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.Speed);
	}

	protected void execute() {
		Robot.driveTrain.FrontLeft.set(this.speed);
		Robot.driveTrain.FrontRight.set(-this.speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
