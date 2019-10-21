/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// import necessary packages/modules
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveSubsystem extends Subsystem {

  // instantiate variables
  public static WPI_TalonSRX talon_fl;
  public static WPI_TalonSRX talon_fr;
  public static WPI_VictorSPX victor_bl;
  public static WPI_VictorSPX victor_br;

  public static DifferentialDrive robotDrive;
  public boolean driveInverted;
  private double rumblePower;

  // class constructor
  public DriveSubsystem() {
    super("Drive Subsystem");

    // instantiate motor controllers
    talon_fl = new WPI_TalonSRX(RobotMap.talon_fl);
    talon_fr = new WPI_TalonSRX(RobotMap.talon_fr);
    victor_bl = new WPI_VictorSPX(RobotMap.victor_bl);
    victor_br = new WPI_VictorSPX(RobotMap.victor_br);
    robotDrive = new DifferentialDrive(talon_fl, talon_fr);

    // default drivetrain inversion
    driveInverted = true;

    // configure motor controllers
    victor_bl.follow(talon_fl);
    victor_br.follow(talon_fr);
    talon_fl.setInverted(driveInverted);
    talon_fr.setInverted(driveInverted);
    victor_bl.setInverted(driveInverted);
    victor_br.setInverted(driveInverted);

    talon_fl.configPeakCurrentLimit(80);
    talon_fr.configPeakCurrentLimit(80);
    talon_fl.configPeakCurrentDuration(50);
    talon_fr.configPeakCurrentDuration(50);
    talon_fl.enableCurrentLimit(true);
    talon_fr.enableCurrentLimit(true);

    talon_fl.setSafetyEnabled(false);
    talon_fr.setSafetyEnabled(false);
    victor_bl.setSafetyEnabled(false);
    victor_br.setSafetyEnabled(false);
  }

  // curve drive method
  public void curveDrive(double speed, double rotation, boolean isQuickTurn) {
    robotDrive.curvatureDrive(speed, rotation, isQuickTurn);
  }

  // invert drive direction
  public void invertDirection() {
    driveInverted = !driveInverted;

    talon_fl.setInverted(driveInverted);
    talon_fr.setInverted(driveInverted);
    victor_bl.setInverted(driveInverted);
    victor_br.setInverted(driveInverted);
  }
  
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new Drive());
  }

}
