package org.usfirst.frc.team1018.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;
import org.usfirst.frc.team1018.robot.commands.Drive;

/**
 * @author firecrafty
 * @since 1.0
 * <p>
 * Subsystem methods class for the drivetrain
 * <p>
 * Contains methods to control the robot's mecanum style drivetrain
 */
public class DriveTrain extends Subsystem {

    RobotDrive robot = Robot.map.driveTrain;

    /**
     * Drives the robot using the mecanum style drive train
     */
    public void drive(double x, double y, double rotation) {
        robot.mecanumDrive_Cartesian(x, y, rotation, 0);
    }

    /**
     * Sets the default command to the <code>Drive</code> command
     * <p>
     * The default command of a subsystem is run continuously as long as there is not another command running that
     * requires that subsystem.
     *
     * @see edu.wpi.first.wpilibj.command.Subsystem#setDefaultCommand(Command)
     */
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}

