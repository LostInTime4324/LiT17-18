package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Pompeii: Teleop Tank", group="Pompeii")
public class TeleOp extends OpMode {
    // TeleOp
    private MotorController leftMotors;
    private MotorController rightMotors;

    // Initialization code that happens TeleOp starts
    @Override
    public void init() {
        leftMotors = new MotorController(hardwareMap);
        leftMotors.add(MotorNames.BACK_LEFT_DRIVE.get());
        leftMotors.add(MotorNames.FRONT_LEFT_DRIVE.get());
        rightMotors = new MotorController(hardwareMap);
        rightMotors.add(MotorNames.BACK_RIGHT_DRIVE.get());
        rightMotors.add(MotorNames.FRONT_RIGHT_DRIVE.get());
    }
    
    @Override
    public void loop() {
        leftMotors.setPower(gamepad1.left_stick_y);
        rightMotors.setPower(gamepad1.right_stick_y);
    }
}