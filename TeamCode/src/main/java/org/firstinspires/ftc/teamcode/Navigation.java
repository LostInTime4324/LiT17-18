package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Navigation {

    //TODO: Calculate the robot speed and turn speed by testing it

    // This is the speed of the robot.
    private static final double SPEED = 1;
    // This is the speed that the robot turns
    private static final double TURN_SPEED = 1;
    // This is the power of the drive motors
    private static final double POWER = 100;

    private MotorController leftMotors;
    private MotorController rightMotors;

    Navigation(HardwareMap hardWareMap) {
        leftMotors = new MotorController(hardWareMap);
        leftMotors.add(MotorNames.BACK_LEFT_DRIVE.get());
        leftMotors.add(MotorNames.FRONT_LEFT_DRIVE.get());
        rightMotors = new MotorController(hardWareMap);
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
        Thread.sleep((long)(angle / TURN_SPEED));
        turnOff();
    }

    void turnLeft(double angle) throws InterruptedException {
        turnOn(false, true);
        Thread.sleep((long)(angle / TURN_SPEED));
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
