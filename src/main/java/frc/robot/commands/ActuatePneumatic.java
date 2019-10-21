/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;

import frc.robot.Robot;

public class ActuatePneumatic extends Command {
  
  private double rumblePower;
  
  public ActuatePneumatic() {
    requires(Robot.s_hatch);

    rumblePower = 0;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.oi.driveController.getBumper(GenericHID.Hand.kRight)) {
      Robot.s_hatchExtend.extendHatch();
    } else if (Robot.oi.driveController.getBumper(GenericHID.Hand.kLeft)) {
      Robot.s_hatchExtend.extendHatch();
      Robot.s_visionAlign.alignRobot();
    } else {
      Robot.s_hatchExtend.retractHatch();
    }

    if (Robot.oi.driveController.getBumperPressed(GenericHID.Hand.kRight) || Robot.oi.driveController.getBumperReleased(GenericHID.Hand.kRight) || Robot.oi.driveController.getBumperPressed(GenericHID.Hand.kLeft) || Robot.oi.driveController.getBumperReleased(GenericHID.Hand.kLeft)) {
      rumblePower = 1;
    }

    Robot.s_hatchExtend.vibrateController(rumblePower);
    rumblePower -= 0.15;
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
