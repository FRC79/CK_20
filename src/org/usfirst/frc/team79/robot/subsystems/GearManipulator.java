package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearManipulator extends Subsystem {
	
	public DoubleSolenoid deploy = new DoubleSolenoid(RobotMap.GEAR_DOWN, RobotMap.GEAR_UP);
	public CANTalon intake = new CANTalon(RobotMap.GEAR_INTAKE);

	/**
	 * Initializes the double solenoid and motors for the gear manipulator.
	 */
	public GearManipulator(){}
	
	protected void initDefaultCommand() {
	}
}
