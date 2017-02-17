package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StopConveyer;
import org.usfirst.frc.team79.robot.commands.StopFeeder;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {

		public CANTalon conveyer = new CANTalon(RobotMap.CONVEYER_MOTOR);
		public CANTalon feeder = new CANTalon(RobotMap.FEEDER_MOTOR);
		public Feeder(){
			conveyer.reverseOutput(true);
		}
		
    public void initDefaultCommand() {
    	new StopConveyer();
    }
    
}

