package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all.
 * Unless you know what you are doing, do not modify this file except to
 * change the parameter class to the startRobot call.
 */
public final class Main {
  private Main() {
  }

  /**
   * Hey... you shouldn't be here...
   * 
   * I know you are used to putting code in the main method, but with WPILib, we don't do that
   * All the main method here does is make the code in the Robot class run. You shouldn't ever
   * have to touch code in the generated Main classes. Just look at the comment above the class.
   * That sounds really scary and it's there by default...
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
    /*
     * In case you are curious about what's happening over here, :: means this is referring to the method.
     * The method itself is being passed as a parameter. In this case Robot::new, the default constructor
     * for a Robot, is being treated as a method that returns a Robot.
     */
  }
}
