package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooter extends Command{
	
	private double invert;
	public boolean stickControl;
	public boolean velocityControl;
	
	/**
	 * Toggles the shooter
	 */
	public StartShooter(){
		this(false);
	}
	
	/**
	 * Used for manual stick control or closed-loop velocity control, if given in the dashboard.
	 * @param nothing
	 */
	public StartShooter(int nothing){
		this(false);
		stickControl = true;
	}
	
	public StartShooter(boolean invert){
		this.invert = invert ? -0.15 : 1;
	}
	protected void initialize() {
		velocityControl = SmartDashboard.getBoolean("Use Auto Shoot", false);
		if(velocityControl){
			Robot.shooter.shooterWheel.changeControlMode(TalonControlMode.Speed);
			Robot.shooter.shooterWheel.setEncPosition(0);
		}
		else {
			Robot.shooter.shooterWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		}
	}
	
	public void execute(){
		if(velocityControl){
			Robot.shooter.shooterWheel.set(SmartDashboard.getNumber("Auto Shooter Speed", 0));
		}else if(stickControl){
			Robot.shooter.shooterWheel.set(Robot.oi.operatorStick.getY()*-1d);
			
		}else{
			Robot.shooter.shooterWheel.set(SmartDashboard.getNumber("Set Shooter Speed", 0)*invert);
		}
	}
	
	public void end(){
	}
	
	public void interrupted(){
		end();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
