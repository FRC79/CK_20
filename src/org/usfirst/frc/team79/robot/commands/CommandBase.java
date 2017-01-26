package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain;
	public static subsystems intake;
	
	public static void init(){
		driveTrain = new DriveTrain(); 
	}
	
    public CommandBase() {   
    	super();
    }

}
