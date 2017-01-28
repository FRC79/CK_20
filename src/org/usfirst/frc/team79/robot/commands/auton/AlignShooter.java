package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AlignShooter extends CommandGroup {
	
	/**
	 * Aligns the shooter to face the boiler.
	 */
	public AlignShooter() {
		addSequential(new ProcessGripData());
		
		//Commented out for testing purposes
//		addSequential(new RotateDegrees(SmartDashboard.getNumber("Header to Boiler", 0)));
	} 

}
