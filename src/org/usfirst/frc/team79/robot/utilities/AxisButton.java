package org.usfirst.frc.team79.robot.utilities;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.tables.ITable;

public class AxisButton extends Trigger {

	private int axis;
	private GenericHID joystick;

	public AxisButton(GenericHID joystick, int axis) {
		this.joystick = joystick;
		this.axis = axis;
	}

	/**
	 * Returns whether or not the trigger is active.
	 *
	 * <p>
	 * This method will be called repeatedly a command is linked to the Trigger.
	 *
	 * @return whether or not the trigger condition is active.
	 */
	public boolean get(double value, double tolerance) {
		return this.joystick.getRawAxis(axis) >= value - tolerance && this.joystick.getRawAxis(axis) <= value + tolerance;
	}

	/**
	 * Starts the given command whenever the trigger just becomes active.
	 *
	 * @param command
	 *            the command to start
	 */
	public void whenActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {

			private boolean m_pressedLast = get(value, tolerance);

			@Override
			public void execute() {
				if (get(value, tolerance)) {
					if (!m_pressedLast) {
						m_pressedLast = true;
						command.start();
					}
				} else {
					m_pressedLast = false;
				}
			}

			@Override
			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	/**
	 * Constantly starts the given command while the button is held.
	 *
	 * {@link Command#start()} will be called repeatedly while the trigger is
	 * active, and will be canceled when the trigger becomes inactive.
	 *
	 * @param command
	 *            the command to start
	 */
	public void whileActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {

			private boolean m_pressedLast = get(value, tolerance);

			@Override
			public void execute() {
				if (get(value, tolerance)) {
					m_pressedLast = true;
					command.start();
				} else {
					if (m_pressedLast) {
						m_pressedLast = false;
						command.cancel();
					}
				}
			}

			@Override
			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	/**
	 * Starts the command when the trigger becomes inactive.
	 *
	 * @param command
	 *            the command to start
	 */
	public void whenInactive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {

			private boolean m_pressedLast = get(value, tolerance);

			@Override
			public void execute() {
				if (get(value, tolerance)) {
					m_pressedLast = true;
				} else {
					if (m_pressedLast) {
						m_pressedLast = false;
						command.start();
					}
				}
			}

			@Override
			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	/**
	 * Toggles a command when the trigger becomes active.
	 *
	 * @param command
	 *            the command to toggle
	 */
	public void toggleWhenActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {

			private boolean m_pressedLast = get(value, tolerance);

			@Override
			public void execute() {
				if (get(value, tolerance)) {
					if (!m_pressedLast) {
						m_pressedLast = true;
						if (command.isRunning()) {
							command.cancel();
						} else {
							command.start();
						}
					}
				} else {
					m_pressedLast = false;
				}
			}

			@Override
			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	/**
	 * Cancels a command when the trigger becomes active.
	 *
	 * @param command
	 *            the command to cancel
	 */
	public void cancelWhenActive(final Command command, double value, double tolerance) {
		new ButtonScheduler() {

			private boolean m_pressedLast = get(value, tolerance);

			@Override
			public void execute() {
				if (get(value, tolerance)) {
					if (!m_pressedLast) {
						m_pressedLast = true;
						command.cancel();
					}
				} else {
					m_pressedLast = false;
				}
			}

			@Override
			protected void start() {
				Scheduler.getInstance().addButton(this);
			}
		}.start();
	}

	/**
	 * These methods continue to return the "Button" SmartDashboard type until
	 * we decided to create a Trigger widget type for the dashboard.
	 */
	@Override
	public String getSmartDashboardType() {
		return "Button";
	}

	private ITable m_table;

	@Override
	public void initTable(ITable table) {
		m_table = table;
		if (table != null) {
			table.putBoolean("pressed", get());
		}
	}

	@Override
	public ITable getTable() {
		return m_table;
	}

	@Override
	public boolean get() {
		return false;
	}

}
