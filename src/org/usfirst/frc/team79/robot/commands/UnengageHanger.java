package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class UnengageHanger extends Command{
	
	public UnengageHanger(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		System.out.println("Backwards");
		Robot.shooter.solenoidShift.set(DoubleSolenoid.Value.kReverse);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
