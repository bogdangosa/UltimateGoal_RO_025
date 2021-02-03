ewpackage org.firstinspires.ftc.teamcode;

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

        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        waitForStart();

        /**     MERGE IN FATA   */
        robot.LeftFrontMotor.setPower(-0.7);
        robot.LeftBackMotor.setPower(-0.7);
        robot.RightFrontMotor.setPower(-0.7);
        robot.RightBackMotor.setPower(-0.7);

        sleep(900);

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

        sleep(300);

        /**     MERGE IN FATA   */
        robot.LeftFrontMotor.setPower(-0.7);
        robot.LeftBackMotor.setPower(-0.7);
        robot.RightFrontMotor.setPower(-0.7);
        robot.RightBackMotor.setPower(-0.7);

        sleep(700);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(300);

        /**     COLECTEAZA CUB  */
        robot.IntakeRight.setPower(-0.55);
        robot.IntakeLeft.setPower(-0.55);

        robot.LeftFrontMotor.setPower(-0.15);
        robot.LeftBackMotor.setPower(-0.15);
        robot.RightFrontMotor.setPower(-0.15);
        robot.RightBackMotor.setPower(-0.15);

        sleep(500);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        robot.IntakeRight.setPower(0);
        robot.IntakeLeft.setPower(0);

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

        sleep(300);

        /**     MERGE IN SPATE   */
        robot.LeftFrontMotor.setPower(0.7);
        robot.LeftBackMotor.setPower(0.7);
        robot.RightFrontMotor.setPower(0.7);
        robot.RightBackMotor.setPower(0.7);

        sleep(750);

        //robot.LeftFrontMotor.setPower(0);
        //robot.LeftBackMotor.setPower(0);
        //robot.RightFrontMotor.setPower(0);
        //robot.RightBackMotor.setPower(0);

        /**     SE INTOARCE LA STANGA  */
        robot.LeftFrontMotor.setPower(0.5);
        robot.LeftBackMotor.setPower(0.5);
        robot.RightFrontMotor.setPower(-0.5);
        robot.RightBackMotor.setPower(-0.5);

        sleep(700);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        sleep(300);

        /**     MERGE IN SPATE   */
        robot.LeftFrontMotor.setPower(0.7);
        robot.LeftBackMotor.setPower(0.7);
        robot.RightFrontMotor.setPower(0.7);
        robot.RightBackMotor.setPower(0.7);

        sleep(200);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);

        /**     lASA CUB   */
        robot.IntakeRight.setPower(-0.3);
        robot.IntakeLeft.setPower(-0.3);

        sleep(150);

        robot.IntakeRight.setPower(0);
        robot.IntakeLeft.setPower(0);

        robot.ServoBariera.setPosition(1);
        sleep(1000);
        robot.ServoOutTake.setPosition(0);
        sleep(1000);
        robot.ServoOutTake.setPosition(1);
        robot.ServoBariera.setPosition(0);
        sleep(1000);

        /** MERGE IN FATA*/
        robot.LeftFrontMotor.setPower(-0.4);
        robot.LeftBackMotor.setPower(-0.4);
        robot.RightFrontMotor.setPower(-0.4);
        robot.RightBackMotor.setPower(-0.4);

        sleep(300);

        robot.LeftFrontMotor.setPower(0);
        robot.LeftBackMotor.setPower(0);
        robot.RightFrontMotor.setPower(0);
        robot.RightBackMotor.setPower(0);
    }
}
