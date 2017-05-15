package org.usfirst.frc.team1018.robot.commands.auto.components;
import com.sun.istack.internal.NotNull;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author Ryan Blue
 */
public class DriveDistance extends Command {
    double distanceToDrive;
    double speed = 1;
    /**
     *
     * @param distanceToDrive The distance to driveMecanum in ft
     */
    public DriveDistance(@NotNull double distanceToDrive) {
        requires(Robot.driveTrain);
        this.distanceToDrive = distanceToDrive;
    }
    public DriveDistance(@NotNull double distanceToDrive, double speed) {
        this(distanceToDrive);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.sensors.resetEncoders();
        Robot.driveTrain.driveArcade(speed, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sensors.getAverageEncoderDistance() >= distanceToDrive;
    }

    // Called once after isFinished() returns true
    protected void end() {
        Robot.driveTrain.stopRobot();
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
