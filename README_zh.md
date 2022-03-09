> 程序用于获取系统通过sysfs 节点获取序列号等信息，由于Android10之后版本第三方APP无法通过标准接口获取序列号、蓝牙、WIFI地址等



| Sys节点                                        | 含义                            |
| -------------------------------------------- | ----------------------------- |
| /sys/bus/platform/devices/newland-misc/WIFI  | WIFI MAC<br>e4:82:3f:01:ea:17 |
| /sys/bus/platform/devices/newland-misc/BT    | BT MAC<br>e4:82:3f:01:d7:fe   |
| /sys/bus/platform/devices/newland-misc/IMEI1 | IMEI1                         |
| /sys/bus/platform/devices/newland-misc/IMEI2 | IMEI2                         |
| /sys/bus/platform/devices/newland-misc/MEID  | MEID                          |
| /sys/bus/platform/devices/newland-misc/SN    | SN                            |
| /sys/bus/platform/devices/newland-misc/OEMID | 资产编码                          |



| 名称                   | 含义       |
| -------------------- | -------- |
| androidboot.serialno | SN       |
| androidboot.oemid    | 资产编码     |
| androidboot.wifimac  | WIFI MAC |
| androidboot.btmac    | BT MAC   |
| androidboot.imei1    | IMEI1    |
| androidboot.imei2    | IMEI2    |
