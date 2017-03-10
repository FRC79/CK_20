package org.usfirst.frc.team79.robot.utilities;

import com.ctre.CANTalon;
import com.ctre.CANTalon.MotionProfileStatus;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TrajectoryPoint;
import edu.wpi.first.wpilibj.Timer;
import java.io.PrintStream;

public class MPOutput {
	static double timeout = 0.0D;
	static int count = 0;
	private static final String[] _table = { " Dis ", " En  ", "Hold " };

	public static void OnUnderrun() {
		System.out.format("%s\n", new Object[] { "UNDERRUN" });
	}

	public static void OnNoProgress() {
		System.out.format("%s\n", new Object[] { "NOPROGRESS" });
	}

	private static String StrOutputEnable(CANTalon.SetValueMotionProfile sv) {
		if (sv == null) {
			return "null";
		}
		if (sv.value > 3) {
			return "Inval";
		}
		return _table[sv.value];
	}

	private static double round(double toround) {
		long whole = (long) (toround * 1000000.0D + 0.5D);
		return whole * 1.0E-6D;
	}

	public static void process(CANTalon.MotionProfileStatus status1) {
		double now = Timer.getFPGATimestamp();
		if (now - timeout > 0.2D) {
			timeout = now;
			if (--count <= 0) {
				count = 8;

				System.out.format("%-9s\t", new Object[] { "topCnt" });
				System.out.format("%-9s\t", new Object[] { "btmCnt" });
				System.out.format("%-9s\t", new Object[] { "set val" });
				System.out.format("%-9s\t", new Object[] { "HasUnder" });
				System.out.format("%-9s\t", new Object[] { "IsUnder" });
				System.out.format("%-9s\t", new Object[] { "IsValid" });
				System.out.format("%-9s\t", new Object[] { "IsLast" });
				System.out.format("%-9s\t", new Object[] { "VelOnly" });
				System.out.format("%-9s\t", new Object[] { "Pos" });
				System.out.format("%-9s\t", new Object[] { "Vel" });

				System.out.format("\n", new Object[0]);
			}
			System.out.format("%-9s\t", new Object[] { Integer.valueOf(status1.topBufferCnt) });
			System.out.format("%-9s\t", new Object[] { Integer.valueOf(status1.btmBufferCnt) });
			System.out.format("%-9s\t", new Object[] { StrOutputEnable(status1.outputEnable) });
			System.out.format("%-9s\t", new Object[] { status1.hasUnderrun ? "1" : "" });
			System.out.format("%-9s\t", new Object[] { status1.isUnderrun ? "1" : "" });
			System.out.format("%-9s\t", new Object[] { status1.activePointValid ? "1" : "" });
			System.out.format("%-9s\t", new Object[] { status1.activePoint.isLastPoint ? "1" : "" });
			System.out.format("%-9s\t", new Object[] { status1.activePoint.velocityOnly ? "1" : "" });
			System.out.format("%-9s\t", new Object[] { Double.valueOf(round(status1.activePoint.position)) });
			System.out.format("%-9s\t", new Object[] { Double.valueOf(round(status1.activePoint.velocity)) });

			System.out.format("\n", new Object[0]);
		}
	}
}
