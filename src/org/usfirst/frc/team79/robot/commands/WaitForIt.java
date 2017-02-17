package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForIt extends Command{
	
	public double time;
	private Timer timer;
	
	/**
	 * Waits for a set amount of time in seconds.
	 * @param time in seconds
	 */
	public WaitForIt(double time){
		this.time = time;
	}
	
	protected void initialize(){
		timer = new Timer();
		timer.start();
	}

	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}
	
	protected void end(){
		timer.stop();
	}
	
	protected void interrupted(){
		this.end();
	}

}