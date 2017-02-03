package org.usfirst.frc.team79.robot.utilities;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class GyroPIDOutput implements PIDOutput{

	@Override
	public void pidWrite(double value) {
		Robot.driveTrain.FrontLeft.set(value);
		Robot.driveTrain.FrontRight.set(-value);
	}

}
