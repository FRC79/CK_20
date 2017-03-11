package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	public CANTalon intake = new CANTalon(RobotMap.INTAKE_MOTOR);
	public DoubleSolenoid deploy = new DoubleSolenoid(RobotMap.INTAKE_DEPLOY_DOWN, RobotMap.INTAKE_DEPLOY_UP);

	/**
	 * Initializes the intake motor and double solenoid.
	 */
	public Intake(){}
	
	public void initDefaultCommand() {
	}
}
