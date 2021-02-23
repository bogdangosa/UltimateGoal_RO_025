package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class Autonom_test extends LinearOpMode {
    Ana_HM_Test robot = new Ana_HM_Test();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        robot.servo.setPosition(0.3);
        //Mers cu spatele
        robot.RightFrontMotor.setPower(0.5);
        robot.RightBackMotor.setPower(0.5);
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(0.5);
        sleep(800);

        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        sleep(300);

        ///Strafe la stanga
        robot.RightFrontMotor.setPower(-0.5);
        robot.RightBackMotor.setPower(0.5);
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(-0.5);
        sleep(600);

        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        sleep(300);

        int ok=0;

        if (robot.color1.argb() < 33000000 ) {

            ok=1;

            // Mers cu spatele
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

            ///Strafe stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            /** LASAM WOBBLE */
            robot.servo.setPosition(0);

            //Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(400);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(300);
        }
        else if(robot.color1.argb()>17000000 && robot.color2.argb()<17000000) {

            ok=2;

            //Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(600);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(300);

            //Mers cu spatele
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(2000);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            /**     LASAM WOBBLE     */
            robot.servo.setPosition(0);

            //Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(600);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(300);
        }
        else if(robot.color1.argb()>17000000 && robot.color2.argb()>17000000) {

            ok=3;

            //Strafe stanga
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

            //Mers cu spatele
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(2800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

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

            /**     LASAM WOBBLE     */
            robot.servo.setPosition(0);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(300);
        }

        if(ok==1) {

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            /**
            //Mers cu fata
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Strafe dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(400);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(300);

            //Mers cu fata
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

                 LUAM WOBBLE

            //Mers cu spatele
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Strafe stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Mers cu spatele
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);
             **/
        }
        else if(ok==2) {
            //Mers cu fata
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(400);



        }
        else {
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(1100);

            /**
            //Strafe la dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Mers cu fata
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(2800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Strafe la stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

               LUAM WOOBLE


            //Strafe la dreapta
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Mers cu spatele
            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(2800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200);

            //Strafe la stanga
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(200); */
        }
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
    }
}
