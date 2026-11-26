package com.tencent.bugly.crashreport.crash.jni;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.List<java.io.File> f323a = new java.util.ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context context, java.lang.String str, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler nativeExceptionHandler) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        if (context == null || str == null || nativeExceptionHandler == null) {
            com.tencent.bugly.proguard.x.e("get eup record file args error", new java.lang.Object[0]);
            return null;
        }
        java.io.File file = new java.io.File(str, "rqd_record.eup");
        if (file.exists()) {
            ?? CanRead = file.canRead();
            try {
                if (CanRead != 0) {
                    try {
                        bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                        try {
                            java.lang.String strA = a(bufferedInputStream);
                            if (strA != null && strA.equals("NATIVE_RQD_REPORT")) {
                                java.util.HashMap map = new java.util.HashMap();
                                java.lang.String str2 = null;
                                while (true) {
                                    java.lang.String strA2 = a(bufferedInputStream);
                                    if (strA2 == null) {
                                        break;
                                    }
                                    if (str2 == null) {
                                        str2 = strA2;
                                    } else {
                                        map.put(str2, strA2);
                                        str2 = null;
                                    }
                                }
                                if (str2 != null) {
                                    com.tencent.bugly.proguard.x.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (java.io.IOException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }
                                com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanA = a(context, map, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                                return crashDetailBeanA;
                            }
                            com.tencent.bugly.proguard.x.e("record read fail! %s", strA);
                            try {
                                bufferedInputStream.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            return null;
                        } catch (java.io.IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return null;
                        }
                    } catch (java.io.IOException e6) {
                        e = e6;
                        bufferedInputStream = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        CanRead = 0;
                        if (CanRead != 0) {
                            try {
                                CanRead.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler nativeExceptionHandler) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.util.HashMap map2;
        java.util.Map<java.lang.String, java.lang.String> map3;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            com.tencent.bugly.proguard.x.e("abnormal com info not created", new java.lang.Object[0]);
            return null;
        }
        java.lang.String str5 = map.get("intStateStr");
        if (str5 == null || str5.trim().length() <= 0) {
            com.tencent.bugly.proguard.x.e("no intStateStr", new java.lang.Object[0]);
            return null;
        }
        java.util.Map<java.lang.String, java.lang.Integer> mapD = d(str5);
        if (mapD == null) {
            com.tencent.bugly.proguard.x.e("parse intSateMap fail", java.lang.Integer.valueOf(map.size()));
            return null;
        }
        try {
            mapD.get("sino").intValue();
            mapD.get("sud").intValue();
            java.lang.String str6 = map.get("soVersion");
            if (str6 == null) {
                com.tencent.bugly.proguard.x.e("error format at version", new java.lang.Object[0]);
                return null;
            }
            java.lang.String str7 = map.get("errorAddr");
            if (str7 == null) {
                str7 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str8 = str7;
            java.lang.String str9 = map.get("codeMsg");
            if (str9 == null) {
                str9 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str10 = map.get("tombPath");
            if (str10 == null) {
                str10 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str11 = str10;
            java.lang.String str12 = map.get("signalName");
            if (str12 == null) {
                str12 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            map.get("errnoMsg");
            java.lang.String str13 = map.get("stack");
            if (str13 == null) {
                str13 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str14 = map.get("jstack");
            if (str14 != null) {
                str13 = str13 + "java:\n" + str14;
            }
            java.lang.Integer num = mapD.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str9;
                str2 = str12;
            } else {
                str2 = str12 + "(" + str9 + ")";
                str = "KERNEL";
            }
            java.lang.String str15 = map.get("nativeLog");
            byte[] bArrA = (str15 == null || str15.isEmpty()) ? null : com.tencent.bugly.proguard.z.a((java.io.File) null, str15, "BuglyNativeLog.txt");
            java.lang.String str16 = map.get("sendingProcess");
            if (str16 == null) {
                str16 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num2 = mapD.get("spd");
            if (num2 != null) {
                str3 = str16 + "(" + num2 + ")";
            } else {
                str3 = str16;
            }
            java.lang.String str17 = map.get("threadName");
            if (str17 == null) {
                str17 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num3 = mapD.get("et");
            if (num3 != null) {
                str4 = str17 + "(" + num3 + ")";
            } else {
                str4 = str17;
            }
            java.lang.String str18 = map.get("processName");
            if (str18 == null) {
                str18 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num4 = mapD.get("ep");
            if (num4 != null) {
                str18 = str18 + "(" + num4 + ")";
            }
            java.lang.String str19 = map.get("key-value");
            if (str19 != null) {
                java.util.HashMap map4 = new java.util.HashMap();
                java.lang.String[] strArrSplit = str19.split("\n");
                int length = strArrSplit.length;
                int i = 0;
                while (i < length) {
                    java.lang.String[] strArrSplit2 = strArrSplit[i].split("=");
                    java.lang.String[] strArr = strArrSplit;
                    if (strArrSplit2.length == 2) {
                        map4.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                    i++;
                    strArrSplit = strArr;
                }
                map2 = map4;
            } else {
                map2 = null;
            }
            com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str18, str4, (((long) mapD.get("ets").intValue()) * 1000) + (((long) mapD.get("etms").intValue()) / 1000), str2, str8, a(str13), str, str3, str11, map.get("sysLogPath"), map.get("jniLogPath"), str6, bArrA, map2, false, false);
            if (crashDetailBeanPackageCrashDatas != null) {
                java.lang.String str20 = map.get("userId");
                if (str20 != null) {
                    com.tencent.bugly.proguard.x.c("[Native record info] userId: %s", str20);
                    crashDetailBeanPackageCrashDatas.m = str20;
                }
                java.lang.String str21 = map.get("sysLog");
                if (str21 != null) {
                    crashDetailBeanPackageCrashDatas.w = str21;
                }
                java.lang.String str22 = map.get("appVersion");
                if (str22 != null) {
                    com.tencent.bugly.proguard.x.c("[Native record info] appVersion: %s", str22);
                    crashDetailBeanPackageCrashDatas.f = str22;
                }
                java.lang.String str23 = map.get("isAppForeground");
                if (str23 != null) {
                    com.tencent.bugly.proguard.x.c("[Native record info] isAppForeground: %s", str23);
                    crashDetailBeanPackageCrashDatas.N = str23.equalsIgnoreCase(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                }
                java.lang.String str24 = map.get("launchTime");
                if (str24 != null) {
                    com.tencent.bugly.proguard.x.c("[Native record info] launchTime: %s", str24);
                    try {
                        crashDetailBeanPackageCrashDatas.M = java.lang.Long.parseLong(str24);
                        map3 = null;
                    } catch (java.lang.NumberFormatException e) {
                        if (com.tencent.bugly.proguard.x.a(e)) {
                            map3 = null;
                        } else {
                            e.printStackTrace();
                            map3 = null;
                        }
                    }
                } else {
                    map3 = null;
                }
                crashDetailBeanPackageCrashDatas.z = map3;
                crashDetailBeanPackageCrashDatas.k = true;
            }
            return crashDetailBeanPackageCrashDatas;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.e("error format", new java.lang.Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x003e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String a(java.io.BufferedInputStream bufferedInputStream) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
            while (true) {
                try {
                    try {
                        int i = bufferedInputStream.read();
                        if (i == -1) {
                            byteArrayOutputStream.close();
                            break;
                        }
                        if (i == 0) {
                            java.lang.String str = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTf-8");
                            byteArrayOutputStream.close();
                            return str;
                        }
                        byteArrayOutputStream.write(i);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.tencent.bugly.proguard.x.a(th);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return null;
    }

    protected static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return "";
        }
        java.lang.String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    public static java.lang.String a(java.lang.String str, int i, java.lang.String str2, boolean z) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        if (str == null || i <= 0) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        com.tencent.bugly.proguard.x.a("Read system log from native record file(length: %s bytes): %s", java.lang.Long.valueOf(file.length()), file.getAbsolutePath());
        f323a.add(file);
        com.tencent.bugly.proguard.x.c("Add this record file to list for cleaning lastly.", new java.lang.Object[0]);
        if (str2 == null) {
            return com.tencent.bugly.proguard.z.a(new java.io.File(str), i, z);
        }
        java.lang.String sb = new java.lang.StringBuilder();
        try {
            try {
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), com.unisound.b.f.b));
                    while (true) {
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (java.util.regex.Pattern.compile(str2 + "[ ]*:").matcher(line).find()) {
                                sb.append(line);
                                sb.append("\n");
                            }
                            if (i > 0 && sb.length() > i) {
                                if (z) {
                                    sb.delete(i, sb.length());
                                    break;
                                }
                                sb.delete(0, sb.length() - i);
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Exception e) {
                                    com.tencent.bugly.proguard.x.a(e);
                                }
                            }
                            throw th;
                        }
                    }
                    java.lang.String string = sb.toString();
                    bufferedReader.close();
                    sb = string;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
                return sb;
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
            }
        } catch (java.lang.Exception e2) {
            com.tencent.bugly.proguard.x.a(e2);
            return sb;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strB = b(str, str2);
        if (strB != null && !strB.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(strB);
        }
        java.lang.String strC = c(str, str2);
        if (strC != null && !strC.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(strC);
        }
        return sb.toString();
    }

    public static void a(boolean z, java.lang.String str) {
        if (str != null) {
            f323a.add(new java.io.File(str, "rqd_record.eup"));
            f323a.add(new java.io.File(str, "reg_record.txt"));
            f323a.add(new java.io.File(str, "map_record.txt"));
            f323a.add(new java.io.File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        java.util.List<java.io.File> list = f323a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (java.io.File file : f323a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                com.tencent.bugly.proguard.x.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.io.File file = new java.io.File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x008b A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.io.BufferedReader bufferedReaderA = com.tencent.bugly.proguard.z.a(str, "reg_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String line = bufferedReaderA.readLine();
                if (line != null && line.startsWith(str2)) {
                    int i = 0;
                    int i2 = 18;
                    int length = 0;
                    while (true) {
                        java.lang.String line2 = bufferedReaderA.readLine();
                        if (line2 == null) {
                            break;
                        }
                        if (i % 4 == 0) {
                            if (i > 0) {
                                sb.append("\n");
                            }
                            sb.append("  ");
                        } else {
                            if (line2.length() > 16) {
                                i2 = 28;
                            }
                            sb.append("                ".substring(0, i2 - length));
                        }
                        length = line2.length();
                        sb.append(line2);
                        i++;
                        if (bufferedReaderA != null) {
                            try {
                                bufferedReaderA.close();
                            } catch (java.lang.Exception e) {
                                com.tencent.bugly.proguard.x.a(e);
                            }
                        }
                    }
                    sb.append("\n");
                    return sb.toString();
                }
                return null;
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
                return null;
            }
        } finally {
            if (bufferedReaderA != null) {
                bufferedReaderA.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x005d A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String c(java.lang.String str, java.lang.String str2) {
        java.io.BufferedReader bufferedReaderA = com.tencent.bugly.proguard.z.a(str, "map_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String line = bufferedReaderA.readLine();
                if (line != null && line.startsWith(str2)) {
                    while (true) {
                        java.lang.String line2 = bufferedReaderA.readLine();
                        if (line2 == null) {
                            break;
                        }
                        sb.append("  ");
                        sb.append(line2);
                        sb.append("\n");
                        if (bufferedReaderA != null) {
                            try {
                                bufferedReaderA.close();
                            } catch (java.lang.Exception e) {
                                com.tencent.bugly.proguard.x.a(e);
                            }
                        }
                    }
                    return sb.toString();
                }
                return null;
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
                return null;
            }
        } finally {
            if (bufferedReaderA != null) {
                bufferedReaderA.close();
            }
        }
    }

    public static void c(java.lang.String str) {
        java.io.File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        com.tencent.bugly.proguard.x.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.proguard.x.a(th);
        }
    }

    private static java.util.Map<java.lang.String, java.lang.Integer> d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.util.HashMap map = new java.util.HashMap();
            for (java.lang.String str2 : str.split(",")) {
                java.lang.String[] strArrSplit = str2.split(":");
                if (strArrSplit.length != 2) {
                    com.tencent.bugly.proguard.x.e("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (java.lang.Exception e) {
            com.tencent.bugly.proguard.x.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}
