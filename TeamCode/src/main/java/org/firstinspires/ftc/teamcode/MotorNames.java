package org.firstinspires.ftc.teamcode;

/*
    This is where all the names of the motors for to use fot the phones should be put.
    Use this whenever you want to add a motor name or change a motor name
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

