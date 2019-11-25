package org.firstinspires.ftc.teamcode.RobotGame;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "SkyStoneTeleOp", group = "TeleOp")


public class SkyStoneTeleOp extends LinearOpMode {

    HardwareMap myRobotHardwareMap;
    Gamepad myGamePad;

    @Override
    public void runOpMode() throws InterruptedException {

        //when init is pressed

        initSystem();
        createRobotSystem();


    }

    public void initSystem(){

        myRobotHardwareMap = super.hardwareMap;
        myGamePad = super.gamepad1;

    }

    public void createRobotSystem(){

        //create controller object

        //create Chasis object

        //create Hook object

        //Create Intake object

        //Create Arm object

    }
}
