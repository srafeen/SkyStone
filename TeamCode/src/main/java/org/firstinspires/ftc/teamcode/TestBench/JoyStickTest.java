package org.firstinspires.ftc.teamcode.TestBench;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "JoyStickTest", group = "Testing")
public class JoyStickTest extends LinearOpMode {

    HardwareMap myRobotHardwareMap;
    Gamepad myGamePad;

    float leftjoystick_x_value = 0;
    float leftjoystick_y_value = 0;
    float rightjoystick_x_value = 0;
    float rightjoystick_y_value = 0;


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

            leftjoystick_x_value = myGamePad.left_stick_x;
            leftjoystick_y_value = myGamePad.left_stick_y;

            telemetry.addData("left joystick X = ",  leftjoystick_x_value);
            telemetry.addData("left joystick Y = ", leftjoystick_y_value);
            telemetry.update();


        }


    }

    public void initSystemVariables(){

        myRobotHardwareMap = hardwareMap;
        myGamePad = gamepad1;

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
