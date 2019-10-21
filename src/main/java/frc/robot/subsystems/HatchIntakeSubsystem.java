/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class HatchIntakeSubsystem extends Subsystem {

  public WPI_TalonSRX intake_motor;
  public boolean hatchIn;

  // class constructor
  public HatchIntakeSubsystem() {
    intake_motor = new WPI_TalonSRX(RobotMap.intake_motor);
    hatchIn = true;
  }

  public void succ() {
    if (!hatchIn) {
      if (intake_motor.getOutputCurrent() <= 70.0) {
        intake_motor.set(1);
        Robot.oi.driveController.setRumble(GenericHID.RumbleType.kRightRumble, 0.5);
      } else {
        intake_motor.set(0.7);
        hatchIn = true;
        SmartDashboard.putBoolean("hatch in", hatchIn);
      }
    }
  }

  public void spit() {
    intake_motor.set(-1);
    Robot.oi.driveController.setRumble(GenericHID.RumbleType.kRightRumble, 0.5);
    hatchIn = false;
    SmartDashboard.putBoolean("hatch in", hatchIn);
  }

  public void atRest() {
    intake_motor.set(0.08);
    Robot.oi.driveController.setRumble(GenericHID.RumbleType.kRightRumble, 0);
  }

  @Override
  public void initDefaultCommand() {
  }
}
