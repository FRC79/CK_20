package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateTime extends Command{
	
	public double invert;
	public Timer timer;
	public double time;
	public double speed;
	
	/**
	 * Rotates with the given speed for a certain time.
	 * @param invert counterclockwise if true, clockwise if false.
	 * @param speed Percentage.
	 * @param time Seconds.
	 */
	public RotateTime(boolean invert, double speed, double time){
		this.invert = invert ? -1 : 1;
		this.speed = speed;
		this.time = time;
	}
	
	public void initialize(){
		Robot.driveTrain.FrontLeft.changeControlMode(TalonControlMode.PercentVbus);
		Robot.driveTrain.FrontRight.changeControlMode(TalonControlMode.PercentVbus);
		timer = new Timer();
		timer.start();
	}
	
	public void execute(){
		System.out.println(speed*invert);
		Robot.driveTrain.FrontLeft.set(-speed*invert);
		Robot.driveTrain.FrontRight.set(speed*invert);
	}
	
	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

}
