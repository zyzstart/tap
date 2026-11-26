package com.tencent.bugly.crashreport.common.info;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f293a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static final java.lang.String[] b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    private static final java.lang.String[] c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};
    private static java.lang.String d = null;
    private static java.lang.String e = null;

    public static java.lang.String a() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String string = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            return string == null ? "null" : string.toLowerCase();
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                com.tencent.bugly.proguard.x.a("Failed to get Android ID.", new java.lang.Object[0]);
            }
            return string;
        }
    }

    public static java.lang.String a(android.content.Context context, boolean z) {
        java.lang.String property = null;
        if (z) {
            try {
                java.lang.String strA = com.tencent.bugly.proguard.z.a(context, "ro.product.cpu.abilist");
                if (com.tencent.bugly.proguard.z.a(strA) || strA.equals("fail")) {
                    strA = com.tencent.bugly.proguard.z.a(context, "ro.product.cpu.abi");
                }
                if (!com.tencent.bugly.proguard.z.a(strA) && !strA.equals("fail")) {
                    com.tencent.bugly.proguard.x.b(com.tencent.bugly.crashreport.common.info.b.class, "ABI list: " + strA, new java.lang.Object[0]);
                    property = strA.split(",")[0];
                }
            } catch (java.lang.Throwable th) {
                if (com.tencent.bugly.proguard.x.a(th)) {
                    return "fail";
                }
                th.printStackTrace();
                return "fail";
            }
        }
        if (property == null) {
            property = java.lang.System.getProperty("os.arch");
        }
        return property;
    }

    public static java.lang.String b() {
        try {
            return android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String simSerialNumber = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "fail";
            }
            simSerialNumber = telephonyManager.getSimSerialNumber();
            return simSerialNumber == null ? "null" : simSerialNumber;
        } catch (java.lang.Throwable unused) {
            com.tencent.bugly.proguard.x.a("Failed to get SIM serial number.", new java.lang.Object[0]);
            return simSerialNumber;
        }
    }

    public static int c() {
        try {
            return android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static java.lang.String c(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) == null) {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
            if (!com.tencent.bugly.proguard.x.a(e)) {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            e.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (java.lang.Exception e2) {
            if (!com.tencent.bugly.proguard.x.a(e2)) {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            e2.printStackTrace();
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static java.lang.String d() {
        return "null";
    }

    public static java.lang.String d(android.content.Context context) throws java.lang.Throwable {
        java.lang.String strA = com.tencent.bugly.proguard.z.a(context, "ro.miui.ui.version.name");
        if (!com.tencent.bugly.proguard.z.a(strA) && !strA.equals("fail")) {
            return "XiaoMi/MIUI/" + strA;
        }
        java.lang.String strA2 = com.tencent.bugly.proguard.z.a(context, "ro.build.version.emui");
        if (!com.tencent.bugly.proguard.z.a(strA2) && !strA2.equals("fail")) {
            return "HuaWei/EMOTION/" + strA2;
        }
        java.lang.String strA3 = com.tencent.bugly.proguard.z.a(context, "ro.lenovo.series");
        if (!com.tencent.bugly.proguard.z.a(strA3) && !strA3.equals("fail")) {
            return "Lenovo/VIBE/" + com.tencent.bugly.proguard.z.a(context, "ro.build.version.incremental");
        }
        java.lang.String strA4 = com.tencent.bugly.proguard.z.a(context, "ro.build.nubia.rom.name");
        if (!com.tencent.bugly.proguard.z.a(strA4) && !strA4.equals("fail")) {
            return "Zte/NUBIA/" + strA4 + "_" + com.tencent.bugly.proguard.z.a(context, "ro.build.nubia.rom.code");
        }
        java.lang.String strA5 = com.tencent.bugly.proguard.z.a(context, "ro.meizu.product.model");
        if (!com.tencent.bugly.proguard.z.a(strA5) && !strA5.equals("fail")) {
            return "Meizu/FLYME/" + com.tencent.bugly.proguard.z.a(context, "ro.build.display.id");
        }
        java.lang.String strA6 = com.tencent.bugly.proguard.z.a(context, "ro.build.version.opporom");
        if (!com.tencent.bugly.proguard.z.a(strA6) && !strA6.equals("fail")) {
            return "Oppo/COLOROS/" + strA6;
        }
        java.lang.String strA7 = com.tencent.bugly.proguard.z.a(context, "ro.vivo.os.build.display.id");
        if (!com.tencent.bugly.proguard.z.a(strA7) && !strA7.equals("fail")) {
            return "vivo/FUNTOUCH/" + strA7;
        }
        java.lang.String strA8 = com.tencent.bugly.proguard.z.a(context, "ro.aa.romver");
        if (!com.tencent.bugly.proguard.z.a(strA8) && !strA8.equals("fail")) {
            return "htc/" + strA8 + "/" + com.tencent.bugly.proguard.z.a(context, "ro.build.description");
        }
        java.lang.String strA9 = com.tencent.bugly.proguard.z.a(context, "ro.lewa.version");
        if (!com.tencent.bugly.proguard.z.a(strA9) && !strA9.equals("fail")) {
            return "tcl/" + strA9 + "/" + com.tencent.bugly.proguard.z.a(context, "ro.build.display.id");
        }
        java.lang.String strA10 = com.tencent.bugly.proguard.z.a(context, "ro.gn.gnromvernumber");
        if (!com.tencent.bugly.proguard.z.a(strA10) && !strA10.equals("fail")) {
            return "amigo/" + strA10 + "/" + com.tencent.bugly.proguard.z.a(context, "ro.build.display.id");
        }
        java.lang.String strA11 = com.tencent.bugly.proguard.z.a(context, "ro.build.tyd.kbstyle_version");
        if (!com.tencent.bugly.proguard.z.a(strA11) && !strA11.equals("fail")) {
            return "dido/" + strA11;
        }
        return com.tencent.bugly.proguard.z.a(context, "ro.build.fingerprint") + "/" + com.tencent.bugly.proguard.z.a(context, "ro.build.rom.id");
    }

    public static java.lang.String e() {
        return "null";
    }

    public static java.lang.String e(android.content.Context context) {
        return com.tencent.bugly.proguard.z.a(context, "ro.board.platform");
    }

    public static java.lang.String f() {
        return "null";
    }

    public static java.lang.String f(android.content.Context context) throws java.lang.Throwable {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strA = com.tencent.bugly.proguard.z.a(context, "ro.genymotion.version");
        if (strA != null) {
            sb.append("ro.genymotion.version");
            sb.append("|");
            sb.append(strA);
            sb.append("\n");
        }
        java.lang.String strA2 = com.tencent.bugly.proguard.z.a(context, "androVM.vbox_dpi");
        if (strA2 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append("|");
            sb.append(strA2);
            sb.append("\n");
        }
        java.lang.String strA3 = com.tencent.bugly.proguard.z.a(context, "qemu.sf.fake_camera");
        if (strA3 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append("|");
            sb.append(strA3);
        }
        return sb.toString();
    }

    public static java.lang.String g() {
        try {
            return android.os.Build.SERIAL;
        } catch (java.lang.Throwable unused) {
            com.tencent.bugly.proguard.x.a("Failed to get hardware serial number.", new java.lang.Object[0]);
            return "fail";
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String g(android.content.Context context) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Throwable th2;
        java.lang.String line;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (d == null) {
            d = com.tencent.bugly.proguard.z.a(context, "ro.secure");
        }
        if (d != null) {
            sb.append("ro.secure");
            sb.append("|");
            sb.append(d);
            sb.append("\n");
        }
        if (e == null) {
            e = com.tencent.bugly.proguard.z.a(context, "ro.debuggable");
        }
        if (e != null) {
            sb.append("ro.debuggable");
            sb.append("|");
            sb.append(e);
            sb.append("\n");
        }
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/self/status"));
            do {
                try {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        com.tencent.bugly.proguard.x.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e2) {
                                com.tencent.bugly.proguard.x.a(e2);
                            }
                        }
                        return sb.toString();
                    }
                } catch (java.lang.Throwable th4) {
                    th2 = th4;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e3) {
                            com.tencent.bugly.proguard.x.a(e3);
                        }
                    }
                    throw th2;
                }
            } while (!line.startsWith("TracerPid:"));
            if (line != null) {
                java.lang.String strTrim = line.substring(10).trim();
                sb.append("tracer_pid");
                sb.append("|");
                sb.append(strTrim);
            }
            java.lang.String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (java.io.IOException e4) {
                com.tencent.bugly.proguard.x.a(e4);
            }
            return string;
        } catch (java.lang.Throwable th5) {
            bufferedReader = null;
            th = th5;
        }
    }

    public static long h() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static java.lang.String h(android.content.Context context) throws java.lang.Throwable {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strA = com.tencent.bugly.proguard.z.a(context, "gsm.sim.state");
        if (strA != null) {
            sb.append("gsm.sim.state");
            sb.append("|");
            sb.append(strA);
        }
        sb.append("\n");
        java.lang.String strA2 = com.tencent.bugly.proguard.z.a(context, "gsm.sim.state2");
        if (strA2 != null) {
            sb.append("gsm.sim.state2");
            sb.append("|");
            sb.append(strA2);
        }
        return sb.toString();
    }

    public static long i() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    public static boolean i(android.content.Context context) {
        if (k(context) != null) {
            return true;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (true) {
            java.lang.String[] strArr = c;
            if (i >= strArr.length) {
                break;
            }
            if (i == 0) {
                if (!new java.io.File(strArr[i]).exists()) {
                    arrayList.add(java.lang.Integer.valueOf(i));
                }
            } else if (new java.io.File(strArr[i]).exists()) {
                arrayList.add(java.lang.Integer.valueOf(i));
            }
            i++;
        }
        return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    public static long j() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.lang.Throwable th;
        java.lang.Throwable th2;
        java.io.BufferedReader bufferedReader;
        ?? r0 = "/proc/meminfo";
        try {
            try {
                fileReader = new java.io.FileReader("/proc/meminfo");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader, 2048);
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            long j = java.lang.Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e2) {
                                if (!com.tencent.bugly.proguard.x.a(e2)) {
                                    e2.printStackTrace();
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                if (!com.tencent.bugly.proguard.x.a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                            return j;
                        }
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e4) {
                            if (!com.tencent.bugly.proguard.x.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (java.io.IOException e5) {
                            if (com.tencent.bugly.proguard.x.a(e5)) {
                                return -1L;
                            }
                            e5.printStackTrace();
                            return -1L;
                        }
                    } catch (java.lang.Throwable th3) {
                        th2 = th3;
                        if (!com.tencent.bugly.proguard.x.a(th2)) {
                            th2.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e6) {
                                if (!com.tencent.bugly.proguard.x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (java.io.IOException e7) {
                            if (com.tencent.bugly.proguard.x.a(e7)) {
                                return -2L;
                            }
                            e7.printStackTrace();
                            return -2L;
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    th2 = th4;
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
            }
        } catch (java.lang.Throwable th6) {
            fileReader = null;
            th = th6;
            r0 = 0;
        }
    }

    public static boolean j(android.content.Context context) {
        return (((l(context) | v()) | w()) | u()) > 0;
    }

    public static long k() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th2;
        try {
            fileReader = new java.io.FileReader("/proc/meminfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader, 2048);
                try {
                    try {
                        bufferedReader.readLine();
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e2) {
                                if (!com.tencent.bugly.proguard.x.a(e2)) {
                                    e2.printStackTrace();
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e3) {
                                if (!com.tencent.bugly.proguard.x.a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                            return -1L;
                        }
                        long j = (java.lang.Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
                        java.lang.String line2 = bufferedReader.readLine();
                        if (line2 == null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                if (!com.tencent.bugly.proguard.x.a(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e5) {
                                if (!com.tencent.bugly.proguard.x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                            return -1L;
                        }
                        long j2 = j + (java.lang.Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                        java.lang.String line3 = bufferedReader.readLine();
                        if (line3 == null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e6) {
                                if (!com.tencent.bugly.proguard.x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (java.io.IOException e7) {
                                if (!com.tencent.bugly.proguard.x.a(e7)) {
                                    e7.printStackTrace();
                                }
                            }
                            return -1L;
                        }
                        long j3 = j2 + (java.lang.Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e8) {
                            if (!com.tencent.bugly.proguard.x.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (java.io.IOException e9) {
                            if (!com.tencent.bugly.proguard.x.a(e9)) {
                                e9.printStackTrace();
                            }
                        }
                        return j3;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        if (!com.tencent.bugly.proguard.x.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e10) {
                                if (!com.tencent.bugly.proguard.x.a(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (java.io.IOException e11) {
                            if (com.tencent.bugly.proguard.x.a(e11)) {
                                return -2L;
                            }
                            e11.printStackTrace();
                            return -2L;
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    th2 = th4;
                }
            } catch (java.lang.Throwable th5) {
                th2 = th5;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th6) {
            fileReader = null;
            th = th6;
            bufferedReader = null;
        }
        th2 = th4;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (java.io.IOException e12) {
                if (!com.tencent.bugly.proguard.x.a(e12)) {
                    e12.printStackTrace();
                }
            }
        }
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (java.io.IOException e13) {
                if (!com.tencent.bugly.proguard.x.a(e13)) {
                    e13.printStackTrace();
                }
            }
        }
        throw th2;
    }

    private static java.lang.String k(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (true) {
            java.lang.String[] strArr = b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(java.lang.Integer.valueOf(i));
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    private static int l(android.content.Context context) {
        int i;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (java.lang.Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (java.lang.Exception unused2) {
            return i;
        }
    }

    public static long l() {
        if (!t()) {
            return 0L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long m() {
        if (!t()) {
            return 0L;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static java.lang.String n() {
        try {
            return java.util.Locale.getDefault().getCountry();
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static java.lang.String o() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static boolean p() {
        boolean z;
        java.lang.String[] strArr = f293a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new java.io.File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        return (android.os.Build.TAGS != null && android.os.Build.TAGS.contains("test-keys")) || z;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static java.lang.String q() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader2;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (new java.io.File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    java.lang.String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                    }
                    bufferedReader.close();
                } catch (java.lang.Throwable unused) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e2) {
                            com.tencent.bugly.proguard.x.a(e2);
                        }
                    }
                    return null;
                }
            } else {
                bufferedReader = null;
            }
            sb.append(",");
            if (new java.io.File("/sys/block/mmcblk0/device/name").exists()) {
                bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    java.lang.String line2 = bufferedReader2.readLine();
                    if (line2 != null) {
                        sb.append(line2);
                    }
                    bufferedReader2.close();
                    bufferedReader = bufferedReader2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            sb.append(",");
            if (new java.io.File("/sys/block/mmcblk0/device/cid").exists()) {
                bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/sys/block/mmcblk0/device/cid"));
                java.lang.String line3 = bufferedReader2.readLine();
                if (line3 != null) {
                    sb.append(line3);
                }
                bufferedReader = bufferedReader2;
            }
            java.lang.String string = sb.toString();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e3) {
                    com.tencent.bugly.proguard.x.a(e3);
                }
            }
            return string;
        } catch (java.lang.Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static java.lang.String r() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                if (new java.io.File("/sys/class/power_supply/ac/online").exists()) {
                    bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/sys/class/power_supply/ac/online"));
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append("ac_online");
                            sb.append("|");
                            sb.append(line);
                        }
                        bufferedReader.close();
                        bufferedReader2 = bufferedReader;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e2) {
                                com.tencent.bugly.proguard.x.a(e2);
                            }
                        }
                        throw th;
                    }
                }
                sb.append("\n");
                if (new java.io.File("/sys/class/power_supply/usb/online").exists()) {
                    java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.FileReader("/sys/class/power_supply/usb/online"));
                    java.lang.String line2 = bufferedReader3.readLine();
                    if (line2 != null) {
                        sb.append("usb_online");
                        sb.append("|");
                        sb.append(line2);
                    }
                    bufferedReader3.close();
                    bufferedReader2 = bufferedReader3;
                }
                sb.append("\n");
                if (new java.io.File("/sys/class/power_supply/battery/capacity").exists()) {
                    bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/sys/class/power_supply/battery/capacity"));
                    java.lang.String line3 = bufferedReader.readLine();
                    if (line3 != null) {
                        sb.append("battery_capacity");
                        sb.append("|");
                        sb.append(line3);
                    }
                    bufferedReader.close();
                    bufferedReader2 = bufferedReader;
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (java.io.IOException e3) {
                com.tencent.bugly.proguard.x.a(e3);
            }
        } catch (java.lang.Throwable unused) {
        }
        return sb.toString();
    }

    public static long s() throws java.lang.Throwable {
        float fCurrentTimeMillis = 0.0f;
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/proc/uptime"));
                    try {
                        java.lang.String line = bufferedReader2.readLine();
                        if (line != null) {
                            fCurrentTimeMillis = (java.lang.System.currentTimeMillis() / 1000) - java.lang.Float.parseFloat(line.split(" ")[0]);
                        }
                        bufferedReader2.close();
                    } catch (java.lang.Throwable unused) {
                        bufferedReader = bufferedReader2;
                        com.tencent.bugly.proguard.x.a("Failed to get boot time of device.", new java.lang.Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return (long) fCurrentTimeMillis;
                    }
                } catch (java.lang.Throwable unused2) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e2) {
            com.tencent.bugly.proguard.x.a(e2);
        }
        return (long) fCurrentTimeMillis;
    }

    private static boolean t() {
        try {
            return android.os.Environment.getExternalStorageState().equals("mounted");
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static int u() {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new java.lang.Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new java.lang.Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (java.lang.Exception unused) {
            return 256;
        }
    }

    private static int v() {
        try {
            throw new java.lang.Exception("detect hook");
        } catch (java.lang.Exception e2) {
            int i = 0;
            int i2 = 0;
            for (java.lang.StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int w() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.IOException e2;
        java.io.UnsupportedEncodingException e3;
        java.io.FileNotFoundException e4;
        int i = 0;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    java.util.HashSet hashSet = new java.util.HashSet();
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/" + android.os.Process.myPid() + "/maps"), com.unisound.b.f.b));
                    while (true) {
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(".so") || line.endsWith(".jar")) {
                                hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                            }
                        } catch (java.io.FileNotFoundException e5) {
                            e4 = e5;
                            e4.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        } catch (java.io.UnsupportedEncodingException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        } catch (java.io.IOException e7) {
                            e2 = e7;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        }
                    }
                    for (java.lang.Object obj : hashSet) {
                        if (((java.lang.String) obj).toLowerCase().contains("xposed")) {
                            i |= 64;
                        }
                        if (((java.lang.String) obj).contains("com.saurik.substrate")) {
                            i |= 128;
                        }
                    }
                    bufferedReader.close();
                } catch (java.io.IOException e8) {
                    e8.printStackTrace();
                }
            } catch (java.io.FileNotFoundException e9) {
                bufferedReader = null;
                e4 = e9;
            } catch (java.io.UnsupportedEncodingException e10) {
                bufferedReader = null;
                e3 = e10;
            } catch (java.io.IOException e11) {
                bufferedReader = null;
                e2 = e11;
            } catch (java.lang.Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
            return i;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
