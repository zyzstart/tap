package com.tencent.bugly.opengame.crashreport.crash.jni;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.List f373a = new java.util.ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean a(android.content.Context context, java.lang.String str, com.tencent.bugly.opengame.crashreport.crash.jni.NativeExceptionHandler nativeExceptionHandler) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.String str2;
        java.lang.String strA;
        ?? r1 = 0;
        if (context == null || str == null || nativeExceptionHandler == null) {
            com.tencent.bugly.opengame.proguard.x.e("get eup record file args error", new java.lang.Object[0]);
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
                            java.lang.String strA2 = a(bufferedInputStream);
                            if (strA2 != null && strA2.equals("NATIVE_RQD_REPORT")) {
                                java.util.HashMap map = new java.util.HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        strA = a(bufferedInputStream);
                                        if (strA == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = strA;
                                        }
                                    }
                                    map.put(str2, strA);
                                }
                                if (str2 != null) {
                                    com.tencent.bugly.opengame.proguard.x.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (java.io.IOException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }
                                com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanA = a(context, map, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                                return crashDetailBeanA;
                            }
                            com.tencent.bugly.opengame.proguard.x.e("record read fail! %s", strA2);
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
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                r1 = CanRead;
            }
        }
        return null;
    }

    private static com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean a(android.content.Context context, java.util.Map map, com.tencent.bugly.opengame.crashreport.crash.jni.NativeExceptionHandler nativeExceptionHandler) {
        java.lang.String str;
        java.lang.String str2;
        java.util.HashMap map2;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.opengame.crashreport.common.info.a.a(context) == null) {
            com.tencent.bugly.opengame.proguard.x.e("abnormal com info not created", new java.lang.Object[0]);
            return null;
        }
        java.lang.String str3 = (java.lang.String) map.get("intStateStr");
        if (str3 == null || str3.trim().length() <= 0) {
            com.tencent.bugly.opengame.proguard.x.e("no intStateStr", new java.lang.Object[0]);
            return null;
        }
        java.util.Map mapD = d(str3);
        if (mapD == null) {
            com.tencent.bugly.opengame.proguard.x.e("parse intSateMap fail", java.lang.Integer.valueOf(map.size()));
            return null;
        }
        try {
            ((java.lang.Integer) mapD.get("sino")).intValue();
            ((java.lang.Integer) mapD.get("sud")).intValue();
            java.lang.String str4 = (java.lang.String) map.get("soVersion");
            if (str4 == null) {
                com.tencent.bugly.opengame.proguard.x.e("error format at version", new java.lang.Object[0]);
                return null;
            }
            java.lang.String str5 = (java.lang.String) map.get("errorAddr");
            if (str5 == null) {
                str5 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str6 = str5;
            java.lang.String str7 = (java.lang.String) map.get("codeMsg");
            if (str7 == null) {
                str7 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str8 = (java.lang.String) map.get("tombPath");
            if (str8 == null) {
                str8 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str9 = str8;
            java.lang.String str10 = (java.lang.String) map.get("signalName");
            if (str10 == null) {
                str10 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            map.get("errnoMsg");
            java.lang.String str11 = (java.lang.String) map.get("stack");
            if (str11 == null) {
                str11 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.String str12 = (java.lang.String) map.get("jstack");
            if (str12 != null) {
                str11 = str11 + "java:\n" + str12;
            }
            java.lang.Integer num = (java.lang.Integer) mapD.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str7;
                str2 = str10;
            } else {
                str2 = str10 + "(" + str7 + ")";
                str = "KERNEL";
            }
            java.lang.String str13 = (java.lang.String) map.get("nativeLog");
            byte[] bArrA = (str13 == null || str13.isEmpty()) ? null : com.tencent.bugly.opengame.proguard.z.a((java.io.File) null, str13, "BuglyNativeLog.txt");
            java.lang.String str14 = (java.lang.String) map.get("sendingProcess");
            if (str14 == null) {
                str14 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num2 = (java.lang.Integer) mapD.get("spd");
            if (num2 != null) {
                str14 = str14 + "(" + num2 + ")";
            }
            java.lang.String str15 = str14;
            java.lang.String str16 = (java.lang.String) map.get("threadName");
            if (str16 == null) {
                str16 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num3 = (java.lang.Integer) mapD.get("et");
            if (num3 != null) {
                str16 = str16 + "(" + num3 + ")";
            }
            java.lang.String str17 = str16;
            java.lang.String str18 = (java.lang.String) map.get("processName");
            if (str18 == null) {
                str18 = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            java.lang.Integer num4 = (java.lang.Integer) mapD.get("ep");
            if (num4 != null) {
                str18 = str18 + "(" + num4 + ")";
            }
            java.lang.String str19 = (java.lang.String) map.get("key-value");
            if (str19 != null) {
                java.util.HashMap map3 = new java.util.HashMap();
                java.lang.String[] strArrSplit = str19.split("\n");
                int length = strArrSplit.length;
                int i = 0;
                while (i < length) {
                    java.lang.String[] strArrSplit2 = strArrSplit[i].split("=");
                    java.lang.String[] strArr = strArrSplit;
                    if (strArrSplit2.length == 2) {
                        map3.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                    i++;
                    strArrSplit = strArr;
                }
                map2 = map3;
            } else {
                map2 = null;
            }
            com.tencent.bugly.opengame.crashreport.crash.CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str18, str17, (((long) ((java.lang.Integer) mapD.get("ets")).intValue()) * 1000) + (((long) ((java.lang.Integer) mapD.get("etms")).intValue()) / 1000), str2, str6, a(str11), str, str15, str9, (java.lang.String) map.get("sysLogPath"), (java.lang.String) map.get("jniLogPath"), str4, bArrA, map2, false, false);
            if (crashDetailBeanPackageCrashDatas != null) {
                java.lang.String str20 = (java.lang.String) map.get("userId");
                if (str20 != null) {
                    com.tencent.bugly.opengame.proguard.x.c("[Native record info] userId: %s", str20);
                    crashDetailBeanPackageCrashDatas.m = str20;
                }
                java.lang.String str21 = (java.lang.String) map.get("sysLog");
                if (str21 != null) {
                    crashDetailBeanPackageCrashDatas.w = str21;
                }
                java.lang.String str22 = (java.lang.String) map.get("appVersion");
                if (str22 != null) {
                    com.tencent.bugly.opengame.proguard.x.c("[Native record info] appVersion: %s", str22);
                    crashDetailBeanPackageCrashDatas.f = str22;
                }
                java.lang.String str23 = (java.lang.String) map.get("isAppForeground");
                if (str23 != null) {
                    com.tencent.bugly.opengame.proguard.x.c("[Native record info] isAppForeground: %s", str23);
                    crashDetailBeanPackageCrashDatas.N = str23.equalsIgnoreCase(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                }
                java.lang.String str24 = (java.lang.String) map.get("launchTime");
                if (str24 != null) {
                    com.tencent.bugly.opengame.proguard.x.c("[Native record info] launchTime: %s", str24);
                    try {
                        crashDetailBeanPackageCrashDatas.M = java.lang.Long.parseLong(str24);
                    } catch (java.lang.NumberFormatException e) {
                        if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                crashDetailBeanPackageCrashDatas.z = null;
                crashDetailBeanPackageCrashDatas.k = true;
            }
            return crashDetailBeanPackageCrashDatas;
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.e("error format", new java.lang.Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String a(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i = bufferedInputStream.read();
                    if (i == -1) {
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
                    try {
                        com.tencent.bugly.opengame.proguard.x.a(th);
                        if (byteArrayOutputStream != null) {
                            break;
                        }
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
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
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static java.lang.String a(java.lang.String str, int i, java.lang.String str2, boolean z) {
        java.io.BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.canRead()) {
                com.tencent.bugly.opengame.proguard.x.a("Read system log from native record file(length: %s bytes): %s", java.lang.Long.valueOf(file.length()), file.getAbsolutePath());
                f373a.add(file);
                com.tencent.bugly.opengame.proguard.x.c("Add this record file to list for cleaning lastly.", new java.lang.Object[0]);
                if (str2 == null) {
                    return com.tencent.bugly.opengame.proguard.z.a(new java.io.File(str), i, z);
                }
                java.lang.String sb = new java.lang.StringBuilder();
                try {
                    try {
                        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), com.unisound.b.f.b));
                        while (true) {
                            try {
                                java.lang.String line = bufferedReader2.readLine();
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
                                bufferedReader = bufferedReader2;
                                try {
                                    com.tencent.bugly.opengame.proguard.x.a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    java.lang.String string = sb.toString();
                                    if (bufferedReader == null) {
                                        return string;
                                    }
                                    bufferedReader.close();
                                    sb = string;
                                } catch (java.lang.Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (java.lang.Exception e) {
                                            com.tencent.bugly.opengame.proguard.x.a(e);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        java.lang.String string2 = sb.toString();
                        bufferedReader2.close();
                        sb = string2;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (java.lang.Exception e2) {
                    com.tencent.bugly.opengame.proguard.x.a(e2);
                    return sb;
                }
            }
        }
        return null;
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
            f373a.add(new java.io.File(str, "rqd_record.eup"));
            f373a.add(new java.io.File(str, "reg_record.txt"));
            f373a.add(new java.io.File(str, "map_record.txt"));
            f373a.add(new java.io.File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        java.util.List list = f373a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (java.io.File file : f373a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                com.tencent.bugly.opengame.proguard.x.c("Delete record file %s", file.getAbsoluteFile());
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String strSubstring;
        java.io.BufferedReader bufferedReaderA = com.tencent.bugly.opengame.proguard.z.a(str, "reg_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String line = bufferedReaderA.readLine();
            if (line == null || !line.startsWith(str2)) {
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (java.lang.Exception e) {
                        com.tencent.bugly.opengame.proguard.x.a(e);
                    }
                }
                return null;
            }
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
                    strSubstring = "  ";
                } else {
                    if (line2.length() > 16) {
                        i2 = 28;
                    }
                    strSubstring = "                ".substring(0, i2 - length);
                }
                sb.append(strSubstring);
                length = line2.length();
                sb.append(line2);
                i++;
            }
            sb.append("\n");
            java.lang.String string = sb.toString();
            if (bufferedReaderA != null) {
                try {
                    bufferedReaderA.close();
                } catch (java.lang.Exception e2) {
                    com.tencent.bugly.opengame.proguard.x.a(e2);
                }
            }
            return string;
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.bugly.opengame.proguard.x.a(th);
                return null;
            } finally {
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (java.lang.Exception e3) {
                        com.tencent.bugly.opengame.proguard.x.a(e3);
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String c(java.lang.String str, java.lang.String str2) {
        java.io.BufferedReader bufferedReaderA = com.tencent.bugly.opengame.proguard.z.a(str, "map_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
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
                }
                java.lang.String string = sb.toString();
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (java.lang.Exception e) {
                        com.tencent.bugly.opengame.proguard.x.a(e);
                    }
                }
                return string;
            }
            if (bufferedReaderA != null) {
                try {
                    bufferedReaderA.close();
                } catch (java.lang.Exception e2) {
                    com.tencent.bugly.opengame.proguard.x.a(e2);
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.bugly.opengame.proguard.x.a(th);
                return null;
            } finally {
                if (bufferedReaderA != null) {
                    try {
                        bufferedReaderA.close();
                    } catch (java.lang.Exception e3) {
                        com.tencent.bugly.opengame.proguard.x.a(e3);
                    }
                }
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
                        com.tencent.bugly.opengame.proguard.x.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.bugly.opengame.proguard.x.a(th);
        }
    }

    private static java.util.Map d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.util.HashMap map = new java.util.HashMap();
            for (java.lang.String str2 : str.split(",")) {
                java.lang.String[] strArrSplit = str2.split(":");
                if (strArrSplit.length != 2) {
                    com.tencent.bugly.opengame.proguard.x.e("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (java.lang.Exception e) {
            com.tencent.bugly.opengame.proguard.x.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}
