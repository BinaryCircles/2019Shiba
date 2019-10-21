/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// import necessary packages/modules
package frc.robot.subsystems;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionSubsystem extends Subsystem {
  
  // initialize variables
  private UsbCamera camera;
  private CvSink cvSink;
  private CvSource outputStream;

  // class constructor
  public VisionSubsystem() {
    // instantiate camera
    camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 480);

    cvSink = CameraServer.getInstance().getVideo();
    outputStream = CameraServer.getInstance().putVideo("cam", 640, 480);
  }

  @Override
  public void initDefaultCommand() {
  }
}
