package org.usfirst.frc.team1018.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author Ryan Blue
 * @since 1.0
 */
public class AlignGearManual extends Command {
    public AlignGearManual() {
        requires(Robot.gearHandler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.gearHandler.spinFlipper();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished() returns true
    protected void end() {
        Robot.gearHandler.stopFlipper();
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
