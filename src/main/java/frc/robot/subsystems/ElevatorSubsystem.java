// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  TalonFX m_elevatorMotor;
  double ff;
  double targetPose;
  PIDController m_PidController = new PIDController(0,0,0);
  boolean PIDMode = false;

  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {
    m_elevatorMotor = new TalonFX(Constants.ELEVATOR_MOTOR_ID);
    m_elevatorMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public double CurrentHeight(){
    return m_elevatorMotor.getPosition().getValueAsDouble() * Constants.SPOOL_DIAMETER * Math.PI;
  }

  public void setInitialPose(){
    m_elevatorMotor.getPosition().getValueAsDouble();
  }

  public void setTargetPose(double target){
    targetPose = target;
    PIDMode = true;
  }

  public void setVolts(double volts){
    m_elevatorMotor.setVoltage(volts);
  }

  public void ElevatorHold(){
    m_elevatorMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  @Override
  public void periodic() {
    if (PIDMode){
      ff = -20;
      double fb = m_PidController.calculate(CurrentHeight(), targetPose);
      m_elevatorMotor.setVoltage (ff - fb);
    }
    else{
      m_elevatorMotor.setVoltage(0);
    }
    }
  public Command goToPose(double target){
    return runOnce(() -> setTargetPose(target));
  }
}
