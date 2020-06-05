package frc.robot;

import static frc.robot.Constants.*;

import frc.robot.commands.ChaseTarget;
import frc.robot.commands.FollowTarget;
import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final Joystick joystick = new Joystick(JOYSTICK_ID);
  private final JoystickButton chaseTargetButton = new JoystickButton(joystick, TRIGGER_BUTTON);

  private final Drive drive = new Drive();
  private final Limelight limelight = new Limelight();

  private final Command autoCommand = null;
  private final JoystickDrive joystickDrive = new JoystickDrive(drive, joystick);
  private final ChaseTarget chaseTarget = new ChaseTarget(drive, limelight);
  private final FollowTarget followTarget = new FollowTarget(drive, limelight);

  public RobotContainer() {
    drive.setDefaultCommand(joystickDrive);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    chaseTargetButton.whileHeld(chaseTarget);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoCommand;
  }
}
