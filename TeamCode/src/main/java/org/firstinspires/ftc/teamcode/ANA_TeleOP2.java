/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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

        if(gamepad2.a )
            robot.Ridicare.setPosition(0.2);
        else if(gamepad2.b)
            robot.Ridicare.setPosition(0.6);

        if(gamepad2.x )
            robot.Impingere.setPosition(0.2);
        else if(gamepad2.y )
            robot.Impingere.setPosition(0.04);

        if(gamepad1.a )
            robot.Ridicare.setPosition(0.2);
        else if(gamepad1.b)
            robot.Ridicare.setPosition(0.6);

        robot.Outtake.setPower(gamepad2.left_trigger);
        robot.Intake.setPower(gamepad2.right_trigger);

        telemetry.addData("Ridicare: ", gamepad1.right_trigger);
        telemetry.addData("Impingere", gamepad1.left_trigger);
        telemetry.update();
    }
}
