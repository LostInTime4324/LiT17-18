package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

public class MotorController {

    private ArrayList<DcMotor> motors = new ArrayList<>();
    private HardwareMap hardwareMap;
    private boolean motorState = true;
    private boolean buttonState = false;
    private double power = 0;

    MotorController(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    // Add motor to MotorController
    void add(String motorName) {
        motors.add(hardwareMap.dcMotor.get(motorName));
    }

    // Sets power of all the motors
    void setPower(double power) {
        if (Math.abs(power) > 5) {
            this.power = power;
            if (motorState) {
                for (DcMotor motor : motors) {
                    motor.setPower(power);
                }
            }
        }
    }

    // Toggles the motor state
    public void toggle() {
        if (motorState)
            turnOff();
        else
            turnOn();
        motorState = !motorState;
    }


    // Toggles the motors when the button is pressed down
    public void toggleOnButtonStateChange(boolean button) {
        if (button && !buttonState)
            toggle();
        buttonState = button;
    }

    void turnOn() {
        for (DcMotor motor : motors) {
            motor.setPower(power);
        }
    }


    void turnOff() {
        for (DcMotor motor : motors) {
            motor.setPower(0);
        }
    }
}
