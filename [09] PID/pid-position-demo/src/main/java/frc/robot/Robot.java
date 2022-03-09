package frc.robot;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  private double kP = 2, kI = 0, kD = 0;

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(11);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(13);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(12);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(14);

  private final WPI_TalonSRX[] masterTalons = {leftMaster, rightMaster};

  @Override
  public void teleopInit() {
    leftSlave.set(ControlMode.Follower, 3);
    rightSlave.set(ControlMode.Follower, 1);
    for (WPI_TalonSRX talon : masterTalons) {
      talon.configFactoryDefault();
      talon.setSensorPhase(true);
      talon.setSelectedSensorPosition(0);
      talon.setInverted(false);
      talon.config_kP(0, kP);
      talon.config_kI(0, kI);
      talon.config_kD(0, kD);
    }
  }

  private final Joystick joystick = new Joystick(0);
  private final JoystickButton resetPositionButton = new JoystickButton(joystick, 1);
  private final double JOYSTICK_DEADZONE = .05;
  
  @Override
  public void teleopPeriodic() {
    for (WPI_TalonSRX talon : masterTalons) {
      talon.config_kP(0, kP);
      talon.config_kI(0, kI);
      talon.config_kD(0, kD);
    }
    if (Math.abs(joystick.getY()) > JOYSTICK_DEADZONE) {
      leftMaster.set(ControlMode.PercentOutput, joystick.getY());
      rightMaster.set(ControlMode.PercentOutput, -joystick.getY());
    } else {
      leftMaster.set(ControlMode.Position, 0);
      rightMaster.set(ControlMode.Position, 0);
    }
    if (resetPositionButton.get()) {
      leftMaster.setSelectedSensorPosition(0);
      rightMaster.setSelectedSensorPosition(0);
    }
    smartDashboard();
  }

  private ShuffleboardTab tab = Shuffleboard.getTab("PID");
  private NetworkTableEntry kPEntry = tab.add("kP", kP)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 100)).getEntry();
  private NetworkTableEntry kIEntry = tab.add("kI", kI)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 100)).getEntry();
  private NetworkTableEntry kDEntry = tab.add("kD", kD)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 100)).getEntry();
  private void smartDashboard() {
    kP = kPEntry.getDouble(0);
    kI = kIEntry.getDouble(0);
    kD = kDEntry.getDouble(0);
  }

}