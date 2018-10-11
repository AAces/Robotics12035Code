package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    public DcMotor leftFrontDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightBackDrive = null;
    private boolean auto = false;
        public Servo leftHold = null;
        public Servo rightHold = null;
    public Servo flipper = null;

        public static final double HOLD_OPEN = 0.0;
        public static final double HOLD_CLOSED = 0.45;
        public static final double FLIPPED_DOWN = -0.45;
    public static final double FLIPPED_UP = -0.45;

        /* local OpMode members. */
        HardwareMap hwMap = null;
        private ElapsedTime period = new ElapsedTime();

        /* Constructor */
        public Hardware(boolean auto){
            this.auto = auto;
        }

        /* Initialize standard Hardware interfaces */
        public void init(HardwareMap ahwMap) {
            // Save reference to Hardware map
            hwMap = ahwMap;

            // Define and Initialize Motors
            leftFrontDrive  = hwMap.get(DcMotor.class, "left_front");
            rightFrontDrive = hwMap.get(DcMotor.class, "right_front");
            leftBackDrive  = hwMap.get(DcMotor.class, "left_back");
            rightBackDrive = hwMap.get(DcMotor.class, "right_back");

            leftFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);
            leftBackDrive.setDirection(DcMotorSimple.Direction.FORWARD);
            rightFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
            rightBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);

            // Set all motors to zero power
            rightBackDrive.setPower(0);
            rightFrontDrive.setPower(0);
            leftFrontDrive.setPower(0);
            leftBackDrive.setPower(0);


            if(auto){
                leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            } else {
                leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }


     // Define and initialize ALL installed servos.
        leftHold = hwMap.get(Servo.class, "left_hold");
        rightHold = hwMap.get(Servo.class, "right_hold");
            flipper = hwMap.get(Servo.class, "flipper");
        leftHold.setPosition(HOLD_CLOSED);
        rightHold.setPosition(HOLD_CLOSED);
        flipper.setPosition(FLIPPED_DOWN);
    }



}
