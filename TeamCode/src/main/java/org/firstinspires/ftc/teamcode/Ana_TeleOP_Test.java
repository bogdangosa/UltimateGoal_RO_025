package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name="Ana_TeleOP_Test")
public class Ana_TeleOP_Test extends OpMode {

    Ana_HM_Test robot=new Ana_HM_Test();

    @Override
    public void init()
    {
        robot.init(hardwareMap);
    }

    @Override
    public void loop()
    {
        if(gamepad1.a==true)
            robot.servo.setPosition(1);
        if(gamepad1.b==true)
            robot.servo.setPosition(0);

        if (robot.touch.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
        }
        else {
            telemetry.addData("Digital Touch", "Is Pressed");
        }

        if(robot.color.red() > robot.color.blue()  && robot.color.red() == robot.color.green())
        {
            robot.servo.setPosition(1);
        }
        telemetry.addData("red", robot.color.red());
        telemetry.addData("green", robot.color.green());
        telemetry.addData("blue", robot.color.blue());
        telemetry.addData("alpha", robot.color.alpha());
        telemetry.update();
    }

    @Override
    public void stop()
    {

    }
}