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

public class CargoSubsystem extends Subsystem {

  public WPI_VictorSPX cargo_motor;
  public boolean cargoIn;

  // class constructor
  public CargoSubsystem() {
    cargo_motor = new WPI_VictorSPX(RobotMap.cargo_motor);
  }

  public void succ() {
    cargo_motor.set(-1);
  }

  public void spit() {
    cargo_motor.set(0.6);
  }

  public void atRest() {
    cargo_motor.set(-0.08);
  }

  public void analogControl(XboxController controller) {
    cargo_motor.set(-Robot.oi.getTriggerMagnitude(controller));
  }

  public void setVibration(XboxController controller, double power) {
    controller.setRumble(GenericHID.RumbleType.kRightRumble, power);
  }

  @Override
  public void initDefaultCommand() {
  }
}
