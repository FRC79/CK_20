package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StopIntake;

/**
 *
 */
public class Intake extends Subsystem {

	public CANTalon intake = new CANTalon(RobotMap.INTAKE_MOTOR);
	public DoubleSolenoid deploy = new DoubleSolenoid(RobotMap.INTAKE_DEPLOY_FORWARDS, RobotMap.INTAKE_DEPLOY_BACKWARDS);
	
	public Intake(){
	}
	
	public void initDefaultCommand(){
		new StopIntake();
	}


}
