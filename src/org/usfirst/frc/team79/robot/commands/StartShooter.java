package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class StartShooter extends Command {
	private double invert;
	public boolean stickControl;
	public boolean velocityControl;
	public double speed;

	public StartShooter() {
		this(false);
	}

	public StartShooter(int speed, boolean invert) {
		this(invert);
		this.speed = speed;
	}

	public StartShooter(boolean invert) {
		this.invert = (invert ? -0.15D : 1.0D);
		this.speed = 4000.0D;
	}

	protected void initialize() {
		Robot.shooter.shooterWheel.changeControlMode(CANTalon.TalonControlMode.Speed);
		Robot.shooter.shooterWheel.setEncPosition(0);
		if (SmartDashboard.getNumber("Set Shooter Speed", 0.0D) != 0.0D) {
			this.speed = SmartDashboard.getNumber("Set Shooter Speed", 0.0D);
		}
	}

	public void execute() {
		Robot.shooter.shooterWheel.set(this.speed * this.invert);
	}

	public void end() {
	}

	public void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return Robot.shooter.shooterWheel.getEncVelocity() > this.speed * this.invert - 200.0D;
	}
}
