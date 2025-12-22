package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@Autonomous(name = "April Tag Selection", group = "Auto")
public class aprilTagAutoSelection extends LinearOpMode {

    MecanumWheelsDecode robot = new MecanumWheelsDecode();
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTag;

    // Change these IDs to match your field setup
    private static final int TAG_GPP = 21;
    private static final int TAG_PPG = 23;
    private static final int TAG_PGP = 22;

    private int selectedTag = -1;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        initAprilTag();

        waitForStart();

        robot.DriveForward(-0.5); // drive backward for 1.4 secs

        sleep(1400);

        robot.DriveForward(0); // stop the robot

        sleep(1200) ;  // to let speed settle

        robot.TurnRight(0.2); // turn right for 1.7 seconds
        sleep(1700);
        robot.TurnRight(0);

        while (opModeIsActive()
                && visionPortal.getCameraState() != VisionPortal.CameraState.STREAMING) {

            telemetry.addLine("Waiting for camera...");
            telemetry.update();
        }

        long scanStartTime = System.currentTimeMillis();
        long scanTimeoutMs = 2000; // 2 seconds max

        while (opModeIsActive()
                && selectedTag == -1
                && System.currentTimeMillis() - scanStartTime < scanTimeoutMs) {

            List<AprilTagDetection> detections = aprilTag.getDetections();

            telemetry.addData("Detections", detections.size());

            for (AprilTagDetection detection : detections) {
                selectedTag = detection.id;
                telemetry.addData("Tag Found", selectedTag);

                int id = detection.id;

                if (id == TAG_GPP) {
                    selectedTag = TAG_GPP;
                    break;
                }
                else if (id == TAG_PPG) {
                    selectedTag = TAG_PPG;
                    break;
                }
                else if (id == TAG_PGP) {
                    selectedTag = TAG_PGP;
                    break;
                }

                break;
            }

            telemetry.update();
        }

        visionPortal.stopStreaming();

        telemetry.addData("Final Tag", selectedTag);
        telemetry.update();

        if (selectedTag == TAG_GPP) {
            runGPP();
        }
        else if (selectedTag == TAG_PPG) {
            runPPG();
        }
        else if (selectedTag == TAG_PGP) {
            runPGP();
        }
        else {
            runDefault();
        }

        visionPortal.close();
    }

    // ---------------- METHODS ----------------

    private void initAprilTag() {
        aprilTag = new AprilTagProcessor.Builder()
                .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                .build();

        visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(aprilTag)
                .build();
    }

    private void runGPP() {
        telemetry.addLine("RUNNING GPP AUTO");
        telemetry.update();

        robot.DriveForward(1.0);
        sleep(1000);
        robot.DriveForward(0.0);
        // TODO: Add movement code here
        sleep(2000);
    }

    private void runPPG() {
        telemetry.addLine("RUNNING PPG AUTO");
        telemetry.update();

        robot.DriftLeft(1.0);
        sleep(1000);
        robot.DriftLeft(0.0);

        // TODO: Add movement code here
        sleep(2000);
    }

    private void runPGP() {
        telemetry.addLine("RUNNING PGP AUTO");
        telemetry.update();

        robot.TurnRight(1.0);
        sleep(1000);
        robot.TurnRight(0.0);

        // TODO: Add movement code here
        sleep(2000);
    }

    private void runDefault() {
        telemetry.addLine("NO TAG FOUND - DEFAULT AUTO");
        telemetry.update();

        // TODO: Safe fallback path
        sleep(2000);
    }

}