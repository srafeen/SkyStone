package org.firstinspires.ftc.teamcode.TestBench;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ArmTeleOp", group = "TeleOp")
public class ArmDDTest extends LinearOpMode {

    //object declaration
    DcMotor armMotor = null;
    //Gamepad gamepad1;
    int armLevel = 0;
    int initialTargetPosition=128;

    @Override
    public void runOpMode() throws InterruptedException {

        //when init is pressed
        armMotor = hardwareMap.dcMotor.get("armMotor");

        //armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //At rest Telemetry
        //getting arm encoder values for different level
        telemetry.addData("encider vakue at armposition 0:",armMotor.getCurrentPosition());


        waitForStart();

        //start is pressed
        while (opModeIsActive()) {

            armLevel = initialTargetPosition;

            telemetry.addData("encider vakue at armposition 0:",armMotor.getCurrentPosition());


            if (gamepad1.left_bumper) {

                armLevel = armLevel -10 ;

                armMotor.setTargetPosition(armLevel);
                //armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                armMotor.setPower(-1);
                sleep(2000);
                telemetry.addData("encider vakue at armposition 0:",armMotor.getCurrentPosition());



            }
            if (gamepad1.right_bumper){

                armLevel = armLevel + 10;
                armMotor.setTargetPosition(armLevel);
                //armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                armMotor.setPower(1);
                sleep(2000);
                telemetry.addData("encider vakue at armposition 0:",armMotor.getCurrentPosition());


            }

            telemetry.update();

        }

    }

}
