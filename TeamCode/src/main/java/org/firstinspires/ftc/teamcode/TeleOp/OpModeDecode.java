package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

// import com.qualcomm.robotcore.ColorSensor.colorSensor
@TeleOp

public class OpModeDecode extends LinearOpMode {
//Using
    MecanumWheelsDecode robot = new MecanumWheelsDecode();
//    ColorSensorHelper colorHelper;
//    boolean lastButton = false;
//    boolean isUp = false;

    @Override

    public void runOpMode() {
        robot.init(hardwareMap);

        final double COUNTS_PER_REV = 537.7;

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

                    leftJoyInputY = -gamepad1.left_stick_y;
                    rightJoyInputY = -gamepad1.right_stick_y;
                    rightTrigger = gamepad1.right_trigger;
                    leftTrigger = gamepad1.left_trigger;
                    leftJoyInputYT = gamepad2.left_stick_y;

                    telemetry.update();

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

                    double rpm = (deltaCounts / COUNTS_PER_REV) / deltaTime * 60.0;

                    telemetry.addData("Launcher RPM", rpm);
                    telemetry.update();
                    lastPosition = currentPosition;
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
                    if (gamepad2.dpad_right){
                        robot.intake.setPower(-0.85);
                    }
                    else if (gamepad2.dpad_left){
                        robot.intake.setPower(0.85);
                    }
                    else{
                        robot.intake.setPower(0.0);
                    }


                    if (gamepad2.b)
                        robot.LauncherPower(-0.95);
                    else if (gamepad2.y)
                        robot.LauncherPower(-0.9);
                    else if (gamepad2.x)
                        robot.LauncherPower(-0.8);
                    else if (gamepad2.a)
                        robot.LauncherPower(-0.7);
                    else{
                        robot.LauncherPower(0);
                    }

                    if (gamepad2.dpad_down){
                        robot.Gate.setPosition(0.5);
                    }
                    else {
                        robot.Gate.setPosition(0.2);
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

 /*
    if(colorHelper.isPurple()){
        telemetry.addData("Detected Color: ", "Puprle");
    }
    else{
        telemetry.addData("Detected Color: ", "Green");
    }
*/

/*
else if (0 != leftJoyInputYT) {
robot.Gate.setPosition(1);
}
else {
robot.LauncherPower(0);
robot.DriveForward(0);
robot.Gate.setPosition(0);
                    }*/