package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	public CANTalon intake = new CANTalon(7);
	public DoubleSolenoid deploy = new DoubleSolenoid(0, 1);

	public void initDefaultCommand() {
	}
}
