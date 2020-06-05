package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Limelight;

public class ChaseTarget extends CommandBase {

  private final Drive drive;
  private final Limelight limelight;

  public ChaseTarget(Drive drive, Limelight limelight) {
    this.drive = drive;
    addRequirements(drive);
    this.limelight = limelight;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (limelight.hasValidTarget()) {
      double speed;
      if (limelight.getTargetArea() < 20) {
        speed = .3;
      } else {
        speed = 0;
      }
      double rotation = rotationPIDStuff();
      drive.arcadeDrive(speed, rotation);
    } else {
      // DifferentialDrive throws a fit if you dont update it every .1 second, so I do something with it no matter what
      drive.arcadeDrive(0, 0);
    }
  }

  /*
   * So the robot needs to turn towards the target. It needs to slow down or else
   * it might overshoot it, it needs to be prevented from oscillating, and we need to make
   * sure it doesn't slow down too much as it approaches the target.
   * There is no "turn x degrees" ControlMode for DifferentialDrive
   * 
   * uh oh
   * 
   * that's PID
   * 
   * you really thought you could escape?!?!?
   * well you kinda did because we're only doing P in this
   * 
   * First I want to point out what exactly are we PID-ing. You've probably only had experience
   * with using PID with position and velocity (if you haven't, you should maybe learn some PID).
   * With position, our target value is some distance, we could find out our current position using
   * the encoder, and the thing we control in order to get to the target position is the velocity.
   * 
   */
  private final double kPRotational = 1.0 / 15;
  /**
   * precondition: limelight has valid target
   */
  private double rotationPIDStuff() {
    double error = 0 - (-limelight.getHorizontalOffset());
    if (Math.abs(error) < .1) error = 0; 
    
    double output = kPRotational * error;
    return output;
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
