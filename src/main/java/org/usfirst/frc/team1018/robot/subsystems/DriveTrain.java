package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1018.robot.Robot;
import org.usfirst.frc.team1018.robot.RobotMap;
import org.usfirst.frc.team1018.robot.commands.Drive;

/**
 * @author firecrafty
 */
public class DriveTrain extends Subsystem {

    RobotDrive robot = Robot.map.driveTrain;

    public void drive(double x, double y, double rotation) {
        robot.mecanumDrive_Cartesian(x, y, rotation, 0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}

