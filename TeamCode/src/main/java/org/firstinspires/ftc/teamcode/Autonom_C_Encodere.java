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
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.teamcode.Hardware_Bistrita.COUNTS_PER_MM;
import static org.firstinspires.ftc.teamcode.Hardware_Bistrita.DriveValue;


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

@Autonomous(name="Autonom_C_Encodere", group="Pushbot")
@Disabled
public class Autonom_C_Encodere extends LinearOpMode {

    Ana_HM_Test robot = new Ana_HM_Test();
    private ElapsedTime     runtime = new ElapsedTime();

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
        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
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
                    newBackLeftTarget = robot.LeftBackMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                    newBackRightTarget = robot.RightBackMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                    newFrontLeftTarget = robot.LeftFrontMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);
                    newFrontRightTarget = robot.RightFrontMotor.getCurrentPosition() + (int) (-distance * COUNTS_PER_MM * DriveValue);

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
                    robot.RightBackMotor.setPower(-speed);
                    robot.LeftFrontMotor.setPower(speed);
                    robot.RightFrontMotor.setPower(-speed);

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
    }
}
