package subsystems;

import java.awt.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	
	public CANTalon intake = new CANTalon(RobotMap.Intake_Motor);
	

	

  
    
   public void StartIntake(double speed){
	  subsystems.intake.set(double speed);
	   
	   
   }
   public void StopIntake() {
	  intake.set();
	   
   }
  
   
}

