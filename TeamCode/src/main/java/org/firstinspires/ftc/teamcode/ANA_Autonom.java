package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="ANA_Autonom",group="Pushbot")
public class ANA_Autonom extends LinearOpMode {

    ANA_HardwareMap robot = new ANA_HardwareMap();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        waitForStart();

        /**     MERGE IN FATA   */
        robot.LeftFrontMotor.setPower(-0.7);
        robot.LeftBackMotor.setPower(-0.7);
        robot.RightFrontMotor.setPower(-0.7);
        robot.RightBackMotor.setPower(-0.7);

        sleep(1500);

        //robot.LeftFrontMotor.setPower(0);
        //robot.LeftBackMotor.setPower(0);
        //robot.RightFrontMotor.setPower(0);
        //robot.RightBackMotor.setPower(0);

        /**     SE INTOARCE LA DREAPTA   */
        robot.LeftFrontMotor.setPower(-0.5);
        robot.LeftBackMotor.setPower(-0.5);
        robot.RightFrontMotor.setPower(0.5);
        robot.RightBackMotor.setPower(0.5);

        sleep(700);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(250);

        /**     MERGE IN FATA   */
        robot.LeftFrontMotor.setPower(-0.7);
        robot.LeftBackMotor.setPower(-0.7);
        robot.RightFrontMotor.setPower(-0.7);
        robot.RightBackMotor.setPower(-0.7);

        sleep(500);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(250);

        /**     COLECTEAZA CUB  */
        //robot.IntakeRight.setPower(0.8);
        //robot.IntakeLeft.setPower(0.8);

        //robot.LeftFrontMotor.setPower(0.2);
        //robot.LeftBackMotor.setPower(0.2);
        //robot.RightFrontMotor.setPower(0.2);
        //robot.RightBackMotor.setPower(0.2);

        //sleep(1000);

        //robot.LeftFrontMotor.setPower(0);
        //robot.LeftBackMotor.setPower(0);
        //robot.RightFrontMotor.setPower(0);
        //robot.RightBackMotor.setPower(0);

        //robot.IntakeRight.setPower(0);
        //robot.IntakeLeft.setPower(0);

        /**     STRAFE  DREAPTA     */
        robot.LeftFrontMotor.setPower(-0.7);
        robot.LeftBackMotor.setPower(0.7);
        robot.RightFrontMotor.setPower(0.7);
        robot.RightBackMotor.setPower(-0.7);

        sleep(700);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(250);

        /**     MERGE IN SPATE   */
        robot.LeftFrontMotor.setPower(10.7);
        robot.LeftBackMotor.setPower(0.7);
        robot.RightFrontMotor.setPower(0.7);
        robot.RightBackMotor.setPower(0.7);

        sleep(700);

        //robot.LeftFrontMotor.setPower(0);
        //robot.LeftBackMotor.setPower(0);
        //robot.RightFrontMotor.setPower(0);
        //robot.RightBackMotor.setPower(0);

        /**     SE INTOARCE LA STANGA  */
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(0.5);
        robot.RightFrontMotor.setPower(-0.5);
        robot.RightBackMotor.setPower(-0.5);

        sleep(800);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(250);

        /**     MERGE IN SPATE   */
        robot.LeftFrontMotor.setPower(0.7);
        robot.LeftBackMotor.setPower(0.7);
        robot.RightFrontMotor.setPower(0.7);
        robot.RightBackMotor.setPower(0.7);

        sleep(700);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        /**     lASA CUB   */
        //robot.ServoBariera.setPosition(1);
        //robot.ServoOutTake.setPosition(1);
        //robot.ServoOutTake.setPosition(0);
        //robot.ServoBariera.setPosition(0);

    }
}
