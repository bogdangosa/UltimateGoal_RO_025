
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class ANA_HardwareMap
{
    public static final double      DriveValue = 2.43;
    public static final double      TurnValue = 2;
    public static final double      StrafeValue = 2;
    public static final double      PullValue = 125;
    public static final double      COUNTS_PER_MOTOR_REV = 1120 ;    // eg: TETRIX Motor Encoder 1440 tetrix
    public static final double      DRIVE_GEAR_REDUCTION = 2.0 ;     // This is < 1.0 if geared UP
    public static final double      WHEEL_DIAMETER_MM = 4.0 * 25.4;     // For figuring circumference
    public static final double     COUNTS_PER_MM = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_MM * 3.1415);
    public static final double      DRIVE_SPEED = 1;
    public static final double      TURN_SPEED = 0.5;
    public static final double      PULL_SPEED = 0.1;

    ColorSensor color1;
    ColorSensor color2;

    public DcMotor RightFrontMotor = null;
    public DcMotor RightBackMotor = null;
    public DcMotor LeftFrontMotor = null;
    public DcMotor LeftBackMotor = null;

    public Servo Ridicare = null;
    public Servo Impingere = null;
    public Servo Wobble =  null;

    public DcMotor Outtake = null;
    public DcMotor Intake = null;

    HardwareMap ANA_HardwareMap =  null;

    public void init(HardwareMap ahwMap) {
        ANA_HardwareMap = ahwMap;

        color1 = ANA_HardwareMap.get(ColorSensor.class, "color1");
        color1 = ANA_HardwareMap.colorSensor.get("color1");

        color2 = ANA_HardwareMap.get(ColorSensor.class, "color2");
        color2 = ANA_HardwareMap.colorSensor.get("color2");

        Ridicare = ANA_HardwareMap.get(Servo.class, "ridicare");
        Impingere = ANA_HardwareMap.get(Servo.class, "impingere");
        Wobble = ANA_HardwareMap.get(Servo.class, " wobble");

        Outtake = ANA_HardwareMap.get(DcMotor.class, "outtake");
        Intake =  ANA_HardwareMap.get(DcMotor.class, "intake");
        RightBackMotor = ANA_HardwareMap.get(DcMotor.class, "RightBackMotor");
        RightFrontMotor = ANA_HardwareMap.get(DcMotor.class, "RightFrontMotor");
        LeftFrontMotor = ANA_HardwareMap.get(DcMotor.class, "LeftFrontMotor");
        LeftBackMotor = ANA_HardwareMap.get(DcMotor.class, "LeftBackMotor");

        RightBackMotor.setDirection(FORWARD);
        RightFrontMotor.setDirection(FORWARD);
        LeftBackMotor.setDirection(REVERSE);
        LeftFrontMotor.setDirection(REVERSE);
        Intake.setDirection(REVERSE);

        Outtake.setPower(0);
        Intake.setPower(0);
        RightBackMotor.setPower(0);
        RightFrontMotor.setPower(0);
        LeftFrontMotor.setPower(0);
        LeftBackMotor.setPower(0);

    }
}
