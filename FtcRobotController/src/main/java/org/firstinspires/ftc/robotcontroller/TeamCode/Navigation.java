package org.firstinspires.ftc.robotcontroller.TeamCode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Navigation {

    //TODO: Calculate the robot speed and turn speed by testing it

    // This is the speed of the robot.
    private static final double SPEED = 1;
    // This is the speed that the robot turns
    private static final double TURN_SPEED = 1;
    // This is the power of the drive motors
    private static final double POWER = 100;

    double xPos;
    double yPos;
    double orientationAngle;
    private MotorController leftMotors;
    private MotorController rightMotors;

    Navigation(HardwareMap hardWareMap, double xPos, double yPos, double angle) {
        leftMotors = new MotorController(hardWareMap);
        leftMotors.add(MotorNames.BACK_LEFT_DRIVE);
        leftMotors.add(MotorNames.FRONT_LEFT_DRIVE);
        rightMotors = new MotorController(hardWareMap);
        rightMotors.add(MotorNames.BACK_RIGHT_DRIVE);
        rightMotors.add(MotorNames.FRONT_RIGHT_DRIVE);
        this.xPos = xPos;
        this.yPos = yPos;
        orientationAngle = angle;
    }

    void drive(double distance, boolean forward) throws InterruptedException {
        if (forward)
            turnOn(true, true);
        else
            turnOn(false, false);
        Thread.sleep((long) (distance / SPEED));
        turnOff();
    }

    void turnClockwise(double angle) throws InterruptedException {
        if (angle > 0)
            turnOn(true, false);
        else
            turnOn(false, true);
        Thread.sleep((long) (angle / TURN_SPEED));
        turnOff();
    }

    void turnOn(boolean leftForward, boolean rightForward) {
        if (leftForward)
            leftMotors.setPower(POWER);
        else
            leftMotors.setPower(-POWER);
        if (rightForward)
            rightMotors.setPower(POWER);
        else
            rightMotors.setPower(-POWER);
    }

    void turnOff() {
        leftMotors.setPower(0);
        rightMotors.setPower(0);
    }

    void moveToPoint(double x, double y) throws InterruptedException {
        double distance = Math.sqrt(Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2));
        double angle = Math.tan((xPos - x) / (yPos - y));
        turnClockwise(angle);
        drive(distance, true);
    }
}
