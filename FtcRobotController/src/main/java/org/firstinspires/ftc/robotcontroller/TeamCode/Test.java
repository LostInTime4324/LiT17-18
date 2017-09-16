package org.firstinspires.ftc.robotcontroller.TeamCode;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;

import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Test: Teleop Tank", group = "Test")
public class Test extends OpMode{
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private double xPos = 0;
    private double yPos = 0;
    private double zPos = 0;
    private long time;
    private long dt;
    @Override
    public void init() {
        SensorManager mSensorManager = (SensorManager) FtcRobotControllerActivity.context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor: sensorList) {
            Log.i("logtag", sensor.getName());
            Log.i("logtag", sensor.toString());
            //Log.i("logtag", sensor.getStringType());
        }
        time = System.nanoTime();
        Sensor mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        SensorEventListener eventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                dt = System.nanoTime() - time;
                time += dt;
                dt /= 1000000;
                double xVel = sensorEvent.values[0] * dt;
                double yVel = sensorEvent.values[1] * dt;
                double zVel = sensorEvent.values[2] * dt;
                xPos += xVel * dt;
                yPos += yVel * dt;
                zPos += zVel * dt;

//                telemetry.addData("X: ", sensorEvent.values[0]);
//                telemetry.addData("Y: ", sensorEvent.values[1]);
//                telemetry.addData("Z: ", sensorEvent.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                telemetry.addData("event", i);
            }
        };

        //mSensorManager.registerListener(eventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void loop() {
        telemetry.addData("X: ", xPos);
        telemetry.addData("Y: ", yPos);
        telemetry.addData("Z: ", zPos);
    }
}
