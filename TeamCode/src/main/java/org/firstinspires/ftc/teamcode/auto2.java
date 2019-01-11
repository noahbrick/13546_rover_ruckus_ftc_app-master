package org.firstinspires.ftc.teamcode;
import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;



@Autonomous(name="auto2 ", group="Pushbot")

public class auto2 extends LinearOpMode {

    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AWNAQgT/////AAABmSMNfKDWF0pLv2PkipZvR4dPWsDUT8WR2YAFCYBySvmRmhibtH70RHSc6vXDqQomKWVjmjH1hz+ieUy94WrFKvjKUrRogBxZu5650ND4E7LYq03gnBStL2BHhY00zhQZOB9U2qeNnh9+V+IUhf1zQvQXVsR4mxaP9sEOD1Z/RofV/ikuJlq7rsNU0UkifGQ8P2y/H7p3gqYv0r3P2yAtImYX5ea4HBPdaqHmmVzG4X96GGMILsrH//+F+ja3qCfAuK1+ETE7QZyqc9V8i6OTp+GuYCwOeIFg6fmQZKZWVr76LUKoQTg3ZHbTJsXQcIEjhZn9LdiTtvnLZSKoMM6l6KUbyZG6xF/1Owl29EP7DJk7";


    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;


    hardwaremap2 robot = new hardwaremap2();
    private ElapsedTime runtime = new ElapsedTime();
    static final double COUNTS_PER_MOTOR_REV = 1440;

    public void runOpMode() {

        initVuforia();


        if (ClassFactory.getInstance().

                canCreateTFObjectDetector())

        {
            initTfod();
        } else

        {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        // Wait for the game to begin */
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();

        waitForStart();

        if (tfod != null) {
            tfod.activate();
        }


        robot.init(hardwareMap);


        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        //robot.lifter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightoniwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftoniwheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        robot.lifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Path0", "lifter position", robot.lifter.getCurrentPosition());
        robot.leftoniwheel.getCurrentPosition();
        robot.leftwheel.getCurrentPosition();
        robot.rightwheel.getCurrentPosition();
        robot.rightoniwheel.getCurrentPosition();

        telemetry.update();

        waitForStart();


        int liftertarget;


        if (opModeIsActive()) {


            //liftertarget = robot.lifter.getCurrentPosition() + 100;
              /*
            robot.lifter.setTargetPosition(9900);


            robot.lifter.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();

            robot.lifter.setPower(-1);


            while (opModeIsActive() &&
                    robot.lifter.isBusy()) {

                // Display it for the driver.
                Telemetry.Item path2 = telemetry.addData("Path2", "Running at %7d ", robot.lifter.getCurrentPosition());


                telemetry.update();

            }

            robot.lifter.setPower(0);
            robot.lifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1000);


            robot.lifter.setTargetPosition(-9900);


            robot.lifter.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();

            robot.lifter.setPower(1);


            while (opModeIsActive() &&
                    robot.lifter.isBusy()) {

                // Display it for the driver.
                Telemetry.Item path2 = telemetry.addData("Path2", "Running at %7d ", robot.lifter.getCurrentPosition());


                telemetry.update();

            }

            robot.lifter.setPower(0);
            robot.lifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            // int leftOniWheelPosition = 2000000;

            robot.leftoniwheel.setTargetPosition(-150);
            robot.leftwheel.setTargetPosition(150);
            robot.rightwheel.setTargetPosition(150);
            robot.rightoniwheel.setTargetPosition(-150);

            runtime.reset();
            // int leftOniWheelPower = (leftOniWheelPosition > 0) ? -1 : 1;
            robot.leftwheel.setPower(1);
            robot.rightwheel.setPower(1);
            robot.leftoniwheel.setPower(1);
            robot.rightoniwheel.setPower(1);

            robot.rightoniwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftoniwheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            while (opModeIsActive() &&
                    robot.leftwheel.isBusy() && robot.leftoniwheel.isBusy() && robot.rightoniwheel.isBusy() && robot.rightwheel.isBusy())
                ;
            {

                // Display it for the driver.
                Telemetry.Item path7 = telemetry.addData("leftoni", "Running at %7d ", robot.leftoniwheel.getCurrentPosition());
                Telemetry.Item path4 = telemetry.addData("righoni", "Running at %7d ", robot.rightoniwheel.getCurrentPosition());
                Telemetry.Item path5 = telemetry.addData("right", "Running at %7d ", robot.rightwheel.getCurrentPosition());
                Telemetry.Item path6 = telemetry.addData("left ", "Running at %7d ", robot.leftwheel.getCurrentPosition());
                         */

                while (opModeIsActive()) {


                    if (tfod != null) {
                        // getUpdatedRecognitions() will return null if no new information is available since
                        // the last time that call was made.
                        List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                        if (updatedRecognitions != null) {
                            telemetry.addData("# Object Detected", updatedRecognitions.size());
                            if (updatedRecognitions.size() == 3) {
                                int goldMineralX = -1;
                                int silverMineral1X = -1;
                                int silverMineral2X = -1;
                                for (Recognition recognition : updatedRecognitions) {
                                    if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                        goldMineralX = (int) recognition.getLeft();
                                    }



                                    else if (silverMineral1X == -1) {
                                        silverMineral1X = (int) recognition.getLeft();
                                    }


                                    else {
                                        silverMineral2X = (int) recognition.getLeft();
                                    }
                                }
                                if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                    if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                        telemetry.addData("Gold Mineral Position", "Left");

                                        robot.leftoniwheel.setTargetPosition(-500);
                                        robot.leftwheel.setTargetPosition(500);
                                        robot.rightwheel.setTargetPosition(500);
                                        robot.rightoniwheel.setTargetPosition(-500);

                                        robot.leftwheel.setPower(1);
                                        robot.rightwheel.setPower(1);
                                        robot.leftoniwheel.setPower(1);
                                        robot.rightoniwheel.setPower(1);
                                        sleep(1000);

                                        robot.leftoniwheel.setTargetPosition(-1000);
                                        robot.leftwheel.setTargetPosition(1000);
                                        robot.rightwheel.setTargetPosition(1000);
                                        robot.rightoniwheel.setTargetPosition(-1000);

                                        robot.leftwheel.setPower(1);
                                        robot.rightwheel.setPower(1);
                                        robot.leftoniwheel.setPower(1);
                                        robot.rightoniwheel.setPower(1);


                                    } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                        telemetry.addData("Gold Mineral Position", "Right");

                                        robot.leftoniwheel.setTargetPosition(500);
                                        robot.leftwheel.setTargetPosition(-500);
                                        robot.rightwheel.setTargetPosition(-500);
                                        robot.rightoniwheel.setTargetPosition(500);

                                        robot.leftwheel.setPower(1);
                                        robot.rightwheel.setPower(1);
                                        robot.leftoniwheel.setPower(1);
                                        robot.rightoniwheel.setPower(1);
                                        sleep(1000);

                                        robot.leftoniwheel.setTargetPosition(-1000);
                                        robot.leftwheel.setTargetPosition(1000);
                                        robot.rightwheel.setTargetPosition(1000);
                                        robot.rightoniwheel.setTargetPosition(-1000);

                                        robot.leftwheel.setPower(1);
                                        robot.rightwheel.setPower(1);
                                        robot.leftoniwheel.setPower(1);
                                        robot.rightoniwheel.setPower(1);




                                    }






                                    else {
                                        telemetry.addData("Gold Mineral Position", "Center");


                                        robot.leftoniwheel.setTargetPosition(-1000);
                                        robot.leftwheel.setTargetPosition(1000);
                                        robot.rightwheel.setTargetPosition(1000);
                                        robot.rightoniwheel.setTargetPosition(-1000);

                                        robot.leftwheel.setPower(1);
                                        robot.rightwheel.setPower(1);
                                        robot.leftoniwheel.setPower(1);
                                        robot.rightoniwheel.setPower(1);




                                    }
                                }
                            }
                            telemetry.update();
                        }
                    }


                }

                if (tfod != null) {
                    tfod.shutdown();

                    telemetry.update();
                }


                robot.leftwheel.setPower(0);
                robot.leftwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                robot.rightwheel.setPower(0);
                robot.rightwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                robot.rightoniwheel.setPower(0);
                robot.rightoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                robot.leftoniwheel.setPower(0);
                robot.leftoniwheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            }


        }


        private void initVuforia () {

        // Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }


    //Initialize the Tensor Flow Object Detection engine.

    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);


    }
}


