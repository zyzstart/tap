package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f959a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static java.lang.String e = "";

    private static android.content.pm.PackageInfo a(java.lang.String str, int i) {
        java.lang.Class<?> cls;
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.content.pm.PackageParser");
            java.lang.Class<?>[] declaredClasses = cls2.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i2];
                if (cls.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
                i2++;
            }
            java.lang.reflect.Constructor<?> constructor = cls2.getConstructor(java.lang.String.class);
            java.lang.reflect.Method declaredMethod = cls2.getDeclaredMethod("parsePackage", java.io.File.class, java.lang.String.class, android.util.DisplayMetrics.class, java.lang.Integer.TYPE);
            java.lang.reflect.Method declaredMethod2 = cls2.getDeclaredMethod("collectCertificates", cls, java.lang.Integer.TYPE);
            java.lang.reflect.Method declaredMethod3 = cls2.getDeclaredMethod("generatePackageInfo", cls, int[].class, java.lang.Integer.TYPE, java.lang.Long.TYPE, java.lang.Long.TYPE);
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            java.lang.Object objNewInstance = constructor.newInstance(str);
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            displayMetrics.setToDefaults();
            java.lang.Object objInvoke = declaredMethod.invoke(objNewInstance, new java.io.File(str), str, displayMetrics, 0);
            if (objInvoke == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(objNewInstance, objInvoke, 0);
            }
            return (android.content.pm.PackageInfo) declaredMethod3.invoke(null, objInvoke, null, java.lang.Integer.valueOf(i), 0, 0);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a() {
        java.io.InputStreamReader inputStreamReader;
        java.lang.String strA;
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        java.io.BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                try {
                    java.lang.String strA2 = a(bufferedReader2.readLine().contains(com.bun.miitmdid.core.Utils.CPU_ABI_X86) ? "i686" : java.lang.System.getProperty("os.arch"));
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused) {
                    }
                    strA = strA2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        strA = a(java.lang.System.getProperty("os.arch"));
                        th.printStackTrace();
                        return strA;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
        return strA;
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.String a(android.content.Context context, java.io.File file, boolean z) {
        android.content.pm.Signature signature;
        try {
            android.content.pm.PackageInfo packageInfoA = z ? a(file.getAbsolutePath(), 65) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
            if (packageInfoA == null) {
                signature = null;
            } else if (packageInfoA.signatures == null || packageInfoA.signatures.length <= 0) {
                com.tencent.smtt.utils.TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
                signature = null;
            } else {
                signature = packageInfoA.signatures[0];
            }
            if (signature != null) {
                return signature.toCharsString();
            }
            return null;
        } catch (java.lang.Exception unused) {
            com.tencent.smtt.utils.TbsLog.i("AppUtil", "getSign " + file + "failed");
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String strValueOf = java.lang.String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            try {
                return java.lang.String.valueOf(java.lang.Integer.toHexString(java.lang.Integer.parseInt(strValueOf)));
            } catch (java.lang.Exception unused) {
                return strValueOf;
            }
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, boolean z, java.io.File file) {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Exception e2;
        if (file == null || !file.exists()) {
            return "";
        }
        if (z) {
            java.io.RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    byte[] bArr = new byte[2];
                    randomAccessFile = new java.io.RandomAccessFile(file, "r");
                    try {
                        randomAccessFile.read(bArr);
                        if (!new java.lang.String(bArr).equalsIgnoreCase("PK")) {
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            return "";
                        }
                    } catch (java.lang.Exception e4) {
                        e2 = e4;
                        e2.printStackTrace();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e6) {
                randomAccessFile = null;
                e2 = e6;
            } catch (java.lang.Throwable th2) {
                th = th2;
                randomAccessFile2.close();
                throw th;
            }
            try {
                randomAccessFile.close();
            } catch (java.io.IOException e7) {
                e7.printStackTrace();
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                java.lang.String strA = a(file);
                if (strA != null) {
                    com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return strA;
                }
            }
        } catch (java.lang.Throwable unused) {
            com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        java.lang.String strA2 = a(context, file, false);
        com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + strA2);
        if (strA2 == null) {
            strA2 = a(file);
            com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + strA2);
        }
        if (strA2 != null) {
            return strA2;
        }
        java.lang.String strA3 = a(context, file, true);
        com.tencent.smtt.utils.TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android reflection signature=" + strA3);
        return strA3;
    }

    private static java.lang.String a(java.io.File file) {
        try {
            java.util.jar.JarFile jarFile = new java.util.jar.JarFile(file);
            byte[] bArr = new byte[8192];
            java.lang.String strA = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            java.util.Enumeration<java.util.jar.JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.jar.JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                java.lang.String name = jarEntryNextElement.getName();
                if (name != null) {
                    java.security.cert.Certificate[] certificateArrA = a(jarFile, jarEntryNextElement, bArr);
                    java.lang.String strA2 = certificateArrA != null ? a(certificateArrA[0].getEncoded()) : null;
                    if (strA2 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!strA2.equals(strA)) {
                        return null;
                    }
                }
            }
            return strA;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static java.lang.String a(java.lang.String str) {
        return str == null ? "" : str;
    }

    private static java.lang.String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            int i2 = (b2 >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b2 & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new java.lang.String(cArr);
    }

    private static java.security.cert.Certificate[] a(java.util.jar.JarFile jarFile, java.util.jar.JarEntry jarEntry, byte[] bArr) throws java.io.IOException {
        java.io.InputStream inputStream = jarFile.getInputStream(jarEntry);
        while (inputStream.read(bArr, 0, bArr.length) != -1) {
        }
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    public static int b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static java.lang.String b() {
        try {
            for (java.net.NetworkInterface networkInterface : java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (java.lang.Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        android.util.Log.d("0816", "saveGuid guid is " + str);
        try {
            com.tencent.smtt.sdk.TbsDownloadConfig tbsDownloadConfig = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String string = "";
        try {
            string = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getString(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (java.lang.Exception unused) {
        }
        android.util.Log.d("0816", "getGuid guid is " + string);
        return string;
    }

    public static boolean c() {
        java.lang.Class<?> cls;
        java.lang.reflect.Method declaredMethod;
        java.lang.Object objInvoke;
        java.lang.reflect.Method declaredMethod2;
        try {
            if (android.os.Build.VERSION.SDK_INT < 21 || (cls = java.lang.Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new java.lang.Class[0])) == null || (objInvoke = declaredMethod.invoke(null, new java.lang.Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new java.lang.Class[0])) == null) {
                return false;
            }
            java.lang.Object objInvoke2 = declaredMethod2.invoke(objInvoke, new java.lang.Object[0]);
            if (objInvoke2 instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) objInvoke2).booleanValue();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static java.lang.String d(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(f959a)) {
            return f959a;
        }
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String e(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String f(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(d)) {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                try {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi");
                    android.net.wifi.WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    d = connectionInfo == null ? "" : connectionInfo.getMacAddress();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                d = b();
            }
        }
        return d;
    }

    public static java.lang.String g(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            e = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return e;
    }
}
