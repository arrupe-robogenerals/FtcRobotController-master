package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//@Disabled
@Autonomous(name="cycle_1_turn_shot_B", group="Auto")
public class cycle_1_turn_shot extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    public void runOpMode() {
//        Object robotDrive = robot.DriveForward;

        robot.init(hardwareMap);

        waitForStart();

        robot.Gate.setPosition(0.1); // open the gate so then we can cycle to the next ball

        sleep(400); // wait 400 mil sec  before cycle

        robot.intake.setPower(0.8); //cycle  the next ball

        sleep(400);

        robot.intake.setPower(0); // stop cycling

        robot.Gate.setPosition(0.5); //  reset gate

        sleep(500);

        robot.launcher.setPower(-0.85); // set power  of the launcher

        robot.TurnLeft(0.5); // turn  left

       sleep(550);

       robot.TurnLeft(0); // stop the robot

       sleep(1200) ;  // to let speed go up of the launcher

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

        robot.DriftLeft(0.30);
        sleep(2000);
        robot.DriftLeft(0);








        robot.launcher.setPower(-0.62);

        robot.DriveForward(0);

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
