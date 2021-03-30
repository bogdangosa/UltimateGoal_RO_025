
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class   Ana_HM_Test
{

    ColorSensor color1;
    ColorSensor color2;

    public Servo servo= null;

    public DcMotor RightFrontMotor = null;
    public DcMotor RightBackMotor = null;
    public DcMotor LeftFrontMotor = null;
    public DcMotor LeftBackMotor = null;

    HardwareMap Ana_HM_Test =  null;

    public void init(HardwareMap ahwMap) {
        Ana_HM_Test = ahwMap;

        color1 = Ana_HM_Test.get(ColorSensor.class, "color1");
        color1 = Ana_HM_Test.colorSensor.get("color1");

        color2 = Ana_HM_Test.get(ColorSensor.class, "color2");
        color2 = Ana_HM_Test.colorSensor.get("color2");

        servo = Ana_HM_Test.get(Servo.class, "servo");

        RightBackMotor=Ana_HM_Test.get(DcMotor.class, "RightBackMotor");
        RightFrontMotor=Ana_HM_Test.get(DcMotor.class, "RightFrontMotor");
        LeftFrontMotor=Ana_HM_Test.get(DcMotor.class, "LeftFrontMotor");
        LeftBackMotor=Ana_HM_Test.get(DcMotor.class, "LeftBackMotor");

        RightBackMotor.setDirection(REVERSE);
        RightFrontMotor.setDirection(REVERSE);
        LeftBackMotor.setDirection(FORWARD);
        LeftFrontMotor.setDirection(REVERSE);

        RightBackMotor.setPower(0);
        RightFrontMotor.setPower(0);
        LeftFrontMotor.setPower(0);
        LeftBackMotor.setPower(0);

        servo.setPosition(0.25);
    }
}
