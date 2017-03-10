package org.usfirst.frc.team79.robot.commands.auton;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.commands.DriveTime;
import org.usfirst.frc.team79.robot.commands.GearDown;
import org.usfirst.frc.team79.robot.commands.GearUp;
import org.usfirst.frc.team79.robot.commands.WaitForIt;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class GearForwardAuton extends CommandGroup {
	public GearForwardAuton() {
		addSequential(new DriveTime(-0.8D, 1.0D));
		addSequential(new WaitForIt(1.0D));
		addSequential(new GearDown());
		addSequential(new WaitForIt(0.5D));
		addSequential(new DriveTime(0.8D, 0.5D));
		addSequential(new WaitForIt(1.0D));
		addSequential(new GearUp());
	}

	public void end() {
		Robot.driveTrain.FrontLeft.enableBrakeMode(false);
		Robot.driveTrain.FrontRight.enableBrakeMode(false);
	}
}
