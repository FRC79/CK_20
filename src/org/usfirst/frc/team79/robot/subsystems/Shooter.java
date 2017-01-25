package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	/*
	 * under the assumption that shooter mechanism includes a shooter motor and an articulation motor
	 */
	CANTalon shooter;
	CANTalon articulator;
	
	public Shooter() {
		shooter = new CANTalon(RobotMap.SHOOTER_MOTOR);
		articulator = new CANTalon(RobotMap.SHOOTER_ARTICULATOR);
	}
	
	/*
	 * not sure if we want speed to be variable or not
	 */
	public void shoot(double velocity) {
		shooter.set(velocity);
	}
	
	public void stopShooter() {
		shooter.set(0);
	}
	
	/*
	 * not entirely sure if there will be an articulator on the shooter
	 * implementation comes when final cad supports it
	 */
	public void setShooterAngle() {
		//TODO:
	}

	@Override
	protected void initDefaultCommand() {

	}

}
