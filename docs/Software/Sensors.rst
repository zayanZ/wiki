
Sensors
=======================

So far in the lessons, we've been discussing moving parts of the robot which cause changes to the robot, whether it be its position in the field, the velocity of its motors, or the status of a solenoid. 

What about detecting a change in the robot? This is where sensors come in.

DigitalInput
------------

DigitalInput Objects
^^^^^^^^^^^^^^^^^^^^

``DigitalInput input = new DigitalInput(DIO_PIN)``

``DIO_PIN`` is the pin which the sensor is plugged into on the roboRIO.

.get()
^^^^^^

``input.get()``

Returns a boolean value corresponding to the sensor's status. Since it is a digital pin, it can only send readings of HIGH or LOW, a 1 or a 0. This is represented as a boolean.

For limit switches, the switch returns false when it's triggered and true when it's dormant. It's strange, but that's how it is.

NavX IMU
--------

MotionSensor Class
^^^^^^^^^^^^^^^^^^

It's good practice to define this sensor as its own class so we have more flexibility in the event we swap out the sensor with something else. It should be in the subsystems folder, but remove the ``extends SubsystemBase``.

Alongside this, be sure to add the library by doing the following:


* Go to VSCode and press Ctrl + Shift + P
* Search "WPILib: Manage Vendor Libraries", and select "Install New Libraries (Online)"
* Input https://www.kauailabs.com/dist/frc/2022/navx_frc.json 

Now that this class has been created, you must create methods to access readings from the sensor. Just copy the methods from the sensor's class and make methods which return that information. This may seem pointless, but offers us more flexibility in the event we want to change a sensor.

Color Sensor
------------

Color Sensor Objects
^^^^^^^^^^^^^^^^^^^^

``private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.Onboard)``

``private final ColorMatch colorMatcher = new ColorMatch()``

The first object is the actual sensor object. This enables us to read from the sensor. However, the sensor only can return RGB values, and these values are subject to change based on light levels or general inaccuracies. This is why the second object is required, which checks to see if the provided RGB value is "close enough" to another relevant value.

Usage
^^^^^

In order to use the color sensor, use ``colorSensor.getColor()``. This returns the RGB value it currently sees as a Color object. After this, create a local Color Object which is equal to ``colorMatcher.matchClosestColor(currentColor).color``.

Now if you want to check if the current color is a desired color, you can simply compare using == in a conditional argument.

Former Director Comments (only edit if you are a current director)
------------------------------------------------------------------
