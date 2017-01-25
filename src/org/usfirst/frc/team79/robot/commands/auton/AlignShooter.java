package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AlignShooter extends CommandGroup {
	
	/**
	 * Aligns the shooter to face the boiler.
	 */
	public AlignShooter() {}
	
	protected void execute(){
		addSequential(new ProcessGripData());
		addSequential(new RotateDegrees(SmartDashboard.getNumber("boilerHeader", 0)));
		//There will probably be more commands, like rotating pitch.
	}

}
