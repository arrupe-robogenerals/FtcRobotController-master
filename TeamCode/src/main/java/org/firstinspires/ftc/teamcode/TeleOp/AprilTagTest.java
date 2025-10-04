//package org.firstinspires.ftc.teamcode.TeleOp;
//
//import com.qualcomm.hardware.limelightvision.LLResult;
//import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.vision.VisionPortal;
//
//public class AprilTagTest extends OpModeDecode {
//
//    private WebCam webecam;
//
//    prive IMU imu;
//    @Override
//    public void init() {
//        webcam = hardwareMap.get((WebcamName.class, "Webcam 1");
//        webecam.pipelineswitch(8); // april tag #11 pipeline
//        imu = hardwareMap.get(IMU.class, "imu");
//        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
//                RevHubOrientationOnRobot.UsbFacingDirection.Forward);
//    }
//
//    @Override
//    public void start() {
//        webecam.start();
//
//    }
//
//
//    @Override
//    public void loop() {
//        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
//        webcam.updateRobotOrientation(orientation.getYaw());
//
//    }
//
//}
