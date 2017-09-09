package org.firstinspires.ftc.teamcode;

/**
 * Created by LMRobotics on 9/5/2017.
 */

enum MotorNames {

    FRONT_LEFT_DRIVE("frontLeftDriveMotor"),
    BACK_LEFT_DRIVE("backLeftDRiveMotor"),
    FRONT_RIGHT_DRIVE("frontRightDriveMotor"),
    BACK_RIGHT_DRIVE("backRightDriveMotor");

    private final String motorName;

    MotorNames(String name) {
        motorName = name;
    }
    String get() {
        return motorName;
    }
}

