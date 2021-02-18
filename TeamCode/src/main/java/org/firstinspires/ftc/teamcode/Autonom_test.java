package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class Autonom_test extends LinearOpMode {
    Ana_HM_Test robot = new Ana_HM_Test();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

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

            /** LASAM WOOBLE */
            robot.servo.setPosition(0);
        }
        else if(robot.color1.argb()>17000000 && robot.color2.argb()<17000000) {

            ok=2;

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

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(1800);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(600);

            /**     LASAM WOBBLE     */
            robot.servo.setPosition(0);

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
            sleep(200);

            /**     LASAM WOBBLE     */
            robot.servo.setPosition(0);
        }

        if(ok==1)
        {
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

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(-0.7);
            robot.LeftBackMotor.setPower(-0.7);
            sleep(3000);

            /**     LUAM WOOBLE     */

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
        }
        else if(ok==2) {
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(2100);

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
            sleep(800);

            /**     Luam Wooble     */

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

            robot.RightFrontMotor.setPower(0.5);
            robot.RightBackMotor.setPower(0.5);
            robot.LeftFrontMotor.setPower(0.5);
            robot.LeftBackMotor.setPower(0.5);
            sleep(2200);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
            sleep(600);

            /**     LASAM WOBBLE    */

            ///PARCARE
            robot.RightFrontMotor.setPower(-0.5);
            robot.RightBackMotor.setPower(-0.5);
            robot.LeftFrontMotor.setPower(-0.5);
            robot.LeftBackMotor.setPower(-0.5);
            sleep(500);

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(0);
            robot.LeftBackMotor.setPower(0);
        } else {
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

            robot.RightFrontMotor.setPower(0);
            robot.RightBackMotor.setPower(0);
            robot.LeftFrontMotor.setPower(-0.35);
            robot.LeftBackMotor.setPower(-0.35);
            sleep(1000);

            /**     LUAM WOOBLE     */

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
        }
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);

    }
}
