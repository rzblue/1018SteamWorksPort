package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;
import org.usfirst.frc.team1018.robot.commands.PaddlesOut;

/**
 * @author Ryan Blue
 */
public class Paddles extends Subsystem {

    private DoubleSolenoid paddles = Robot.map.paddles;

    public void paddlesOut() {
        paddles.set(DoubleSolenoid.Value.kForward);
    }
    public void paddlesIn() {
        paddles.set(DoubleSolenoid.Value.kReverse);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new PaddlesOut());
    }
}

