## DigitalInput

### DigitalInput Objects

`DigitalInput input = new DigitalInput(DIO_PIN)`

`DIO_PIN` is the pin which the sensor is plugged into on the roboRIO.

### .get()

`input.get()`

Returns a boolean value corresponding to the sensor's status. Since it is a digital pin, it can only send readings of HIGH or LOW, a 1 or a 0. This is represented as a boolean.

For limit switches, the switch returns false when it's triggered and true when it's dormant. It's strange, but that's how it is.