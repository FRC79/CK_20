package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {

		public CANTalon Conveyer = new CANTalon(RobotMap.CONVEYER_MOTOR);
		public CANTalon Feeder = new CANTalon(RobotMap.FEEDER_MOTOR);
  

    public void initDefaultCommand() {
    	
    }
    
}
