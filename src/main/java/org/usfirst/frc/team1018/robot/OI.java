package org.usfirst.frc.team1018.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1018.robot.commands.*;

/**
 * @author firecrafty
 * @since 0.1.0
 * <p>
 * This class is the glue that binds the controls on the button panel to the commands and command groups that allow
 * control of the robot.
 */
public class OI {
    private static int LEFT_JOYSTICK_PORT = 0;
    private static int RIGHT_JOYSTICK_PORT = 1;
    private static int BUTTON_PANEL_PORT = 2;

    private static int CLIMB_UP_NUM = 0;
    private static int CLIMB_DOWN_NUM = 1;
    private static int GEAR_SPIN_NUM = 2;
    private static int BRAKES_DOWN_NUM = 3;

    public Joystick leftStick;
    public Joystick rightStick;
    public Joystick buttonPanel;

    JoystickButton climbUpButton;
    JoystickButton climbDownButton;
    JoystickButton gearSpinButton;
    JoystickButton brakesDownButton;

    public OI() {
        init();
        assignFunctions();
    }

    public void init() {
        initSticks();
        initButtons();
    }

    public void initSticks() {
        leftStick = new Joystick(LEFT_JOYSTICK_PORT);
        rightStick = new Joystick(RIGHT_JOYSTICK_PORT);
        buttonPanel = new Joystick(BUTTON_PANEL_PORT);
    }

    public void initButtons() {
        climbUpButton = new JoystickButton(buttonPanel, CLIMB_UP_NUM);
        climbDownButton = new JoystickButton(buttonPanel, CLIMB_DOWN_NUM);
        gearSpinButton = new JoystickButton(buttonPanel, GEAR_SPIN_NUM);
        brakesDownButton = new JoystickButton(buttonPanel, BRAKES_DOWN_NUM);
    }

    public void assignFunctions() {
        climbUpButton.whileHeld(new ClimbUp());
        climbDownButton.whileHeld(new ClimbDown());
        gearSpinButton.whileHeld(new AlignGearManual());
        brakesDownButton.whileHeld(new BrakesDown());
    }
}
