package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;


@TeleOp

public class OpModeDecode extends LinearOpMode {
//Using
    MecanumWheelsDecode robot = new MecanumWheelsDecode();
    ColorSensorHelper colorHelper;

    boolean lastButton = false;
    boolean isUp = false;

@Override

    public void runOpMode() {

        robot.init(hardwareMap);
        ColorSensor colorSensor = hardwareMap.get(ColorSensor.class, "Color");
        colorHelper = new ColorSensorHelper(colorSensor);
        waitForStart();

            while (opModeIsActive()) {

                boolean currentButton = gamepad1.x;

                float rightJoyInputX;
                float leftJoyInputY;
                float rightJoyInputY;
                float rightTrigger;
                float leftTrigger;

                rightJoyInputY = -gamepad1.right_stick_y;
                rightJoyInputX = -gamepad1.right_stick_x;
                leftJoyInputY = -gamepad1.left_stick_y;
                // leftJoyInputX = -gamepad1.left_stick_x; not declared in the float
                rightTrigger = gamepad1.right_trigger;
                leftTrigger = gamepad1.left_trigger;


                telemetry.update();


                boolean rightBumper = gamepad1.right_bumper;
                boolean leftBumper = gamepad1.left_bumper;
                boolean dpad_down = gamepad1.dpad_up; // inverted code !!Keep!!
                boolean dpad_up = gamepad1.dpad_down; // inverted code !!Keep!!
                boolean dpad_right = gamepad1.dpad_left; // also inverted code !Keep!
                boolean dpad_left = gamepad1.dpad_right; // also inverted code !keep!


                //moving robot
                if (rightBumper) // drifting
                {
                    robot.DriftRight(1);
                } else if (leftBumper) // drifting
                {
                    robot.DriftLeft(1);
                } else if (rightTrigger > 0) // turning
                {
                    robot.TurnRight(1);
                } else if (leftTrigger > 0)// turning
                {
                    robot.TurnLeft(1);
                } else {
                    robot.DriveForward(0);
                }
                if (0 != rightJoyInputY) // driving
                {
                    robot.DriveForward(rightJoyInputY);
                }

                }//end while loop
        } //end public void
} //end public class


/*
    telemetry.addData("A_Button", gamepad1.a);
    telemetry.addData("X_Button", gamepad1.x);
    telemetry.addData("Y_Button", gamepad1.y);
    telemetry.addData("B_Button", gamepad1.b);
    telemetry.addData("RightJoyY", rightJoyInputY);
    telemetry.addData("LeftJoyY", leftJoyInputY);
    telemetry.addData("RightJoyX",rightJoyInputX);
    telemetry.addData("Front Left", robot.leftDriveFront.getCurrentPosition());
    telemetry.addData("Front Right", robot.rightDriveFront.getCurrentPosition());
    telemetry.addData("Back Left", robot.leftDriveBack.getCurrentPosition());
    telemetry.addData("Back Right", robot.rightDriveBack.getCurrentPosition());
    telemetry.addData("Dpad Down", gamepad1.dpad_down);
    telemetry.addData("Dpad Up", gamepad1.dpad_up);
    telemetry.addData("Dpad Right", gamepad1.dpad_right);
    telemetry.addData("Dpad Left", gamepad1.dpad_left);
    telemetry.addData("Right Bumper", gamepad1.right_bumper);
    telemetry.addData("Left Bumper", gamepad1.left_bumper);
    telemetry.addData("Right Trigger", rightTrigger);
    telemetry.addData("Left Trigger", leftTrigger);
*/