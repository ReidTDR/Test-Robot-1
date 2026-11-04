// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeAngleSubsystem extends SubsystemBase {

  TalonFX m_intakeAngleMotor;
  PIDController m_PIDController = new PIDController(0, 0, 0);
  double m_targetPose;
  double motor_angle;
  double initialPose;
  double ff;
  VoltageConfigs m_VoltageConfigs;
  boolean pidMode = false;

  /** Creates a new IntakeAngleSubsystem. */
  public IntakeAngleSubsystem() {
  m_intakeAngleMotor = new TalonFX(Constants.INTAKE_ANGLE_MOTOR_ID);
  m_intakeAngleMotor.setNeutralMode(NeutralModeValue.Brake);

  m_VoltageConfigs = new VoltageConfigs();
  m_VoltageConfigs.SupplyVoltageTimeConstant = Constants.INTAKE_ANGLE_TIME_CONSTANT;
  m_intakeAngleMotor.getConfigurator().apply(m_VoltageConfigs);
  initialPose = m_intakeAngleMotor.getPosition().getValueAsDouble();
  m_targetPose = getAngle();
  }

  public double getAngle(){
    return -1
      * (m_intakeAngleMotor.getPosition().getValueAsDouble() - initialPose)
      / (5)
      * 360;
  }

 public void changePidMode(boolean newPid) {
    pidMode = newPid;
  }

  public void resetEncoder(){
    m_intakeAngleMotor.setPosition(0);
  }

  public void setInitialPose(){
    initialPose = m_intakeAngleMotor.getPosition().getValueAsDouble();
  }

  public void IntakeDown(){
    m_intakeAngleMotor.setVoltage(Constants.INTAKE_ANGLE_DOWN_VOLTS);
  }

  public void IntakeUp(){
    m_intakeAngleMotor.setVoltage(Constants.INTAKE_ANGLE_UP_VOLTS);
  }

  public void setVolts(double Volts){
    m_intakeAngleMotor.setVoltage(Volts);
  }

  public void FeedForward(){
    m_intakeAngleMotor.setVoltage(ff);
  }

  public void IntakeStop(){
    m_intakeAngleMotor.setVoltage(0);
  }

  public void targetPose(double Target){
    m_targetPose = Target;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    if (pidMode){
      ff = -2;
      double fb = m_PIDController.calculate(getAngle() , m_targetPose);
      setVolts(ff - fb);
    }
  }
}
