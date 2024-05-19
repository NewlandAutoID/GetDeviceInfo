> The program is used to obtain the serial number and other information through sysfs. After the Android 10 version, the third-party APP cannot obtain the serial number, Bluetooth, WIFI address, etc. through the standard interface.

| Sys节点                                        | 含义                            |
| -------------------------------------------- | ----------------------------- |
| /sys/bus/platform/devices/newland-misc/WIFI  | WIFI MAC<br>e4:82:3f:01:ea:17 |
| /sys/bus/platform/devices/newland-misc/BT    | BT MAC<br>e4:82:3f:01:d7:fe   |
| /sys/bus/platform/devices/newland-misc/IMEI1 | IMEI1                         |
| /sys/bus/platform/devices/newland-misc/IMEI2 | IMEI2                         |
| /sys/bus/platform/devices/newland-misc/MEID  | MEID                          |
| /sys/bus/platform/devices/newland-misc/SN    | SN                            |
| /sys/bus/platform/devices/newland-misc/OEMID | Asset code                          |

| 名称                   | 含义       |
| -------------------- | -------- |
| androidboot.serialno | SN       |
| androidboot.oemid    | Asset code     |
| androidboot.wifimac  | WIFI MAC |
| androidboot.btmac    | BT MAC   |
| androidboot.imei1    | IMEI1    |
| androidboot.imei2    | IMEI2    |
