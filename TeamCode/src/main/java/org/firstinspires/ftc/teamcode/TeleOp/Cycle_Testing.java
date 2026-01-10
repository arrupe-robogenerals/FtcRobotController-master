package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;

//@Disabled
@Autonomous(name="Test Cycle", group="Auto")
public class Cycle_Testing extends LinearOpMode {
    MecanumWheelsDecode robot = new MecanumWheelsDecode();

    @Override

    public void runOpMode() {
        // ppg

        robot.init(hardwareMap);

        waitForStart();

        robot.Gate.setPosition(0.1); // open the gate so then we can cycle tothe next ball

        sleep(600); // wait 400 mil sec  before cycle

        robot.intake.setPower(0.0); //cycle  the next ball

        sleep(870);

        robot.intake.setPower(0); // stop cycling

        robot.Gate.setPosition(0.5); //  reset gate

        sleep(500);


//        robot.Gate.setPosition(0.8); // pushed the 1st ball  up into the launcher

        sleep(2000);

        robot.Gate.setPosition(0.5); // reset gate

        sleep(1000);

        robot.intake.setPower(0.85); //cycle  the next ball

        sleep(400);

        robot.intake.setPower(0); // after 400 mil secs stop cycle

        sleep(2000); // wait before launching

//        robot.Gate.setPosition(0.8); // pushed the 2nd ball up into the launcher

        sleep(1000);

        robot.intake.setPower(0.70); //cycle  the next 3rd ball

        sleep(400);

        robot.intake.setPower(0); // after 400 mil secs stop cycle

        sleep(2000); // wait before launching

        robot.Gate.setPosition(0.8); // pushed the 3rd ball up into the launcher


        robot.Gate.setPosition(0.5);
        robot.Gate.setPosition(0.8);
        robot.Gate.setPosition(0.5);

        sleep(2000);


// this cycle
/*
        //pgp

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

// this cycle GPP
        robot.Gate.setPosition(0.1); // open the gate so then we can cycle to the next ball

        sleep(400); // wait 400 mil sec  before cycle

        robot.intake.setPower(0.8); //cycle  the next ball

        sleep(400);

        robot.intake.setPower(0); // stop cycling

        robot.Gate.setPosition(0.5); //  reset gate

        sleep(500);


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

*/
    }
}