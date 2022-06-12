## Software Shift

Software speed shifting works by applying a multiplier to the speed parameter in the `arcadeDrive()` method in our Drive subsystem. This should make sense since all software speed shifting does is slow down the motors for the robot.

The first time the team used software speed shifting was with the robot for Infinite Recharge which used Falcon 500s. These motors are incredibly powerful and incredibly fast, so a multiplier was used to simplify the building process and to simply adjust the speed of the robot.

After creating the method, create as many commands as necessary in the commands folder (most likely 1-3, depending if you want a toggle command, or buttons to switch between individual modes).

### When to Implement
This style will also be decided by build for the same aforementioned reasons. It is slightly harder to implement in some cases if some members are unfamiliar with enums. However, it is still relatively simple, and has the added benefit of being a part of the Drive subsystem, and does not need to be a separate subsystem.

**NOTE:** DO NOT ADD MULTIPLIERS TO THE DRIVETRAIN / JOYSTICKDRIVE COMMAND, KEEP THE MULTIPLIERS TO THE DRIVE CLASS. This is more of an organization thing, not that your code will break. It makes more sense to put the multiplier in the Drive subsystem itself instead of the command.