package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 */
public class Brakes extends Subsystem {

    private DoubleSolenoid brakes = Robot.map.brakes;

    public void brakesDown() {
        brakes.set(DoubleSolenoid.Value.kForward);
    }

    public void brakesUp() {
        brakes.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

