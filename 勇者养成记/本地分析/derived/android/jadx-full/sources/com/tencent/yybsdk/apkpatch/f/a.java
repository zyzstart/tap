package com.tencent.yybsdk.apkpatch.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1415a = false;
    public static boolean b = false;
    private static java.text.SimpleDateFormat c;

    private static java.lang.String a() {
        if (c == null) {
            c = new java.text.SimpleDateFormat("MM-dd HH:mm:ss.SSS", java.util.Locale.US);
        }
        return c.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    private static java.lang.String a(java.lang.String str) {
        return "ApkPatch-" + str;
    }

    public static java.lang.String a(java.lang.Throwable th) {
        java.lang.String stackTraceString = android.util.Log.getStackTraceString(th);
        if (stackTraceString != null) {
            return stackTraceString.length() > 200 ? stackTraceString.substring(0, 200) : stackTraceString;
        }
        return "";
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.d(a(str), str2);
            e("/D-" + str, str2);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        if (f1415a) {
            a(a() + " [" + a(str) + "] " + str3, str2, true);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Throwable {
        java.io.BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    java.lang.String strA = com.tencent.yybsdk.apkpatch.f.b.a();
                    if (android.text.TextUtils.isEmpty(strA)) {
                        android.util.Log.e("ApkPatchLog", "writeToFile, logDir=" + strA);
                        return;
                    }
                    if (!new java.io.File(strA).exists()) {
                        new java.io.File(strA).mkdirs();
                    }
                    java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(strA + java.io.File.separator + str2, z));
                    try {
                        bufferedWriter2.write(str + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (java.lang.Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                        } else {
                            bufferedWriter.close();
                        }
                    } catch (java.lang.OutOfMemoryError e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                            return;
                        }
                        bufferedWriter.close();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
            } catch (java.lang.Exception e5) {
                e = e5;
            } catch (java.lang.OutOfMemoryError e6) {
                e = e6;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.i(a(str), str2);
            e("/I-" + str, str2);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.w(a(str), str2);
            e("/W-" + str, str2);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.e(a(str), str2);
            e("/E-" + str, str2);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        a(str, "apkpatch.log", str2);
    }
}
