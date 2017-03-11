package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team79.robot.commands.StartShooter;

public class AutoShoot extends CommandGroup {
	Command shootCom;

	/**
	 * Theoretically starts the shooter with the correct velocity to shoot accurately.
	 */
	public AutoShoot() {
		addSequential(this.shootCom = new StartShooter(3500, false));
	}

	public void initialize() {
		double projection = Math.toRadians(70.0D);
		double target = 0.0D;
		if ((target = calculateVelocity(projection)) > 5000.0D) {
			target = calculateVelocity(80.0D);
		}
	}

	public double calculateVelocity(double projection) {
		double distance = ProcessGripData.getDistance();
		double ballVelocity = distance
				/ (Math.cos(projection) * Math.sqrt((6.058333333333334D - distance * Math.tan(projection)) / 4.905D));
		return ballVelocity / 1.0D / 6.283185307179586D * 60.0D;
	}
}
