package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(DRIVE_LEFT_MASTER_ID);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(DRIVE_LEFT_SLAVE_ID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(DRIVE_RIGHT_MASTER_ID);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(DRIVE_RIGHT_SLAVE_ID);

  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMaster, rightMaster);

  public Drive() {
    leftSlave.set(ControlMode.Follower, DRIVE_LEFT_MASTER_ID);
    rightSlave.set(ControlMode.Follower, DRIVE_RIGHT_MASTER_ID);
  }

  @Override
  public void periodic() {
    
  }

  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

}
