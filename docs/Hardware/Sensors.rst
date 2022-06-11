.. role:: raw-html-m2r(raw)
   :format: html


Sensors
=======


* `Proximity Sensors <#Proximity-Sensors>`_
* `Encoders <#Encoders>`_
* `Accelerometers <#Accelerometers>`_
* `Gyroscopes <#Gyroscopes>`_

Proximity Sensors
-----------------

Proximity Sensors are an incredibly important set of sensors. Their job is to act as a switch to detect when something comes in range of the robot. There are many types of proximity switches, but we'll cover two common types:

Limit Switches are switches which activate when the button on them trigger from contact. They are especially useful when using a simple method to detect if an item has come in the path of the robot. You may see them used to prevent a motor from overextending.

`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/limit-switch-to-roborio.svg" width="250"/>` <https://docs.wpilib.org/en/stable/_images/limit-switch-to-roborio.svg>`_

Photoelectric switches are incredibly different from the former due to the fact they are contactless. Their job is to detect changes in light and tell the robot if the light levels pass a certain threshold.

`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/ir-digital-obstacle-sensor-to-roborio.svg" width="250"/>` <https://docs.wpilib.org/en/stable/_images/ir-digital-obstacle-sensor-to-roborio.svg>`_

Encoders
--------

Encoders are a type of sensor which are integrated within our motors, but we'll still cover them briefly here.

Say you're given a motor, and you want to make it turn 5 centimeters. How would you do that? The motor has no way of determining how far it has gone and there's no real way to find this using the motor alone. This is where encoders come into play.

An encoder's job is to keep track of how far the motor has traveled, sending a signal whenever its position changes, which we can record as an increase or decrease for the position of the motor. This is done by the encoder rotating and detecting a change. It has two channels, and when used in conjunction, we can see which channel is "leading", indicating the direction of the motor.

`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/encoding-direction.png" width="500"/>` <https://docs.wpilib.org/en/stable/_images/encoding-direction.png>`_

There are several types, but magnetic encoders tend to be common. Here's a picture of one:

`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/ctre-magnetic-encoder.png" width="250"/>` <https://docs.wpilib.org/en/stable/_images/ctre-magnetic-encoder.png>`_

Accelerometers
--------------

Accelerometers are sensors which measure acceleration. Sometimes they will be for only one dimension, but most commonly you'll see them as triple-axis accelerometers. These come in different shapes and forms, with some going through the analog in port, separate boards known as Inertial Measurement Units (IMUs), or the integrated accelerometer present in the roboRIO itself. Here are diagrams of some accelerometers:

`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/adxl193-single-axis-accelerometer-to-roborio.svg" width="250"/>` <https://docs.wpilib.org/en/stable/_images/adxl193-single-axis-accelerometer-to-roborio.svg>`_
`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/triple-axis-accelerometer-to-roborio.svg" width="250"/>` <https://docs.wpilib.org/en/stable/_images/triple-axis-accelerometer-to-roborio.svg>`_
`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/roborio-accelerometer.svg" width="300"/>` <https://docs.wpilib.org/en/stable/_images/roborio-accelerometer.svg>`_
`\ :raw-html-m2r:`<img src="https://docs.wpilib.org/en/stable/_images/navx-imu-to-roborio-mxp.svg" width="300"/>` <https://docs.wpilib.org/en/stable/_images/navx-imu-to-roborio-mxp.svg>`_

We tend to use IMUs like the Kauai Labs NavX, seen on 2014's Aerial Assist robot.

One shortcoming of accelerometers is that they aren't very useful for other time derivatives of position such as displacement or velocity. This is due to their clock speed not enabling them to refresh fast enough. When their readings are integrated, we use a Riemann Sum so they fall short in regards to accuracy. For example, the NavX only updates 200 times a second, or .005 seconds. This may sound fast on paper, but a lot of movement can happen in that short time. If you don't understand calculus, basically the issue is that we use an already slightly inaccurate method for calculating the velocity/displacement when we start with acceleration. When we compound this with the time frame allowed, it results in a non ideal result for us.

Gyroscopes
----------

The job of a gyroscope is to determine the rate of rotation of a robot. They are useful to stabilizer driving or to measure tilt of a certain object. These are typically used in conjunction with accelerometers. We tend to use the NavX (the purple board) shown before for gyro control.
