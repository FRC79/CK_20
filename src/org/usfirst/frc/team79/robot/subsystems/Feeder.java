package org.usfirst.frc.team79.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StopConveyer;

public class Feeder extends Subsystem {
	public CANTalon conveyer = new CANTalon(RobotMap.CONVEYER_MOTOR);
	public CANTalon feeder = new CANTalon(RobotMap.FEEDER_MOTOR);

	public Feeder() {
		this.conveyer.reverseOutput(true);
	}

	public void initDefaultCommand() {
		new StopConveyer();
	}
}
