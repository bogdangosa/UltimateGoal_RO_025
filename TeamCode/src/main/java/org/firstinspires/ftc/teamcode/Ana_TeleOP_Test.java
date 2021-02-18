package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp (name="Ana_TeleOP_Test")
public class Ana_TeleOP_Test extends OpMode {

    Ana_HM_Test robot = new Ana_HM_Test();

    @Override
    public void init()
    {

        robot.init(hardwareMap);

    }

    @Override
    public void loop()
    {

        double drive = gamepad1.right_stick_y;
        double turn = gamepad1.left_stick_x;

        double rightPower;
        double leftPower;

        double RightStrafe = gamepad1.right_trigger-0.2;
        double LeftStrafe = gamepad1.left_trigger-0.2;

        rightPower = Range.clip(drive + turn,-1.0,1.0);
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
        else
        {
            robot.RightFrontMotor.setPower(rightPower);
            robot.RightBackMotor.setPower(rightPower);
            robot.LeftFrontMotor.setPower(leftPower);
            robot.LeftBackMotor.setPower(leftPower);
        }
        if(gamepad1.a==true)
            robot.servo.setPosition(0.15);
        if(gamepad1.b==true)
            robot.servo.setPosition(0);

        if(robot.color1.argb() > 60000000)
        {
            robot.servo.setPosition(1);
        }

        telemetry.addData("Servo", gamepad2.right_trigger);
        telemetry.addData("argb1", robot.color1.argb());
        telemetry.addData("argb2", robot.color2.argb());

        telemetry.update();
    }

}