package org.firstinspires.ftc.teamcode.RobotSystem;


import com.qualcomm.robotcore.hardware.Gamepad;

public class Controller {

    Gamepad gamePadController;

    public Controller() {
    }

    public Controller(Gamepad myGamePad){

        gamePadController = myGamePad;

    }


    //function to return power for wheels
    public double getPower(){

        double wheelPower = 0;

        wheelPower = gamePadController.left_stick_x;

        return wheelPower;

    }


}
