package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

// import com.qualcomm.robotcore.ColorSensor.colorSensor
@TeleOp

public class OpModeTwo extends LinearOpMode {
    //Using
    MecanumWheelsDecode robot = new MecanumWheelsDecode();
//    ColorSensorHelper colorHelper;
//    boolean lastButton = false;
//    boolean isUp = false;

    @Override

    public void runOpMode() {
        robot.init(hardwareMap);

        final double COUNTS_PER_REV = 28; // changes from 537. to 28 for the 6,000 rpm motor

        int lastPosition = robot.launcher.getCurrentPosition();
        ElapsedTime timer = new ElapsedTime();


//         ColorSensor colorSensor = hardwareMap.get(ColorSensor.class, "Color");
//        colorHelper = new ColorSensorHelper(colorSensor);
        waitForStart();

        while (opModeIsActive()) {

            float rightJoyInputY;
            float rightTrigger;
            float leftTrigger;
            float leftJoyInputY;
            float leftJoyInputYT;
            float leftTrig;

            leftJoyInputY = -gamepad1.left_stick_y;
            rightJoyInputY = -gamepad1.right_stick_y;
            rightTrigger = gamepad1.right_trigger;
            leftTrigger = gamepad1.left_trigger;
            leftJoyInputYT = gamepad2.left_stick_y;
            leftTrig = gamepad2.left_trigger;

            telemetry.update();

            double speed = 0.0;
            boolean launcherOn = false;

            boolean lastA = false;
            boolean lastB = false;

            boolean rightBumper = gamepad1.right_bumper;
            boolean leftBumper = gamepad1.left_bumper;

                 /*
                    boolean dpad_down = gamepad1.dpad_up; // inverted code !!Keep!!
                    boolean dpad_up = gamepad1.dpad_down; // inverted code !!Keep!!
                    boolean dpad_right = gamepad1.dpad_left; // also inverted code !Keep!
                    boolean dpad_left = gamepad1.dpad_right; // also inverted code !keep!
                 */

            // rpm equation code

            int currentPosition = robot.launcher.getCurrentPosition();
            double deltaTime = timer.seconds();
            double deltaCounts = currentPosition - lastPosition;
            double motorExvel =robot.launcher.getVelocity();// robot tell us the velocity of the launcher



            double rpm = (deltaCounts / COUNTS_PER_REV) / deltaTime * 60.0;
            double rpmex = (motorExvel / COUNTS_PER_REV)*60 ; // coverting from ticks to rotation

            telemetry.addData("Launcher RPM", rpm);
            telemetry.addData("rpmEx",rpmex);// display rpmex on the drive hub


            telemetry.addData("A_Button", gamepad1.a);
            telemetry.addData("X_Button", gamepad1.x);
            telemetry.addData("Y_Button", gamepad1.y);
            telemetry.addData("B_Button", gamepad1.b);
            telemetry.update();
//                    lastPosition = currentPosition;
            timer.reset();

            //moving robot
            if (rightBumper) // drifting
            {
                robot.DriftRight(0.6);
            } else if (leftBumper) // drifting
            {
                robot.DriftLeft(0.6);
            } else if (rightTrigger > 0) // turning
            {
                robot.TurnRight(0.5);
            } else if (leftTrigger > 0)// turning
            {
                robot.TurnLeft(0.5);
            }
            else if (0 != leftJoyInputY) // driving
            {
                robot.DriveForward(leftJoyInputY);
            }
            else{
                robot.DriveForward(0);
            }

            if (leftTrig > 0){
                robot.intake.setPower(0.85);
            }
            else{
                robot.intake.setPower(0.0);
            }

            if (gamepad2.a && !lastA) {
                launcherOn = true;
                speed = -0.1;
            }

// Button B: STEP speed down by -0.1 (each press)
            if (gamepad2.b && !lastB && launcherOn) {
                speed -= 0.1;
                speed = Math.max(speed, -1.0);
            }

// Apply power based on state, NOT button hold
            if (launcherOn) {
                robot.LauncherPower(speed);
            }
// Save previous states for edge detection
            lastA = gamepad2.a;
            lastB = gamepad2.b;




            // lock in position for gate
            if (gamepad2.dpad_down){
                robot.Gate.setPosition(0.1);
            }
            else if (gamepad2.dpad_up){
                robot.Gate.setPosition(0.8);
            }
            else {
                robot.Gate.setPosition(0.5);
            }

        }//end while loop
    } //end public void
} //end public class

