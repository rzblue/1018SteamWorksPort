package org.usfirst.frc.team1018.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1018.robot.subsystems.Brakes;
import org.usfirst.frc.team1018.robot.subsystems.Climber;
import org.usfirst.frc.team1018.robot.subsystems.GearHandler;

/**
 * @author firecrafty
 *         <p>
 *         The VM is configured to automatically run this class, and to call the
 *         functions corresponding to each mode, as described in the IterativeRobot
 *         documentation. If you change the name of this class or the package after
 *         creating this project, you must also update the manifest file in the resource
 *         directory.
 */
public class Robot extends IterativeRobot {
    public static RobotMap map;
    public static RobotDrive robot;
    public static OI oi;

    public static GearHandler gearHandler;
    public static Climber climber;
    public static Brakes brakes;
    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        map = new RobotMap();
        robot = new RobotDrive(map.frontLeftDrive, map.rearLeftDrive, map.frontRightDrive, map.rearRightDrive);

        gearHandler = new GearHandler();
        climber = new Climber();
        brakes = new Brakes();

        // chooser.addDefault("Default Auto", new ExampleCommand());
        // chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);

        // OI must be done last
        // If it is not and it calls commands (it will) they will pull NullPointerExceptions
        oi = new OI();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();

		/*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

        // schedule the autonomous command (example)
        if(autonomousCommand != null)
            autonomousCommand.start();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if(autonomousCommand != null)
            autonomousCommand.cancel();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        robot.mecanumDrive_Cartesian(oi.leftStick.getX(), oi.leftStick.getY(), oi.rightStick.getX(), 0);
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
