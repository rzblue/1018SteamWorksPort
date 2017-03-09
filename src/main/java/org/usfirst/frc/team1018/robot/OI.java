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

    private static int CLIMB_UP_NUM = 1;
    private static int CLIMB_DOWN_NUM = 2;
    private static int GEAR_SPIN_NUM = 3;
    private static int BRAKES_DOWN_NUM = 4;

    public Joystick leftStick;
    //public Joystick rightStick;
    //public Joystick buttonPanel;

    JoystickButton climbUpButton;
    JoystickButton climbDownButton;
    JoystickButton gearSpinButton;
    JoystickButton brakesDownButton;

    public OI() {
        init();
        assignFunctions();
    }

    /**
     * Initializes the joysticks and buttons in the correct order
     */
    public void init() {
        initSticks();
        initButtons();
    }

    /**
     * Initializes the joysticks and the button panel
     */
    public void initSticks() {
        leftStick = new Joystick(LEFT_JOYSTICK_PORT);
        //rightStick = new Joystick(RIGHT_JOYSTICK_PORT);
        //buttonPanel = new Joystick(BUTTON_PANEL_PORT);
    }

    /**
     * Initializes the buttons on the joysticks and button panel
     */
    public void initButtons() {
        climbUpButton = new JoystickButton(leftStick, CLIMB_UP_NUM);
        climbDownButton = new JoystickButton(leftStick, CLIMB_DOWN_NUM);
        gearSpinButton = new JoystickButton(leftStick, GEAR_SPIN_NUM);
        brakesDownButton = new JoystickButton(leftStick, BRAKES_DOWN_NUM);
    }

    /**
     * Binds the commands to their respective buttons
     */
    public void assignFunctions() {
        climbUpButton.whileHeld(new ClimbUp());
        climbDownButton.whileHeld(new ClimbDown());
        gearSpinButton.whileHeld(new AlignGearManual());
        brakesDownButton.whileHeld(new BrakesDown());
    }
}
