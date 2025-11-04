package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Disabled
// MAKE THIS FILE A PUBLIC METHOD TO CALL INTO AUTO AND TELEOP
public class ColorSensorHelper{

	private final ColorSensor colorSensor;
	public ColorSensorHelper(ColorSensor sensor){
		this.colorSensor = sensor;
	}

	// method to read the hsv values
	public float[] getHSV() {
		int red = colorSensor.red();
		int green = colorSensor.green();
		int blue = colorSensor.blue();

		return RGBtoHSV(red, green, blue);
	}
	 // detects that the color is purple
	public boolean isPurple() {
		float[] hsv = getHSV();
		return (hsv[0] < 270 && hsv[0] > 250);
	}

	 // Method to convert RGB to HSV
	 private float[] RGBtoHSV(int red, int green, int blue) {
		  // Normalize the RGB values to be between 0 and 1
		  float r = red / 255.0f;
		  float g = green / 255.0f;
		  float b = blue / 255.0f;

		  // Find the min and max RGB values
		  float min = Math.min(r, Math.min(g, b));
		  float max = Math.max(r, Math.max(g, b));
		  float delta = max - min;

		  // Calculate the Hue (H)
		  float hue = 0;
		  if (delta != 0) {
				if (max == r) {
					 hue = (g - b) / delta;
				} else if (max == g) {
					 hue = 2 + (b - r) / delta;
				} else {
					 hue = 4 + (r - g) / delta;
				}
		  }

		  // Adjust Hue to be in the range [0, 360]
		  hue = hue * 60;
		  if (hue < 0) {
				hue += 360;
		  }

		  // Calculate the Saturation (S)
		  float saturation = 0;
		  if (max != 0) {
				saturation = delta / max;
		  }

		  // The Value (V) is the max RGB value
		  float value = max;

		  // Return the HSV values as an array
		  return new float[]{hue, saturation, value};
	 }
}

/*
* public void runOpMode() {
		  // Get the color sensor from hardwareMap
		  color = hardwareMap.get(ColorSensor.class, "Color");

		  // Wait for the Play button to be pressed
		  waitForStart();

		  // While the Op Mode is running, update the telemetry values.
		  while (opModeIsActive()) {
				// Get the RGB values from the color sensor
				int red = color.red();
				int green = color.green();
				int blue = color.blue();

				// Convert RGB to HSV
				float[] hsvValues = RGBtoHSV(red, green, blue);

				// Add telemetry data for RGB and HSV values
				telemetry.addData("Red", red);
				telemetry.addData("Green", green);
				telemetry.addData("Blue", blue);
				telemetry.addData("Hue", hsvValues[0]);
				telemetry.addData("Saturation", hsvValues[1]);
				telemetry.addData("Value", hsvValues[2]);
				// telemetry.update();

				if(hsvValues[0] < 270 && hsvValues[0] > 250){
					telemetry.addData("Purple", "True");
				}
				else {
					telemetry.addData("Purple", "False");
				}

				telemetry.update();
		  }
	 }*/