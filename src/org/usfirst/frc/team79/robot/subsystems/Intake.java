package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team79.robot.RobotMap;

/**
 *
 */
public class Intake extends Subsystem {

	public CANTalon intake = new CANTalon(RobotMap.INTAKE_MOTOR);

	 public void initDefaultCommand(){

	 }


}
