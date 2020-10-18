package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


@Autonomous(name="Vuforia Test2", group ="Linear Opmode")
//@Disabled
public class VuforiaOpTest2 extends LinearOpMode {
    //Declaram Variabile
    WebcamName Webcam;
    VuforiaLocalizer.Parameters params;
    VuforiaLocalizer Vuforia;
    VuforiaTrackables VisionTargets;
    VuforiaTrackable target;

    OpenGLMatrix CameraPosition = null;
    OpenGLMatrix TargetLocation = null;


    @Override
    public void runOpMode() throws InterruptedException {
        Webcam = hardwareMap.get(WebcamName.class,"Webcam1");

        // Aici creem variabila params care vor fi setarile pentru vuforia si setam daca vrem sa apara camera pe ecran sau nu
       params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);

        //Daca Folosim Camera din spate
        //params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //Daca folosim camera externa
        params.cameraName = Webcam;

        // Adauga Licenta
        params.vuforiaLicenseKey= "AaiJFS7/////AAABmVpWv68PNUlbhA4ign1HTy5vSc9WldNhtHxgsYpDu0IunMxma" +
                "Zr1ekMfd+noqZikjacAdRvzdhxf/+XaqOiLQWMREOPQOkHS1MT2fLg6VsJzaOb4yiw+VC19JLQA0z4le/A" +
                "Kl2iGVuQfRF2YsYuaA+rQ8sMuIcj1HF5tmBnoLctVJDbWcqQUZyrMgcp7pe80UyGHXxos8tonEnJwSeopPJZzi" +
                "qBELIXqPsNOVfRKok2dGAfEiZroDQpfoEJvEL/yweQjejFXYA0PhduGAN0OPPbjyejmSrKo93R44I/N93S7NvXnr" +
                "AVapFZAaDS03+HWXTQWbYDM1en1jW1xoYhGVOmDvi3klPLZzYFi/MzEXi5k";

        //punem setarile
        Vuforia = ClassFactory.getInstance().createVuforia(params);

        //Adaugam Obiectele care vor trebui recunoscute de catre camera
        VisionTargets = Vuforia.loadTrackablesFromAsset("");

        target = VisionTargets.get(0);
        target.setName("Target");

        // Set camera position Relative To the Robot
        CameraPosition = OpenGLMatrix.translation(0,0,0)
                .multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XZY,
                        AngleUnit.DEGREES, 90, 90, 0));


        waitForStart();

        while (opModeIsActive()){

            telemetry.addData(target.getName(),
                    ((VuforiaTrackableDefaultListener)target.getListener()).isVisible() ? "Visible" : "Not Visible");

        }






    }
}
