PID Overview
============

These lessons primarily are a text summary of the PID series by Matlab and serve to inform our team members on PID Control.
If you have any questions on a specific lesson, go to the corresponding video number in `this playlist <https://www.youtube.com/playlist?list=PLn8PRpmsu08pQBgjxYFXSsODEF3Jqmm-y>`_.

These notes are best read alongside the videos, acting as supplemental notes to help you focus on the important details, but I am aware that the majority of people will just read the notes and nothing more. If you want to gain as much as possible from these notes, it's best to watch the videos alongside, but if you choose not to it's up to you.

Note: These are more for understanding how this control system functions, and less so implementation. There will be no code examples through these files, moreso to understand the theory and how each part works so it is easier to figure out how to optimize and tune our systems for the robot.

What is PID?
------------
With speed controllers, we are only able to control how much voltage we let the motor use. Normally, we are not able to make the motor turn a specified distance or rotate at some velocity, but some really smart guy invented encoders. Encoders are sensors that can see how much the motor rotated. We can plug the readings of the encoder into a funky formula, and if you want to bring the motor to some position, it will calculate the speed of the motor, and if you want to bring the motor to some velocity, it will calculate the acceleration of the motor.

The specifics of the equation don't really matter (I hope...), but what does matter is what you control - kP, kI, and kD.
You can see the effect of changing each one `here <https://www.youtube.com/watch?v=fusr9eTceEo&list=WL&index=2&t=0s>`_.
You can experiment with the values using an online simulator, with `this one being my favorite <https://sites.google.com/site/fpgaandco/pid>`_.

In the second example, I got P=10, I=0, D=4. It doesn't have to be like my PID at all, as long as the car doesn't overshoot the target, oscillate that badly, or get critically damped.
You may want different PIDs depending on what you are doing. You may want to tailor your PID to small changes or large changes depending on how the motor is going to be used.
If you look at the car parameters section, there is "motor force limit(N)". This limits how fast the car can accelerate. In real life, this may be a physical limit of the motor or you, the programmer, could have put a limit on how fast it accelerate in the code.

If you are interested in learning more about the equation, I found `this resource <http://robotsforroboticists.com/pid-control/>`_ very helpful because not only does it give a good explanation, but it also gives you the code version of the formula.


Basic Diagram
-------------


.. image:: img/pid/Basic_PID_Diagram.jpg
   :target: img/pid/Basic_PID_Diagram.jpg
   :alt: Diagram


Vocabulary
----------

**Plant**\ : System we want to control

**Actuating Signal**\ : input into plant

**Controlled Variable**\ : output of the plant

**Commanded Variable**\ : Desired output of the plant

**Feedback Path**\ : output of the system is fed back and compared to command

**Error Term**\ : Difference between Controlled and Commanded Variable (Desired Value is 0)

**PID Controller**\ : Controller used to combat error term and drive it to 0

PID Meaning
-----------

Proportion
^^^^^^^^^^


* Used to reach an error term of 0 by multiplication of a constant factor
* Gives a magnitude to combat error and approach commanded variable
* In many cases solely a proportional controller works
* Sometimes leaves an error (known as steady state error) which requires the use of an integrator

Integral
^^^^^^^^


* Used to combat steady state error
* Keeps track of past information and has a memory of sorts
* Its job is to combat the error by summing the past errors
* A steady state error is a non zero constant value, and when that is integrated, a linear term appears for the integrator
* Once a steady state error is reached, the proportional path does nothing
* The path may cause oscillation, which requires the use of a derivative path

Derivative
^^^^^^^^^^


* Used to combat oscillation
* Measures the rate of change of the error and determines how we are approaching the goal
* Prematurely alters the rate of change to prevent overshooting

Advanced Integrators
--------------------

Vocabulary
^^^^^^^^^^

Plants can be broken into two fundamental parts:

**Actuator**\ : Devices generating force/energy to change the system (ex. motor, heater, etc.)

**Process**\ : Part the actuator is trying to impact

**Saturation**\ : the mechanical limit of an actuator which can not be overrided (ex. max rpm of a motor)

Actuators
---------

Actuators are not perfect linear systems in the real world. One major error is saturation.

In a motor with a PID controller, the PID controller is fed a constant error and in turn produces an increasing term. This term will cause the rpm of the motor to increase indefinitely to satiate what the controller asks for, however, it refuses to because the motor has a physical rpm limit, say 4000 rpm. Once it reaches 4000 rpm, it will flatline and will no longer increase, and will instead stay at a constant rpm.

All non linear actuators suffer from saturation, and all real life systems are non linear.

Integral Windup
^^^^^^^^^^^^^^^

.. image:: img/pid/Integral_Windup.jpg
   :target: img/pid/Integral_Windup.jpg
   :alt: Integral Windup due to saturation


In the diagram above, the motor saturates at 1000 rpm, however the integral controller wants the motor to speed up to 2000 rpm.

The motors are restricted by a human who prevents the motor from moving the process to the target destination. The motor saturates and remains at a constant 1000 rpm. Once it saturates, it remains stuck for a short period of time until the human releases the plant and it moves to the target destination.

However, once it it let go, the error barrels towards 0 and the integral term rapidly decelerates with one major problem: the rpm of the integral controller and the motor itself do not align. This causes integral windup to occur, causing the motor to overshoot the target and go far beyond it until it can recalibrate itself and is within the bounds of the integral controller once more. We combat this with an integrator windup limit.

Three popular methods to combat integral windup are: Clamping, Back-Calculation, and the Observer Approach. We will discuss Clamping.

Clamping
^^^^^^^^


.. image:: img/pid/Clamping_Diagram.jpg
   :target: img/pid/Clamping_Diagram.jpg
   :alt: Clamping Diagram


Don’t be afraid of this diagram because it’s simpler than it seems. A quick summary is:


* 
  We implement a clamping saturation limit and works by turning the integrator off

* 
  It performs two checks:


  * First it compares the output before and after the saturation check. If they’re equal, a 0 is passed, and if they’re not equal, a 1 is passed
  * Secondly, it compares the signs of the controller output and the error. If they’re both positive, then that means the integrator is still adding to the output. If they’re both negative, then the integrator is making the output more negative.

* 
  If both conditions are true, then the switch is triggered and clamps the * integrator and the value immediately decreases.

* 
  Clamping can help to make a PID controller perform better

Do not set the integrator limit equal to the hardware limit, instead keep it slightly lower to account for fluctuations like mechanical fault or temperature changes.
