package org.usfirst.frc.team1018.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
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

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public double getAverageEncoderDistance() {
        return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
    }

}

