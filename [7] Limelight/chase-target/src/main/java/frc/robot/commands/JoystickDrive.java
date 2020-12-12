package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class JoystickDrive extends CommandBase {

  private final Drive drive;
  private final Joystick joystick;

  public JoystickDrive(Drive drive, Joystick joystick) {
    this.drive = drive;
    addRequirements(drive);
    this.joystick = joystick;
  }

  @Override
  public void execute() {
    drive.arcadeDrive(-joystick.getY(), joystick.getX());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

}
