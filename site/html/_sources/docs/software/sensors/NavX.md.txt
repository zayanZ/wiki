## NavX IMU

### MotionSensor Class

It's good practice to define this sensor as its own class so we have more flexibility in the event we swap out the sensor with something else. It should be in the subsystems folder, but remove the `extends SubsystemBase`.

Alongside this, be sure to add the library by doing the following:

- Go to VSCode and press Ctrl + Shift + P
- Search "WPILib: Manage Vendor Libraries", and select "Install New Libraries (Online)"
- Input https://www.kauailabs.com/dist/frc/2022/navx_frc.json 

Now that this class has been created, you must create methods to access readings from the sensor. Just copy the methods from the sensor's class and make methods which return that information. This may seem pointless, but offers us more flexibility in the event we want to change a sensor.