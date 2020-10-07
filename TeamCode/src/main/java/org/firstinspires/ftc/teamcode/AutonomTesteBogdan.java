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
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.HardwareMapTesteBogdan;
import static org.firstinspires.ftc.teamcode.HardwareMapTesteBogdan.COUNTS_PER_MM;
import static org.firstinspires.ftc.teamcode.HardwareMapTesteBogdan.DriveValue;


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

@Autonomous(name="Autonom Teste bogdan", group="Linear Opmode")
//@Disabled
public class AutonomTesteBogdan extends LinearOpMode {


    private static final double SERVO_HOME = 0.1;

    //Declaring Hardware Map
    private ElapsedTime runtime = new ElapsedTime();
    HardwareMapTesteBogdan Robot = new HardwareMapTesteBogdan();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initializam robot
        Robot.init(hardwareMap);

        // Initializam encoderele
        Robot.InitEncoders();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        if(opModeIsActive()){
            DeplasareTimp(1300,0.7,0.7);
            sleep(200);
            StrafeDreaptaTimp(1000,0.5);
            sleep(200);
            DeplasareTimp(850,0.5,-0.5);
            sleep(200);
            DeplasareTimp(500,0.7,0.7);
            sleep(200);
            StrafeDreaptaTimp(500,0.5);
            Robot.Intake(-1);
            DeplasareTimp(500,0.7,0.7);
            sleep(400);
            DeplasareTimp(850,0.5,-0.5);
            sleep(200);
            Robot.StopIntakeMotors();
        }




    }

    public void DeplasareTimp(long Time,double PowerRight,double PowerLeft){
        Robot.RunMovementMotors(-PowerRight,-PowerLeft);
        sleep(Time);
        Robot.StopMovementMotors();
    }
    public void StrafeDreaptaTimp(long Time,double Power){
        Robot.StrafeMovementMotors(-Power);
        sleep(Time);
        Robot.StopMovementMotors();
    }

    public void StrafeStangaTimp(long Time,double Power){
        Robot.StrafeMovementMotors(Power);
        sleep(Time);
        Robot.StopMovementMotors();
    }
    public void IntakeTime(long Time,double direction){
        Robot.Intake(direction);
        sleep(Time);
        Robot.StopIntakeMotors();
    }

    public void DeplasareEncoders(double Power,double distance){

        int RightBackTarget = Robot.RightBackMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * DriveValue);
        int RightFrontTarget = Robot.RightFrontMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * DriveValue);
        int LeftBackTarget = Robot.LeftBackMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * DriveValue);
        int LeftFrontTarget = Robot.LeftFrontMotor.getCurrentPosition() + (int)(distance * COUNTS_PER_MM * DriveValue);

        Robot.RunToPositionMode(RightBackTarget,RightFrontTarget,LeftBackTarget,LeftFrontTarget);

        Robot.RunMovementMotors(Power,Power);
        while(opModeIsActive() && Robot.VerifMovementMotors() ){
            //loop pana ajunge la pozitia dorita
        }

        Robot.StopMovementMotors();

        Robot.RightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Robot.RightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Robot.LeftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Robot.LeftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    

}
