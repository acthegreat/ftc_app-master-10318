package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Administrator on 2015/10/28.
 */
public class ACtheHardware  extends OpMode{

    //defining the variables:

     DcMotor ac_motorleft;
     DcMotor ac_motorright;
     DcMotor ac_motorbkleft;
     DcMotor ac_motorbkright;
     OpticalDistanceSensor ac_ods;
     TouchSensor ac_touch;
     ColorSensor ac_color;
     Servo ac_servo;


    @Override
    public void init() {
        //assigning the variables to their motors
        try {ac_motorleft = hardwareMap.dcMotor.get ("motorleft");}
        catch (Exception p_exeception){
            ac_motorleft = null;
            telemetry.addData ("ERROR", " motorleft (front) not detected  ):  ");
        }
        try {ac_motorright = hardwareMap.dcMotor.get("motorright");}
        catch (Exception p_exception){
            ac_motorright = null;
            telemetry.addData ("'ERROR", "motorright (front) not detected  ):  ");
        }

        try {ac_motorbkleft = hardwareMap.dcMotor.get("motorbkleft");}
        catch (Exception p_exception){
            ac_motorbkleft = null;
            telemetry.addData ("ERROR", "motorbkleft not detected  ):  " );

        }
        try {
        ac_motorbkright = hardwareMap.dcMotor.get("motorbkright");}
        catch (Exception p_exception){
            ac_motorbkright = null;
            telemetry.addData("Error", "motorbkright not detected  ):  ");
        }
        try {
            ac_ods = hardwareMap.opticalDistanceSensor.get ("ods");
        }
        catch (Exception p_exception){
            ac_ods = null;
            telemetry.addData("Error", "optical distance sensor (ods) not detected  ):  ");
        }
        try {
            ac_touch = hardwareMap.touchSensor.get ("touch");
        }
        catch (Exception p_exception){
            ac_touch = null;
            telemetry.addData("Error", "touch sensor (touch) not detected  ):  ");
        }
        try {
            ac_color = hardwareMap.colorSensor.get ("color");
        }
        catch (Exception p_exception){
            ac_color = null;
            telemetry.addData ("Error", "color not detected  ):  ");
        }
        try {
            ac_servo = hardwareMap.servo.get ("servo");
        }
        catch (Exception p_exception){
            ac_servo =  null;
            telemetry.addData ("Error", "servo not detected ):");
        }


        ac_motorleft.setDirection(DcMotor.Direction.REVERSE);
        ac_motorbkleft.setDirection(DcMotor.Direction.REVERSE);


    }
    @Override public void start ()

    {
        //
        // Only actions that are common to all Op-Modes (i.e. both automatic and
        // manual) should be implemented here.
        //
        // This method is designed to be overridden.
        //

    } // start

    @Override
    public void loop() {
        //nothing here.

    }
    @Override public void stop ()
    {
        //
        // Nothing needs to be done for this method.
        //

    } // stop
     public void telemetry_update()
    {
        telemetry.addData("left drive stick" , +gamepad1.left_stick_y);
        telemetry.addData("right drive stick" , +gamepad1.right_stick_y);
        telemetry.addData ("touch sensor", ac_touch.isPressed());
        telemetry.addData ("Optical Distance", ac_ods.getLightDetected());
        telemetry.addData ("Color.Red", +ac_color.red());
        telemetry.addData ("Color.Green", +ac_color.green());
        telemetry.addData ("Color.Blue", +ac_color.blue());


    }
    public void set_drive_power (double lt , double rt){
        ac_motorleft.setPower (lt);
        ac_motorright.setPower (rt);
        ac_motorbkleft.setPower (lt);
        ac_motorbkright.setPower (rt);
    }
}
