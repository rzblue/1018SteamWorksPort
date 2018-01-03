package org.usfirst.frc.team1018.robot.commands.auto.components;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1018.robot.Robot;

/**
 * @author Ryan Blue
 */
public class TurnToAngle extends Command implements PIDOutput{

    private static int kP = 0;
    private static int kI = 0;
    private static int kD = 0;

    private double turnRate = 0;

    PIDController controller;

    /**
     *
     * @param angle The angle to turn to
     */
    public TurnToAngle(double angle) {
        this(angle, false);
    }

    /**
     *
     * @param angle The angle to turn to
     * @param relativeAngle Is the angle specified relative to the current angle?
     */
    public TurnToAngle(double angle, boolean relativeAngle) {
        requires(Robot.driveTrain);

        //Changes a relative angle to an exact angle
        if(relativeAngle) {
            angle = Robot.sensors.navX.getYaw() + angle;
        }
        //Normalizes the angle value within the -180 to 180 range
        if(angle > 180) {
            angle = angle - 360;
        } else if(angle < 180) {
            angle = angle + 360;
        }
        controller = new PIDController(kP, kI, kD, Robot.sensors.navX, this);
        controller.setSetpoint(angle);
        controller.setInputRange(-180, 180);
        controller.setOutputRange(-1, 1);
        controller.setContinuous();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.driveArcade(0, turnRate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controller.onTarget();
    }

    // Called once after isFinished() returns true
    protected void end() {
        Robot.driveTrain.stopRobot();
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
        end();
    }

    @Override
    public void pidWrite(double output) {
        turnRate = output;
    }

    public void setAngle(double angle) {
        controller.setSetpoint(angle);
    }
}
