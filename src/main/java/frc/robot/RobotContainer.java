// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.IntakeAngleIn;
import frc.robot.commands.IntakeAngleOut;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeAngleSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  //Subsystems
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final IntakeAngleSubsystem m_intakeAngleSubsystem = new IntakeAngleSubsystem();
  private final ElevatorSubsystem m_ElevatorSubsystem = new ElevatorSubsystem();

  //Commands
    //Intake
      //Rollers
      private final IntakeInCommand m_intakeInCommand = new IntakeInCommand(m_intakeSubsystem);
      private final IntakeOutCommand m_intakeOutCommand = new IntakeOutCommand(m_intakeSubsystem);
      //Angle
      private final IntakeAngleIn m_IntakeAngleInCommand = new IntakeAngleIn (m_intakeAngleSubsystem);
      private final IntakeAngleOut m_IntakeAngleOutCommand = new IntakeAngleOut (m_intakeAngleSubsystem);

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();
  public static Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_CHANNEL);
  public static Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_CHANNEL);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    Trigger intakeIn = new JoystickButton(rightJoystick, 1);
    Trigger intakeOut = new JoystickButton(rightJoystick, 4);
    Trigger intakeAngleIn = new JoystickButton(rightJoystick, 2);
    Trigger intakeAngleOut = new JoystickButton(rightJoystick, 3);
    Trigger elevatorPosition1 = new JoystickButton(leftJoystick, 0);
    Trigger elevatorPosition2 = new JoystickButton(leftJoystick, 1);


    intakeIn.whileTrue(m_intakeInCommand);
    intakeOut.whileTrue(m_intakeOutCommand);
    intakeAngleIn.whileTrue(m_IntakeAngleInCommand);
    intakeAngleOut.whileTrue(m_IntakeAngleOutCommand);
    elevatorPosition1.whileTrue(m_ElevatorSubsystem.goToPose(Constants.POSITION_1));
    elevatorPosition2.whileTrue(m_ElevatorSubsystem.goToPose(Constants.POSITION_2));




    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  }
}
