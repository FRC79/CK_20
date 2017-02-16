package org.usfirst.frc.team79.robot.utilities;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public enum ProjectionEnum {
	
	UP(30, Value.kForward),
	DOWN(18, Value.kReverse);
	
	public final double angle;
	public final Value value;
	
	ProjectionEnum(double angle, Value value){
		this.angle = angle;
		this.value = value;
	}
	
	public static ProjectionEnum getByValue(Value value){
		return value==Value.kForward ? UP : value==Value.kReverse ? DOWN : null;
	}

}
