package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
/*
 * Created by noahbrick48 on 10/17/2018.
  */

public class hardwaremap2 {

    public DcMotor lifter = null;
    public DcMotor rightoniwheel = null;
    public DcMotor leftoniwheel = null;
    public DcMotor rightwheel = null;
    public DcMotor leftwheel = null;
    public DcMotor ballpulley = null;
    public DcMotor   ballfliper = null;


    public Servo liftflipper = null ;
    public Servo spinner = null ;





    HardwareMap hwMap2 = null;

    public void init (HardwareMap hawMap) {

        hwMap2 = hawMap;

        rightwheel = hwMap2.get(DcMotor.class, "rightdrive");
        leftwheel = hwMap2.get(DcMotor.class, "leftdrive");

        rightoniwheel = hwMap2.get(DcMotor.class, "rightonidrive");
        leftoniwheel = hwMap2.get(DcMotor.class, "leftonidrive");

        lifter = hwMap2.get(DcMotor.class, "lifter");

        ballpulley = hwMap2.get(DcMotor.class, "ballpulley");

        ballfliper = hwMap2.get(DcMotor.class, "ballfliper");


        spinner = hwMap2.get(Servo.class, "spinner");

        liftflipper = hwMap2.get(Servo.class, "lifterflipper");





    }

    }




