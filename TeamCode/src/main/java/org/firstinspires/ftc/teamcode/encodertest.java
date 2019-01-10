package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import android.graphics.Path;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.abs;

@Autonomous(name="test ", group="Pushbot")

public class encodertest extends LinearOpMode  {
    hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        robot.rightwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightoniwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftoniwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rightwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();
        while (opModeIsActive())
        {






                robot.leftwheel.setPower(0.5);
                robot.rightwheel.setPower(0.5);
                robot.rightoniwheel.setPower(0.5);
                robot.leftoniwheel.setPower(0.5);

            Telemetry.Item path7  = telemetry.addData("leftoni", "Running at %7d ", robot.leftoniwheel.getCurrentPosition() );
            Telemetry.Item path4  = telemetry.addData("righoni", "Running at %7d ", robot.rightoniwheel.getCurrentPosition() );
            Telemetry.Item path5  = telemetry.addData("right", "Running at %7d ", robot.rightwheel.getCurrentPosition() );
            Telemetry.Item path6  = telemetry.addData("left ", "Running at %7d ", robot.leftwheel.getCurrentPosition() );

            telemetry.update();






        }
    }
}
