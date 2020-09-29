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

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class HardwareMapSponsori {

    /**  Acest Hardware Map va fi folosit la prezentarile pentru sponsori  **/

    /**  DECLARARI  **/

    // Declarare Motoare Deplasare
    public DcMotor RightBackMotor = null;
    public DcMotor RightFrontMotor = null;
    public DcMotor LeftBackMotor = null;
    public DcMotor LeftFrontMotor = null;

    // Declarare Motoare Intake

    public DcMotor RightIntakeMotor = null;
    public DcMotor LeftIntakeMotor = null;

    // Declarare Servouri
    public servo ServoBariera = null;
    public servo ServoBrat = null;

    //Declarare HardwareMap
    HardwareMap HWM_Sponsori  =  null;

    // Constructor
    public HardwareMapSponsori(){}

    /*  Initializare HardwareMap  */

    public void init(HardwareMap ahwMap){
        HWM_Sponsori = ahwMap;

        // Initializare Motoare de Deplasare

        RightBackMotor = HWM_Sponsori.get(DcMotor.class,"RightBackMotor");
        RightFrontMotor = HWM_Sponsori.get(DcMotor.class,"RightFrontMotor");
        LeftBackMotor  = HWM_Sponsori.get(DcMotor.class, "LeftBackMotor");
        LeftFrontMotor = HWM_Sponsori.get(DcMotor.class, "LeftFrontMotor");

        // Initializare Motoare pentru Intake

        RightIntakeMotor=HWM_Sponsori.get(DcMotor.class,"RightIntakeMotor");
        LeftIntakeMotor=HWM_Sponsori.get(DcMotor.class,"LeftIntakeMotor");

        // Initializare Servouri

        ServoBariera = HWM_Sponsori.get(servo.class,"ServoBariera");
        ServoBrat = HWM_Sponsori.get(servo.class,"ServoBrat");

        // Seteaza directia Motoarelor de Deplasare

        RightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        RightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        LeftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        LeftFrontMotor.setDirection(DcMotor.Direction.REVERSE);

        // Seteaza directia Motoarelor pentru Intake
        RightIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        LeftIntakeMotor.setDirection(DcMotor.Direction.REVERSE);

        // Opreste Motoarele

        StopMovementMotors();

        StopIntakeMotors();

        // Setare mod: cu sau fara Encodere

        RightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LeftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LeftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    /* Metode sa faca codul mai lizibil si mai scurt */


    public void StopMovementMotors(){
        RightBackMotor.setPower(0);
        RightFrontMotor.setPower(0);
        LeftBackMotor.setPower(0);
        LeftFrontMotor.setPower(0);
    }

    public void StopIntakeMotors(){
        RightIntakeMotor.setPower(0);
        LeftIntakeMotor.setPower(0);
    }
    public void Intake(double direction){
        RightIntakeMotor.setPower(direction*0.5);
        LeftIntakeMotor.setPower(direction*0.5);
    }

}
