package com.nlscan.getinfoapplication

import android.bluetooth.BluetoothAdapter
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemProperties
import android.telephony.TelephonyManager
import com.nlscan.getinfoapplication.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        getDeviceInfo()
    }

    private fun getDeviceInfo() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val sb = StringBuilder()
            sb.append("get by SDK interface:\n")
            try {
                val serial = Build.getSerial()
                sb.append("Serial:$serial\n")
            }catch (e:Exception) {
                sb.append("Serial:get failed(${e.message})\n")
                e.printStackTrace()
            }
            try {
                val btMac = BluetoothAdapter.getDefaultAdapter().address
                sb.append("BluetoothMAC:$btMac\n")
            }catch (e: Exception) {
                sb.append("BluetoothMAC:get failed(${e.message})\n")
                e.printStackTrace()
            }
            try {
                val wifiManager = applicationContext.getSystemService(WIFI_SERVICE)
                        as WifiManager
                val wifiMac = wifiManager.connectionInfo.macAddress
                sb.append("WifiMAC:$wifiMac\n")
            }catch (e: Exception) {
                sb.append("WifiMAC:get failed(${e.message})\n")
                e.printStackTrace()
            }
            try {
                val telephonyManager = applicationContext.getSystemService(
                        TELEPHONY_SERVICE) as TelephonyManager
                val imei1 = telephonyManager.getImei(0)
                val imei2 = telephonyManager.getImei(1)
                val meid = telephonyManager.meid
                sb.append("imei1:$imei1\n")
                sb.append("imei2:$imei2\n")
                sb.append("meid:$meid\n")
            }catch (e: Exception) {
                sb.append("imei1:get failed(${e.message})\n")
                e.printStackTrace()
            }
            sb.append("\n")
            sb.append("get by prop:\n")
            val snProp = SystemProperties.get("ro.boot.serialno")
            sb.append("sn_prop:$snProp\n")
            val imei1Prop = SystemProperties.get("ro.boot.imei1")
            sb.append("imei1_prop:$imei1Prop\n")
            val imei2Prop = SystemProperties.get("ro.boot.imei2")
            sb.append("imei2_prop:$imei2Prop\n")
            val btmacProp = SystemProperties.get("ro.boot.btmac")
            sb.append("btmac_prop:$btmacProp\n")
            val wifimacProp = SystemProperties.get("ro.boot.wifimac")
            sb.append("wifimac_prop:$wifimacProp\n")
            sb.append("\n")
            sb.append("get by read sys:\n")
            try {
                val snSys: String? = readSysFile("/sys/bus/platform/devices/newland-misc/SN")
                snSys?.let { sb.append("SN_sys:$snSys") }
                sb.append("\n")
                val imei1Sys: String? = readSysFile("/sys/bus/platform/devices/newland-misc/IMEI1")
                imei1Sys?.let { sb.append("imei1_sys:$imei1Sys") }
                sb.append("\n")
                val imei2Sys: String? = readSysFile("/sys/bus/platform/devices/newland-misc/IMEI2")
                imei2Sys?.let { sb.append("imei2_sys:$imei2Sys") }
                sb.append("\n")
                val btMacSys: String? = readSysFile("/sys/bus/platform/devices/newland-misc/BT")
                btMacSys?.let { sb.append("btMAC_sys:$btMacSys") }
                sb.append("\n")
                val wifiMacSys: String? = readSysFile("/sys/bus/platform/devices/newland-misc/WIFI")
                wifiMacSys?.let { sb.append("wifiMAC_sys:$wifiMacSys") }
                sb.append("\n")

            }catch (e:IOException) {
                sb.append("read sys failed(${e.message})")
                e.printStackTrace()
            }

            mainBinding.infoView.text = sb.toString()
        }

    }

    private fun readSysFile(path: String): String? {
        val fileReader = FileReader(path)
        val br = BufferedReader(fileReader)
        val sb = StringBuffer()
        var read = true
        while (read) {
            val line = br.readLine()
            line?.let {
                sb.append(line)
                sb.append("\n")
            }
            read = (line != null)
        }
        br.close()
        return sb.toString()
    }
}