package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class StartShooter extends Command{
	
	public double speed;
	
	/**
	 * Set the shooter to a certain speed in RPM
	 * @param speed RPM
	 */
	public StartShooter(double speed){
		this.speed = speed;
	}
	
	protected void initialize(){
		Robot.shooter.shooterWheel.changeControlMode(TalonControlMode.Speed);
		Robot.shooter.shooterWheel.setEncPosition(0);
		Robot.shooter.shooterWheel.setAllowableClosedLoopErr(360);
	}
	
	protected void execute(){
		Robot.shooter.shooterWheel.set(speed);
	}
	
	protected void end(){
		Robot.shooter.shooterWheel.set(0);
	}
	
	protected void interrupted(){
		this.end();
	}

	@Override
	protected boolean isFinished() {
		return Robot.shooter.shooterWheel.getError() < 0.5;
	}

}
