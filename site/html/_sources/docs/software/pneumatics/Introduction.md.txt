# Introduction

Hopefully you've read about how pneumatics works from the hardware section. Knowing this will aid you when debugging code and trying to figure out why something controlled by pneumatics is not working (Build team screws up too, contrary to popular belief).

## Pneumatics Control Module

The Pneumatics Control Module (PCM) is a board which lets us control our pneumatic devices. The PCM has its own specialized CAN ID, and has PCM IDs aboard it. Typically, you'll only see 0 and 1, used, however there may be more channels if the robot contains more pneumatic devices.

## Examples

If you'd like to see more examples of pneumatics (in a robot which doesn't cause suffering), check out [Power Up's Code](https://github.com/frc3624/power-up/tree/master/src/main/java/frc/robot). Many subsystems and commands for that robot relied on pneumatics.