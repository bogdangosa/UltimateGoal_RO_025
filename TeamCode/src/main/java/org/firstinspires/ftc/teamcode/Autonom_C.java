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

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous
public class Autonom_C extends LinearOpMode {

    Ana_HM_Test robot = new Ana_HM_Test();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        robot.RightFrontMotor.setPower(0.5);
        robot.RightBackMotor.setPower(0.5);
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(0.5);
        sleep(650);


        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        sleep(300);

        robot.RightFrontMotor.setPower(-0.5);
        robot.RightBackMotor.setPower(-0.5);
        robot.LeftFrontMotor.setPower(-0.5);
        robot.LeftBackMotor.setPower(-0.5);
        sleep(600);

        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        sleep(300);

        int ok=0;

        if (robot.color1.argb() < 17000000 ) {

            ok=1;

            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1000);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1200);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);
        }
        else if(robot.color1.argb()>17000000 && robot.color2.argb()<17000000) {

            ok=2;

            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(600);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

        }
        else if(robot.color1.argb()>17000000 && robot.color2.argb()>17000000) {

            ok=3;

            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(2500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(500);
        }
                   /**LUAM WOOBLE**/

        if(ok==3)
        {
            ///Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(500);

            ///Merge in fata
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            ///Strafe stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(400);

            ///Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(500);

            ///Merge in spate
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

             ///Strafe stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(900);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(400);

            ///Merge in fata (parcare)
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);


        }

    }
}
