package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import java.util.Locale;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


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

@TeleOp(name="ANA_TeleOP2", group="Iterative Opmode")
public class ANA_TeleOP2 extends OpMode
{
    Ana_HM_Test robot = new Ana_HM_Test();

    // The IMU sensor object
    BNO055IMU imu;

    // State used for updating telemetry
    Orientation angles;
    Acceleration gravity;


    @Override
    public void init() {
        telemetry.addData("Status", "Before Initialization");

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

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop()
    {
        //robot.Ridicare.setPosition(gamepad2.right_trigger);
        //robot.Impingere.setPosition(gamepad2.left_trigger);
        ///robot.Wobble.setPosition(gamepad1.right_trigger);

        double drive = gamepad1.right_stick_y;
        double turn = gamepad1.left_stick_x;

        double rightPower;
        double leftPower;

        double RightStrafe = gamepad1.right_trigger;
        double LeftStrafe = gamepad1.left_trigger;

        int ok=0;

        if(gamepad1.y)
        {
            ok=1;
            telemetry.addData("y: ", gamepad1.y);
        }

        if(ok==1)
        {
            drive = gamepad1.right_trigger * 0.2;
            turn = gamepad1.left_trigger * 0.2;
        }

        rightPower = Range.clip(drive + turn,-1.0,1.0)+0.1;
        leftPower  = Range.clip(drive - turn,-1.0,1.0);

        if(RightStrafe>0)
        {
            robot.RightFrontMotor.setPower(RightStrafe);
            robot.RightBackMotor.setPower(-RightStrafe);
            robot.LeftFrontMotor.setPower(-RightStrafe);
            robot.LeftBackMotor.setPower(RightStrafe);

        }
        else if(LeftStrafe>0)
        {
            robot.RightFrontMotor.setPower(-LeftStrafe);
            robot.RightBackMotor.setPower(LeftStrafe);
            robot.LeftFrontMotor.setPower(LeftStrafe);
            robot.LeftBackMotor.setPower(-LeftStrafe);
        }
        else if(gamepad1.left_stick_x==0 && gamepad1.left_stick_y==0 && gamepad1.right_stick_x==0 && gamepad1.right_stick_y==0)
        {
            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
        }
        else
        {
            robot.RightFrontMotor.setPower(rightPower);
            robot.RightBackMotor.setPower(rightPower);
            robot.LeftFrontMotor.setPower(leftPower);
            robot.LeftBackMotor.setPower(leftPower);
        }


        if(gamepad2.a )
            robot.Ridicare.setPosition(0.2);
        else if(gamepad2.b)
            robot.Ridicare.setPosition(0.6);

        if(gamepad2.x )
            robot.Impingere.setPosition(0.2);
        else if(gamepad2.y )
            robot.Impingere.setPosition(0.04);

        if(gamepad1.a )
            robot.Wobble.setPosition(0.3);
        else if(gamepad1.b)
            robot.Wobble.setPosition(0.45);
        else if(gamepad1.x)
            robot.Wobble.setPosition(0.6);

        ///if(gamepad1.y)
        {
            if(Double.parseDouble(formatAngle(angles.angleUnit, angles.firstAngle)) > angles.firstAngle)
            {
                telemetry.addData("Rotestete la dreapta", formatAngle(angles.angleUnit, angles.firstAngle));
                telemetry.addData("angle", formatAngle(angles.angleUnit, angles.firstAngle));
                telemetry.addData("angles.firstAngle", angles.firstAngle);


            }
            else
            {
                telemetry.addData("Rotestete la stanga", formatAngle(angles.angleUnit, angles.firstAngle));
                telemetry.addData("angle", formatAngle(angles.angleUnit, angles.firstAngle));
                telemetry.addData("angles.firstAngle", angles.firstAngle);
            }
        }


        robot.Outtake.setPower(gamepad2.left_trigger);
        robot.Intake.setPower(gamepad2.right_trigger);


        telemetry.addData("color1 alpha:", robot.color1.alpha());
        //telemetry.addData("color1 argb", robot.color1.argb());
        telemetry.addData("color2 alpha:", robot.color2.alpha());
        //telemetry.addData("color2 argb", robot.color2.argb());
        //telemetry.addData("Ridicare: ", gamepad1.right_trigger);
        //telemetry.addData("Impingere", gamepad1.left_trigger);
        telemetry.update();
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
}
