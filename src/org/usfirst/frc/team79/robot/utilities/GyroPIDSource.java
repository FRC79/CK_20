package org.usfirst.frc.team79.robot.utilities;

import org.usfirst.frc.team79.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroPIDSource implements PIDSource{
	
	PIDSourceType sourceType;
	
	public GyroPIDSource(){
		this.sourceType = PIDSourceType.kDisplacement;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		sourceType = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	@Override
	public double pidGet() {
		return Robot.driveTrain.gyro.getAngle();
	}

}
