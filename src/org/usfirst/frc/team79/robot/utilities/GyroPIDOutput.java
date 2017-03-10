package org.usfirst.frc.team79.robot.utilities;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team79.robot.Robot;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

public class GyroPIDOutput implements PIDOutput {
	public void pidWrite(double value) {
		SmartDashboard.putNumber("PID Output", value);
		Robot.driveTrain.FrontLeft.set(-value*.8);
		Robot.driveTrain.FrontRight.set(value*.8);
	}
}
