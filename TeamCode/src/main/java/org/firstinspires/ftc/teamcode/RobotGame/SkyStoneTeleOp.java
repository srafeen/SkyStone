package org.firstinspires.ftc.teamcode.RobotGame;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotSystem.Chassis;
import org.firstinspires.ftc.teamcode.RobotSystem.Controller;

@TeleOp(name = "SkyStoneTeleOp", group = "TeleOp")


public class SkyStoneTeleOp extends LinearOpMode {

    HardwareMap myRobotHardwareMap;
    Gamepad myGamePad;

    boolean atHome = true;
    boolean gamepadPressed = false;

    double drivePower =0;
    int targetDistance = 0;

    //Robot hardware objects
    Controller myController;
    Chassis myChasis;

    @Override
    public void runOpMode() throws InterruptedException {

        //when init is pressed

        initSystemVariables();
        createRobotSystem();
        telemetry.addData("Robot state:","Initialised and Ready for start");

        //waiting for start press
        waitForStart();

        //game begins
        while (opModeIsActive()){

            //if at base and joystick is moved
            drivePower = myController.getPower();
            myChasis.robotMove(targetDistance,drivePower);


        }


    }

    public void initSystemVariables(){

        myRobotHardwareMap = super.hardwareMap;
        myGamePad = super.gamepad1;

        drivePower = 0;
        targetDistance = 0;

    }

    public void initSystem(){

    }

    public void createRobotSystem(){

        //create controller object
        myController = new Controller(myGamePad);
        //create Chassis object
        myChasis = new Chassis(myRobotHardwareMap);

        //create Hook object

        //Create Intake object

        //Create Arm object

    }
}
