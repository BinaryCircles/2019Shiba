/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class VisionAlignSubsystem extends Subsystem {

  // initialize variables
  private boolean driverVision, tapeVision, cargoVision, cargoSeen, tapeSeen;
  private NetworkTableEntry tapeDetected, cargoDetected, tapeYaw, cargoYaw, videoTimestamp;
  private double targetAngle;
  NetworkTableInstance instance;
  NetworkTable visionTable;

  private double kP; // p constant of controller

  // constructor and configuration
  public VisionAlignSubsystem() {
    instance = NetworkTableInstance.getDefault();
    visionTable = instance.getTable("ChickenVision");

    tapeDetected = visionTable.getEntry("tapeDetected");
    tapeYaw = visionTable.getEntry("tapeYaw");

    kP = 0.08;
  }

  public double calculateOutput() {
    // find the error in angle based on yaw feedback from vision loop
    if (tapeDetected.getBoolean(true) && Math.abs(tapeYaw.getDouble(0)) > 2) {
      SmartDashboard.putNumber("vision output", (-kP * tapeYaw.getDouble(0)));
      return -kP * tapeYaw.getDouble(0);
    } else {
      SmartDashboard.putNumber("vision output", 0);
      return 0;
    }
  }

  // move the robot to the center
  public void alignRobot() {
    Robot.s_drive.curveDrive(-0.25, calculateOutput() * 0.5, true);
  }

  @Override
  public void initDefaultCommand() {

  }
}
