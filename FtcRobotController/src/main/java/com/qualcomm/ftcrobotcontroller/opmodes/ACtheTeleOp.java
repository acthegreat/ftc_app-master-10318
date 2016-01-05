package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Administrator on 2015/10/28.
 */
public class ACtheTeleOp  extends ACtheHardware {
    @Override
    public void loop() {
        ac_motorleft.setPower (-1*gamepad1.left_stick_y);
        ac_motorright.setPower (-1*gamepad1.right_stick_y);
        ac_motorbkleft.setPower (-1*gamepad1.left_stick_y);
        ac_motorbkright.setPower(-1*gamepad1.right_stick_y);
        if (gamepad1.a){
            ac_leftservo.setPosition (0.1);
        }
        if (gamepad1.b){
            ac_leftservo.setPosition(0.7);
        }
        if (gamepad1.x){
            ac_rightservo.setPosition (0.1);
        }
        if (gamepad1.y){
            ac_rightservo.setPosition (0.7);
        }
        if (gamepad2.a){
           ac_conveyerbelt.setPower (1.0);
      }
       else if (gamepad2.b){
            ac_conveyerbelt.setPower (-1);
        }
        else {
            ac_conveyerbelt.setPower(0);
        }
        if (gamepad2.x){
            ac_bucket.setPower(0.2);
        }
        else if (gamepad2.y){
            ac_bucket.setPower(-0.2);
        }
        else{
            ac_bucket.setPower(0);
       }
        if (gamepad1.dpad_up){
            set_drive_power(-0.5,-0.5);
        }
        else if (gamepad1.dpad_down){
            set_drive_power(0.5,0.5);
        }
        else if (gamepad1.dpad_left){
            set_drive_power(-0.5, 0.5);
        }
        else if (gamepad1.dpad_right){
            set_drive_power(0.5, -0.5);
        }
      /*  if (gamepad2.dpad_down){
            ac_climberdropper.setPower(0.1);
        }
        else if (gamepad2.dpad_up){
            ac_climberdropper.setPower(-0.1);
        }
        else{
            ac_climberdropper.setPower(0);
        }
        */

        telemetry_update();
    }
}
