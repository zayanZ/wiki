## Encoders

Encoders are a type of sensor which are integrated within our motors, but we'll still cover them briefly here.

Say you're given a motor, and you want to make it turn 5 centimeters. How would you do that? The motor has no way of determining how far it has gone and there's no real way to find this using the motor alone. This is where encoders come into play.

An encoder's job is to keep track of how far the motor has traveled, sending a signal whenever its position changes, which we can record as an increase or decrease for the position of the motor. This is done by the encoder rotating and detecting a change. It has two channels, and when used in conjunction, we can see which channel is "leading", indicating the direction of the motor.

[<img src="https://docs.wpilib.org/en/stable/_images/encoding-direction.png" width="500"/>](https://docs.wpilib.org/en/stable/_images/encoding-direction.png)

There are several types, but magnetic encoders tend to be common. Here's a picture of one:

[<img src="https://docs.wpilib.org/en/stable/_images/ctre-magnetic-encoder.png" width="250"/>](https://docs.wpilib.org/en/stable/_images/ctre-magnetic-encoder.png)
