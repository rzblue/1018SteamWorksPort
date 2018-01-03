package org.usfirst.frc.team1018.robot.commands.auto.redalliance;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1018.robot.commands.auto.components.DriveDistance;
import org.usfirst.frc.team1018.robot.commands.auto.components.TurnToAngle;

/**
 * @author Ryan Blue
 */
public class RedRightPegDeadReckon extends CommandGroup {

    public RedRightPegDeadReckon() {
        addSequential(new DriveDistance(3));
        addSequential(new TurnToAngle(-60));
        addSequential(new DriveDistance(3));
    }
}
