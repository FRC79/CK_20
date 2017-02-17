package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChangeProjection extends Command{

	/**
	 * Toggles the projection;
	 */
	public ChangeProjection(){
		requires(Robot.shooter);
	}
	
	public void execute(){
		Robot.shooter.pitchController.set(!Robot.shooter.pitchController.get());
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
