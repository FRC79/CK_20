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
    
    public void startConveyer(double speed){
    	Conveyer.set(speed);
    }
    
    public void stopConveyer(){
    	Conveyer.set(0);
    }
    
    public void StartFeeder(double speed){
    	Feeder.set(speed);
    }
    
    public void StopFeeder(){
    	Feeder.set(0);
    }
    public void AllStart(double speed){
    	Conveyer.set(speed);
    	Feeder.set(speed);

    }
    public void AllStop(){
    	Conveyer.set(0);
    	Feeder.set(0);
    }
}

