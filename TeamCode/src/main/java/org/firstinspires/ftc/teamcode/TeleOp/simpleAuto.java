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

//        robot.DriveForward(1);
//        sleep(500);
//        robot.DriveForward(0);
//        sleep(500);

        robot.launcher.setPower(1);
        sleep(100);
        robot.Gate.setPosition(1);
        robot.launcher.setPower(1);
        sleep(100);
        robot.launcher.setPower(0);


//        robot.launcher.setPower(1);


    }
}
