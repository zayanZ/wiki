# How to use

This is supposed to be a real life version of this [PID simulator](https://sites.google.com/site/fpgaandco/pid)
The position the robot is at when it is enabled is its target position.  Move joystick 1 (left joystick on an xbox controller, the joystick itself on a flight stick) up and down  to move the robot forwards and backwards. Once you let go of the joystick, the robot will return back to its target position using PID.
You can press button 1 (A button/trigger) to set the current position as the target position.

Shuffleboard has a PID tab where you can change the PID values while the robot is on, or you can change the PID variables in the Robot class if you can't get Shuffleboard working.

# Arduino Demo

We also have an Arduino based PID demo which I (Haadi) have. It's pretty basic, and its function is to show a stripped down and basic PID system in real life. If you would like to see it, you can either ask me, or if you would just like to see the source code, refer to this [repository](https://github.com/Haadi-Khan/Arduino-PID-Demo).
