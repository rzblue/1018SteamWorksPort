package org.usfirst.frc.team1018.robot.subsystems;

import org.usfirst.frc.team1018.robot.Robot;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	private TalonSRX lowerClimber = Robot.map.lowerClimber;
	private TalonSRX upperClimber = Robot.map.upperClimber;
	
    public void climbUp() {
    	lowerClimber.set(1);
    	upperClimber.set(1);
    }
    
    public void climbDown() {
    	lowerClimber.set(-1);
    	upperClimber.set(-1);
    }
    
    public void stopClimb() {
    	lowerClimber.set(0);
    	upperClimber.set(0);
    }
    
    public void initDefaultCommand() {}
}
