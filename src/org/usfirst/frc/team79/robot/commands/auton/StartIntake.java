package commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class StartIntake extends auton {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

   
    
    public StartIntake(){
    	requires(Robot.intake);
    	
    }
    public void execute() {
    	intake.StartIntake();
    	
    	
    	
    	
    }
}

