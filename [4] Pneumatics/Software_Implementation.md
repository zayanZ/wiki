# Software Implementation

Hopefully you've read about how pneumatics works. Knowing this will aid you when debugging code and trying to figure out why something controlled by pneumatics is not working (Build team screws up too, contrary to popular belief).

- [Pneumatics Control Module (PCM)](#Pneumatics-Control-Module)
- [Solenoid](#Solenoid)
  - [Objects](#Solenoid-Objects)
  - [.get() and .set()](#.get()-and-.set())
- [DoubleSolenoid](#DoubleSolenoid)
  - [Objects](#DoubleSolenoid-Objects)
  - [.get() and .set()](#.get()-and-.set(Value))
  - [Gear Shift](#Gear-Shift)
- [Former Director Comments](#Former-Director-Comments-(only-edit-if-you-are-a-current-director))

## Pneumatics Control Module

The Pneumatics Control Module (PCM) is a board which lets us control our pneumatic devices. The PCM has its own specialized CAN ID, and has PCM IDs aboard it. Typically, you'll only see 0 and 1, used however there may be more channels if the robot contains more pneumatic devices.

## Solenoid

[Official Documentation](https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/Solenoid.html)

### Solenoid Objects

`private final Solenoid solenoid = new Solenoid(PCM_ID, CHANNEL)`

This is how a Solenoid object is constructed. The PCM ID is required, which can be attained either from looking at the roborio or (more commonly) the Phoenix Tuner software. After this, the channel which the solenoid is plugged into is asked.

### .get() and .set()

`solenoid.get()`

Returns the current status of the Solenoid, true is on, false is off.

`solenoid.set(boolean turnOn)`

The boolean parameter turns the solenoid on or off.

## DoubleSolenoid

[Official Documentation](https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/DoubleSolenoid.html)

### DoubleSolenoid Objects

`private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM_ID, FORWARD_CHANNEL, REVERSE_CHANNEL)`

This is how a DoubleSolenoid object is constructed. The PCM ID is required, which can be attained either from looking at the roborio or (more commonly) the Phoenix Tuner software. After this, the forward and reverse channels are asked for. The IDs here indicate which channel lets air go in, and the other out.

### .get() and .set(Value)

`piston.get()`

Returns the current status of the DoubleSolenoid, according to the `Value` enum. `Value` contains the following: `kOff`, `kForward`, `kReverse`. kOff turns off the solenoid, kForward puts it into the forward position, and kReverse the reverse position. Reverse will deactivate the solenoid's movement and return to the base position.

`piston.set(Value.Values)`

Where values is an item in the Value enum.

### Gear Shift

This topic is covered more in the following lesson, but the gist is that many times we use a pneumatic system to setup our robot's gear shifting functionality. This gives us the ability to swap between a fast and slow mode for the robot, and you can learn more about it in the following lesson. This is only one application for pneumatics, however this is the most consistent usage across years.

<hr>

If you'd like to see more examples of pneumatics (in a robot which doesn't cause suffering), check out [Power Up's Code](https://github.com/frc3624/power-up/tree/master/src/main/java/frc/robot). Many subsystems and commands for that robot relied on pneumatics.

## Former Director Comments (only edit if you are a current director)
