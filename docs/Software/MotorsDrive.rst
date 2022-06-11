Motors
======

This section of the wiki is arguably the most important of the sections, and thankfully is also one of the simplest. Motor control and drive are not hard topics, and are rather simple to implement.

When we talk about motor control, we're talking about how our code interacts with the motor controllers which are wired up to the motors. 

CTRE has its own `documentation <https://docs.ctre-phoenix.com/en/latest/index.html>`_ which I'd suggest checking out, and this moreso serves for a basic usage of motors.

CTRE Motor Control
------------------

`Official Documentation <https://www.ctr-electronics.com/downloads/api/java/html/classcom_1_1ctre_1_1phoenix_1_1motorcontrol_1_1can_1_1_base_motor_controller.html>`_

Motor Objects
^^^^^^^^^^^^^

``private final WPI_TalonFX motor = new WPI_TalonFX(CAN_ID)``

``private final WPI_TalonSRX motor = new WPI_TalonSRX(CAN_ID)``

Typically you'll see the former for newer robots, and the latter for the older ones. The former is for Falcons and the latter for Talons.

Controlling
^^^^^^^^^^^

Controlling a single motor with software is rather simple to do. All that's required is the following:

``motor.set(ControlMode.PercentOutput, speed)``

This method does what it says, not much to it. Given a speed between 0-1 (which are the values given by joysticks) the motor will set itself at a speed according to that value as a percentage.

This method can also be used with other ControlModes which can be seen in full `here <https://www.ctr-electronics.com/downloads/api/java/html/enumcom_1_1ctre_1_1phoenix_1_1motorcontrol_1_1_control_mode.html#ab4de63991da4d77be1719fd41d0e8035>`_. However, most use cases will most likely use the above method.


As for controlling a singular motor, the process is similar, just using the respective method you created to activate the motor. You might also want to add a line in the ``end()`` method calling the aforementioned method to power off the motor (typically just by passing a 0 as a parameter).
