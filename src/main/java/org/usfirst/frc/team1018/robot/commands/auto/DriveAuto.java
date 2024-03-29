package org.usfirst.frc.team1018.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author firecrafty
 */
public class DriveAuto extends Command {
    private static String startingPosition = "";

    public DriveAuto(String startingPosition) {
        this.startingPosition = startingPosition;
        requires(Robot.driveTrain);
        requires(Robot.pegAligner);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.map.leftUltrasonic.getRangeInches() > 30 && Robot.map.rightUltrasonic.getRangeInches() > 30) {
            Robot.driveTrain.driveMecanum(0.3, 0.0, 0);
        } else {
            switch(startingPosition) {
                case "LEFT":
                    Robot.driveTrain.driveMecanum(0, -0.3, 0);
                    break;
                case "CENTER":
                    Robot.driveTrain.driveMecanum(0, -0.3, 0);
                    break;
                case "RIGHT":
                    Robot.driveTrain.driveMecanum(0, 0.3, 0);
                    break;
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished() returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
