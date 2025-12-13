package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//@Disabled
@Autonomous(name="autoScoreB", group="Auto")
public class autoScoreB extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    // 1000 milliseconds = 1 second

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();



    }
}

/*

change the code to move back and then launch with servo opening three times
code three things

 */

/*

    robot.intake.setPower(0.7);

        sleep(1000);

        robot.intake.setPower(0.0);

        robot.launcher.setPower(0.0);

        robot.launcher.setPower(-0.67);

        robot.DriveForward(-0.5);

        sleep(700);

        robot.launcher.setPower(-0.62);

        robot.DriveForward(0);

        robot.Gate.setPosition(0.5);

        sleep(16000);

        robot.DriftLeft(0.30);
        sleep(1000);
        robot.DriftLeft(0);
 */