package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * In a Timed robot, all your code happens here, not in a main method.
 */
public class Robot extends TimedRobot {

  /**
   * Throughout this class, you have sets of 2 methods - Init and Periodic. Init is called once
   * at the start, and Periodic is called continuously every .02 seconds, so you should think
   * of it as the body of a loop.
   * THe Robot methods is called unconditionally, while the rest are called only during their 
   * respective mode.
   * 
   * To put this code on the robot, connect to the robot via Wifi and then run "Deploy Robot Code" 
   * through the command palette.
   * 
   * If you connect to the robot and start "RioLog" through the command palette, you can see
   * what you print out and any errors you may have.
   */
  @Override
  public void robotInit() {
    System.out.println("I execute when the robot turns on");
  }

  @Override
  public void robotPeriodic() {
    System.out.println("I execute every .02s while the robot is on");
  }

  /*
   * If you want to activate autonomous mode or teleop mode, you will need to connect to the robot, open
   * Driver Station, choose the mode you want, and then enable the robot.
   */


  /*
   * In FRC, motors have 2 parts - the motor and a speed controller.
   * If were to just plug the motor directly into the Power Distribution Panel, the motor
   * would use as much voltage as it can and spin full throttle. Between the motor and the PDP,
   * we put a speed controller. We are able to change how much voltage the speed controller "lets through
   * it" in order to control the speed of the motor.
   */
  private final int CAN_ID = 1;
  private final WPI_TalonSRX speedController = new WPI_TalonSRX(CAN_ID);
  /*
   * Every speed controller is on the CAN bus, which connects it to the roboRio. We then use the CAN bus
   * to send instructions from the code to the speed controllers. We need to be able to differentiate stuff on
   * the CAN bus, so we give each device an ID.
   * This code currently uses the Talon with the id 1, but I can't guarantee that there is a motor on the robot you
   * are using with the CAN ID 1, so you need to open Phoenix Tuner, which you should have gotten from the Cross
   * the Road Electronics website. If you go to the "CAN Devices" tab, it will show you every device, their name, and
   * their ID.
   */
  @Override
  public void autonomousInit() {
    System.out.println("I execute when you start autonomous mode");
  }
  @Override
  public void autonomousPeriodic() {
    System.out.println("I execute every .02s while autonomous mode is active");
    speedController.set(.1);
    /*
     * This takes a double from -1 to 1. 1 means it will use 100% of its voltage and -1 means it will
     * use 100% of its voltage, but in the negative (reverse) direction.
     * Voltage is proportional to speed, so this code will make the motor run at 1/10th of its
     * maximum speed.
     */
  }


  /*
   * Joysticks are given their IDs in the order you plug them in. The first one you plug
   * in has the ID 0, the second one is ID 1, and so on.
   */
  private final int JOYSTICK_ID = 0;
  private final Joystick joystick = new Joystick(JOYSTICK_ID);
  @Override
  public void teleopInit() {
     System.out.println("I execute when you start teleop mode");
  }

  /*
   * If you go to the USB tab in driver station (4th tab), you can see the output of the USB devices.
   * During teleop, the robot will make the speed of the motor the y axis of the joystick. If button 1
   * (trigger on flight stick, A button on xbox controller) is pressed, the motor will turn off.
   */
  @Override
  public void teleopPeriodic() {
    System.out.println("I execute every .02s while teleop mode is active");
    System.out.println("Y Axis: " + joystick.getY());
    System.out.println("Button Pressed: " + joystick.getRawButton(1));
    // Every .02s, it will find the Y axis, and then set the speed to that
    double speed = joystick.getY();

    if (joystick.getRawButton(1)) { // getRawButton is a boolean method that returns true if it is pressed, false otherwise
      speed = 0;
    }

    speedController.set(speed);

    /* This is wrong!
    while (true) {
      double speed = joystick.getY();

      if (joystick.getRawButton(1)) {
        speed = 0;
      }

      speedController.set(speed);
    }
    * This whole method is like the body of a loop. You should not be making the loop yourself.
    * Period methods should also end as fast as possible, so you don't want to slow it down
    * with loops! Period methods need to end, or else the program will break!
    */
  }

}
