package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team79.robot.commands.WaitForIt;
import org.usfirst.frc.team79.robot.pathfinding.IWaypoint;

public class OperationShootBalls extends CommandGroup {
	public OperationShootBalls() {
		String alliance = DriverStation.getInstance().getAlliance().name();
		int invert = alliance.equals("Red") ? 1 : -1;

		GenerateMotionProfile.generate(new Waypoint[] {
				new IWaypoint(18.0D, invert * SmartDashboard.getNumber("Y Offset", 0.0D) + 20.0D, 0.0D) });
		addSequential(new ExecuteMotionProfile());
		addSequential(new ExecuteMotionProfile(alliance + "ShootBallsPart1"));
		addSequential(new WaitForIt(2.0D));
		addSequential(new ExecuteMotionProfile(alliance + "ShootBallsPart2"));
		addSequential(new AutoShoot());
	}
}
