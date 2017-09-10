package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Test: Teleop Tank", group = "Test")
public class Test extends OpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;


    @Override
    public void init() {
        leftmotor = hardwareMap.dcMotor.get("Motor1");
        rightmotor = hardwareMap.dcMotor.get("Motor2");
    }

    @Override
    public void loop() {
        leftmotor.setPower(gamepad1.left_stick_y);
        rightmotor.setPower(gamepad1.right_stick_y);
        if (gamepad1.x) {
            leftmotor.setPower(0);
        }
    }
}
