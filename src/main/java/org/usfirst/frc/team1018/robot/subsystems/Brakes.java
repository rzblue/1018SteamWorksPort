package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 *         <p>
 *         Subsystem methods class for the braking mechanism
 *         <p>
 *         Contains methods to control the pneumatic "outriggers" that prevent the robot from spinning out after a
 *         potential robot collison during peg alignment
 */
public class Brakes extends Subsystem {

    private DoubleSolenoid brakes = Robot.map.brakes;

    /**
     * Extends the brake "outriggers"
     */
    public void brakesDown() {
        brakes.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * Retracts the brake "outriggers"
     */
    public void brakesUp() {
        brakes.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

