package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@Autonomous(name = "April Tag Chosen Blue Side", group = "Auto")
public class AprilTagChosen_Blue extends LinearOpMode {

    MecanumWheelsDecode robot = new MecanumWheelsDecode();
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTag;

    // Change these IDs to match your field setup
    private static final int TAG_GPP = 21;
    private static final int TAG_PPG = 23;
    private static final int TAG_PGP = 22;
    private static final int blue_tag = 20;

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
                else if (id == blue_tag) {
                    selectedTag = blue_tag;
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

        // TODO: Add movement code here
        robot.Gate.setPosition(0.1); // open the gate so then we can cycle to the next ball

        sleep(400); // wait 400 mil sec  before cycle

        robot.intake.setPower(0.8); //cycle  the next ball

        sleep(400);

        robot.intake.setPower(0); // stop cycling

        robot.Gate.setPosition(0.5); //  reset gate

        sleep(500);

        robot.launcher.setPower(-0.85); // set power  of the launcher

        robot.TurnLeft(0.5); // turn  left

        sleep(730);

        robot.TurnLeft(0); // stop the robot

        sleep(2500);  // to let speed go up of the launcher

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

        sleep(1600);

        robot.DriftLeft(0.30);
        sleep(1000);
        robot.DriftLeft(0);
        sleep(2000);
    }

    private void runPPG() {
        telemetry.addLine("RUNNING PPG AUTO");
        telemetry.update();

        robot.Gate.setPosition(0.1); // open the gate so then we can cycle tothe next ball

        sleep(600); // wait 400 mil sec  before cycle

        robot.intake.setPower(0.70); //cycle  the next ball

        sleep(1000);

        robot.intake.setPower(0); // stop cycling

        robot.Gate.setPosition(0.5); //  reset gate

        sleep(800);

        robot.launcher.setPower(-0.85); // set power  of the launcher

        robot.TurnLeft(0.5); // turn  left

        sleep(730);

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
        /*
        robot.DriftLeft(0.30);
        sleep(2000);
        robot.DriftLeft(0);
        */
        // TODO: Add movement code here
        sleep(2000);

        // code start - turnleft to pickup artifacts
        robot.TurnLeft(0.3);
        sleep(800);
        robot.TurnLeft(0.0);

        robot.DriftLeft(0.2);
        sleep(300);
        robot.DriftLeft(0.0);

        robot.DriveForward(0.3);
        sleep(800);
        robot.intaker.setPower(1);
        sleep(1000);
        robot.DriveForward(0);
        sleep(300);
        robot.intake.setPower(0.85); //cycle  the next ball
        sleep(520);

        // code stop    - robot movement stops with three artiifacts in the rocktumbler

    }

    private void runPGP() {
        telemetry.addLine("RUNNING PGP AUTO");
        telemetry.update();

        robot.launcher.setPower(-0.85); // set power  of the launcher

        robot.TurnLeft(0.5); // turn  left

        sleep(600);

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
        sleep(2000);

    }
    private void runDefault() {
        telemetry.addLine("NO TAG FOUND - DEFAULT AUTO PGP");
        telemetry.update();

        robot.launcher.setPower(-0.85); // set power  of the launcher

        robot.TurnLeft(0.5); // turn  left

        sleep(600);

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
        sleep(2000);
    }

}