package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class MainTeleop extends LinearOpMode {
    Robot robot;
    ElapsedTime servoGrabberToggleDelay;
    ElapsedTime servoGrabberAngleDelay;

    @SuppressWarnings("RedundantThrows")
    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        waitForStart();

        telemetry.addData("Status", "Running");
        telemetry.update();

        while (opModeIsActive()) {
            driveWheels();
            toggleServoGrabber();
            rotateClaw();
            moveLinearSlide();
        }
    }

    private void initialize() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);
        servoGrabberToggleDelay = new ElapsedTime();
        servoGrabberAngleDelay = new ElapsedTime();

        telemetry.addData("Status", "Ready");
        telemetry.update();
    }

    private void driveWheels() {
        robot.wheelLeft.setPower(-gamepad1.left_stick_y * .5f);
        robot.wheelRight.setPower(-gamepad1.right_stick_y * .5f);
    }

    private void toggleServoGrabber() {
        if (gamepad1.b && servoGrabberToggleDelay.seconds() > .25f) {
            if (robot.servoGrabber.getPosition() == Robot.SERVO_POS_GRABBER_GRAB) {
                robot.servoGrabber.setPosition(Robot.SERVO_POS_GRABBER_OPEN);
            } else {
                robot.servoGrabber.setPosition(Robot.SERVO_POS_GRABBER_GRAB);
            }
            servoGrabberToggleDelay.reset();
        }
    }

    private void rotateClaw() {
        // Change delay seconds if you need it to be faster
        if (gamepad1.left_bumper && servoGrabberAngleDelay.seconds() > .05f) {
            robot.servoGrabberAngle.setPosition(robot.servoGrabberAngle.getPosition() + .01f);
            servoGrabberAngleDelay.reset();
        } else if (gamepad1.right_bumper && servoGrabberAngleDelay.seconds() > .05f) {
            robot.servoGrabberAngle.setPosition(robot.servoGrabberAngle.getPosition() - .01f);
            servoGrabberAngleDelay.reset();
        }
    }

    private void moveLinearSlide() {
        if (gamepad1.left_trigger > .1f) {
            robot.servoGrabberHeight.setPosition(.4f);
        } else if (gamepad1.right_trigger > .1f) {
            robot.servoGrabberHeight.setPosition(.6f);
        } else {
            robot.servoGrabberHeight.setPosition(.5f);
        }
    }
}
