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
import edu.wpi.first.wpilibj.XboxController;
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
      } else {
        intake_motor.set(0.7);
        hatchIn = true;
        SmartDashboard.putBoolean("hatch in", hatchIn);
      }
    }
  }

  public void spit() {
    intake_motor.set(-1);
    hatchIn = false;
    SmartDashboard.putBoolean("hatch in", hatchIn);
  }

  public void atRest() {
    intake_motor.set(0.15);
  }

  public void setVibration(XboxController controller, double power) {
    controller.setRumble(GenericHID.RumbleType.kRightRumble, power);
  }

  @Override
  public void initDefaultCommand() {
  }
}
