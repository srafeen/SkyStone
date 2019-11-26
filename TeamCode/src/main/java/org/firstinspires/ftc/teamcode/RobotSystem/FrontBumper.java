package org.firstinspires.ftc.teamcode.RobotSystem;

import android.telecom.TelecomManager;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class FrontBumper {

    HardwareMap myRobotHardwareConfig;

    DigitalChannel frontBumperSensor;


    boolean frontBumperFlag = false;

    public  FrontBumper(HardwareMap myHardwareMap){

        myRobotHardwareConfig = myHardwareMap;
        frontBumperSensor = myRobotHardwareConfig.digitalChannel.get("touch_sensor");
        frontBumperSensor.setMode(DigitalChannel.Mode.INPUT);
        frontBumperFlag = false;

    }

    //set the digitalchannel mode

    public void setSensorMode(DigitalChannel.Mode mode){

        frontBumperSensor.setMode(mode);
    }

    public boolean isBumperPressed(){

        // getState() return FALSE for button presed and TRUE for not pressed
        frontBumperFlag = !frontBumperSensor.getState();

        return frontBumperFlag;
    }
}
