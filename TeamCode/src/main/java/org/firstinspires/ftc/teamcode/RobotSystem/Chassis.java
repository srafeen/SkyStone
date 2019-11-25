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
                setAllWheelRunToPosition();
                break;

            case RUN_USING_ENCODER:
                setAllWheelRunUsingEncoder();
                break;

            case RUN_WITHOUT_ENCODER:
                setAllWheelRunWithoutEncoder();
                break;

            case STOP_AND_RESET_ENCODER:
                setAllWheelStopResetEncoder();
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
        setAllWheelStopResetEncoder();

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

    //function to set the mode of all wheels to RUN_TO_POSITION
    public void setAllWheelRunToPosition(){

        front_left_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //function to set the mode for all wheels to RUN_USING_ENCODER
    public void setAllWheelRunUsingEncoder(){

        front_left_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_right_wheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //function to set the mode for all wheels to RUN_WITHOUT_ENCODER
    public void setAllWheelRunWithoutEncoder(){

        front_left_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        front_right_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        back_left_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        back_right_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    //function to set the mode for all wheels to STOP_AND_RESET_ENCODER
    public void setAllWheelStopResetEncoder(){

        front_left_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    //functions for moving the wheel drive

    public void robotMove(int position){

        setAllWheelDirection(DcMotor.Direction.FORWARD);
        setAllWheelTargetPosition(position);
        setAllWheelRunToPosition();

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

    }
}

