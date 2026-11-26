package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class EmulatorDetector {
    public static boolean checkIsNotRealPhone() {
        java.lang.String cpuInfo = readCpuInfo();
        return cpuInfo.contains("intel") || cpuInfo.contains("amd");
    }

    public static boolean isSimulator(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        boolean z = intent.resolveActivity(context.getPackageManager()) != null;
        boolean zNotHasBlueTooth = notHasBlueTooth();
        boolean zNotHasLightSensorManager = notHasLightSensorManager(context);
        boolean zCheckIsNotRealPhone = checkIsNotRealPhone();
        if (android.os.Build.FINGERPRINT.startsWith("generic") || android.os.Build.FINGERPRINT.toLowerCase().contains("vbox") || android.os.Build.FINGERPRINT.toLowerCase().contains("test-keys") || android.os.Build.MODEL.contains("google_sdk") || android.os.Build.MODEL.contains("Emulator") || android.os.Build.MODEL.contains("MuMu") || android.os.Build.MODEL.contains("virtual") || android.os.Build.SERIAL.equalsIgnoreCase("android") || android.os.Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (android.os.Build.BRAND.startsWith("generic") && android.os.Build.DEVICE.startsWith("generic")) || "google_sdk".equals(android.os.Build.PRODUCT) || ((android.telephony.TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase().equals("android") || !z || zNotHasBlueTooth || zNotHasLightSensorManager || zCheckIsNotRealPhone;
    }

    public static boolean notHasBlueTooth() {
        android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null || android.text.TextUtils.isEmpty(defaultAdapter.getName());
    }

    public static boolean notHasLightSensorManager(android.content.Context context) {
        return ((android.hardware.SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) == null;
    }

    public static java.lang.String readCpuInfo() {
        try {
            java.lang.Process processStart = new java.lang.ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processStart.getInputStream(), com.unisound.b.f.b));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
                stringBuffer.append(line);
            }
        } catch (java.io.IOException unused) {
            return "";
        }
    }
}
