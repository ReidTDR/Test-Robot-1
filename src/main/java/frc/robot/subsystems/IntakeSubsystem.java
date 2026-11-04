// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IntakeSubsystem extends SubsystemBase {
  TalonFX m_intakeRollerMotor;

  /** Creates a new Intake. */
  public IntakeSubsystem() {
    m_intakeRollerMotor = new TalonFX(Constants.INTAKE_MOTOR_ID);
  }
  public void intakeRollerIn() {
    m_intakeRollerMotor.setVoltage(Constants.INTAKE_IN_VOLTS);
  }
  public void intakeRollerOut() {
    m_intakeRollerMotor.setVoltage(Constants.INTAKE_OUT_VOLTS);
  }
  public void intakeRollerStop (){
    m_intakeRollerMotor.setVoltage(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  // Find a motor, Give motor some voltage
}
