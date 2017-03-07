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

    public void spinFlipper() {
        flipper.set(-1);
    }

    public void stopFlipper() {
        flipper.set(0);
    }

    public boolean isGearPositioned() {
        return !banner.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new AlignGearAuto());
    }
}

