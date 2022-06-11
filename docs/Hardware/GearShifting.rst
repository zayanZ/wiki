Gear Shifting
=============

What is Gear Shifting
---------------------

When creating a robot, we want to be able to change its speed. In order to change its speeds, we need to be able to shift between a "low gear", a "high gear", and occasionaly an extra "gear", similar to a car.

For more info on how it works, refer to `this <Hardware_Aspects.md>`_ for hardware aspects and `this <Software_Implementation.md>`_ for how to implement it in our code.

Why do we use Gear Shifting
---------------------------

When driving the robot, we want to have the ability to adjust our speed to best suit our current scenario, whether we’re trying to score, helping an ally team, or simply move around. Gear Shifting enables us to change our speed (along with our resistance to moving to an external force, say another robot crashing into us) while we play a game. It’s an incredibly useful tool for us when we’re trying to properly move around and it’s a relatively simple thing to implement.


.. image:: https://www.researchgate.net/profile/Aghil-Yousefi-Koma/publication/267488568/figure/fig4/AS:324268555554818@1454323056198/schematic-of-the-rear-pulley-in-two-states-low-gear-and-high-gear.png
   :target: https://www.researchgate.net/profile/Aghil-Yousefi-Koma/publication/267488568/figure/fig4/AS:324268555554818@1454323056198/schematic-of-the-rear-pulley-in-two-states-low-gear-and-high-gear.png
   :alt: 


This is what a gear box would look like without gear shifting and all that jazz.

First of all, what does high/low gear even mean? Gear refers to that circle thing with teeth. `The motor shaft goes directly into the driver pulley. The motor turns the driver pulley, and the driver pulley turns the driven pulley. <https://youtu.be/B1AJsUiJuQQ?t=60>`_ As the second gear gets bigger, the gear ratio gets bigger, it will lose speed, and it will gain torque/strength. The gear box has two driven gears that it can switch between. 


.. image:: https://image.shutterstock.com/image-vector/illustration-physics-bicycle-gearing-energy-260nw-1201835926.jpg
   :target: https://image.shutterstock.com/image-vector/illustration-physics-bicycle-gearing-energy-260nw-1201835926.jpg
   :alt: 


When in high gear mode, the gearbox will switch the driven gear to a big gear. Big gear -> higher gear ratio, low speed, high torque/stregth.
Likewise, in low gear, the gearbox will switch the driven gear to a small gear. Small gear -> lower gear ratio, higher speed, less torque/strength