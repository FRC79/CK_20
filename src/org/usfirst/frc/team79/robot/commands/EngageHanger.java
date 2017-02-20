package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class EngageHanger extends Command{

	public EngageHanger(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		System.out.println("Forward");
		Robot.shooter.solenoidShift.set(DoubleSolenoid.Value.kForward);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
