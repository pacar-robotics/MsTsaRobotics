package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class TestServo extends LinearOpMode {
    @SuppressWarnings("RedundantThrows")
    @Override
    public void runOpMode() throws InterruptedException {
        Servo servo = hardwareMap.get(Servo.class, "servoGrabber");
        ElapsedTime elapsedTime = new ElapsedTime();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up && elapsedTime.seconds() > .25f) {
                servo.setPosition(servo.getPosition() + .01f);
                elapsedTime.reset();
            } else if (gamepad1.dpad_down && elapsedTime.seconds() > .5f) {
                servo.setPosition(servo.getPosition() - .01f);
                elapsedTime.reset();
            }

            telemetry.addData("Position", servo.getPosition());
            telemetry.update();
        }
    }
}
