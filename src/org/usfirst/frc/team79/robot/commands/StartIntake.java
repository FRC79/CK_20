package commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class startIntake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

   
    
    public startIntake(){
    	requires(Robot.intake);
    	
    }
    public void execute() {
    	Robot.intake.startIntake();
    	
    	
    	
    	
    }
}

