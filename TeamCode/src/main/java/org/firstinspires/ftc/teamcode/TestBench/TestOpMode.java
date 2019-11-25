package org.firstinspires.ftc.teamcode.TestBench;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotSystem.Chassis;
import org.firstinspires.ftc.teamcode.RobotSystem.Controller;

public class TestOpMode extends LinearOpMode {

    HardwareMap myRobotHardwareMap;
    Gamepad myGamePad;
    @Override
    public void runOpMode() throws InterruptedException {

        //when init is pressed
        initSystemVariables();
        initSystem();
        createRobotSystem();

        //waiting for start press
        waitForStart();

        //when start is pressed until stop is pressed
        while (opModeIsActive()){


        }

    }

    public void initSystemVariables(){

        myRobotHardwareMap = super.hardwareMap;
        myGamePad = super.gamepad1;

     }

    public void initSystem(){

    }

    public void createRobotSystem(){

        //create controller object

        //create Chassis object


        //create Hook object

        //Create Intake object

        //Create Arm object

    }
}
