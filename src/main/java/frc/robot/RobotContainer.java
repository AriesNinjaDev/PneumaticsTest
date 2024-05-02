// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.filter.Debouncer.DebounceType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Subsystems.TestSubsystem;

public class RobotContainer {
    TestSubsystem testSubsystem = new TestSubsystem();
    CommandXboxController controller = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        new Trigger(controller.a()).onTrue(new InstantCommand(() -> testSubsystem.toggleComp())).debounce(1,
                DebounceType.kFalling);
        new Trigger(controller.b())
                .onTrue(new InstantCommand(() -> testSubsystem.openSole())
                        .andThen(new WaitCommand(testSubsystem.waitTime))
                        .andThen(new InstantCommand(() -> testSubsystem.closeSole())))
                .debounce(2.0, DebounceType.kFalling);
        new Trigger(controller.y()).onTrue(new InstantCommand(() -> testSubsystem.increaseTimeBig()));
        new Trigger(controller.x()).onTrue(new InstantCommand(() -> testSubsystem.decreaseTimeBig()));
        new Trigger(controller.rightBumper()).onTrue(new InstantCommand(() -> testSubsystem.decreaseTimeSmall()));
        new Trigger(controller.leftBumper()).onTrue(new InstantCommand(() -> testSubsystem.increaseTimeSmall()));
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }

    public TestSubsystem getTestSubsystem() {
        return testSubsystem;
    }
}
