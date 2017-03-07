package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;
import org.usfirst.frc.team1018.robot.commands.AlignGearAuto;

/**
 * @author firecrafty
 *         <p>
 *         Subsystem methods class for the gear handler mechanism
 *         <p>
 *         Contains methods to control the gear alignment (flipper) mechanism on the front of the robot
 */

public class GearHandler extends Subsystem {

    private TalonSRX flipper = Robot.map.flipper;
    private DigitalInput banner = Robot.map.banner;

    /**
     * Starts the flipper motor spinning
     */
    public void spinFlipper() {
        flipper.set(-1);
    }

    /**
     * Stops the flipper motor
     */
    public void stopFlipper() {
        flipper.set(0);
    }

    /**
     * Returns <code>true</code> if the gear is positioned correctly in the gear handler
     *
     * @return <code>true</code> if the gear is positioned correctly;
     * <code>false</code> otherwise
     */
    public boolean isGearPositioned() {
        return !banner.get();
    }

    /**
     * Sets the default command for the <code>GearHandler</code> subsystem to <code>AlignGearAuto</code>
     */
    public void initDefaultCommand() {
        setDefaultCommand(new AlignGearAuto());
    }
}

