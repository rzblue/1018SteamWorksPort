package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 */
public class PegAligner extends Subsystem {

    private static Ultrasonic rightUltrasonic = Robot.map.rightUltrasonic;
    private static Ultrasonic leftUltrasonic = Robot.map.leftUltrasonic;

    public double coerceValue(double value, double lowerLimit, double upperLimit) {
        if(value < lowerLimit) {
            value = lowerLimit;
        } else if(value > upperLimit) {
            value = upperLimit;
        }
        return value;
    }

    public boolean ultrasonicInRange() {
        return leftUltrasonic.getRangeInches() < 13 && rightUltrasonic.getRangeInches() < 13;
    }

    public double calculateSpeed(double speedIn) {
        return this.coerceValue(speedIn, -0.35, 0.35);
    }

    public double calculateStrafe(double strafeIn) {
        return this.coerceValue(strafeIn, -0.1, 0.1);
    }

    public double calculateRotation(double rotationIn) {
        return this.coerceValue(rotationIn, -0.07, 0.07);
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

