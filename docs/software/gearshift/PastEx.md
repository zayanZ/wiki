## Past Code Examples

### **Solenoid Shift**

In a separate GearShift class, a DoubleSolenoid object must be created, similar to this:

```java
private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM_ID, GEARSHIFT_FORWARD_CHANNEL, GEARSHIFT_REVERSE_CHANNEL);
```

and an accompanying method to toggle/set gears. A potential `toggleGear()` method can be seen below:

```java
public void toggleGear() {
    if (gearPiston.get() == Value.kReverse)
        gearPiston.set(Value.kForward);
    else if (gearPiston.get() == Value.kForward)
        gearPiston.set(Value.kReverse);
    else
        gearPiston.set(Value.kReverse);
}
```

Note: Value.kOff also exists, it turns off the solenoid for either being set forward or backwards.

If you have any questions about the DoubleSolenoid class, here is the [documentation](https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/DoubleSolenoid.html) for the class.  

Finally, a command to toggle/set the gears must be created. This would be accomplished by calling the method in the `initialize()` method of a command.

This section is going to be more oriented towards reference material and less so explaining how it works, some code examples can help with the reference, and we could add some more in the future if you want. I think this is good enough since we shouldn't be giving exactly how to do it, but we're just giving some good reference material

### **Software Multipliers (Speed Shifting)**

The most barebones implementation of this technique is in this example below:

```java
public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(speedMultiplier * xSpeed, zRotation);
}
```

As seen in the [drive class](https://github.com/frc3624/infinite-recharge/blob/master/src/main/java/frc/robot/subsystems/Drive.java) for infinite recharge, we used an enum to create the multipliers for the `arcadeDrive()` method. {Maybe include some explanation as to wtf an enum is, I don't know if you want that here or in a future lesson} This enum enabled us to have 3 distinct speeds for the robot, so this implementation may be useful for further robots.

**NOTE:** If you are viewing the source code for the drive class prior to revisions of the code on GitHub, the 0.9x multiplier was added for the zRotation due to members of the Drive team wanting the robot to turn slightly slower and we never got around to making it obvious in the code why we did that.