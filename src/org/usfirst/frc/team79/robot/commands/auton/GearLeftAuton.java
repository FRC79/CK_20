package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.DriveTime;
import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.WaitForIt;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearLeftAuton extends CommandGroup{
	
	public GearLeftAuton(){
		this.addSequential(new DriveTime(-0.8D, 0.965D));
		this.addSequential(new WaitForIt(.8));
		this.addSequential(new RotateTime(false, 0.5, 0.45));
		this.addSequential(new WaitForIt(.8));
		this.addSequential(new DriveTime(-0.8, 0.65));
		this.addSequential(new WaitForIt(.5));
		this.addSequential(new GearDown());
		this.addSequential(new WaitForIt(.5));
		this.addSequential(new DriveTime(0.5, 1));
		this.addSequential(new GearUp());
	}

}
