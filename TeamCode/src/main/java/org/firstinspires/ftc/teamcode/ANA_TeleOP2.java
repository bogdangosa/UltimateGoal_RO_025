package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="ANA_TeleOP2", group="Iterative Opmode")
public class ANA_TeleOP2 extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    ANA_HardwareMap robot = new ANA_HardwareMap();
    @Override
    public void init() {
        telemetry.addData("Status", "Before Initialization");

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


        robot.Outtake.setPower(gamepad2.left_trigger);
        robot.Intake.setPower(gamepad2.right_trigger);
        telemetry.addData("color1 alpha:", robot.color1.alpha());
        telemetry.addData("color1 argb", robot.color1.argb());
        telemetry.addData("color2 alpha:", robot.color2.alpha());
        telemetry.addData("color2 argb", robot.color2.argb());
        telemetry.addData("Ridicare: ", gamepad1.right_trigger);
        telemetry.addData("Impingere", gamepad1.left_trigger);
        telemetry.update();
    }
}
