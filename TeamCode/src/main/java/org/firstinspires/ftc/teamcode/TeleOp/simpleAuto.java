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

        robot.DriveForward(-0.5);
        sleep(500); // make seconds longer and organize speed runs for launcher
        robot.launcher.setPower(-0.7);
        robot.Gate.setPosition(1);
        robot.launcher.setPower(-0.7);
        robot.Gate.setPosition(0);
        robot.launcher.setPower(0);

    }
}

/*

change the code to move back and then launch with servo opening three times
code three things

 */
