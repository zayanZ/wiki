
FRC Documentation
=================

`This <https://docs.wpilib.org/en/latest/>`_ is the official documentation for WPILib. If you want to become gigantic-minded, I highly suggest you just look through it and find things that interest you. If you're not up to that, I compiled a list of pages which I think you should read.


* `Brownouts <https://docs.wpilib.org/en/latest/docs/software/roborio-info/roborio-brownouts.html>`_
* Command-based programming.
  At this point, you probably already know how to make subsystems and commands, and how to use them. I don't think you really know what purpose they serve from a design standpoint. When reading these pages, please carefully read the text at the top. That's the most important part of what they're trying to say.

  * `Subsystems <https://docs.wpilib.org/en/latest/docs/software/commandbased/subsystems.html>`_
  * `Commands <https://docs.wpilib.org/en/latest/docs/software/commandbased/commands.html>`_
  * `Command groups <https://docs.wpilib.org/en/latest/docs/software/commandbased/command-groups.html>`_
  * *****\ `Command Scheduler <https://docs.wpilib.org/en/latest/docs/software/commandbased/command-scheduler.html>`_\ **

* `Advanced Triggers <https://docs.wpilib.org/en/latest/docs/software/commandbased/binding-commands-to-triggers.html#binding-a-command-to-a-joystickbutton>`_.
  Note that you've only been working with JoystickButtons so far. Triggers are a much broader idea that when something happens, a command will run/stop. In your case, it has only been buttons being pressed, but now it can be readings on sensors, X seconds have passed in the game, or anything else that can be represented as a boolean.
