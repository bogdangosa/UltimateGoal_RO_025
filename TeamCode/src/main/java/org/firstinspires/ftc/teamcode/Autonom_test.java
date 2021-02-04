package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.nio.charset.CharsetDecoder;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@Autonomous
public class Autonom_test extends LinearOpMode {
    Ana_HM_Test robot = new Ana_HM_Test();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
/*
        robot.RightFrontMotor.setPower(-0.5);
        robot.RightBackMotor.setPower(0.5);
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(-0.5);
        sleep(500);

        robot.RightFrontMotor.setPower(0.5);
        robot.RightBackMotor.setPower(0.5);
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(0.5);
        sleep(700);

        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);

        if (robot.color1.argb() < 36000000) {
            telemetry.addData("color1", robot.color1.argb());
            telemetry.addData("color2", robot.color1.argb());
            telemetry.update();

            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(650);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1100);
        }
        else if(robot.color1.argb()>36000000 && robot.color2.argb()<17000000){
            telemetry.addData("color1", robot.color1.argb());
            telemetry.addData("color2", robot.color1.argb());
            telemetry.update();


            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(600);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1300);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(600);
        }
        /*
        else if(robot.color1.argb()>17000000 && robot.color2.argb()>17000000){
            telemetry.addData("color1", robot.color1.argb());
            telemetry.addData("color2", robot.color1.argb());
            telemetry.update();

            robot.RightFrontMotor.setPower(0.3);
            robot.RightBackMotor.setPower(0.3);
            robot.LeftFrontMotor.setPower(-0.3);
            robot.LeftBackMotor.setPower(0-.3);
            sleep(200);

            robot.RightFrontMotor.setPower(0.3);
            robot.RightBackMotor.setPower(0.3);
            robot.LeftFrontMotor.setPower(0.3);
            robot.LeftBackMotor.setPower(0.3);
            sleep(600);
        }

        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);j

         */
    }
}
