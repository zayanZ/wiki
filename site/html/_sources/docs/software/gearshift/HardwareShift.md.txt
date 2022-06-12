## Hardware Shift

In order to utilize gear shift, you must create a subsystem and a command. Within the subsystem, you must create a DoubleSolenoid object (for information on what a double solenoid exactly is, consult [this](../../hardware/Pneumatics.md). Along with this, you must create a method to set/toggle the gears (preferably toggle as there will most likely only be 2 gears using this style of gear shifting).

This style of gear shifting will most commonly be used on simpler robot designs. The more complex the robot becomes, the harder it is for build to utilize the pneumatics required for the gear shifting. Usually this style will be used (as it has been the main style throughout our team's history) but it may not be used if the robot design gets too complex.

### When to Implement

This style will most likely be decided entirely by build. It is mostly dependent on the pneumatic setup and how it will interact with the rest of the robot, along with other factors build has to take into account. Luckily, this is a simple style to implement into the code.