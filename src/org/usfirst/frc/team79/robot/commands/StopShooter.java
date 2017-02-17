package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopShooter extends Command{
	
	/**
	 * Toggles the shooter
	 */
	public StopShooter(){
		requires(Robot.shooter);
	}
	
	public void execute(){
		Robot.shooter.shooterWheel.set(0);
		StartShooter.stickControl = false;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}