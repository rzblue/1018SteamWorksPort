package org.usfirst.frc.team1018.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;

/**
 * @author Ryan Blue
 * @since 0.1.0
 * <p>
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides
 * flexibility changing wiring, makes checking the wiring easier and significantly reduces the number of magic numbers
 * floating around.
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

    private final static int LEFT_ENCODER_CHANNEL_A = 4;
    private final static int LEFT_ENCODER_CHANNEL_B = 5;
    private final static int RIGHT_ENCODER_CHANNEL_A = 6;
    private final static int RIGHT_ENCODER_CHANNEL_B = 7;


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

    public Encoder leftEncoder;
    public Encoder rightEncoder;

    public AHRS navX;

    public RobotMap() {
        init();
    }

    /**
     * "Puts together" the robot
     */
    private void init() {
        initDriveMotors();
        initGearHandler();
        initClimber();
        initBrakes();
        initSensors();
    }

    /**
     * Initializes the driveMecanum motors
     */
    private void initDriveMotors() {
        rearRightDrive = new TalonSRX(REAR_RIGHT_DRIVE_PWM);
        rearLeftDrive = new TalonSRX(REAR_LEFT_DRIVE_PWM);
        frontRightDrive = new TalonSRX(FRONT_RIGHT_DRIVE_PWM);
        frontLeftDrive = new TalonSRX(FRONT_LEFT_DRIVE_PWM);
        rearRightDrive.setInverted(true);
        frontRightDrive.setInverted(true);
        driveTrain = new RobotDrive(frontLeftDrive, rearLeftDrive, frontRightDrive, rearRightDrive);

    }

    /**
     * Initializes the inputs and outputs for the gear handling system
     */
    private void initGearHandler() {
        flipper = new TalonSRX(FLIPPER_PWM);
        banner = new DigitalInput(BANNER_DIO);
    }

    /**
     * Initializes and sets up the outputs for the climbing system
     */
    private void initClimber() {
        lowerClimber = new TalonSRX(LOWER_CLIMBER_PWM);
        upperClimber = new TalonSRX(UPPER_CLIMBER_PWM);
        upperClimber.setInverted(true);
    }

    /**
     * Initializes the outputs for the brake system
     */
    private void initBrakes() {
        brakes = new DoubleSolenoid(BRAKES_DOWN_SOLENOID_PORT, BRAKES_UP_SOLENOID_PORT);
    }

    /**
     * Initializes all the robot navigation/autonomous sensors
     */
    private void initSensors() {
        rightUltrasonic = new Ultrasonic(RIGHT_ULTRASONIC_PING_DIO, RIGHT_ULTRASONIC_ECHO_DIO, Ultrasonic.Unit.kInches);
        leftUltrasonic = new Ultrasonic(LEFT_ULTRASONIC_PING_DIO, LEFT_ULTRASONIC_ECHO_DIO, Ultrasonic.Unit.kInches);
        leftEncoder = new Encoder(LEFT_ENCODER_CHANNEL_A, LEFT_ENCODER_CHANNEL_B);
        rightEncoder = new Encoder(RIGHT_ENCODER_CHANNEL_A, RIGHT_ENCODER_CHANNEL_B);

        //6 inch wheels, 256 cycles/rotation, in ft/pulse
        leftEncoder.setDistancePerPulse(0.00613592314);
        rightEncoder.setDistancePerPulse(0.00613592314);

        navX = new AHRS(I2C.Port.kMXP);
    }
}
