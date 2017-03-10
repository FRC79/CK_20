package org.usfirst.frc.team79.robot.commands;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class ManualShooterControl extends Command {
	public ManualShooterControl() {
		requires(Robot.shooter);
	}

	public void initialize() {
		Robot.shooter.shooterWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public void execute() {
		Robot.shooter.shooterWheel.set(-Robot.oi.operatorStick.getRawAxis(1));
	}

	protected boolean isFinished() {
		return true;
	}
}
