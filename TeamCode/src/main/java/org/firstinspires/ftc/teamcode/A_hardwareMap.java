
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import java.util.Locale;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

public class   A_hardwareMap
{
    public static final double      PRINDERE_INITIAL      =  0.25 ;
    public static final double      PRINDERE_COMPLETA = 1;
    public static final double      TAVA_JOS =  0.75 ;
    public static final double      TAVA_SUS   = 0.25 ;
    public static final double      DriveValue = 2.43;
    public static final double      TurnValue = 2;
    public static final double      StrafeValue = 2;
    public static final double      PullValue = 125;
    public static final double      COUNTS_PER_MOTOR_REV    = 1120 ;    // eg: TETRIX Motor Encoder 1440 tetrix
    public static final double      DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    public static final double      WHEEL_DIAMETER_MM   = 4.0 * 25.4;     // For figuring circumference
    public static final double     COUNTS_PER_MM         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_MM * 3.1415);
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

    HardwareMap A_hardwareMap =  null;

    public void init(HardwareMap ahwMap) {
        A_hardwareMap = ahwMap;


        color1 = A_hardwareMap.get(ColorSensor.class, "color1");
        color1 = A_hardwareMap.colorSensor.get("color1");

        color2 = A_hardwareMap.get(ColorSensor.class, "color2");
        color2 = A_hardwareMap.colorSensor.get("color2");

        Ridicare = A_hardwareMap.get(Servo.class, "ridicare");
        Impingere = A_hardwareMap.get(Servo.class, "impingere");
        Wobble = A_hardwareMap.get(Servo.class, " wobble");

        Outtake = A_hardwareMap.get(DcMotor.class, "outtake");
        Intake =  A_hardwareMap.get(DcMotor.class, "intake");
        RightBackMotor = A_hardwareMap.get(DcMotor.class, "RightBackMotor");
        RightFrontMotor = A_hardwareMap.get(DcMotor.class, "RightFrontMotor");
        LeftFrontMotor = A_hardwareMap.get(DcMotor.class, "LeftFrontMotor");
        LeftBackMotor = A_hardwareMap.get(DcMotor.class, "LeftBackMotor");

        RightBackMotor.setDirection(REVERSE);
        RightFrontMotor.setDirection(FORWARD);
        LeftBackMotor.setDirection(REVERSE);
        LeftFrontMotor.setDirection(REVERSE);
        Outtake.setDirection(REVERSE);
        Intake.setDirection(FORWARD);

        Outtake.setPower(0);
        Intake.setPower(0);
        RightBackMotor.setPower(0);
        RightFrontMotor.setPower(0);
        LeftFrontMotor.setPower(0);
        LeftBackMotor.setPower(0);

        Wobble.setPosition(0.45);
    }

}