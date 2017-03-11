package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.commands.DriveTime;
import org.usfirst.frc.team79.robot.commands.WaitForIt;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class DriveForwardAuton extends CommandGroup {
	
	/**
	 * The autonomous function to call if you want to cross into the neutral zone.
	 */
	public DriveForwardAuton() {
		addSequential(new DriveTime(0.8D, 1.65D));
		addSequential(new WaitForIt(1.0D));
	}

	public void end() {
		Robot.driveTrain.FrontLeft.enableBrakeMode(false);
		Robot.driveTrain.FrontRight.enableBrakeMode(false);
	}
}
