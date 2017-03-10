package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class DriveTime extends Command {
	public double speed;
	public Timer timer;
	public double time;

	public DriveTime(double speed, double time) {
		this.speed = speed;
		this.time = time;
	}

	protected void initialize() {
		Robot.driveTrain.FrontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		this.timer = new Timer();
		this.timer.start();
	}

	public void execute() {
		Robot.driveTrain.FrontLeft.set(-this.speed);
		Robot.driveTrain.FrontRight.set(-this.speed);
	}

	public void end() {
		Robot.driveTrain.FrontLeft.enableBrakeMode(true);
		Robot.driveTrain.FrontRight.enableBrakeMode(true);
		Robot.driveTrain.FrontLeft.set(0.0D);
		Robot.driveTrain.FrontRight.set(0.0D);
	}

	public void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return this.timer.hasPeriodPassed(this.time);
	}
}
