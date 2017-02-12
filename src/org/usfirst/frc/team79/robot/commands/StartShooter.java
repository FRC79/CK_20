package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooter extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StartShooter(){
		requires(Robot.shooter);
	}
	
	public void execute(){
		Robot.shooter.shooterWheel.set(SmartDashboard.getNumber("Set Shooter Speed", 0));
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
