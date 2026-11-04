// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeAngleSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeAngleOut extends Command {
  /** Creates a new IntakeAngleOut. */
  IntakeAngleSubsystem m_IntakeAngleSubsystem;
  public IntakeAngleOut(IntakeAngleSubsystem intakeAngleSubsystem) {
    m_IntakeAngleSubsystem = intakeAngleSubsystem;
    addRequirements(intakeAngleSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_IntakeAngleSubsystem.targetPose(Constants.INTAKE_ANGLE_DOWN);
    m_IntakeAngleSubsystem.changePidMode(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_IntakeAngleSubsystem.getAngle() - Constants.INTAKE_ANGLE_DOWN) <= Constants.INTAKE_ANGLE_SAFETY_FACTOR ;
  }
}
