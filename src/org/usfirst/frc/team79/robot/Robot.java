package org.usfirst.frc.team79.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team79.robot.commands.RetractIntake;
import org.usfirst.frc.team79.robot.commands.UnengageHanger;
import org.usfirst.frc.team79.robot.commands.auton.GearCenterAuton;
import org.usfirst.frc.team79.robot.commands.auton.GearCenterAutonOld;
import org.usfirst.frc.team79.robot.commands.auton.GearLeftAuton;
import org.usfirst.frc.team79.robot.commands.auton.GearRightAuton;
import org.usfirst.frc.team79.robot.commands.auton.GenerateMotionProfile;
import org.usfirst.frc.team79.robot.commands.auton.DriveForwardAuton;
import org.usfirst.frc.team79.robot.pathfinding.FWaypoint;
import org.usfirst.frc.team79.robot.pathfinding.IWaypoint;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.Feeder;
import org.usfirst.frc.team79.robot.subsystems.GearManipulator;
import org.usfirst.frc.team79.robot.subsystems.Intake;
import org.usfirst.frc.team79.robot.subsystems.Shooter;

public class Robot extends IterativeRobot {
	public Compressor pump;
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Feeder feeder;
	public static Intake intake;
	public static Shooter shooter;
	public static GearManipulator gearManipulator;
	CameraServer server;
	SendableChooser<Integer> autonChooser;

	public void robotInit() {
		driveTrain = new DriveTrain();
		feeder = new Feeder();
		intake = new Intake();
		shooter = new Shooter();
		gearManipulator = new GearManipulator();
		oi = new OI();

		this.pump = new Compressor();

		UsbCamera camera = new UsbCamera("cam0", 0);
		camera.setBrightness(7);
		this.server = CameraServer.getInstance();
		this.server.startAutomaticCapture(camera);

		SmartDashboard.putNumber("Heading to Boiler", 0.0D);
		SmartDashboard.putNumber("Center X", 0.0D);
		SmartDashboard.putNumber("Center Y", 0.0D);

		NetworkTable.getTable("SmartDashboard").setPersistent("Set Shooter Speed");

		SmartDashboard.putNumber("Velocity", 0.0D);

		this.autonChooser = new SendableChooser<Integer>();
		this.autonChooser.addDefault("Center Gear", 0);
		this.autonChooser.addObject("Forward Auto", 1);
		this.autonChooser.addObject("Left Gear", 2);
		this.autonChooser.addObject("Right Gear", 3);
		SmartDashboard.putData("Autonomous Chooser", this.autonChooser);
	}

	public void disabledInit() {
		driveTrain.FrontLeft.clearMotionProfileTrajectories();
		driveTrain.FrontRight.clearMotionProfileTrajectories();
		driveTrain.FrontLeft.setEncPosition(0);
		driveTrain.FrontRight.setEncPosition(0);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		this.pump.setClosedLoopControl(true);
		Scheduler.getInstance().add(new RetractIntake());
		Scheduler.getInstance().add(new UnengageHanger());
		switch(this.autonChooser.getSelected()){
			case 0:
				Scheduler.getInstance().add(new GearCenterAutonOld());
				break;
			case 1:
				Scheduler.getInstance().add(new DriveForwardAuton());
				break;
			case 2:
				Scheduler.getInstance().add(new GearLeftAuton());
				break;
			case 3:
				Scheduler.getInstance().add(new GearRightAuton());
		}
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", driveTrain.FrontLeft.getPosition());
		SmartDashboard.putNumber("Right Encoder", driveTrain.FrontRight.getPosition());
	}

	public void teleopInit() {
		this.pump.setClosedLoopControl(true);
	}

	public void robotPeriodic() {
		SmartDashboard.putNumber("Match Time", DriverStation.getInstance().getMatchTime());
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", driveTrain.getGyroAngle());
		SmartDashboard.putNumber("Left Encoder", driveTrain.FrontLeft.getPosition());
		SmartDashboard.putNumber("Right Encoder", driveTrain.FrontRight.getPosition());
		SmartDashboard.putNumber("Velocity", driveTrain.FrontLeft.getSpeed());
		SmartDashboard.putNumber("Shooter Velocity", shooter.shooterWheel.getSpeed());
	}

	public void testInit() {
		generateMPPoints();
	}

	public void testPeriodic() {
	}

	private void generateMPPoints() {
		System.out.println("Starting motion profiling point generation. Please wait...");
		GenerateMotionProfile.generate("DriveStraight",
				new Waypoint[] { new FWaypoint(0.0D, 0.0D, 0.0D), new FWaypoint(16.0D, 0.1D, 0.0D) });
		GenerateMotionProfile.generate("Gear",
				new Waypoint[] { new FWaypoint(0.0D, 0.0D, 0.0D), new IWaypoint(-81, 0.0D, 0.0D) });
		GenerateMotionProfile.generate("GearSidePart1", new IWaypoint(0, 0, 0), new IWaypoint(-105+RobotMap.ROBOT_LENGTH/2, 0, 0));
		GenerateMotionProfile.generate("GearSidePart2", new IWaypoint(0, 0, 0), new IWaypoint(-50, 0, 0));
		GenerateMotionProfile.generate("GearSidePart3", new IWaypoint(0, 0, 0), new IWaypoint(50, 0, 0));
		System.out.println("All points have been generated.");
	}
}
