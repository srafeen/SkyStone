package org.firstinspires.ftc.teamcode.RobotSystem;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ColorDetector {

    HardwareMap myHarwadreMap;
    ColorSensor myColorSensor;

    public ColorDetector(HardwareMap myRobotConfiguration) {

        myHarwadreMap = myRobotConfiguration;
        myColorSensor = myHarwadreMap.colorSensor.get("color_sensor");
    }


    public void setLEDMode(boolean mode){



    }
}
