package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;


//@Disabled
@Autonomous(name="LongScore Shooting", group="Auto")
public class LongScore extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();
        sleep (15000);

        robot.launcher.setPower(-.950); // set power  of the launcher

//        robot.TurnLeft(0.5); // turn  left
//
//        sleep(650);
//
//        robot.TurnLeft(0); // stop the robot

        sleep(1300) ;  // to let speed go up of the launcher

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

//        robot.DriftLeft(0.30);
//        sleep(2000);
//        robot.DriftLeft(0);
//        sleep(2000);
        robot.TurnLeft(0.3);
        sleep(500);
        robot.TurnLeft(0.0);
//
        robot.DriftLeft(-0.2);
        sleep(500);
        robot.DriftLeft(0.0);
//
        robot.intaker.setPower(1);
        robot.DriveForward(0.3);
        sleep(800);
        robot.intaker.setPower(1);
        sleep(1000);
        robot.DriveForward(0);
        sleep(300);
        robot.intake.setPower(0.85); //cycle  the next ball
        sleep(520);

    }
}

/*

change the code to move back and then launch with servo opening three times
code three things

 */
