iSkipper-In-One-Package
=======================
An Atmega328P-MU, a RFM69HW, a CH340E,and a patch antenna on one PCB.
![](https://github.com/charlescao460/iSkipper-In-One-Package/blob/master/pics/Ver2.0.0.Small.Size.jpg)

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
