
Cross the Road Electronics (CTRE) Controllers
=============================================


* `Single Motor <#Single-Motor-Control>`_

  * `Objects <#Motor-Objects>`_
  * `Control <#Controlling>`_

* `Differential Drive <#Differential-Drive>`_

  * `Objects <#DiffDrive-Objects>`_
  * `Master/Slave <#Master/Slave>`_
  * `arcadeDrive() <#arcadeDrive(>`_\ )

* `Commands <#Commands>`_
* `Former Director Comments <#Former-Director-Comments-(only-edit-if-you-are-a-current-director>`_\ )

Single Motor Control
--------------------

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

Differential Drive
------------------

`Official Documentation <https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html>`_

DiffDrive Objects
^^^^^^^^^^^^^^^^^

``private final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster)``

Say you wanted to control two motors in unison, say to move a robot. In order to calculate the turning angles and anything else which would be required, you would have to do a bunch of trigonometry and other things. Differential Drive takes care of that work and makes it into a convenient class with a ``DifferentialDrive`` object.

Master/Slave
^^^^^^^^^^^^

This works great if we only have 2 motors, however our robots tend to have 4 motors for our wheels. So what do we do now? We use a master/slave relationship, which does the following. Motor A is given instructions on how to move from a joystick. Motor B is set to follow Motor A, and does the same. This achieved by the following method:

Falcon: ``slave.follow(master)``

Talon: ``slave.set(ControlMode.Follower, MASTER_CAN_ID)``

Where ``master`` and ``slave`` are both motor objects.

Place these lines in the Drive class's constructor.

arcadeDrive()
^^^^^^^^^^^^^

We're almost done with our Drive class. All that's left is to create a method to actually do something with our motor objects. This is where the arcadeDrive method comes in. ``arcadeDrive()`` is a method from the ``DifferentialDrive`` class, and we use it to control our motors. We tend to create a method called ``arcadeDrive()`` in the Drive class just for consistency. The implementation should look like this:

.. code-block:: java

   public void arcadeDrive(double xSpeed, double zRotation) {
       diffDrive.arcadeDrive(xSpeed, zRotation);
   }

It's a rather simple method and makes it so the method can be called from a command.

Commands
--------

In order to utilize the Drive subsystem for the robot, you must create a command for it. Typically it'll be called DriveTrain or JoystickDrive. You must create a Drive object, as well as an object for your controller, whether it be a joystick or an Xbox controller, and set them as fields for the class. Follow standard procedure in the constructor, preferably using ``this.``\ , and include ``addRequirements(drive);`` at the bottom of the contructor. ``addRequirements()`` is used to declare subsystem dependencies.

Typically for Drive, the only method you have to edit is the ``execute()`` method. Inside of it, call the ``arcadeDrive()`` in the following manner:

Xbox Controller:

.. code-block:: java

       @Override
       public void execute() {
           drive.arcadeDrive(-shootStick.getY(Hand.kLeft), shootStick.getX(Hand.kRight));
       }

Joysticks:

.. code-block:: java

       @Override
       public void execute() {
           drive.arcadeDrive(-joystick.getY(), joystick.getX());
       }

The negation of certain parameters depends mostly on the specific use case. Sometimes the controllers will have a swapped direction than desired.

As for controlling a singular motor, the process is similar, just using the respective method you created to activate the motor. You might also want to add a line in the ``end()`` method calling the aforementioned method to power off the motor (typically just by passing a 0 as a parameter).

Former Director Comments (only edit if you are a current director)
------------------------------------------------------------------
