package org.usfirst.frc.team1018.robot;

import edu.wpi.first.wpilibj.*;

/**
 * @author firecrafty
 *         The RobotMap is a mapping from the ports sensors and actuators are wired into
 *         to a variable name. This provides flexibility changing wiring, makes checking
 *         the wiring easier and significantly reduces the number of magic numbers
 *         floating around.
 */
public class RobotMap {
    private final static int REAR_RIGHT_DRIVE_PWM = 0;
    private final static int REAR_LEFT_DRIVE_PWM = 1;
    private final static int FRONT_RIGHT_DRIVE_PWM = 2;
    private final static int FRONT_LEFT_DRIVE_PWM = 3;

    private final static int FLIPPER_PWM = 4;
    private final static int BANNER_DIO = 8;

    private final static int LOWER_CLIMBER_PWM = 5;
    private final static int UPPER_CLIMBER_PWM = 6;

    private final static int BRAKES_UP_SOLENOID_PORT = 0;
    private final static int BRAKES_DOWN_SOLENOID_PORT = 1;

    private final static int RIGHT_ULTRASONIC_PING_DIO = 0;
    private final static int RIGHT_ULTRASONIC_ECHO_DIO = 1;
    private final static int LEFT_ULTRASONIC_PING_DIO = 2;
    private final static int LEFT_ULTRASONIC_ECHO_DIO = 3;

    public TalonSRX rearRightDrive;
    public TalonSRX rearLeftDrive;
    public TalonSRX frontRightDrive;
    public TalonSRX frontLeftDrive;
    public RobotDrive driveTrain;

    public TalonSRX flipper;
    public DigitalInput banner;

    public TalonSRX lowerClimber;
    public TalonSRX upperClimber;

    public DoubleSolenoid brakes;

    public Ultrasonic rightUltrasonic;
    public Ultrasonic leftUltrasonic;

    public RobotMap() {
        init();
    }

    /**
     * "Put together" the robot
     */
    public void init() {
        initDriveMotors();
        initGearHandler();
        initClimber();
        initBrakes();
        initVision();
    }

    /**
     * Initialize the drive motors
     */
    public void initDriveMotors() {
        rearRightDrive = new TalonSRX(REAR_RIGHT_DRIVE_PWM);
        rearLeftDrive = new TalonSRX(REAR_LEFT_DRIVE_PWM);
        frontRightDrive = new TalonSRX(FRONT_RIGHT_DRIVE_PWM);
        frontLeftDrive = new TalonSRX(FRONT_LEFT_DRIVE_PWM);
        rearRightDrive.setInverted(true);
        frontRightDrive.setInverted(true);
        driveTrain = new RobotDrive(frontLeftDrive, rearLeftDrive, frontRightDrive, rearRightDrive);

    }

    public void initGearHandler() {
        flipper = new TalonSRX(FLIPPER_PWM);
        banner = new DigitalInput(BANNER_DIO);
    }

    public void initClimber() {
        lowerClimber = new TalonSRX(LOWER_CLIMBER_PWM);
        upperClimber = new TalonSRX(UPPER_CLIMBER_PWM);
        upperClimber.setInverted(true);
    }

    public void initBrakes() {
        brakes = new DoubleSolenoid(BRAKES_DOWN_SOLENOID_PORT, BRAKES_UP_SOLENOID_PORT);
    }

    public void initVision() {
        rightUltrasonic = new Ultrasonic(RIGHT_ULTRASONIC_PING_DIO, RIGHT_ULTRASONIC_ECHO_DIO, Ultrasonic.Unit.kInches);
        leftUltrasonic = new Ultrasonic(LEFT_ULTRASONIC_PING_DIO, LEFT_ULTRASONIC_ECHO_DIO, Ultrasonic.Unit.kInches);
    }
}
