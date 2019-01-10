package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by noahbrick48 on 1/8/2018.
 */
@TeleOp(name="relic test", group="metal")
public class relictest extends LinearOpMode{

    hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() {
        double relicgrabber;






        robot.init(hardwareMap);


        telemetry.addData("say", "it's working???");

        waitForStart();
        while (opModeIsActive()) {


            relicgrabber = (-gamepad2.right_stick_y)/3;
            robot.relicgrabber.setPower(relicgrabber);





            sleep(40);












        }












        }







}
