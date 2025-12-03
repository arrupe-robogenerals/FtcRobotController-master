package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;


@Autonomous(name="simpleBAuto", group="Auto")
public class simpleBAuto_Otos extends LinearOpMode {

    SparkFunOTOS myOtos;
    MecanumWheelsDecode robot = new MecanumWheelsDecode();
    SparkFunOTOS.Pose2D pos = myOtos.getPosition(); // get position from the spark fun sensor
    double ypostion = pos.y; // Variable for the position
    double xposition = pos.x; //Variable for the x position
    @Override

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;
        myOtos = hardwareMap.get(SparkFunOTOS .class, "sensor_otos");

        robot.init(hardwareMap);

        waitForStart();
        while (xposition > -36){
            robot.DriveForward(-0.5); // drives backwards until robot is 36 in from obilisk
        }

        robot.launcher.setPower(-0.67);



        sleep(700);

        robot.launcher.setPower(-0.62);



        robot.Gate.setPosition(0.5);

        sleep(16000);

        robot.DriftLeft(0.30);
        sleep(1000);
        robot.DriftLeft(0);

    }
}

/*

change the code to move back and then launch with servo opening three times
code three things

 */
