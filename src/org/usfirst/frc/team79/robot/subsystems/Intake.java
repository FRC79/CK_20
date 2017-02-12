package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StopIntake;

/**
 *
 */
public class Intake extends Subsystem {

	public CANTalon intake = new CANTalon(RobotMap.INTAKE_MOTOR);
	
	public Intake(){ 
	}
	 public void initDefaultCommand(){
		 new StopIntake();
	 }


}
