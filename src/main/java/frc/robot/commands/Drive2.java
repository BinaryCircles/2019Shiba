/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.OI;

public class Drive2 extends Command {

    public double rumblePower;

    public Drive2() {
        requires(Robot.s_drive);

        rumblePower = 0;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // invert drive direction
        if (Robot.oi.driveController.getYButtonPressed()) {
            Robot.s_drive.invertDirection();
        }

        if (Robot.s_drive.driveInverted) {
            if (!Robot.oi.driveController.getXButton()) { // when not quick turning
                Robot.s_drive.curveDrive(Robot.oi.getTriggerMagnitude(Robot.oi.driveController),
                        Robot.oi.getXMagnitude(Robot.oi.driveController) * 50,
                        false);
            } else { // when quick turning
                Robot.s_drive.curveDrive(Robot.oi.getTriggerMagnitude(Robot.oi.driveController),
                        Robot.oi.getXMagnitude(Robot.oi.driveController) * 0.8,
                        true);
            }
        } else {
            if (!Robot.oi.driveController.getXButton()) { // when not quick turning
                Robot.s_drive.curveDrive(Robot.oi.getTriggerMagnitude(Robot.oi.driveController),
                        Robot.oi.getXMagnitude(Robot.oi.driveController) * -50,
                        false);
            } else { // when quick turning
                Robot.s_drive.curveDrive(Robot.oi.getTriggerMagnitude(Robot.oi.driveController),
                        Robot.oi.getXMagnitude(Robot.oi.driveController) * -0.8,
                        true);
            }
        }
 
            if(Robot.oi.driveController.getPOV() == 0) {
        Robot.s_drive.turnPID(0);
        } else if(Robot.oi.driveController.getPOV() == 90) {
        Robot.s_drive.turnPID(90);
        } else if(Robot.oi.driveController.getPOV() == 180) {
        Robot.s_drive.turnPID(180);
        } else if(Robot.oi.driveController.getPOV() ==  270) {
        Robot.s_drive.turnPID(270);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}