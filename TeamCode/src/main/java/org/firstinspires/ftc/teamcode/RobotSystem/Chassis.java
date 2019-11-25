package org.firstinspires.ftc.teamcode.RobotSystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

public class Chassis {

    HardwareMap robotConfiguration;

    DcMotor front_left_wheel;
    DcMotor front_right_wheel;
    DcMotor back_left_wheel;
    DcMotor back_right_wheel;

    public Chassis() {
    }

    public Chassis(HardwareMap myRobotHardwareMap){

        robotConfiguration = myRobotHardwareMap;

    }

    public void initWheels(){

        front_left_wheel = robotConfiguration.dcMotor.get("front_left_motor");
        front_right_wheel = robotConfiguration.dcMotor.get("front_right_motor");
        back_left_wheel = robotConfiguration.dcMotor.get("back_left_wheel");
        back_right_wheel = robotConfiguration.dcMotor.get("back_right_wheel");

    }

    public void setWheelDirection(String wheel , DcMotor.Direction direction){

        switch (wheel){

            case "FRONT_LEFT": front_left_wheel.setDirection(direction);
                               break;


            case "FRONT_RIGHT": front_right_wheel.setDirection(direction);
            break;

            case "BACK_LEFT" : back_left_wheel.setDirection(direction);
            break;

            case "BACK_RIGHT": back_right_wheel.setDirection(direction);
            break;

            case "ALL": setAllWheel(direction);
            break;
        }

    }

    public void setAllWheel(DcMotor.Direction direction){

        front_left_wheel.setDirection(direction);
        front_right_wheel.setDirection(direction);
        back_left_wheel.setDirection(direction);
        back_right_wheel.setDirection(direction);
    }
}

