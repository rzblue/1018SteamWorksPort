package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 */
public class PegAligner extends Subsystem {

    private static double[] previousRightValues = new double[20];
    private static double[] previousLeftValues = new double[20];
    private static Ultrasonic rightUltrasonic = Robot.map.rightUltrasonic;
    private static Ultrasonic leftUltrasonic = Robot.map.leftUltrasonic;

    /**
     * Calculates the final x-axis (forward/backward) output based on joystick inputs
     *
     * @param joySpeedIn the speed value from a driver input device (joystick)
     * @return the final blended output for x-axis movement
     */
    public double calculateBlendedSpeed(double joySpeedIn) {
        return isInRange() ? coerceValue(joySpeedIn, -0.35, 0.35) : joySpeedIn;
    }

    /**
     * Returns <code>true</code> if the robot is in range to begin driver assistance
     *
     * @return <code>true</code> if the both ultrasonic sensors are within range;
     * <code>false</code> otherwise
     */
    public boolean isInRange() {
        return leftUltrasonic.getRangeInches() < 13 && rightUltrasonic.getRangeInches() < 13;
    }

    /**
     * Determines whether x falls within a range specified by the upper limit and lower limit inputs and coerces the value to fall within the range.
     *
     * @param value
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    public double coerceValue(double value, double lowerLimit, double upperLimit) {
        if(value < lowerLimit) {
            value = lowerLimit;
        } else if(value > upperLimit) {
            value = upperLimit;
        }
        return value;
    }

    /**
     * Calculates the final y-axis (left/right) output based on joystick inputs and vision processing results
     *
     * @param joyStrafeIn  the strafe value from a driver input device (joystick)
     * @param visionStrafe the unweighted strafe correction value generated by Vision Processing
     * @return the final blended output for y-axis movement
     */
    public double calculateBlendedStrafe(double joyStrafeIn, double visionStrafe) {
        return weighStrafeCorrection(visionStrafe) + joyStrafeIn;
    }

    /**
     * Calculates a weighted strafe correction value
     *
     * @param visionStrafe the unweighted strafe correction value generated by Vision Processing
     * @return the weighted strafe correction value
     */
    public double weighStrafeCorrection(double visionStrafe) {
        return isInRange() ? coerceValue(visionStrafe, -0.1, 0.1) : visionStrafe;
    }

    /**
     * Calculates the final z-axis (vertical) rotation output based on joystick inputs and vision processing results
     *
     * @param joyRotationIn  the rotation value from a driver input device (joystick)
     * @param visionRotation the unweighted rotation correction value generated by Vision Processing
     * @return the final blended output for z-axis rotation
     */
    public double calculateBlendedRotation(double joyRotationIn, double visionRotation) {
        return weighRotationCorrection(visionRotation) + joyRotationIn;
    }

    /**
     * Calculates a weighted rotation correction value
     *
     * @param visionRotation the unweighted rotation correction value generated by Vision Processing
     * @return the weighted rotation correction value
     */
    public double weighRotationCorrection(double visionRotation) {
        return isInRange() ? coerceValue(visionRotation, -0.07, 0.07) : visionRotation;
    }

    public double getLeftUltrasonicRange() {
        return leftUltrasonic.getRangeInches();
    }

    public double getRightUltrasonicRange() {
        return rightUltrasonic.getRangeInches();
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}
