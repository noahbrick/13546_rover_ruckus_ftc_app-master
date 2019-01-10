package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by noahbrick48 on 10/17/2018.
 */
@TeleOp(name="drivetrain: Telop tank2", group="metal")

public class drivetrank2 extends LinearOpMode{

    hardwaremap2 robot = new hardwaremap2();

    @Override
    public void runOpMode() {
        double liftmotor;
        double left;
        double right;
        double ballservo;
        double ballarm;
        double divide;

        robot.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {

            ballarm = -gamepad2.left_stick_y;
            divide = 1;
            //down
            if (ballarm > 0) {
                divide = 3;
            }
            //up

            else if (ballarm < 0) {
                divide = 3;
            }

            robot.ballarm.setPower(ballarm / divide);


            liftmotor = -gamepad2.right_stick_y;
            robot.lifter.setPower(liftmotor);


            left = gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            telemetry.update();

            if (left > 0.05 || left < -0.05 || right > 0.05 || right < -0.05) {
                robot.leftwheel.setPower(left);
                robot.rightwheel.setPower(right);
                robot.rightoniwheel.setPower(right);
                robot.leftoniwheel.setPower(left);
                Telemetry.Item path2 = telemetry.addData("Path2", "stick movement " );

            } else if (gamepad1.x) {
                robot.leftoniwheel.setPower(0.5);
                robot.rightwheel.setPower(0.5);
                Telemetry.Item path2 = telemetry.addData("Path2", "gamepad1 press x");
            }
             else if (gamepad1.y) {
            robot.leftoniwheel.setPower(-0.5);
            robot.rightwheel.setPower(-0.5);
                Telemetry.Item path2 = telemetry.addData("Path2", "gamepad1 press y");

        }


             else if (gamepad1.dpad_up) {
                robot.leftwheel.setPower(0.5);
                robot.rightoniwheel.setPower(0.5);
            }
            else if (gamepad1.dpad_down) {
                robot.leftwheel.setPower(-0.5);
                robot.rightoniwheel.setPower(-0.5);
            }

            else if (gamepad1.dpad_right) {
                robot.leftwheel.setPower(-0.5);
                robot.rightoniwheel.setPower(0.5);
                robot.leftoniwheel.setPower(0.5);
                robot.rightwheel.setPower(-0.5);
            }

            else if (gamepad1.dpad_left) {
                robot.leftwheel.setPower(0.5);
                robot.rightoniwheel.setPower(-0.5);
                robot.rightwheel.setPower(0.5);
                robot.leftoniwheel.setPower(-0.5);
            }



            else {
                robot.leftwheel.setPower(0);
                robot.rightwheel.setPower(0);
                robot.rightoniwheel.setPower(0);
                robot.leftoniwheel.setPower(0);
            }


            if (gamepad2.dpad_down)
            {
                robot.ballholder.setPosition(robot.center);
            }
            else if (gamepad2.dpad_left)
            {
                robot.ballholder.setPosition(robot.negativeone);
            }
            else if  (gamepad2.dpad_right)
            {
                robot.ballholder.setPosition(robot.one);
            }
            }
        }







    }




