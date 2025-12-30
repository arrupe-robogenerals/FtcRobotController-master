package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@Disabled
@Autonomous(name="turn_and_shot_B", group="Auto")
public class turn_and_shot_B_R extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

//    @Override
    boolean blue = false;




    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();

        robot.launcher.setPower(-0.85); // set power  of the launcher

        if (blue = true) {
            robot.TurnLeft(0.5); // turn  left
        } else {
            robot.TurnRight(0.5); // turn right
        }


        sleep(550);

        robot.TurnLeft(0); // stop the robot

        robot.TurnRight(0); // stop the robot

        sleep(1200);  // to let speed go up of the launcher

        robot.Gate.setPosition(0.8); // pushed the 1st ball  up into the launcher

        sleep(2000);

        robot.Gate.setPosition(0.5); // reset gate

        sleep(1000);

        robot.intake.setPower(0.85); //cycle  the next ball

        sleep(400);

        robot.intake.setPower(0); // after 400 mil secs stop cycle

        sleep(2000); // wait before launching

        robot.Gate.setPosition(0.8); // pushed the 2nd ball up into the launcher

        sleep(2000);

        robot.Gate.setPosition(0.5); // reset gate

        sleep(1000);

        robot.intake.setPower(0.85); //cycle  the next 3rd ball

        sleep(400);

        robot.intake.setPower(0); // after 400 mil secs stop cycle

        sleep(2000); // wait before launching

        robot.Gate.setPosition(0.8); // pushed the 3rd ball up into the launcher

        sleep(2000);

        robot.Gate.setPosition(0.5);
        robot.Gate.setPosition(0.8);
        robot.Gate.setPosition(0.5);

        sleep(2000);

        if (blue = true) {
            robot.DriftLeft(0.30);// if its  blue then turn left



        } else {
            robot.DriftRight(0.30); // if  not blue then turn right

        }

        sleep(2000);
        robot.DriftRight(0);
        robot.DriftLeft(0);




        /*robot.launcher.setPower(-0.62);

        robot.DriveForward(0);

        robot.Gate.setPosition(0.5);

        sleep(16000);

        robot.DriftLeft(0.30);
        sleep(1000);
        robot.DriftLeft(0); */

    }

}

/*

change the code to move back and then launch with servo opening three times
code three things

 */
