package org.firstinspires.ftc.robotcontroller.TeamCode;
//This defines which package the class will go in and tells the compiler where the code will go

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//We need to import these classes to use them in our code.


/*
Keywords
    Variable (primitive types): things that store either numbers, characters, or booleans
        syntax for declaring a variable:
        variableType variableName;
        syntax for assigning a value to a variable
        variableName = value;
        syntax for doing both
        variableType variableName = value;
        syntax for accessing a variable on an object
        objectName.variableName;
        note variables are only declared once but may change values any number of times
        int: integer number
        long: integer number but can store larger numbers than int
        float: decimal number
        double: decimal number but is more precise and can store larger numbers than float
        char: single character such as 'a', 'b', 'c', '!', '1'
        boolean: can only be either true or false
    Method: A chunk of code that can be called with parameters and can return a primitive type or object.
        syntax for creating: returnType methodName(parameter1Type parameter1Name, parameter2Type parameter2Name ... ) {
            //code
        }
        syntax for calling:
        methodName(parameter1Value, parameter2Value ...);

        syntax for calling and setting it to a variable (or an object):
        variableType variableName = methodName(parameter1Value, parameter2Value ...);

        syntax for calling on object:
        objectName.methodName(parameter1Value, parameter2Value ...);

        void: function with no return type
        i.e. if we want to make a method that takes an input integer number and returns the absolute value of the number we would do
        int absoluteValue(int inputNumber) {
            if(inputNumber >= 0) { //if the input is greater than 0 then it is positive so we can just return the number
                return inputNumber
            } else { //else if the input isn't greater than zero then it must be negative so we return the negative of the number because a negative negative is a positive
                return -inputNumber
            }
        }
    Object: something that has variables, methods, and other objects
    Class: something that is used to create objects
    Constructor: a method that is used to create new objects from a class.
        They may have parameters but have no return type (not even void) and always have the same name as the class they are in
        when calling a constructor you must put 'new' before the method call
        i.e. Object obj = new Object();
        here Object is the object type, obj is the object name, and Object() is the constructor for the class Object

*/


//The 'public' is here because the class needs to be public so the ftc package can access it so it can be registered and used by the Robot Controller app
//The 'extends OpMode' is here because we need to inherit variables, methods and objects from the class 'OpMode'
public class Tutorial extends OpMode {
    //Here is where the class variables and objects are
    //declared so they can be accessed everywhere inside the class

    //DcMotor is a class from the ftc package that we use to control dc motors.
    DcMotor motor = null;
    //Setting motor to null is unnecessary but it here to show that
    //every object that has not been created is by default null
    //which means trying to use the object will cause a NullPointerException


    @Override //This override is not technically necessary however is here to show that the 'init()' method is part of OpMode and is being overridden
    public void init() { //init is short of 'initialize'
        //Here is where all the code to prepare the robot before the robot actually moves

        //Because 'motor' is null currently, we need to set it to something
        //'hardWareMap' is an object declared in OpMode that holds another object called 'dcMotor'
        //and dcMotor has a method called 'get' which returns a DcMotor object
        //Note the reason we can use hardWareMap is because we inherit it from OpMode because we put 'extends OpMode' after the class name
        motor = hardwareMap.dcMotor.get("motor");
    }

    @Override //Again not necessary but here to show that 'loop()' is a method in 'OpMode'
    public void loop() {
        //Here is where all the code that will check if buttons are being pressed and react by changing the motor power

        //gamepad1 is an object that holds the states of the first game pad.

        if (gamepad1.a) { //gamepad1.a is true when the 'a' button is pressed on the game pad and false otherwise
            motor.setPower(100); //setPower(int power) is a method part of DcMotor. The power ranged from -100 to 100
        } //This if statement essentially reads "if the a button is being pressed, then set the motor power to 100

    }
}
