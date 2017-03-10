package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForIt extends Command {
	public double time;
	private Timer timer;

	public WaitForIt(double time) {
		this.time = time;
	}

	protected void initialize() {
		this.timer = new Timer();
		this.timer.start();
	}

	protected boolean isFinished() {
		return this.timer.hasPeriodPassed(this.time);
	}

	protected void end() {
		this.timer.stop();
	}

	protected void interrupted() {
		end();
	}
}
