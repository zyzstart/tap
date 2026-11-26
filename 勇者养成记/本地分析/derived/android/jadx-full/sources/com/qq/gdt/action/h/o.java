package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f121a = {"Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE="};
    private static final java.util.Map<java.lang.String, java.lang.String> b = new java.util.HashMap();

    static {
        b.put("Y29tLnRlbmNlbnQubW0=", "w");
        b.put("Y29tLnRlbmNlbnQubW9iaWxlcXE=", "q");
    }

    public static int a() {
        return 1;
    }

    public static java.lang.String a(android.content.Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private static java.lang.String a(java.lang.String str) {
        return new java.lang.String(android.util.Base64.decode(str, 2));
    }

    public static android.util.Pair<java.lang.Integer, java.lang.Integer> b(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
        }
        return new android.util.Pair<>(java.lang.Integer.valueOf(java.lang.Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)), java.lang.Integer.valueOf(java.lang.Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
    }

    public static java.lang.String b() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static long c(android.content.Context context) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.FileReader fileReader;
        java.lang.String line;
        long jLongValue = 0;
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            if (activityManager == null) {
                return 0L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        try {
            fileReader = new java.io.FileReader("/proc/meminfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (java.io.FileNotFoundException unused) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        if (fileReader == null) {
                            return 0L;
                        }
                    } catch (java.io.IOException unused3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        if (fileReader == null) {
                            return 0L;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        if (fileReader == null) {
                            throw th;
                        }
                        try {
                            fileReader.close();
                            throw th;
                        } catch (java.io.IOException unused6) {
                            throw th;
                        }
                    }
                } while (!line.contains("MemTotal"));
                jLongValue = line != null ? java.lang.Long.valueOf(line.split("\\s+")[1]).longValue() * 1024 : 0L;
                try {
                    bufferedReader.close();
                } catch (java.io.IOException unused7) {
                }
            } catch (java.io.FileNotFoundException unused8) {
                bufferedReader = null;
            } catch (java.io.IOException unused9) {
                bufferedReader = null;
            } catch (java.lang.Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (java.io.FileNotFoundException unused10) {
            fileReader = null;
            bufferedReader = null;
        } catch (java.io.IOException unused11) {
            fileReader = null;
            bufferedReader = null;
        } catch (java.lang.Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
        try {
            fileReader.close();
            return jLongValue;
        } catch (java.io.IOException unused12) {
            return jLongValue;
        }
    }

    public static java.lang.String c() {
        try {
            return java.util.TimeZone.getDefault().getDisplayName(false, 0);
        } catch (java.lang.AssertionError | java.lang.Exception unused) {
            return "";
        }
    }

    public static long d() {
        long blockSize;
        long blockCount;
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        } else {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
        }
        return blockSize * blockCount;
    }

    public static java.util.Map<java.lang.String, android.content.pm.PackageInfo> d(android.content.Context context) {
        java.util.HashMap map = new java.util.HashMap();
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        for (java.lang.String str : f121a) {
            try {
                map.put(b.get(str), packageManager.getPackageInfo(a(str), 0));
            } catch (java.lang.Exception unused) {
            }
        }
        return map;
    }

    public static java.lang.String e() throws java.lang.Throwable {
        java.io.FileReader fileReader;
        java.lang.String property = java.lang.System.getProperty("os.version");
        java.io.BufferedReader bufferedReader = null;
        try {
            fileReader = new java.io.FileReader("/proc/version");
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(fileReader, 8192);
                try {
                    java.lang.String line = bufferedReader2.readLine();
                    if (line != null) {
                        property = line;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused) {
                    }
                } catch (java.io.FileNotFoundException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    if (fileReader != null) {
                    }
                    return property;
                } catch (java.io.IOException unused4) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused5) {
                        }
                    }
                    if (fileReader != null) {
                    }
                    return property;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused6) {
                        }
                    }
                    if (fileReader == null) {
                        throw th;
                    }
                    try {
                        fileReader.close();
                        throw th;
                    } catch (java.io.IOException unused7) {
                        throw th;
                    }
                }
            } catch (java.io.FileNotFoundException unused8) {
            } catch (java.io.IOException unused9) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.FileNotFoundException unused10) {
            fileReader = null;
        } catch (java.io.IOException unused11) {
            fileReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (java.io.IOException unused12) {
        }
        return property;
    }
}
