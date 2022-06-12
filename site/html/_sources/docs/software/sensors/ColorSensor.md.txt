## Color Sensor

### Color Sensor Objects

`private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.Onboard)`

`private final ColorMatch colorMatcher = new ColorMatch()`

The first object is the actual sensor object. This enables us to read from the sensor. However, the sensor only can return RGB values, and these values are subject to change based on light levels or general inaccuracies. This is why the second object is required, which checks to see if the provided RGB value is "close enough" to another relevant value.

### Usage

In order to use the color sensor, use `colorSensor.getColor()`. This returns the RGB value it currently sees as a Color object. After this, create a local Color Object which is equal to `colorMatcher.matchClosestColor(currentColor).color`.

Now if you want to check if the current color is a desired color, you can simply compare using == in a conditional argument.