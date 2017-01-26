package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	public CANTalon Intake = new CANTalon(RobotMap.INTAKE_MOTOR);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void StartIntake(double speed){
  	  Intake.set(speed);
  	   
  	   
     }
     public void StopIntake() {
  	  Intake.set(0);
  	   
     }
    
     
  
}

