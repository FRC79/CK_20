package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.DriveTime;
import org.usfirst.frc.team79.robot.commands.RunFeederConveyer;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.commands.StopFiringSubsystems;
import org.usfirst.frc.team79.robot.commands.WaitForIt;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BlueBallsAuton extends CommandGroup{
	
	public BlueBallsAuton(){
		this.addSequential(new StopFiringSubsystems());
		this.addSequential(new StartShooter());
		this.addSequential(new WaitForIt(2));
		this.addSequential(new RunFeederConveyer(false));
		this.addSequential(new WaitForIt(5));
		this.addSequential(new StopFiringSubsystems());
		this.addSequential(new DriveTime(-0.7, 0.2));
		this.addSequential(new RotateTime(true, 0.7, 0.39));
		this.addSequential(new DriveTime(-0.7, 1.1));
	}

}
