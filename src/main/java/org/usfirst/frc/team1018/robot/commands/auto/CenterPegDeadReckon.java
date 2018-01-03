package org.usfirst.frc.team1018.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1018.robot.commands.auto.components.DriveDistance;

/**
 * @author Ryan Blue
 */
public class CenterPegDeadReckon extends CommandGroup {

    public CenterPegDeadReckon() {
        addSequential(new DriveDistance(3));
    }
}
