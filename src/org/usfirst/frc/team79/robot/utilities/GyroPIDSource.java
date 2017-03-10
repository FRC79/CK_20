package org.usfirst.frc.team79.robot.utilities;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class GyroPIDSource implements PIDSource {
	PIDSourceType sourceType;

	public GyroPIDSource() {
		this.sourceType = PIDSourceType.kDisplacement;
	}

	public void setPIDSourceType(PIDSourceType pidSource) {
		this.sourceType = pidSource;
	}

	public PIDSourceType getPIDSourceType() {
		return this.sourceType;
	}

	public double pidGet() {
		return Robot.driveTrain.gyro.getAngle();
	}
}
