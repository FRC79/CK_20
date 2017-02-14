package org.usfirst.frc.team79.robot.utilities;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public enum ShiftState {
	
	SHOOTER("Shooter", Value.kForward),
	CLIMBER("Climber", Value.kReverse);
	
	public final String name;
	public final Value value;
	
	private ShiftState(String name, Value value){
		this.name = name;
		this.value = value;
	}
	
	public static ShiftState getStateByValue(Value value){
		return value==Value.kForward ? SHOOTER : value==Value.kReverse ? CLIMBER : null;
	}
	
}
