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

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Sponsori_TeleOp", group="Iterative Opmode")
//@Disabled
public class TeleOpSponsori extends OpMode {
    // Declare OpMode members.
    /*
     * Code to run ONCE when the driver hits INIT
     */

    private ElapsedTime runtime = new ElapsedTime();
    HardwareMapSponsori Robot = new HardwareMapSponsori();

    double TimpBariera=0.0;
    double TimpBrat=0.0;



    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Before initialazation");
        Robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        /** Deplasare **/

        //Creem variabila pentru puterea motoarelor
        double rightPower;
        double leftPower;

        // Creem variabile care sa preia inputul de la controllere
        double drive = gamepad1.right_stick_y;
        double turn  =  gamepad1.left_stick_x;
        double strafeRight = gamepad1.right_trigger;
        double strafeLeft = gamepad1.left_trigger;

        // Setam puterea
        rightPower = Range.clip(drive - turn,-1.0,1.0);
        leftPower = Range.clip(drive + turn,-1.0,1.0);


        // Ne deplasam in ce directie s-a apasat pe controller
        if(strafeLeft > 0){
            Robot.LeftBackMotor.setPower(strafeLeft);
            Robot.LeftFrontMotor.setPower(-strafeLeft);
            Robot.RightBackMotor.setPower(-strafeLeft);
            Robot.RightFrontMotor.setPower(strafeLeft);
        }
        else if(strafeRight > 0 ){
            Robot.LeftBackMotor.setPower(-strafeRight);
            Robot.LeftFrontMotor.setPower(strafeRight);
            Robot.RightBackMotor.setPower(strafeRight);
            Robot.RightFrontMotor.setPower(-strafeRight);
        }
        else {
            Robot.RightFrontMotor.setPower(rightPower);
            Robot.RightBackMotor.setPower(rightPower);
            Robot.LeftFrontMotor.setPower(leftPower);
            Robot.LeftBackMotor.setPower(leftPower);
        }

        /** Intake **/
        if(gamepad2.a)
            Robot.Intake(-1);
        else if(gamepad2.b)
            Robot.Intake(1);
        else
            Robot.StopIntakeMotors();

        // Controlare Bariera
        if(gamepad2.x){
            //TimpBariera = Double.parseDouble( runtime.toString() );

            if(Robot.ServoBariera.getPosition()==0.5)
                Robot.ServoBariera.setPosition(0.7);
            else if(Robot.ServoBariera.getPosition()==0.7)
                Robot.ServoBariera.setPosition(0.5);
        }

        if(gamepad2.y){
           // TimpBrat = Double.parseDouble( runtime.toString() );
            int pozitie_brat= (int)(Robot.ServoBrat.getPosition()*10);

            if(pozitie_brat==9)
                Robot.ServoBrat.setPosition(0.0);
            else if(pozitie_brat==0)
                Robot.ServoBrat.setPosition(0.9);
        }

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
        telemetry.addData("Servo Brat: ", Robot.ServoBrat.getPosition());
        telemetry.addData("TimpBrat",TimpBrat);
        telemetry.addData("TimpBariera",TimpBariera);
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        Robot.StopMovementMotors();
        Robot.StopIntakeMotors();
    }




}
