package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//@Disabled
@Autonomous(name="simpleAuto", group="Auto")
public class simpleAuto extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();

        robot.DriveForward(1);
        sleep(500);
        robot.DriveForward(0);
//        sleep(500);ftrvgfvv

//        robot.TurnRight(1);
//        sleep(500);
//        robot.TurnRight(0);

        robot.Gate.setPosition(1);
        sleep(1000);
        robot.Gate.setPosition(0);

        robot.launcher.setPower(-1);
        sleep(2000);
        robot.launcher.setPower(0);

    }
}

/*

 */