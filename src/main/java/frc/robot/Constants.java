// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //Joysticks
  public static final int RIGHT_JOYSTICK_CHANNEL = 1;
  public static final int LEFT_JOYSTICK_CHANNEL = 0;
  public static class OperatorConstants {
  public static final int kDriverControllerPort = 0;
  }
  // Intake Constants
  public static final int INTAKE_MOTOR_ID = 22;
  public static final int INTAKE_IN_VOLTS = 12;
  public static final int INTAKE_OUT_VOLTS = -12;

  // Intake Angle Constasnts
  public static final int INTAKE_ANGLE_MOTOR_ID = 21;
  public static final int INTAKE_ANGLE_TIME_CONSTANT = 8;
  public static final int INTAKE_ANGLE_DOWN_VOLTS = -6;
  public static final int INTAKE_ANGLE_UP_VOLTS = 8;
  public static final int INTAKE_ANGLE_UP = 90; //degrees
  public static final int INTAKE_ANGLE_DOWN = 0; //degrees
  public static final int INTAKE_ANGLE_SAFETY_FACTOR = 3; //degrees

  // Elevator Constants
  public static final int ELEVATOR_MOTOR_ID = 23;
  public static final double SPOOL_DIAMETER = 1.5; //inches for all units
  public static final int POSITION_1 = 0;
  public static final int POSITION_2 = 5;
  public static final int POSITION_3 = 10;
  public static final int POSITION_4 = 20;
}
