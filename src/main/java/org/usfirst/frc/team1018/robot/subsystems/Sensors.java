package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author Ryan Blue
 */
public class Sensors extends Subsystem {

    private Ultrasonic rightUltrasonic = Robot.map.rightUltrasonic;
    private Ultrasonic leftUltrasonic = Robot.map.leftUltrasonic;


    public void initDefaultCommand() {
    }
}

