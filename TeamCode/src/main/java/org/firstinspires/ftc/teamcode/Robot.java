package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    DcMotor wheelLeft;
    DcMotor wheelRight;

     Servo servoGrabber;
     Servo servoGrabberAngle;
     Servo servoGrabberHeight;

    Robot(HardwareMap hardwareMap) {
        wheelLeft = hardwareMap.get(DcMotor.class, "wheelLeft");
        wheelRight = hardwareMap.get(DcMotor.class, "wheelRight");
        wheelLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        servoGrabber = hardwareMap.get(Servo.class, "servoGrabber");
        servoGrabberAngle = hardwareMap.get(Servo.class, "servoGrabberAngle");
        servoGrabberHeight = hardwareMap.get(Servo.class, "servoGrabberHeight");
    }


    // ********** CONSTANTS ********** //
    final static float SERVO_POS_GRABBER_GRAB = .77f;
    final static float SERVO_POS_GRABBER_OPEN = .3f;
}
