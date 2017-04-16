package org.usfirst.frc.team1018.robot.networktables;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * @author Ryan Blue
 */
public class VisionTableHelper {
    private VisionTableHelper() {
    }

    private static NetworkTable visionTable = NetworkTable.getTable("Vision");

    public static double getTargetCenterX() {
        return visionTable.getNumber("", 0);
    }

    /**
     * Normalizes a value given a total resolution
     * <p>
     * Proportionally changes a pixel value so that the far left is -1 and far right is 1. Can be used to set motor
     * values directly to vision data.
     *
     * @param value
     * @param totalResolution
     * @return The normalized value. -1<x<1
     */
    public static double normalize(double value, double totalResolution) {
        return ((value / totalResolution) * 2) - 1;

    }

}
