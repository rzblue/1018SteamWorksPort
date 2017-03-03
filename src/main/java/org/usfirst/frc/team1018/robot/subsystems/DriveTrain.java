package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;
import org.usfirst.frc.team1018.robot.commands.Drive;

/**
 * @author firecrafty
 */
public class DriveTrain extends Subsystem {

    public void drive() {
        Robot.map.driveTrain.mecanumDrive_Cartesian(Robot.oi.leftStick.getX(), Robot.oi.leftStick.getY(), Robot.oi.rightStick.getX(), 0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}

