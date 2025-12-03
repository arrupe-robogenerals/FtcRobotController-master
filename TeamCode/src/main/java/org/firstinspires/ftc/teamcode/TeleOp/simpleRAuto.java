package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//@Disabled
@Autonomous(name="simpleRAuto", group="Auto")
public class simpleRAuto extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();

        robot.launcher.setPower(-0.67);

        robot.DriveForward(-0.5);

        sleep(700);

        robot.launcher.setPower(-0.62);

        robot.DriveForward(0);

        robot.Gate.setPosition(0.5);

        sleep(16000);

        robot.DriftRight(0.30);
        sleep(1000);
        robot.DriftRight(0);

    }
}

/*

change the code to move back and then launch with servo opening three times
code three things

 */
