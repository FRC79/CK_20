package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.commands.DriveTime;
import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.WaitForIt;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideGearAuton extends CommandGroup{
	
	/**
	 * Angle the robot from the side and drive straight.
	 */
	public SideGearAuton(){
		addSequential(new DriveAngle(-0.32D, 3.1D));
		addSequential(new WaitForIt(1.0D));
		addSequential(new GearDown());
		addSequential(new WaitForIt(0.5D));
		addSequential(new DriveAngle(0.8D, 0.5D));
		addSequential(new WaitForIt(1.0D));
		addSequential(new GearUp());
	}

	public void end() {
		Robot.driveTrain.FrontLeft.enableBrakeMode(false);
		Robot.driveTrain.FrontRight.enableBrakeMode(false);
	}

}
