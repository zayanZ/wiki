## Accelerometers

Accelerometers are sensors which measure acceleration. Sometimes they will be for only one dimension, but most commonly you'll see them as triple-axis accelerometers. These come in different shapes and forms, with some going through the analog in port, separate boards known as Inertial Measurement Units (IMUs), or the integrated accelerometer present in the roboRIO itself. Here are diagrams of some accelerometers:

[<img src="https://docs.wpilib.org/en/stable/_images/adxl193-single-axis-accelerometer-to-roborio.svg" width="250"/>](https://docs.wpilib.org/en/stable/_images/adxl193-single-axis-accelerometer-to-roborio.svg)
[<img src="https://docs.wpilib.org/en/stable/_images/triple-axis-accelerometer-to-roborio.svg" width="250"/>](https://docs.wpilib.org/en/stable/_images/triple-axis-accelerometer-to-roborio.svg)
[<img src="https://docs.wpilib.org/en/stable/_images/roborio-accelerometer.svg" width="300"/>](https://docs.wpilib.org/en/stable/_images/roborio-accelerometer.svg)
[<img src="https://docs.wpilib.org/en/stable/_images/navx-imu-to-roborio-mxp.svg" width="300"/>](https://docs.wpilib.org/en/stable/_images/navx-imu-to-roborio-mxp.svg)

We tend to use IMUs like the Kauai Labs NavX, seen on 2014's Aerial Assist robot.

One shortcoming of accelerometers is that they aren't very useful for other time derivatives of position such as displacement or velocity. This is due to their clock speed not enabling them to refresh fast enough. When their readings are integrated, we use a Riemann Sum so they fall short in regards to accuracy. For example, the NavX only updates 200 times a second, or .005 seconds. This may sound fast on paper, but a lot of movement can happen in that short time. If you don't understand calculus, basically the issue is that we use an already slightly inaccurate method for calculating the velocity/displacement when we start with acceleration. When we compound this with the time frame allowed, it results in a non ideal result for us.