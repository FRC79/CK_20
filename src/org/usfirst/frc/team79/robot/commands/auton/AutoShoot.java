package org.usfirst.frc.team79.robot.commands.auton;

import java.util.ArrayList;

import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.utilities.ProjectionEnum;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup{
	
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	public AutoShoot(){
		add(new AlignShooter());
	}
	
	public void initialize(){
		double distance = ProcessGripData.getDistance();
		double projection = Math.toRadians(ProjectionEnum.getByValue(null).angle); //The solenoid for setting the projection is in button-mappings.
		double ballVelocity = distance/(Math.cos(projection)*(Math.sqrt((RobotMap.BOILER_HEIGHT-RobotMap.CAMERA_HEIGHT-distance*Math.tan(projection))/(4.905))));
		double shooterTargetVelocity = ballVelocity / RobotMap.SHOOTER_WHEEL_RADIUS / (2*Math.PI) * 60; //RPM
		if(shooterTargetVelocity > RobotMap.SHOOTER_MAX_VELOCITY); //Change angle and try again.
	}
	
	public void add(Command command){
		this.addSequential(command);
	}

}
