package com.qq.gdt.action.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f109a = {"Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE="};

    private static java.lang.String a() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String message;
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            java.lang.String strA = a();
            android.util.Pair<java.lang.Integer, java.lang.Integer> pairC = c(applicationContext);
            java.lang.String strE = e();
            long jD = d(applicationContext);
            long jD2 = d();
            java.lang.String strB = b();
            java.lang.String strB2 = b(applicationContext);
            java.lang.String strC = c();
            java.util.List<java.lang.Long> listE = e(applicationContext);
            java.lang.String str2 = java.lang.String.format(java.util.Locale.US, "%s|%d|%d|%s|%d|%d", strA, pairC.first, pairC.second, strE, java.lang.Long.valueOf(jD), java.lang.Long.valueOf(jD2));
            java.lang.String str3 = java.lang.String.format(java.util.Locale.US, "%s|%s|%s|%s", strB, strB2, strC, android.text.TextUtils.join("|", listE));
            char[] cArrB = b(str2);
            char[] cArrB2 = b(str3);
            a(cArrB);
            b(cArrB, cArrB2);
            return a(cArrB, cArrB2);
        } catch (java.lang.Error e) {
            str = "AMS-QADID";
            sb = new java.lang.StringBuilder();
            sb.append("createQADID error: ");
            message = e.getMessage();
            sb.append(message);
            android.util.Log.w(str, sb.toString());
            return "[REDACTED_HEX_CONSTANT]";
        } catch (java.lang.Throwable th) {
            str = "AMS-QADID";
            sb = new java.lang.StringBuilder();
            sb.append("createQADID exception: ");
            message = th.getMessage();
            sb.append(message);
            android.util.Log.w(str, sb.toString());
            return "[REDACTED_HEX_CONSTANT]";
        }
    }

    private static java.lang.String a(java.lang.String str) {
        return new java.lang.String(android.util.Base64.decode(str, 2));
    }

    private static java.lang.String a(char[] cArr, char[] cArr2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        while (i < 32) {
            sb.append(i < 16 ? cArr[i] : cArr2[i - 16]);
            i++;
        }
        return sb.toString();
    }

    private static void a(char[] cArr) {
        java.lang.String upperCase = java.lang.Integer.toHexString(1).toUpperCase();
        if (upperCase.length() < 2) {
            cArr[0] = '0';
            cArr[1] = upperCase.charAt(0);
        } else {
            cArr[0] = upperCase.charAt(0);
            cArr[1] = upperCase.charAt(1);
        }
    }

    private static long b(char[] cArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (char c : cArr) {
            sb.append(c);
        }
        byte[] bArrD = d(sb.toString());
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(bArrD);
        return crc32.getValue();
    }

    private static java.lang.String b() {
        return java.util.Locale.getDefault().getLanguage();
    }

    private static java.lang.String b(android.content.Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private static void b(char[] cArr, char[] cArr2) {
        char[] cArr3 = new char[30];
        for (int i = 0; i < 30; i++) {
            if (i < 16) {
                cArr3[i] = cArr[i];
            } else {
                cArr3[i] = cArr2[i - 16];
            }
        }
        java.lang.String upperCase = java.lang.Integer.toHexString((int) (b(cArr3) % 256)).toUpperCase();
        if (upperCase.length() < 2) {
            cArr2[14] = '0';
            cArr2[15] = upperCase.charAt(0);
        } else {
            cArr2[14] = upperCase.charAt(0);
            cArr2[15] = upperCase.charAt(1);
        }
    }

    private static char[] b(java.lang.String str) {
        java.lang.String strC = c(str);
        char[] cArr = new char[16];
        for (int i = 8; i < 24; i++) {
            cArr[i - 8] = strC.charAt(i);
        }
        return cArr;
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> c(android.content.Context context) {
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

    private static java.lang.String c() {
        try {
            return java.util.TimeZone.getDefault().getDisplayName(false, 0);
        } catch (java.lang.AssertionError | java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String c(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(java.lang.Integer.toHexString(i));
            }
            return sb.toString().toUpperCase();
        } catch (java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static long d() {
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

    private static long d(android.content.Context context) throws java.lang.Throwable {
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

    private static byte[] d(java.lang.String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((java.lang.Character.digit(str.charAt(i), 16) << 4) + java.lang.Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private static java.lang.String e() throws java.lang.Throwable {
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

    private static java.util.List<java.lang.Long> e(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        for (java.lang.String str : f109a) {
            try {
                arrayList.add(java.lang.Long.valueOf(packageManager.getPackageInfo(a(str), 0).firstInstallTime));
            } catch (java.lang.Exception unused) {
                arrayList.add(-1L);
            }
        }
        return arrayList;
    }
}
