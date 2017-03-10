package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearManipulator extends Subsystem {
	public DoubleSolenoid deploy = new DoubleSolenoid(3, 2);
	public CANTalon intake = new CANTalon(10);

	protected void initDefaultCommand() {
	}
}
