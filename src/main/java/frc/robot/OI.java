/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class OI {

  public static XboxController driveController = new XboxController(RobotMap.controller1);
  public static XboxController operatorController = new XboxController(RobotMap.controller2);

  // get magnitude of trigger from -1 to 1 (left and right triggers)
  public double getTriggerMagnitude(XboxController controller) {
    return Math.pow((-controller.getTriggerAxis(GenericHID.Hand.kRight)+controller.getTriggerAxis(GenericHID.Hand.kLeft)), 3);  
  }

  public double getXMagnitude(XboxController controller) {
    return Math.pow(controller.getX(GenericHID.Hand.kLeft), 3) * -1;
  }

  public double getYMagnitude(XboxController controller) {
    return Math.pow(controller.getY(GenericHID.Hand.kLeft), 3);
  }

}
