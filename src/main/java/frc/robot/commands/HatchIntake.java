/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class HatchIntake extends Command {
  public HatchIntake() {
    requires(Robot.s_subsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.oi.driveController.getAButton()) {
      Robot.s_hatch.succ();
      Robot.s_hatch.setVibration(Robot.oi.driveController, 0.5);
    } else if (Robot.oi.driveController.getBButton()) {
      Robot.s_hatch.spit();
      Robot.s_hatch.setVibration(Robot.oi.driveController, 0.5);
    } else if (Robot.oi.driveController.getAButtonReleased() || Robot.oi.driveController.getBButtonReleased()) {
      Robot.s_hatch.atRest();
      Robot.s_hatch.setVibration(Robot.oi.driveController, 0);
    }

    if (Robot.oi.operatorController.getAButton()) {
      Robot.s_hatch.succ();
      Robot.s_hatch.setVibration(Robot.oi.operatorController, 0.5);
    } else if (Robot.oi.operatorController.getBButton()) {
      Robot.s_hatch.spit();
      Robot.s_hatch.setVibration(Robot.oi.operatorController, 0.5);
    } else if (Robot.oi.operatorController.getAButtonReleased() || Robot.oi.operatorController.getBButtonReleased()) {
      Robot.s_hatch.atRest();
      Robot.s_hatch.setVibration(Robot.oi.operatorController, 0);
    }

    SmartDashboard.putNumber("hatch current", Robot.s_hatch.intake_motor.getOutputCurrent());
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
