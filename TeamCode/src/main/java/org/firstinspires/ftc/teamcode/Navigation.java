package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by adsweiger on 11/12/2016.
 */
public class Navigation {
    private static final double SPEED = 1;
    private static final double ROTATION_SPEED = 1;
    private static final double POWER = 100;

    private MotorController leftMotors;
    private MotorController rightMotors;

    Navigation(HardwareMap hardWareMap) {
        leftMotors = new MotorController(hardWareMap);
        rightMotors = new MotorController(hardWareMap);
        leftMotors.add(MotorNames.BACK_LEFT_DRIVE.get());
        leftMotors.add(MotorNames.FRONT_LEFT_DRIVE.get());
        rightMotors.add(MotorNames.BACK_RIGHT_DRIVE.get());
        rightMotors.add(MotorNames.FRONT_RIGHT_DRIVE.get());
    }

    void driveForward(double distance) throws InterruptedException {
        turnOn(true, true);
        Thread.sleep((long) (distance / SPEED));
        turnOff();
    }

    void driveBackwards(double distance) throws InterruptedException {
        turnOn(false, false);
        Thread.sleep((long) (distance / SPEED));
        turnOff();
    }

    void turnRight(double angle) throws InterruptedException {
        turnOn(true, false);
        Thread.sleep((long)(angle / ROTATION_SPEED));
        turnOff();
    }

    void turnLeft(double angle) throws InterruptedException {
        turnOn(false, true);
        Thread.sleep((long)(angle / ROTATION_SPEED));
        turnOff();
    }

    void turnOn(boolean leftForward, boolean rightForward) {
        if(leftForward)
            leftMotors.setPower(POWER);
        else
            leftMotors.setPower(-POWER);
        if(rightForward)
            rightMotors.setPower(POWER);
        else
            rightMotors.setPower(-POWER);
    }

    void turnOff() {
        leftMotors.setPower(0);
        rightMotors.setPower(0);
    }

}
