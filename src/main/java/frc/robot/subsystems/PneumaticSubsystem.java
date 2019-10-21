/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// import necessary packages
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.*;

public class PneumaticSubsystem extends Subsystem {

  // instantiate variables
  public DoubleSolenoid hatchMech;

  // class constructor
  public PneumaticSubsystem() {
    super("Pneumatic Subsystem");
    hatchMech = new DoubleSolenoid(RobotMap.solenoidFront, RobotMap.solenoidBack);
  }

  // extend or unextend hatch mech
  public void extendHatch() {
    hatchMech.set(DoubleSolenoid.Value.kForward);
  }
  public void retractHatch() {
    hatchMech.set(DoubleSolenoid.Value.kReverse);
  }

  // tactile feedback
  public void vibrateController(double rumblePower) {
    Robot.oi.driveController.setRumble(RumbleType.kRightRumble, rumblePower);
    Robot.oi.driveController.setRumble(RumbleType.kLeftRumble, rumblePower);
  }

  @Override
  public void initDefaultCommand() {
  }
}
