package org.usfirst.frc.team1018.robot;

import org.usfirst.frc.team1018.robot.commands.ClimbDown;
import org.usfirst.frc.team1018.robot.commands.ClimbUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the button panel
 * to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static int LEFT_JOYSTICK_PORT = 0;
	private static int RIGHT_JOYSTICK_PORT = 1;
	
	public Joystick leftStick;
	public Joystick rightStick;
	
	JoystickButton climbUpButton;
	JoystickButton climbDownButton;
	
	public OI() {
		init();
		climbUpButton.whileHeld(new ClimbUp());
		climbDownButton.whileHeld(new ClimbDown());
	}
	public void init() {
		initSticks();
		initButtons();
	}
	public void initSticks() {
		leftStick = new Joystick(LEFT_JOYSTICK_PORT);
		rightStick = new Joystick(RIGHT_JOYSTICK_PORT);
	}
	public void initButtons() {
		climbUpButton = new JoystickButton(leftStick, 1);
		climbDownButton = new JoystickButton(leftStick, 2);
	}
}
