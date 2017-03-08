package org.usfirst.frc.team1018.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 * @since 1.0
 */
public class Drive extends Command {
    public Drive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.drive(Robot.oi.leftStick.getX(), Robot.oi.leftStick.getY(), Robot.oi.rightStick.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished() returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
