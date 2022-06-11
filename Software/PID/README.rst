
What is PID?
============

With speed controllers, we are only able to control how much voltage we let the motor use. Normally, we are not able to make the motor turn a specified distance or rotate at some velocity, but some really smart guy invented encoders. Encoders are sensors that can see how much the motor rotated. We can plug the readings of the encoder into a funky formula, and if you want to bring the motor to some position, it will calculate the speed of the motor, and if you want to bring the motor to some velocity, it will calculate the acceleration of the motor.

The specifics of the equation don't really matter (I hope...), but what does matter is what you control - kP, kI, and kD.
You can see the effect of changing each one `here <https://www.youtube.com/watch?v=fusr9eTceEo&list=WL&index=2&t=0s>`_.
You can experiment with the values using an online simulator, with `this one being my favorite <https://sites.google.com/site/fpgaandco/pid>`_.

In the second example, I got P=10, I=0, D=4. It doesn't have to be like my PID at all, as long as the car doesn't overshoot the target, oscillate that badly, or get critically damped.
You may want different PIDs depending on what you are doing. You may want to tailor your PID to small changes or large changes depending on how the motor is going to be used.
If you look at the car parameters section, there is "motor force limit(N)". This limits how fast the car can accelerate. In real life, this may be a physical limit of the motor or you, the programmer, could have put a limit on how fast it accelerate in the code.

If you are interested in learning more about the equation, I found `this resource <http://robotsforroboticists.com/pid-control/>`_ very helpful because not only does it give a good explanation, but it also gives you the code version of the formula.
