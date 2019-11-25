package org.firstinspires.ftc.teamcode.RobotSystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Chassis {

    HardwareMap robotConfiguration;

    DcMotor front_left_wheel;
    DcMotor front_right_wheel;
    DcMotor back_left_wheel;
    DcMotor back_right_wheel;

    HashMap<Integer,DcMotor> wheels ;

    public Chassis() {
    }

    public Chassis(HardwareMap myRobotHardwareMap){

        robotConfiguration = myRobotHardwareMap;
        wheels = new HashMap<Integer, DcMotor>();

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

            case "ALL": setAllWheelDirection(direction);
            break;
        }

    }



    public  void wheelsSetZero(String wheel){

        switch (wheel){

            case "FRONT_LEFT": front_left_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                break;


            case "FRONT_RIGHT": front_right_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                break;

            case "BACK_LEFT" : back_left_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                break;

            case "BACK_RIGHT": back_right_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                break;

            case "ALL": setAllWheelZeroPower();
                break;
        }



    }



    public void setWheelMode(DcMotor.RunMode mode){

        runWheelPreCondition();

        switch (mode) {

            case RUN_TO_POSITION:
                setAllWheelMode(DcMotor.RunMode.RUN_TO_POSITION);
                break;

            case RUN_USING_ENCODER:
                setAllWheelMode(DcMotor.RunMode.RUN_USING_ENCODER);
                break;

            case RUN_WITHOUT_ENCODER:
                setAllWheelMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                break;

            case STOP_AND_RESET_ENCODER:
                setAllWheelMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                break;



        }

    }

    public void setWheelTargetPosition(String wheel , int position){

        switch (wheel){

            case "FRONT_LEFT": front_left_wheel.setTargetPosition(position);
                break;


            case "FRONT_RIGHT": front_right_wheel.setTargetPosition(position);
                break;

            case "BACK_LEFT" : back_left_wheel.setTargetPosition(position);
                break;

            case "BACK_RIGHT": back_right_wheel.setTargetPosition(position);
                break;

            case "ALL": setAllWheelTargetPosition(position);
                break;
        }

    }

    //function to run as precondition before changing the run mode of all wheels
    public void runWheelPreCondition(){

        setAllWheelZeroPower();
        setAllWheelMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    //function to set  direction to REVERSE or FORWARD for all  wheels
    public void setAllWheelDirection(DcMotor.Direction direction){

        front_left_wheel.setDirection(direction);
        front_right_wheel.setDirection(direction);
        back_left_wheel.setDirection(direction);
        back_right_wheel.setDirection(direction);
    }

    //function to set the Zero power behaviour for all wheels
    public void setAllWheelZeroPower(){

        front_left_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    //Function to set run mode for all wheels
    public void setAllWheelMode(DcMotor.RunMode mode){

        front_left_wheel.setMode(mode);
        front_right_wheel.setMode(mode);
        back_left_wheel.setMode(mode);
        back_right_wheel.setMode(mode);
    }





    //setting the target position for all wheels
    public void setAllWheelTargetPosition(int position){

        front_left_wheel.setTargetPosition(position);
        front_right_wheel.setTargetPosition(position);
        back_left_wheel.setTargetPosition(position);
        back_right_wheel.setTargetPosition(position);

    }

    //setting the power to all wheels
    public void setAllWheelPower(double power){

        front_left_wheel.setPower(power);
        front_right_wheel.setPower(power);
        back_left_wheel.setPower(power);
        back_right_wheel.setPower(power);

    }

    //functions for moving the wheel drive

    //function to move forward given position and power
    public void robotMove(int position, double power) {

        setAllWheelDirection(DcMotor.Direction.FORWARD);
        setAllWheelTargetPosition(position);
        setAllWheelMode(DcMotor.RunMode.RUN_TO_POSITION);
        setAllWheelZeroPower();
        setAllWheelPower(power);
    }
}

