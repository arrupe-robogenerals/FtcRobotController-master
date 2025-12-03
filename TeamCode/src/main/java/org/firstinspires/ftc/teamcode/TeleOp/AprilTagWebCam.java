package org.firstinspires.ftc.teamcode.TeleOp;

import android.appwidget.AppWidgetProviderInfo;
import android.graphics.Canvas;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.opencv.core.Mat;

import java.util.ArrayList;


public class AprilTagWebcam {

    private AprilTagProcessor aprilTagProcessor;
    private VisionPortal visionPortal;
    private List<AprilTagDetection> detectedTags = new ArrayList<>;
    private Telemetry telemetry;

    public void init(HardwareMap hwMap, Telemetry telemetry){
        this.telemetry = telemetry;

        aprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setOutputUnits(DistanceUnit.CM, AngleUnit.Degrees)
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(hwMap.get(WebcamName.class, "Webcam"));
        builder.setCameraResolution(new Size(640, 480));
        builder.addProcessor(aprilTagProcessor);

        visionPortal = builder.build();
    }
    public void update() {
        detectedTags = aprilTagProcessor.getDetections();
    }
    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags;
    }
    public AprilTagDetection getTagSpecificId(int id){
        for(AprilTagDetection detection : detectedTags){
            if (detected.id == id){
                return detection;
            }
            return null;
        }
        public void stop() {
            if (visionPortal != null){
                visionPortal.close();
            }
        }




    }