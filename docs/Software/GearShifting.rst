.. role:: raw-html-m2r(raw)
   :format: html



Gear Shifting
=============

**Pneumatics**
^^^^^^^^^^^^^^^^^^

In order to utilize gear shift, you must create a subsystem and a command. Within the subsystem, you must create a DoubleSolenoid object (for information on what a double solenoid exactly is, consult `this <Hardware_Aspects.md>`_\ ). Along with this, you must create a method to set/toggle the gears (preferably toggle as there will most likely only be 2 gears using this style of gear shifting).

This style of gear shifting will most commonly be used on simpler robot designs. The more complex the robot becomes, the harder it is for build to utilize the pneumatics required for the gear shifting. Usually this style will be used (as it has been the main style throughout our team's history) but it may not be used if the robot design gets too complex.


**Software Multipliers**
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Software speed shifting works by applying a multiplier to the speed parameter in the ``arcadeDrive()`` method in our Drive subsystem. This should make sense since all software speed shifting does is slow down the motors for the robot.

The first time the team used software speed shifting was with the robot for Infinite Recharge which used Falcon 500s. These motors are incredibly powerful and incredibly fast, so a multiplier was used to simplify the building process and to simply adjust the speed of the robot.

After creating the method, create as many commands as necessary in the commands folder (most likely 1-3, depending if you want a toggle command, or buttons to switch between individual modes).


When to Implement Which Type
----------------------------

**Pneumatic Style** \
This style will most likely be decided entirely by build. It is mostly dependent on the pneumatic setup and how it will interact with the rest of the robot, along with other factors build has to take into account. Luckily, this is a simple style to implement into the code.

**Speed Multipliers** \
This style will also be decided by build for the same aforementioned reasons. It is slightly harder to implement in some cases if some members are unfamiliar with enums. However, it is still relatively simple, and has the added benefit of being a part of the Drive subsystem, and does not need to be a separate subsystem.

**NOTE:** DO NOT ADD MULTIPLIERS TO THE DRIVETRAIN / JOYSTICKDRIVE COMMAND, KEEP THE MULTIPLIERS TO THE DRIVE CLASS. This is more of an organization thing, not that your code will break. It makes more sense to put the multiplier in the Drive subsystem itself instead of the command.

Past Code Examples
------------------

**Solenoid Shift**
^^^^^^^^^^^^^^^^^^^^^^

In a separate GearShift class, a DoubleSolenoid object must be created, similar to this:

.. code-block:: java

   private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM_ID, GEARSHIFT_FORWARD_CHANNEL, GEARSHIFT_REVERSE_CHANNEL);

and an accompanying method to toggle/set gears. A potential ``toggleGear()`` method can be seen below:

.. code-block:: java

   public void toggleGear() {
       if (gearPiston.get() == Value.kReverse)
           gearPiston.set(Value.kForward);
       else if (gearPiston.get() == Value.kForward)
           gearPiston.set(Value.kReverse);
       else
           gearPiston.set(Value.kReverse);
   }

Note: Value.kOff also exists, it turns off the solenoid for either being set forward or backwards.

If you have any questions about the DoubleSolenoid class, here is the `documentation <https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/DoubleSolenoid.html>`_ for the class.  

Finally, a command to toggle/set the gears must be created. This would be accomplished by calling the method in the ``initialize()`` method of a command.

This section is going to be more oriented towards reference material and less so explaining how it works, some code examples can help with the reference, and we could add some more in the future if you want. I think this is good enough since we shouldn't be giving exactly how to do it, but we're just giving some good reference material

**Software Multipliers (Speed Shifting)**
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The most barebones implementation of this technique is in this example below:

.. code-block:: java

   public void arcadeDrive(double xSpeed, double zRotation) {
       diffDrive.arcadeDrive(speedMultiplier * xSpeed, zRotation);
   }

As seen in the `drive class <https://github.com/frc3624/infinite-recharge/blob/master/src/main/java/frc/robot/subsystems/Drive.java>`_ for infinite recharge, we used an enum to create the multipliers for the ``arcadeDrive()`` method. {Maybe include some explanation as to wtf an enum is, I don't know if you want that here or in a future lesson} This enum enabled us to have 3 distinct speeds for the robot, so this implementation may be useful for further robots.

**NOTE:** If you are viewing the source code for the drive class prior to revisions of the code on GitHub, the 0.9x multiplier was added for the zRotation due to members of the Drive team wanting the robot to turn slightly slower and we never got around to making it obvious in the code why we did that.

Advanced Usages
---------------

Now, you after learning about these two different techniques, you may want to use them in tandum. This in theory would seem like a way to have the best of both worlds, customizable speeds, and having a wonderful robot which will be amazing. This is stupid. 

There isn't much purpose to have the two types of shifting work alongside one another since it increses complexity greatly for the driver. While it may seem like a good idea at first, overall it's a bad idea due to the increased skill and coordination between drivers and the increased training for something that should be simple. Unless it's necessary for the robot in a edge case, using both styles alongside one another is not recommendable at all.

Former Director Comments
------------------------------------------------------------------

Kyle
^^^^

I am Kyle Bobert Diaz and I approve of this message.

Matt & Talha
^^^^^^^^^^^^

Year 2020-2021

Heyo Matt here, I just wanted to give a bit more insight/advice that will (hopefully) help any current/future nerds on this team.

**DO NOT BE CONFINED TO THE WIKI**\ - this lesson is just a guide for learning about the software aspects of gear shifting.\ :raw-html-m2r:`<br />`
This is not a rulebook that you *must* be absolutely confined to this, I'm guilty of doing this as well.\ :raw-html-m2r:`<br />`
Different situations need different implementations of code- **not one implementation** is always going to work! :raw-html-m2r:`<br />`
I know that this has been/will be mentioned on your time on software- it is still **important to realize**.

**ASK HARDWARE FOR HELP**\ - Face it, most of us on software don't know the difference between a nut and a bolt, less so than an entire gear shift system.\ :raw-html-m2r:`<br />`
Hardware isn't your enemy or anything, ask them for help! This can be crucial when understanding how a robot's gear shift works.

**CHECK PRESSURE IN COMPRESSOR**\ - sometimes the solenoid won't move like the way you want it to. This doesn't mean that it is your code is the problem (still check it anyway).\ :raw-html-m2r:`<br />`
Sometimes the compressor is not creating enough pressure for the solenoid to move- check out the wired connections to make sure it is properly working.

**USE PROPER NAMING**\ - make sure that you properly name your gears in the code (normal gear when drivine- driveGear, gear used when on defense- defenseDrive, etc).\ :raw-html-m2r:`<br />` 
Don't use names that don't tell the programmer anything (like g)- makes it harder to debug.
