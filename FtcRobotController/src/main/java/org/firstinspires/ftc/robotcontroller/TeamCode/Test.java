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


    @Override
    public void init() {
        SensorManager mSensorManager = (SensorManager) FtcRobotControllerActivity.context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor: sensorList) {
            Log.i("logtag", sensor.getName());
            Log.i("logtag", sensor.toString());
            //Log.i("logtag", sensor.getStringType());
        }
        Sensor mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener eventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                telemetry.addData("X: ", sensorEvent.values[0]);
                telemetry.addData("X: ", sensorEvent.values[1]);
                telemetry.addData("X: ", sensorEvent.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                telemetry.addData("event", i);
            }
        };

        mSensorManager.registerListener(eventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        if (mSensor == null) {
            telemetry.addData("null", "");

        } else {
            telemetry.addData("not null", "");
        }
        mSensorManager.unregisterListener(eventListener);
    }

    @Override
    public void loop() {

    }
}
