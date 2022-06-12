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