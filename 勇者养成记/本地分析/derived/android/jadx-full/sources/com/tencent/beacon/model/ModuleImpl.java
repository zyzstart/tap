package com.tencent.beacon.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ModuleImpl extends com.tencent.beacon.core.c {
    private static com.tencent.beacon.model.ModuleImpl mInstance = null;
    private static final java.lang.String modelEvent = "rqd_model";
    private boolean modelEventUsable;

    public ModuleImpl(android.content.Context context) {
        super(context);
        this.modelEventUsable = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getCpuProductorName() {
        try {
            java.lang.Object obj = android.os.Build.class.getField("HARDWARE").get(null);
            if (obj != null) {
                return obj.toString();
            }
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[model] get cpu product error!", new java.lang.Object[0]);
        }
        return null;
    }

    private long getFreeMem() {
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) this.mContext.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[model] getFreeMem error!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(th);
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getFreeMem2() {
        long freeMem = getFreeMem();
        if (freeMem <= 0) {
            return "0";
        }
        return ((freeMem / 1024) / 1024) + "";
    }

    public static synchronized com.tencent.beacon.model.ModuleImpl getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.beacon.model.ModuleImpl(context);
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getRomFingerPrint() {
        java.util.ArrayList arrayListA = com.tencent.beacon.core.e.b.a(new java.lang.String[]{"/system/bin/sh", "-c", "getprop ro.build.fingerprint"});
        return (arrayListA == null || arrayListA.size() <= 0) ? "" : (java.lang.String) arrayListA.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSDCardSize() {
        if (!com.tencent.beacon.core.info.e.d(this.mContext).a()) {
            return 0L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1024) / 1024;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getSensor() {
        int i;
        java.lang.reflect.Method method;
        java.lang.String str;
        char c = 0;
        com.tencent.beacon.core.e.d.a("[model] getSensor start", new java.lang.Object[0]);
        java.lang.String str2 = "X";
        java.lang.String str3 = "X";
        java.lang.String str4 = "X";
        java.lang.String str5 = "X";
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) >= 10) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.hardware.Camera");
                int iIntValue = ((java.lang.Integer) cls.getMethod("getNumberOfCameras", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0])).intValue();
                if (iIntValue == 0) {
                    str3 = "N";
                    str2 = "N";
                } else {
                    java.lang.Class<?> cls2 = java.lang.Class.forName("android.hardware.Camera$CameraInfo");
                    java.lang.Object objNewInstance = cls2.newInstance();
                    java.lang.reflect.Method[] methods = cls.getMethods();
                    int length = methods.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            method = null;
                            break;
                        }
                        try {
                            method = methods[i2];
                            if (method.getName().equals("getCameraInfo")) {
                                break;
                            }
                            i2++;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i = 0;
                            com.tencent.beacon.core.e.d.b("[model] getSensor error!", new java.lang.Object[i]);
                            com.tencent.beacon.core.e.d.a(th);
                            stringBuffer.append(str2);
                            stringBuffer.append(str3);
                            stringBuffer.append(str4);
                            stringBuffer.append(str5);
                            return stringBuffer.toString();
                        }
                    }
                    java.lang.reflect.Field field = cls2.getField("facing");
                    java.lang.reflect.Field field2 = cls2.getField("CAMERA_FACING_BACK");
                    java.lang.reflect.Field field3 = cls2.getField("CAMERA_FACING_FRONT");
                    if (method != null) {
                        java.lang.String str6 = "X";
                        java.lang.String str7 = "X";
                        int i3 = 0;
                        while (i3 < iIntValue) {
                            try {
                                java.lang.Object[] objArr = new java.lang.Object[2];
                                objArr[c] = java.lang.Integer.valueOf(i3);
                                objArr[1] = objNewInstance;
                                method.invoke(cls, objArr);
                                int i4 = field.getInt(objNewInstance);
                                int i5 = field2.getInt(objNewInstance);
                                int i6 = field3.getInt(objNewInstance);
                                if (i4 == i5) {
                                    str = "Y";
                                    if (iIntValue == 1) {
                                        str6 = "N";
                                    }
                                } else {
                                    if (i4 == i6) {
                                        str6 = "Y";
                                        if (iIntValue == 1) {
                                            str = "N";
                                        }
                                    }
                                    i3++;
                                    c = 0;
                                }
                                str7 = str;
                                i3++;
                                c = 0;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                i = 0;
                                str2 = str7;
                                str3 = str6;
                                com.tencent.beacon.core.e.d.b("[model] getSensor error!", new java.lang.Object[i]);
                                com.tencent.beacon.core.e.d.a(th);
                                stringBuffer.append(str2);
                                stringBuffer.append(str3);
                                stringBuffer.append(str4);
                                stringBuffer.append(str5);
                                return stringBuffer.toString();
                            }
                        }
                        str2 = str7;
                        str3 = str6;
                    }
                }
                try {
                    android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) this.mContext.getSystemService("sensor");
                    str4 = sensorManager.getDefaultSensor(9) != null ? "Y" : "N";
                    str5 = sensorManager.getDefaultSensor(4) != null ? "Y" : "N";
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    i = 0;
                    com.tencent.beacon.core.e.d.b("[model] getSensor error!", new java.lang.Object[i]);
                    com.tencent.beacon.core.e.d.a(th);
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        }
        stringBuffer.append(str2);
        stringBuffer.append(str3);
        stringBuffer.append(str4);
        stringBuffer.append(str5);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getSensor2() {
        com.tencent.beacon.core.e.d.a("[model] getSensor2 start", new java.lang.Object[0]);
        java.lang.String str = "X";
        java.lang.String str2 = "X";
        java.lang.String str3 = "X";
        java.lang.String str4 = "X";
        java.lang.String str5 = hasWIFIDevice() ? "Y" : "N";
        if (java.lang.Integer.parseInt(android.os.Build.VERSION.SDK) >= 10) {
            try {
                android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) this.mContext.getSystemService("sensor");
                str = sensorManager.getDefaultSensor(1) != null ? "Y" : "N";
                str2 = sensorManager.getDefaultSensor(5) != null ? "Y" : "N";
                str3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter() == null ? "N" : "Y";
                str4 = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc") ? "Y" : "N";
            } catch (java.lang.Throwable unused) {
                com.tencent.beacon.core.e.d.b("[model] getSensor2 error!", new java.lang.Object[0]);
            }
        }
        return str5 + str + str2 + str3 + str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getWifiSSID() {
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo();
            return connectionInfo.getBSSID() != null ? connectionInfo.getSSID() : "";
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[model] getWifiSSID error!", new java.lang.Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String hasGPSDevice() {
        java.util.List<java.lang.String> allProviders;
        android.location.LocationManager locationManager = (android.location.LocationManager) this.mContext.getSystemService("location");
        return (locationManager == null || (allProviders = locationManager.getAllProviders()) == null || !allProviders.contains("gps")) ? "N" : "Y";
    }

    private boolean hasWIFIDevice() {
        return ((android.net.wifi.WifiManager) this.mContext.getSystemService("wifi")) != null;
    }

    private void modelEvent() {
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.mContext);
        try {
            if (com.tencent.beacon.core.e.b.a().equals(fVarA.a(modelEvent, ""))) {
                return;
            }
            com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.model.a(this), 50000L);
            try {
                fVarA.b().a(modelEvent, (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.b("[model] save upload flag failed!", new java.lang.Object[0]);
                com.tencent.beacon.core.e.d.a(e);
            }
        } catch (java.lang.Exception unused) {
            com.tencent.beacon.core.e.d.b("[model] get upload flag failed! ", new java.lang.Object[0]);
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        com.tencent.beacon.core.e.d.d("[module] model module > %S", "" + this.modelEventUsable);
        if (this.modelEventUsable) {
            modelEvent();
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, java.util.Map map) {
        super.onModuleStrategyUpdated(i, map);
        if (i == 1) {
            this.modelEventUsable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("modelEventUsable"), this.modelEventUsable);
        }
    }
}
