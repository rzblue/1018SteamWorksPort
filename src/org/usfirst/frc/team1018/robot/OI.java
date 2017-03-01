package org.usfirst.frc.team1018.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the button panel
 * to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static int LEFT_JOYSTICK_PORT = 0;
	private static int RIGHT_JOYSTICK_PORT = 1;
	
	public Joystick leftStick;
	public Joystick rightStick;
	
	public OI() {
		leftStick = new Joystick(LEFT_JOYSTICK_PORT);
		rightStick = new Joystick(RIGHT_JOYSTICK_PORT);
	}
}
