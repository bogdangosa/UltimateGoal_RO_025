package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static org.firstinspires.ftc.teamcode.Ana_HM_Test.COUNTS_PER_MM;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.DriveValue;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.StrafeValue;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.TURN_SPEED;
import static org.firstinspires.ftc.teamcode.Ana_HM_Test.TurnValue;

@Autonomous(name="AUtonomB_Encodere")
public class AutonomB_Encodere extends LinearOpMode{
    Ana_HM_Test robot   = new Ana_HM_Test();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

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

        robot.Wobble.setPosition(0.6);
        StrafeLeft(33, putere);
        sleep(200);
        DriveForward(103, putere);
        sleep(200);
        ///RotateLeft(10);
        sleep(1000);
       /// RotateRight(10);
        ///DriveForward(10, putere);
        sleep(100);
        if (robot.color1.alpha() < 140)
        {
            RotateLeft(15);
            StrafeLeft(100, putere);
            RotateRight(15);
            sleep(100);
            DriveForward(135, putere);
            RotateLeft(170);
            DriveBackward(25, putere);
            sleep(100);
            robot.Wobble.setPosition(0.15);
        }
        else if (robot.color1.alpha() > 120 && robot.color2.alpha() < 120 )
        {
            StrafeLeft(15, putere);
            robot.Intake.setPower(-1);
            DriveForward(45, 0.15);
            sleep(500);
            robot.Intake.setPower(0);
            RotateRight(10);
            DriveForward(220, putere);
            sleep(200);
            robot.Wobble.setPosition(0.3);
            sleep(100);
            DriveForward(65, putere);
            robot.Ridicare.setPosition(0.15);
            robot.Outtake.setPower(-1);
            robot.Impingere.setPosition(0.2);
            sleep(2000);
            robot.Outtake.setPower(0);
            sleep(200);
            robot.Ridicare.setPosition(0.6);
            robot.Impingere.setPosition(0.04);
            DriveBackward(150, putere);
            RotateLeft(155);
            DriveForward(200,putere);
            StrafeRight(73,putere);
            robot.Wobble.setPosition(0.45);
            sleep(300);
            robot.Wobble.setPosition(0.6);
            sleep(300);
        }
        else if(robot.color1.alpha() > 120 && robot.color2.alpha()>120)
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

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void EncoderDrive ( double speed, double distance, double timeoutS){
        if (opModeIsActive())
        {
            int newBackLeftTarget;
            int newBackRightTarget;
            int newFrontLeftTarget;
            int newFrontRightTarget;
            if (opModeIsActive())
            {
                newBackLeftTarget = robot.LeftBackMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                newBackRightTarget = robot.RightBackMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                newFrontLeftTarget = robot.LeftFrontMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                newFrontRightTarget = robot.RightFrontMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);

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
                robot.RightBackMotor.setPower(-speed + 0.2);
                robot.LeftFrontMotor.setPower(speed);
                robot.RightFrontMotor.setPower(-speed + 0.2);

                while (opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (
                                robot.LeftBackMotor.isBusy() && robot.RightBackMotor.isBusy() &&
                                        robot.LeftFrontMotor.isBusy() && robot.RightFrontMotor.isBusy()
                        ))
                {
                    telemetry.addData("Path1", "Running to %7d :%7d :%7d :%7d"
                            , newFrontLeftTarget, newFrontRightTarget
                            , newBackLeftTarget, newBackRightTarget);
                    telemetry.addData("Path2", "Running at %7d :%7d :%7d :%7d",
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
    }

    public void DriveBackward (double distance, double speed)
    {
        EncoderDrive(-speed, distance,15);
    }

    public void StrafeRight(double distance, double speed)
    {
        EncoderStrafe(speed, distance, 15);
    }

    public void StrafeLeft (double distance, double speed)
    {
        EncoderStrafe(-speed, -distance, 15);
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
}
