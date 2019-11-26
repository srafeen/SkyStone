package org.firstinspires.ftc.teamcode.TestBench;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.RobotSystem.FrontBumper;


@TeleOp(name = "TestTouchSensor",group = "TeleOp")
public class TestTouchSensor extends LinearOpMode {

    HardwareMap myRobotHardwareMap;
    Gamepad myGamePad;

    FrontBumper hazmatFrontSensor;

    boolean robotRun;
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


            if (hazmatFrontSensor.isBumperPressed()){

                telemetry.addData("Bumper status = ", "bumper pressed");

            }
            else{

                telemetry.addData("Bumper status = ", "bumper not pressed");
            }

            telemetry.update();



        }

    }

    public void initSystemVariables(){

        myRobotHardwareMap = super.hardwareMap;
        myGamePad = super.gamepad1;
        robotRun=true;
        telemetry.setAutoClear(false);

    }

    public void initSystem(){

    }

    public void createRobotSystem(){

        //create controller object

        //create Chassis object


        //create Hook object

        //Create Intake object

        //Create Arm object

        //create TouchSensor
        hazmatFrontSensor = new FrontBumper(myRobotHardwareMap);


    }
}
