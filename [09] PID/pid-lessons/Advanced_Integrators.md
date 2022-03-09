# Advanced Integrators

## Vocabulary

Plants can be broken into two fundamental parts:

**Actuator**: Devices generating force/energy to change the system (ex. motor, heater, etc.)

**Process**: Part the actuator is trying to impact

**Saturation**: the mechanical limit of an actuator which can not be overrided (ex. max rpm of a motor)

## Actuators

Actuators are not perfect linear systems in the real world. One major error is saturation.

In a motor with a PID controller, the PID controller is fed a constant error and in turn produces an increasing term. This term will cause the rpm of the motor to increase indefinitely to satiate what the controller asks for, however, it refuses to because the motor has a physical rpm limit, say 4000 rpm. Once it reaches 4000 rpm, it will flatline and will no longer increase, and will instead stay at a constant rpm.

All non linear actuators suffer from saturation, and all real life systems are non linear.

## Integral Windup

![Integral Windup due to saturation](img/Integral_Windup.jpg)

In the diagram above, the motor saturates at 1000 rpm, however the integral controller wants the motor to speed up to 2000 rpm.

The motors are restricted by a human who prevents the motor from moving the process to the target destination. The motor saturates and remains at a constant 1000 rpm. Once it saturates, it remains stuck for a short period of time until the human releases the plant and it moves to the target destination.

However, once it it let go, the error barrels towards 0 and the integral term rapidly decelerates with one major problem: the rpm of the integral controller and the motor itself do not align. This causes integral windup to occur, causing the motor to overshoot the target and go far beyond it until it can recalibrate itself and is within the bounds of the integral controller once more. We combat this with an integrator windup limit.

Three popular methods to combat integral windup are: Clamping, Back-Calculation, and the Observer Approach. We will discuss Clamping.

## Clamping

![Clamping Diagram](img/Clamping_Diagram.jpg)

Don’t be afraid of this diagram because it’s simpler than it seems. A quick summary is:

* We implement a clamping saturation limit and works by turning the integrator off

* It performs two checks:
  * First it compares the output before and after the saturation check. If they’re equal, a 0 is passed, and if they’re not equal, a 1 is passed
  * Secondly, it compares the signs of the controller output and the error. If they’re both positive, then that means the integrator is still adding to the output. If they’re both negative, then the integrator is making the output more negative.

* If both conditions are true, then the switch is triggered and clamps the * integrator and the value immediately decreases.

* Clamping can help to make a PID controller perform better

Do not set the integrator limit equal to the hardware limit, instead keep it slightly lower to account for fluctuations like mechanical fault or temperature changes.
