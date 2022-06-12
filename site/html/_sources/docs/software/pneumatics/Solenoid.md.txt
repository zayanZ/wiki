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