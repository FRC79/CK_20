package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team79.robot.Robot;

/**
 *
 */
public class StartIntake extends Command {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public StartIntake(){
    	requires(Robot.intake);

    }
    public void execute() {
    	Robot.intake.intake.set(1.0);
    }

    public boolean isFinished() {
      return false;
    }
}
