/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VisionAlign extends Command {

  public VisionAlign() {
    requires(Robot.s_subsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    if (Robot.oi.driveController.getBumper(GenericHID.Hand.kLeft)) {
      Robot.s_hatchExtend.extendHatch();
      Robot.s_visionAlign.alignRobot();
    } else {
      Robot.s_hatchExtend.retractHatch();
    }

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
