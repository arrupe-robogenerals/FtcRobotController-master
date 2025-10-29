/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.TeleOp;

//import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a K9 robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:  "left_drive"
 * Motor channel:  Right drive motor:  "right_drive"
 * Servo channel:  Servo to raise/lower arm: "arm"
 * Servo channel:  Servo to open/close claw: "claw"
 *
 * Note: the configuration of the servos is such that:
 * As the arm servo approaches 0, the arm position moves up (away from the floor).
 * As the servo approaches 0, the claw opens up (drops the game element).
 */

 // global variable - updating negatives

public class MecanumWheelsDecode {

  /* Public OpMode members. */
  public DcMotor  leftDriveFront  = null;
  public DcMotor  rightDriveFront  = null;
  public DcMotor  leftDriveBack = null;
  public DcMotor  rightDriveBack  = null;

  public ColorSensor colorSensor = null;
 /*

  public DcMotor launcher = null

  public DcMotor waterWheel = null;

  public Servo Gate = null;

 */



  /* Local OpMode members. */

  HardwareMap hwMap = null;
  private ElapsedTime period = new ElapsedTime();

  //
//    // Encoder constants
    static final double COUNTS_PER_MOTOR_REV = 28;    // e.g. goBILDA 312RPM
    static final double DRIVE_GEAR_REDUCTION = 1.0;      // No external gearing
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // 4-inch mecanum wheels
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
  /* Constructor */
  public MecanumWheelsDecode() {
  }

  /* Initialize standard Hardware interfaces */
  public void init(HardwareMap ahwMap) {
    // save reference to HW Map
     hwMap = ahwMap;
//
       // Define and Initialize Motors
        leftDriveFront  = hwMap.get(DcMotor.class, "FrontLeft");
        rightDriveFront = hwMap.get(DcMotor.class, "FrontRight");
        leftDriveBack  = hwMap.get(DcMotor.class, "BackLeft");
        rightDriveBack = hwMap.get(DcMotor.class, "BackRight");

        colorSensor = hwMap.get(ColorSensor.class, "Color");

        /*


        */


        leftDriveFront.setDirection(DcMotor.Direction.REVERSE);
        leftDriveBack.setDirection(DcMotor.Direction.REVERSE);



        // Set all motors to zero power
        leftDriveFront.setPower(0);
        leftDriveBack.setPower(0);
        rightDriveFront.setPower(0);
        rightDriveBack.setPower(0);

        //armJointOne.setPower(0);


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDriveBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDriveBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //Define and initialize ALL installed servos.

    }

    void DriveForward(double x)
    {
        leftDriveBack.setPower(x);
        rightDriveBack.setPower(x);
        leftDriveFront.setPower(x);
        rightDriveFront.setPower(x);

    }
    void TurnRight(double x)
    {
        leftDriveBack.setPower(x);
        rightDriveBack.setPower(-x);
        leftDriveFront.setPower(x);
        rightDriveFront.setPower(-x);
    }
    void TurnLeft(double x)
    {
        leftDriveBack.setPower(-x);
        rightDriveBack.setPower(x);
        leftDriveFront.setPower(-x);
        rightDriveFront.setPower(x);
    }

    //DRIFTING
    void DriftRight(double x)
    {
        leftDriveBack.setPower(-x);
        rightDriveBack.setPower(x);
        leftDriveFront.setPower(x);
        rightDriveFront.setPower(-x);
    }
    void DriftLeft(double x)
    {
        leftDriveBack.setPower(x);
        rightDriveBack.setPower(-x);
        leftDriveFront.setPower(-x);
        rightDriveFront.setPower(x);

    }


  /*  static final double COUNTS_PER_REV = 537.7; // adjust to your motor spec

    public double getRPM(DcMotor motor) {
        int startPosition = motor.getCurrentPosition();
        sleep(100); // wait 0.1 second
        int newPosition = motor.getCurrentPosition();
        int delta = newPosition - startPosition;

        double revs = (double) delta / COUNTS_PER_REV;
        double rpm = (revs / 0.1) * 60; // since we waited 0.1 sec → multiply by 60/0.1 = 600
        return Math.abs(rpm);
    }
*/


  }

