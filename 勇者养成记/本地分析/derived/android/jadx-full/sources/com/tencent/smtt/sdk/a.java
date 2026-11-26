package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f902a = 600;
    private static int b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a() {
        int i = b;
        if (i > 0) {
            return i;
        }
        java.io.BufferedReader bufferedReader = null;
        int i2 = 0;
        try {
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 8192);
                    while (true) {
                        try {
                            java.lang.String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            int iIndexOf = line.indexOf("MemTotal:");
                            if (-1 != iIndexOf) {
                                java.lang.String strTrim = line.substring(iIndexOf + 9).trim();
                                if (strTrim != null && strTrim.length() != 0 && strTrim.contains("k")) {
                                    i2 = java.lang.Integer.parseInt(strTrim.substring(0, strTrim.indexOf("k")).trim()) / 1024;
                                    break;
                                }
                                break;
                                break;
                                break;
                            }
                        } catch (java.io.IOException e) {
                            bufferedReader = bufferedReader2;
                            e = e;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (java.lang.Throwable th) {
                            bufferedReader = bufferedReader2;
                            th = th;
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    }
                    bufferedReader2.close();
                } catch (java.lang.Throwable th2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (java.io.IOException e3) {
                e = e3;
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
        }
        b = i2;
        return i2;
    }
}
