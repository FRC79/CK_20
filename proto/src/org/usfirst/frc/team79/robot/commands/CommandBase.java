package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.GyroSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static DriveTrain arcadeDrive;
	public static GyroSystem gyro;
	
	public static void init(){
		arcadeDrive = new DriveTrain(); 
		gyro = new GyroSystem();
	}
	
    public CommandBase() {   
    	super();
    }

}
