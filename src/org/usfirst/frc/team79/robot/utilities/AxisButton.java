package org.usfirst.frc.team79.robot.utilities;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.tables.ITable;

public class AxisButton extends Trigger {
	private int axis;
	private GenericHID joystick;
	private ITable m_table;

	public AxisButton(GenericHID joystick, int axis) {
		this.joystick = joystick;
		this.axis = axis;
	}

	public boolean get(double value, double tolerance) {
		return (this.joystick.getRawAxis(this.axis) >= value - tolerance)
				&& (this.joystick.getRawAxis(this.axis) <= value + tolerance);
	}

	public void whenActive(final Command command, double value, double tolerance) {
		new Trigger.ButtonScheduler() {
			private boolean m_pressedLast = get(value, tolerance);

			public void execute() {
				if (get(value, tolerance)) {
					if (!this.m_pressedLast) {
						this.m_pressedLast = true;
						command.start();
					}
				} else {
					this.m_pressedLast = false;
				}
			}

			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	public void whileActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {
			private boolean m_pressedLast = get(value, tolerance);

			public void execute() {
				if (get(value, tolerance)) {
					this.m_pressedLast = true;
					command.start();
				} else if (this.m_pressedLast) {
					this.m_pressedLast = false;
					command.cancel();
				}
			}

			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	public void whenInactive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {
			private boolean m_pressedLast = get(value, tolerance);

			public void execute() {
				if (get(value, tolerance)) {
					this.m_pressedLast = true;
				} else if (this.m_pressedLast) {
					this.m_pressedLast = false;
					command.start();
				}
			}

			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	public void toggleWhenActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {
			private boolean m_pressedLast = AxisButton.this.get(value, tolerance);

			public void execute() {
				if (get(value, tolerance)) {
					if (!this.m_pressedLast) {
						this.m_pressedLast = true;
						if (command.isRunning()) {
							command.cancel();
						} else {
							command.start();
						}
					}
				} else {
					this.m_pressedLast = false;
				}
			}

			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	public void cancelWhenActive(final Command command, final double value, double tolerance) {
		new ButtonScheduler() {
			private boolean m_pressedLast = get(value, tolerance);

			public void execute() {
				if (get(value, tolerance)) {
					if (!this.m_pressedLast) {
						this.m_pressedLast = true;
						command.cancel();
					}
				} else {
					this.m_pressedLast = false;
				}
			}

			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	public String getSmartDashboardType() {
		return "Button";
	}

	public void initTable(ITable table) {
		this.m_table = table;
		if (table != null) {
			table.putBoolean("pressed", get());
		}
	}

	public ITable getTable() {
		return this.m_table;
	}

	public boolean get() {
		return false;
	}
}
