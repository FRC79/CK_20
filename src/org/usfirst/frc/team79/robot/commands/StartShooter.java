package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooter extends Command{
	
	private double invert;
	public static Boolean stickControl;

	/**
	 * Toggles the shooter
	 */
	public StartShooter(){
		this(false);
	}
	public StartShooter(int nothing){
		this(false);
		stickControl = true;
	}
	
	public StartShooter(boolean invert){
		requires(Robot.shooter);
		this.invert = invert ? -0.15 : 1;
	}
	protected void initialize() {
		Robot.shooter.shooterWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void execute(){
		if(!stickControl){
			Robot.shooter.shooterWheel.set(SmartDashboard.getNumber("Set Shooter Speed", 0)*invert);
		}else{
			Robot.shooter.shooterWheel.set(Robot.oi.operatorStick.getY());
		}
	}

	@Override
	protected boolean isFinished() {
		return !stickControl;
	}

}
