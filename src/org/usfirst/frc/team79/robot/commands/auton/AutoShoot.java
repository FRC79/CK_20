package org.usfirst.frc.team79.robot.commands.auton;

import java.util.ArrayList;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.commands.StartShooter;
import org.usfirst.frc.team79.robot.utilities.ProjectionEnum;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup{
	
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	public AutoShoot(){
		add(new AlignShooter());
		add(new StartShooter(0));
	}
	
	public void initialize(){
		double projection = Math.toRadians(ProjectionEnum.DOWN.angle);
		double target = 0;
		if((target=calculateVelocity(projection))>RobotMap.SHOOTER_MAX_VELOCITY){
			target = calculateVelocity(ProjectionEnum.UP.angle);
		}
		((StartShooter)commands.get(1)).speed = target;
		System.out.println("Shooter set to " + target + " RPM");
	}
	
	public double calculateVelocity(double projection){
		double distance = ProcessGripData.getDistance();
		double ballVelocity = distance/(Math.cos(projection)*(Math.sqrt((RobotMap.BOILER_HEIGHT-RobotMap.CAMERA_HEIGHT-distance*Math.tan(projection))/(4.905))));
		return ballVelocity / RobotMap.SHOOTER_WHEEL_RADIUS / (2*Math.PI) * 60; // ft/s to RPM
	}
	
	public void add(Command command){
		this.addSequential(command);
		commands.add(command);
	}

}
