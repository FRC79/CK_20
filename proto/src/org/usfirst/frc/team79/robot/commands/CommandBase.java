package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static DriveTrain arcadeDrive;
	public static DriveTrain gyro;
	
	public static void init(){
		arcadeDrive = new DriveTrain(); 
		gyro = new DriveTrain();
	}
	
    public CommandBase() {   
    	super();
    }

}
