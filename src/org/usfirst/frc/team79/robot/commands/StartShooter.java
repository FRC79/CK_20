package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StartShooter extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StartShooter(){
		requires(Robot.shooter);
	}
	
	public void execute(){
		Robot.shooter.shooterWheel.set(0.6);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
