package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoShoot extends CommandGroup{
	
	public AutoShoot(){
		this.addSequential(new AlignShooter());
	}
	
	public void initialize(){
		double projection = Math.toRadians(RobotMap.HOOD_DOWN_ANGLE);
		double target = 0;
		if((target=calculateVelocity(projection))>RobotMap.SHOOTER_MAX_VELOCITY){
			target = calculateVelocity(RobotMap.HOOD_UP_ANGLE);
		}
		SmartDashboard.putNumber("Auto Shooter Speed", target);
	}
	
	public double calculateVelocity(double projection){
		double distance = ProcessGripData.getDistance();
		double ballVelocity = distance/(Math.cos(projection)*(Math.sqrt((RobotMap.BOILER_HEIGHT-RobotMap.CAMERA_HEIGHT-distance*Math.tan(projection))/(4.905))));
		return ballVelocity / RobotMap.SHOOTER_WHEEL_RADIUS / (2*Math.PI) * 60; // ft/s to RPM
	}

}
