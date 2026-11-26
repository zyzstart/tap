package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static int d;
    public static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1417a = android.os.Build.VERSION.RELEASE;
    public static final int b = android.os.Build.VERSION.SDK_INT;
    public static final com.tencent.yybsdk.apkpatch.f.a.e c = e();
    public static final float f = d();
    public static final java.lang.String g = android.os.Build.BRAND;
    public static final java.lang.String h = android.os.Build.MODEL;
    public static final java.lang.String i = android.os.Build.MANUFACTURER;
    public static final java.lang.String j = android.os.Build.PRODUCT;
    public static java.lang.String[] k = k();
    public static final java.lang.String l = g();
    public static final int m = h();
    public static final int n = i();
    public static final int o = j();
    public static final long p = f();
    private static boolean q = false;

    public static com.tencent.yybsdk.apkpatch.f.a.d a(java.lang.String str) {
        if (str == null || !str.contains("/data/data")) {
            return a() ? com.tencent.yybsdk.apkpatch.f.a.d.SDCARD : com.tencent.yybsdk.apkpatch.f.a.d.UNKNOWN;
        }
        return com.tencent.yybsdk.apkpatch.f.a.d.PHONE;
    }

    public static boolean a() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState());
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(android.content.Context context) {
        if (q) {
            return true;
        }
        if (context == null) {
            return false;
        }
        try {
            int iMin = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = context.getResources().getDisplayMetrics().heightPixels;
            int i3 = context.getResources().getConfiguration().orientation;
            if (i3 == 1) {
                d = iMin;
                iMin = i2;
            } else if (i3 == 2) {
                d = i2;
            } else {
                iMin = java.lang.Math.min(iMin, i2);
                d = iMin;
            }
            e = iMin;
            q = true;
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static long b() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        long blockSize = ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
        if (blockSize < 0) {
            return 0L;
        }
        return blockSize;
    }

    public static long b(java.lang.String str) {
        com.tencent.yybsdk.apkpatch.f.a.d dVarA = a(str);
        if (dVarA == com.tencent.yybsdk.apkpatch.f.a.d.PHONE) {
            return b();
        }
        if (dVarA == com.tencent.yybsdk.apkpatch.f.a.d.SDCARD) {
            return c();
        }
        return -1L;
    }

    public static long c() {
        if (!"mounted".equals(android.os.Environment.getExternalStorageState())) {
            return 0L;
        }
        android.os.StatFs statFs = new android.os.StatFs(new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath()).getPath());
        long blockSize = ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
        if (blockSize < 0) {
            return 0L;
        }
        return blockSize;
    }

    private static java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > ' ' && charArray[i2] != '/' && charArray[i2] != '_' && charArray[i2] != '&' && charArray[i2] != '|' && charArray[i2] != '-') {
                stringBuffer.append(charArray[i2]);
            }
        }
        return stringBuffer.toString();
    }

    private static float d() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityManagerNative");
            java.lang.Object objInvoke = cls.getMethod("getDefault", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]);
            return ((android.content.res.Configuration) objInvoke.getClass().getMethod("getConfiguration", new java.lang.Class[0]).invoke(objInvoke, new java.lang.Object[0])).fontScale;
        } catch (java.lang.Exception unused) {
            return 1.0f;
        }
    }

    private static com.tencent.yybsdk.apkpatch.f.a.e e() {
        return com.tencent.yybsdk.apkpatch.f.a.e.UNKNOWN;
    }

    private static long f() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.lang.Exception e2;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            fileReader = new java.io.FileReader("/proc/meminfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader, 8192);
                try {
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                            return 0L;
                        }
                        long j2 = java.lang.Long.parseLong(line.substring(line.indexOf(58) + 1, line.indexOf(107)).trim()) / 1024;
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                        return j2;
                    } catch (java.lang.Exception e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return 0L;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                }
            } catch (java.lang.Exception e10) {
                bufferedReader = null;
                e2 = e10;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e11) {
            bufferedReader = null;
            e2 = e11;
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        th = th;
        bufferedReader2 = bufferedReader;
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (java.io.IOException e12) {
                e12.printStackTrace();
            }
        }
        if (bufferedReader2 == null) {
            throw th;
        }
        try {
            bufferedReader2.close();
            throw th;
        } catch (java.io.IOException e13) {
            e13.printStackTrace();
            throw th;
        }
    }

    private static java.lang.String g() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.lang.String str = "";
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                fileReader = new java.io.FileReader("/proc/cpuinfo");
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(fileReader, 8192);
                    try {
                        java.lang.String[] strArrSplit = bufferedReader2.readLine().split("\\s+");
                        for (int i2 = 2; i2 < strArrSplit.length; i2++) {
                            str = str + strArrSplit[i2] + " ";
                        }
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        bufferedReader2.close();
                    } catch (java.io.IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                } catch (java.io.IOException unused2) {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.io.IOException e6) {
                e6.printStackTrace();
            }
        } catch (java.io.IOException unused3) {
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        return str;
    }

    private static int h() {
        try {
            return new java.io.File("/sys/devices/system/cpu/").listFiles(new com.tencent.yybsdk.apkpatch.f.a.c()).length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[SYNTHETIC] */
    private static int i() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.io.IOException e2;
        java.io.BufferedReader bufferedReader2 = null;
        int iIntValue = 0;
        try {
            fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
                try {
                    try {
                        iIntValue = java.lang.Integer.valueOf(bufferedReader.readLine().trim()).intValue();
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (java.io.IOException e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        return iIntValue;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (bufferedReader2 != null) {
                        throw th;
                    }
                    try {
                        bufferedReader2.close();
                        throw th;
                    } catch (java.io.IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.io.IOException e8) {
                bufferedReader = null;
                e2 = e8;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader2 != null) {
                    throw th;
                }
                bufferedReader2.close();
                throw th;
            }
        } catch (java.io.IOException e9) {
            bufferedReader = null;
            e2 = e9;
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            bufferedReader.close();
        } catch (java.io.IOException e10) {
            e10.printStackTrace();
        }
        return iIntValue;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[SYNTHETIC] */
    private static int j() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.io.IOException e2;
        java.io.BufferedReader bufferedReader2 = null;
        int iIntValue = 0;
        try {
            fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
                try {
                    try {
                        iIntValue = java.lang.Integer.valueOf(bufferedReader.readLine().trim()).intValue();
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (java.io.IOException e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        return iIntValue;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (bufferedReader2 != null) {
                        throw th;
                    }
                    try {
                        bufferedReader2.close();
                        throw th;
                    } catch (java.io.IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.io.IOException e8) {
                bufferedReader = null;
                e2 = e8;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader2 != null) {
                    throw th;
                }
                bufferedReader2.close();
                throw th;
            }
        } catch (java.io.IOException e9) {
            bufferedReader = null;
            e2 = e9;
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            bufferedReader.close();
        } catch (java.io.IOException e10) {
            e10.printStackTrace();
        }
        return iIntValue;
    }

    private static java.lang.String[] k() {
        java.lang.String[] strArrB = {"", ""};
        if (com.tencent.yybsdk.apkpatch.f.a.g.a()) {
            strArrB = com.tencent.yybsdk.apkpatch.f.a.g.b();
        } else if (com.tencent.yybsdk.apkpatch.f.a.f.a()) {
            strArrB = com.tencent.yybsdk.apkpatch.f.a.f.b();
        }
        strArrB[0] = c(strArrB[0]);
        strArrB[1] = c(strArrB[1]);
        return strArrB;
    }
}
