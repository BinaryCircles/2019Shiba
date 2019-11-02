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

public class CargoIntake extends Command {
  public CargoIntake() {
    requires(Robot.s_cargo);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.oi.driveController.getPOV() == 180) {
      Robot.s_cargo.succ();
      Robot.s_cargo.setVibration(Robot.oi.driveController, 0.5);
    } else if (Robot.oi.driveController.getPOV() == 0) {
      Robot.s_cargo.spit();
      Robot.s_cargo.setVibration(Robot.oi.driveController, 0.5);
    } else if (Robot.oi.driveController.getPOV() == -1) {
      Robot.s_cargo.atRest();
      Robot.s_cargo.setVibration(Robot.oi.driveController, 0);
    }

    if (Robot.oi.driveController.getPOV() == -1) {
      if (Robot.oi.getTriggerMagnitude(Robot.oi.operatorController) < -0) {
        Robot.s_cargo.succ();
        Robot.s_cargo.setVibration(Robot.oi.operatorController, 0.5);
      } else if (Robot.oi.getTriggerMagnitude(Robot.oi.operatorController) > 0) {
        Robot.s_cargo.spit();
        Robot.s_cargo.setVibration(Robot.oi.operatorController, 0.5);
      } else if (Robot.oi.getTriggerMagnitude(Robot.oi.operatorController) == 0){
        Robot.s_cargo.atRest();
        Robot.s_cargo.setVibration(Robot.oi.operatorController, 0);
      }
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
