package subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	
	public CANTalon intake = new CANTalon(RobotMap.intake_Motor);
	

	

    public void initDefaultCommand() {
        	
    
    	
    	
    }
    
    
   public void startIntake(double speed){
	  intake.set(speed);
	   
	   
   }
   public void stopIntake() {
	   intake.set(0);
	   
   }
  
   
}

