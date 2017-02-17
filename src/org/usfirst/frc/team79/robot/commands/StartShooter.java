package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooter extends Command{
	
	private double invert;
	
	/**
	 * Toggles the shooter
	 */
	public StartShooter(){
		this(false);
	}
	
	public StartShooter(boolean invert){
		requires(Robot.shooter);
		this.invert = invert ? -0.15 : 1;
	}
	
	public void execute(){
		Robot.shooter.shooterWheel.set(SmartDashboard.getNumber("Set Shooter Speed", 0)*invert);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
