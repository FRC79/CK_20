package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AlignShooter extends CommandGroup {
	
	/**
	 * Aligns the shooter to face the boiler.
	 */
	public AlignShooter() {}
	
	public void execute(){
		//The NetworkTable used to get GRIP data from drive station. All data will be calculated on driver station.
		NetworkTable grip = NetworkTable.getTable("grip");
		addSequential(new RotateDegrees(grip.getNumber("boilerTape/yawDegrees", 0d)));
		//There will probably be more commands, like rotating pitch.
	}

}
