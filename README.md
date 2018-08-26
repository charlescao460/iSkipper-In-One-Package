iSkipper-In-One-Package
=======================
An integration of Arduino and RFM69HW for iClicker emulation.
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/iSkipper.Ver.2.0.2.jpg)

Versions
----
For the hardwares, there are currently two available versions: ***Ver.1.0.2*** and ***Ver.2.0.2***. (The Ver.1.0.0-1.0.1, Ver.2.0.0-2.0.1 are not perfectly useable).

The softwares should be compatible with all versions of hardwares.

### Ver.2.0.2
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/iSkipper.Ver.2.0.2.Top.Preview.png)
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/iSkipper.Ver.2.0.2.Bottom.Preview.png)


**Size:** 50mm x 26mm (including USB connector), 35mm x 26mm (without USB connector)

**MCU:** ATmega328P-MU (QFN-32)

**USB to Serial:** CH340E (MSOP-10)

**RF:** RFM69HW

**Level-shifting:** TXB0106RGYR (VQFN-16)

**3.3V power supply:** LP5907MFX-3.3 (SOT23-5)

**Antenna:** patch antenna (theoretically 3dbi gain)

**Resistors/Capacitors:** 0603


The Ver.2.X.X version is designed to minimize board's size, maximize portability and invisibility. Thus, the possibly smallest packages are selected. For example, the patch antenna, QFN-packaged chips, 0603 Resistors/Capacitors are used. Although it still practicable to solder it manually, it would be hard to do so without solder paste. Besides, you would need to burn Arduino's bootloader into ATmega328P-MU before soldering. Burning bootloader would require a QFN-32 dock, or other additional cost.

There are four holes on the board reserved for case installing. If you are going to use screws to install Acrylic case, please notice that the metal screws near the patch antenna would influence antenna's performances.


### Ver.1.0.2
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/iSkipper.Ver.1.0.2.Top.Preview.png)
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/iSkipper.Ver.1.0.2.Bottom.Preview.png)

**Size:** 90mm x 26mm (with connectors), 68mm x 26mm (without connectors)

**MCU:** ATmega328P-AU (QFP-32)

**USB to Serial:** CH340G (SOP-16)

**RF:** RFM69HW

**Level-shifting:** None (but it still work)

**3.3V power supply:** LM1117-3.3 (SOT223) (AMS1117 is also selectable)

**Antenna:** external antenna (with SMA connector)

**Resistors/Capacitors:** 1206

The Ver.1.X.X version is the first design of this project. It is basically a combination of Arduino Nano and RFM69HW. The original goal of this design is make it to be easy-manufactured. Thus, all components are big enough to solder with the normal soldering equipments and materials.

Some useful pin headers are reserved for burning bootloader or debugging. 

This version requires external antenna for better RF performance. The high-gain antennas would improve receiving performances. However, the overall size of this board would then be very big. (And if you are using this in public, the flaring LEDs and long antenna would catch everyone's eyes:) 


Cost of Materials
----
(In the Chinese Market)

$0.87 Atmega328P-MU (Need to burn Arduino bootloader before soldering)

$1.72 RFM69HW

$0.27 CH340G

$0.59 TXB0106RGYR

$0.23 LP5907MFX-3.3 

$0.56 PCB

$0.5 Connectors, capacitors, oscillators, resistors.

$FREE Manual soldering 

Total: $4.74 (9.5% of the expensive iClicker2)

Notes
------
ATmega328P is working on 5 voltage, but RFM69HW requires 3.3 voltage. However, shockingly, they are stable and durable in daily use.

Update 2018/07/06: In Ver.2.0.0 design, I added a TXB0106 for level-shifting. So the logic level won't be a problem anymore. But I am still wondering why RFM69HW could work proper under 5.0V. To save money, you could still consider remove TXB0106 in your own disign. 
