package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Pompeii: Autonomous", group="Pompeii")
public class Autonomous extends LinearOpMode {

    private Navigation nav;

    @Override
    public void runOpMode() throws InterruptedException {
        nav = new Navigation(hardwareMap);

        waitForStart();


    }
}
