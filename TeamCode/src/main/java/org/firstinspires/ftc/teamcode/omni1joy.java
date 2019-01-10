package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.abs;

/**
 * Created by noahbrick48 on 11/27/2017.
 */
@TeleOp(name="drivetrain: Omni 1 Joy", group="metal")
public class omni1joy extends LinearOpMode {


    hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() {
        double blockgrabber;
        double relicgrabber;
        double x,y;


        robot.init(hardwareMap);

        telemetry.addData("say", "it's working???");

        waitForStart();
        while (opModeIsActive()) {

            x = -gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;

            if (abs(x) > 0.1 || abs(y) > 0.1)
            {
                robot.leftwheel.setPower(y-x);
                robot.rightwheel.setPower(x + y);
                robot.rightoniwheel.setPower(y-x);
                robot.leftoniwheel.setPower(x + y);
            }
            else
            {
                robot.leftwheel.setPower(0);
                robot.rightwheel.setPower(0);
                robot.rightoniwheel.setPower(0);
                robot.leftoniwheel.setPower(0);
            }

            telemetry.addData("X value", "working",x);
            telemetry.addData("Y value", "working",y);


            sleep(40);


        }
    }
}