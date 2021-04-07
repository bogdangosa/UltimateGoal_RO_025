package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Locale;

import static org.firstinspires.ftc.teamcode.Ana_HM_Test.COUNTS_PER_MM;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.DriveValue;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.StrafeValue;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.TURN_SPEED;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.TurnValue;

@Autonomous(name="AUtonomB_Encodere")
public class AutonomB_Encodere extends LinearOpMode{
    ANA_HardwareMap robot   = new ANA_HardwareMap();
    private ElapsedTime runtime = new ElapsedTime();

    // The IMU sensor object
    BNO055IMU imu;

    // State used for updating telemetry
    public Orientation angles;
    public Acceleration gravity;


    public double head = -0.1;
    public double pitch = -178.6;
    public double roll = -88.6;

    @Override
    public void runOpMode() {


        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        // Set up our telemetry dashboard
        composeTelemetry();

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);


        robot.init(hardwareMap);

        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        robot.LeftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.LeftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.update();

        double putere = 0.6;

        waitForStart();
        DriveBackward(500, 0.15);
        sleep(10000);
        /*
        DriveForward(5000, 0.15);
        sleep(2000);
        StrafeLeft(200, 0.3);
        sleep(2000);
        StrafeRight(200, 0.3);

        /*
        robot.Wobble.setPosition(0.6);
        sleep(1000);
        StrafeRight(27, putere);
        sleep(1000);
        DriveBackward(100, putere);
        sleep(1000);
        if (robot.color1.alpha() < 150)
        {
            DriveBackward(100, putere);
            sleep(1000);
            RotateLeft(180);
            sleep(1000);
            StrafeLeft(80, putere);
            sleep(1000);
            robot.Wobble.setPosition(0.15);
        }
        else if (robot.color1.alpha() > 150 && robot.color2.alpha() < 150 )
        {
            StrafeLeft(15, putere);
            robot.Intake.setPower(-1);
            DriveForward(45, 0.15);
            sleep(500);
            robot.Intake.setPower(0);
            RotateLeft(15);
            DriveForward(225, putere);
            sleep(200);
            robot.Wobble.setPosition(0.3);
            sleep(100);
            DriveForward(75, putere);
            robot.Ridicare.setPosition(0.15);
            robot.Outtake.setPower(-1);
            robot.Impingere.setPosition(0.2);
            sleep(2000);
            robot.Outtake.setPower(0);
            sleep(200);
            robot.Ridicare.setPosition(0.6);
            robot.Impingere.setPosition(0.04);
            StrafeLeft(15,putere);
            DriveBackward(150, putere);
        }
        else if(robot.color1.alpha() > 150 && robot.color2.alpha() > 150)
        {
            RotateLeft(15);
            StrafeLeft(90, putere);
            RotateRight(25);
            sleep(200);
            DriveForward(300, putere);
            RotateLeft(165);
            DriveBackward(50, putere);
            StrafeRight(50,putere);
            sleep(150);
            robot.Wobble.setPosition(0.3);
            StrafeLeft(20, putere);
            DriveForward(150, putere);
        }
        */
        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void EncoderDrive ( double speed, double distance, double timeoutS){
        if (opModeIsActive()) {
            int newBackLeftTarget;
            int newBackRightTarget;
            int newFrontLeftTarget;
            int newFrontRightTarget;
            // Ensure that the opmode is still active
            if (opModeIsActive()) {

                // Determine new target position, and pass to motor controller
                newBackLeftTarget = robot.LeftBackMotor.getCurrentPosition() + (int) (distance * COUNTS_PER_MM * DriveValue);
                newBackRightTarget = robot.RightBackMotor.getCurrentPosition() + (int) (distance * COUNTS_PER_MM * DriveValue);
                newFrontLeftTarget = robot.LeftFrontMotor.getCurrentPosition() + (int) (distance * COUNTS_PER_MM * DriveValue);
                newFrontRightTarget = robot.RightFrontMotor.getCurrentPosition() + (int) (distance * COUNTS_PER_MM * DriveValue);

                robot.LeftBackMotor.setTargetPosition(newBackLeftTarget);
                robot.RightBackMotor.setTargetPosition(newBackRightTarget);
                robot.LeftFrontMotor.setTargetPosition(newFrontLeftTarget);
                robot.RightFrontMotor.setTargetPosition(newFrontRightTarget);

                // Turn On RUN_TO_POSITION
                robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                // reset the timeout time and start motion.
                runtime.reset();
                robot.LeftBackMotor.setPower(speed);
                robot.RightBackMotor.setPower(speed);
                robot.LeftFrontMotor.setPower(speed);
                robot.RightFrontMotor.setPower(speed);

                // keep looping while we are still active, and there is time left, and both motors are running.
                // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
                // its target position, the motion will stop.  This is "safer" in the event that the robot will
                // always end the motion as soon as possible.
                // However, if you require that BOTH motors have finished their moves before the robot continues
                // onto the next step, use (isBusy() || isBusy()) in the loop test.
                while (opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (
                                robot.LeftBackMotor.isBusy() && robot.RightBackMotor.isBusy() &&
                                        robot.LeftFrontMotor.isBusy() && robot.RightFrontMotor.isBusy()
                        )) {

                    // Display it for the driver.
                    telemetry.addData("Path1", "Running to %7d :%7d :%7d :%7d"
                            , newFrontLeftTarget, newFrontRightTarget
                            , newBackLeftTarget, newBackRightTarget
                    );
                    telemetry.addData("Path2", "Running at %7d :%7d :%7d :%7d",
                            robot.LeftFrontMotor.getCurrentPosition(),
                            robot.RightFrontMotor.getCurrentPosition()
                            ,
                            robot.LeftBackMotor.getCurrentPosition(),
                            robot.RightBackMotor.getCurrentPosition()
                    );
                    telemetry.update();
                }

                // Stop all motion;

                robot.LeftBackMotor.setPower(0);
                robot.RightBackMotor.setPower(0);
                robot.LeftFrontMotor.setPower(0);
                robot.RightFrontMotor.setPower(0);

                /* COMMENT THESE FOR SPEED */

                // Turn off RUN_TO_POSITION
                robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                //sleep(250);   // optional pause after each move
            }
        }
    }
    public void EncoderStrafe(double speed, double distance, double timeoutS) {
        int newBackLeftTarget;
        int newBackRightTarget;
        int newFrontLeftTarget;
        int newFrontRightTarget;
        if (opModeIsActive()) {

            newBackLeftTarget = robot.LeftBackMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * StrafeValue);
            newBackRightTarget = robot.RightBackMotor.getCurrentPosition() + (int)(-distance * COUNTS_PER_MM * StrafeValue);
            newFrontLeftTarget = robot.LeftFrontMotor.getCurrentPosition() + (int)(-distance * COUNTS_PER_MM * StrafeValue);
            newFrontRightTarget = robot.RightFrontMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * StrafeValue);

            robot.LeftBackMotor.setTargetPosition(newBackLeftTarget);
            robot.RightBackMotor.setTargetPosition(newBackRightTarget);
            robot.LeftFrontMotor.setTargetPosition(newFrontLeftTarget);
            robot.RightFrontMotor.setTargetPosition(newFrontRightTarget);

            robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            robot.LeftBackMotor.setPower(-speed);
            robot.RightBackMotor.setPower(-speed);
            robot.LeftFrontMotor.setPower(speed);
            robot.RightFrontMotor.setPower(speed);

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (
                            robot.LeftBackMotor.isBusy() && robot.RightBackMotor.isBusy() &&
                                    robot.LeftFrontMotor.isBusy() && robot.RightFrontMotor.isBusy()
                    ))
            {

                telemetry.addData("Path1",  "Running to %7d :%7d :%7d :%7d"
                        , newFrontLeftTarget, newFrontRightTarget
                        , newBackLeftTarget, newBackRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d :%7d :%7d",
                        robot.LeftFrontMotor.getCurrentPosition(),
                        robot.RightFrontMotor.getCurrentPosition()
                        ,
                        robot.LeftBackMotor.getCurrentPosition(),
                        robot.RightBackMotor.getCurrentPosition());
                telemetry.addData("head", head);
                telemetry.update();
            }

            robot.LeftBackMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.RightFrontMotor.setPower(0);

            robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    public void DriveForward (double distance, double speed)
    {
        EncoderDrive(speed, -distance,15);
        sleep(500);
        gyro(-Double.parseDouble(formatAngle(angles.angleUnit, angles.firstAngle)));
    }

    public void DriveBackward (double distance, double speed)
    {
        EncoderDrive(-speed, distance,15);
        sleep(500);
        gyro(Double.parseDouble(formatAngle(angles.angleUnit, angles.firstAngle)));
    }

    public void StrafeRight(double distance, double speed)
    {
        EncoderStrafe(speed, distance, 15);
        sleep(500);
        gyro(Double.parseDouble(formatAngle(angles.angleUnit, angles.firstAngle)));
    }

    public void StrafeLeft (double distance, double speed)
    {
        EncoderStrafe(-speed, -distance, 15);
        sleep(500);
        gyro(Double.parseDouble(formatAngle(angles.angleUnit, angles.firstAngle)));
    }

    public void EncoderTurn(double speed, double distance, double timeoutS) {
        int newBackLeftTarget;
        int newBackRightTarget;
        int newFrontLeftTarget;
        int newFrontRightTarget;
        if (opModeIsActive()) {

            newBackLeftTarget = robot.LeftBackMotor.getCurrentPosition() + (int)(-distance * COUNTS_PER_MM * TurnValue);
            newBackRightTarget = robot.RightBackMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * TurnValue);
            newFrontLeftTarget = robot.LeftFrontMotor.getCurrentPosition() + (int)(-distance * COUNTS_PER_MM * TurnValue);
            newFrontRightTarget = robot.RightFrontMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * TurnValue);

            robot.LeftBackMotor.setTargetPosition(newBackLeftTarget);
            robot.RightBackMotor.setTargetPosition(newBackRightTarget);
            robot.LeftFrontMotor.setTargetPosition(newFrontLeftTarget);
            robot.RightFrontMotor.setTargetPosition(newFrontRightTarget);

            robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            robot.LeftBackMotor.setPower(speed);
            robot.RightBackMotor.setPower(speed);
            robot.LeftFrontMotor.setPower(speed);
            robot.RightFrontMotor.setPower(speed);

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (
                            robot.LeftBackMotor.isBusy() && robot.RightBackMotor.isBusy() &&
                                    robot.LeftFrontMotor.isBusy() && robot.RightFrontMotor.isBusy()
                    ))
            {
                telemetry.addData("Path1",  "Running to %7d :%7d :%7d :%7d"
                        , newFrontLeftTarget, newFrontRightTarget
                        , newBackLeftTarget, newBackRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d :%7d :%7d",
                        robot.LeftFrontMotor.getCurrentPosition(),
                        robot.RightFrontMotor.getCurrentPosition()
                        ,
                        robot.LeftBackMotor.getCurrentPosition(),
                        robot.RightBackMotor.getCurrentPosition());
                telemetry.update();
            }

            robot.LeftBackMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.RightFrontMotor.setPower(0);

            robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

    public void RotateRight(double angle)
    {
        EncoderTurn(TURN_SPEED, angle, 15);
    }

    public void RotateLeft(double angle)
    {
        EncoderTurn(-TURN_SPEED, -angle, 15);
    }

    public void StopAllMotion() {
        robot.LeftFrontMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

    }


    void composeTelemetry() {

        // At the beginning of each telemetry update, grab a bunch of data
        // from the IMU that we will then display in separate lines.
        telemetry.addAction(new Runnable() { @Override public void run()
        {
            // Acquiring the angles is relatively expensive; we don't want
            // to do that in each of the three items that need that info, as that's
            // three times the necessary expense.
            angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            gravity  = imu.getGravity();
        }
        });

        telemetry.addLine()
                .addData("status", new Func<String>() {
                    @Override public String value() {
                        return imu.getSystemStatus().toShortString();
                    }
                })
                .addData("calib", new Func<String>() {
                    @Override public String value() {
                        return imu.getCalibrationStatus().toString();
                    }
                });

        telemetry.addLine()
                .addData("heading", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.firstAngle);
                    }
                })
                .addData("roll", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.secondAngle);
                    }
                })
                .addData("pitch", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.thirdAngle);
                    }
                });

        telemetry.addLine()
                .addData("grvty", new Func<String>() {
                    @Override public String value() {
                        return gravity.toString();
                    }
                })
                .addData("mag", new Func<String>() {
                    @Override public String value() {
                        return String.format(Locale.getDefault(), "%.3f",
                                Math.sqrt(gravity.xAccel*gravity.xAccel
                                        + gravity.yAccel*gravity.yAccel
                                        + gravity.zAccel*gravity.zAccel));
                    }
                });
    }

    //----------------------------------------------------------------------------------------------
    // Formatting
    //----------------------------------------------------------------------------------------------

    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees){
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

    public void gyro(double angle)
    {
        if(angle > head)
            RotateRight(angle - head);
        else if(angle < head)
            RotateLeft(head - angle);
    }
}
