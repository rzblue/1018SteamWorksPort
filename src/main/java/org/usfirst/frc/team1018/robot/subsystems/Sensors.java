package org.usfirst.frc.team1018.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import org.usfirst.frc.team1018.lib.LidarLite;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author Ryan Blue
 */
public class Sensors {

    private Ultrasonic rightUltrasonic = Robot.map.rightUltrasonic;
    private Ultrasonic leftUltrasonic = Robot.map.leftUltrasonic;

    public Encoder leftEncoder = Robot.map.leftEncoder;
    public Encoder rightEncoder = Robot.map.rightEncoder;

    public AHRS navX = Robot.map.navX;

    private LidarLite lidar = Robot.map.lidar;

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
    public int getLidarDistance() {
        return lidar.getDistanceCentimeters();
    }

    public double getAverageEncoderDistance() {
        return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
    }

}

