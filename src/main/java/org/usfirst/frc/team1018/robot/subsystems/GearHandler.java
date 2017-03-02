package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
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
        return banner.get();
    }

    public void initDefaultCommand() {

    }
}

