package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    public DcMotor leftFrontDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightBackDrive = null;

    public DcMotor spinnyThing = null;

    public DcMotor lift1 = null;
    public DcMotor lift2 = null;
    public DcMotor cargoLift = null;

    private boolean auto = false;

    /* local OpMode members. */
    private HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public Hardware(boolean auto) {
        this.auto = auto;
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFrontDrive = hwMap.get(DcMotor.class, "left_front");
        rightFrontDrive = hwMap.get(DcMotor.class, "right_front");
        leftBackDrive = hwMap.get(DcMotor.class, "left_back");
        rightBackDrive = hwMap.get(DcMotor.class, "right_back");
        lift1 = hwMap.get(DcMotor.class, "lift1");
        lift2 = hwMap.get(DcMotor.class, "lift2");
        cargoLift = hwMap.get(DcMotor.class, "cargo_lift");
        spinnyThing = hwMap.get(DcMotor.class, "spinny_thing");


        leftFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set all motors to zero power
        rightBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        lift1.setPower(0);
        lift2.setPower(0);
        cargoLift.setPower(0);
        spinnyThing.setPower(0);

        if (auto) {
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

    }


}
