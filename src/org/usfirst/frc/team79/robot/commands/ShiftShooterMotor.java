package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.utilities.ShiftState;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftShooterMotor extends Command{
	
	public ShiftState state;

	public ShiftShooterMotor(ShiftState state){
		this.state = state;
	}
	
	public void execute(){
		if(ShiftState.getStateByValue(Robot.shooter.shift.get()) != state){
			Robot.shooter.shift.set(state.value);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
