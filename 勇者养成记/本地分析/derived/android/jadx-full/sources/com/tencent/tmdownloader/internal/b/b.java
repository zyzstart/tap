package com.tencent.tmdownloader.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f1118a;
    protected java.lang.String b;
    protected long e;
    protected java.io.FileOutputStream c = null;
    protected byte[] d = null;
    protected int f = 0;

    public b(java.lang.String str, java.lang.String str2) {
        this.f1118a = null;
        this.b = null;
        this.e = 0L;
        this.f1118a = str;
        this.b = str2;
        this.e = c();
    }

    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strD = d();
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "getSaveFilePath rootDirString=" + strD);
        if (strD == null) {
            return null;
        }
        return strD + java.io.File.separator + str;
    }

    private boolean a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "enter");
        if (str != null && str2 != null) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                boolean zRenameTo = file.renameTo(new java.io.File(str2));
                if (zRenameTo) {
                    com.tencent.tmassistantbase.util.k.d(str2);
                }
                com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "moveFileFromTmpToSavaPath result: " + zRenameTo);
                return zRenameTo;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "exit");
        return false;
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strD;
        if (str == null || (strD = d()) == null) {
            return null;
        }
        return strD;
    }

    public static java.lang.String d() {
        java.lang.StringBuilder sb;
        java.io.File externalStorageDirectory;
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            return null;
        }
        if (f()) {
            java.lang.String str = "/tencent/TMAssistantSDK/Download/" + contextB.getPackageName();
            if (android.os.Build.VERSION.SDK_INT < 23) {
                externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
            } else {
                try {
                    externalStorageDirectory = (java.io.File) contextB.getClass().getMethod("getExternalFilesDir", java.lang.String.class).invoke(contextB, "");
                } catch (java.lang.Exception e) {
                    com.tencent.tmassistantbase.util.TMLog.e("TMAssistantFile", "getExternalFilesDir Exception", e);
                    externalStorageDirectory = null;
                }
            }
            if (externalStorageDirectory == null) {
                return null;
            }
            sb = new java.lang.StringBuilder();
            sb.append(externalStorageDirectory.getAbsolutePath());
            sb.append(str);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(contextB.getFilesDir().getAbsolutePath());
            sb.append("/TMAssistantSDK/Download");
        }
        return sb.toString();
    }

    public static boolean f() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    public void a() {
        java.lang.String strA = a(this.b);
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 1 finalFilePathString: " + strA);
        if (android.text.TextUtils.isEmpty(strA)) {
            return;
        }
        java.io.File file = new java.io.File(strA);
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 2 file: " + file);
        if (!file.exists()) {
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 3");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile result:" + file.delete() + ",filename:" + strA);
    }

    public void b() {
        java.lang.String strC = c(this.f1118a);
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 1 tmpFilePathString: " + strC);
        if (android.text.TextUtils.isEmpty(strC)) {
            return;
        }
        java.io.File file = new java.io.File(strC);
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 2 file: " + file);
        if (!file.exists()) {
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile 3");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMAssistantFile", "deleteFile result:" + file.delete() + ",filename:" + strC);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r3
  0x002b: PHI (r3v1 java.io.File) = (r3v0 java.io.File), (r3v2 java.io.File) binds: [B:5:0x0013, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public long c() {
        java.lang.String strA = a(this.b);
        if (strA == null) {
            return 0L;
        }
        java.io.File file = new java.io.File(strA);
        if (file.exists()) {
            this.e = file.length();
        } else {
            java.lang.String strC = c(this.f1118a);
            if (strC != null) {
                file = new java.io.File(strC);
                if (file.exists()) {
                    this.e = file.length();
                } else {
                    this.e = 0L;
                }
            }
        }
        return this.e;
    }

    public java.lang.String c(java.lang.String str) {
        java.lang.String strD;
        if (str == null || (strD = d()) == null) {
            return null;
        }
        return strD + "/.tmp/" + str + ".tmp";
    }

    public void e() {
        a(c(this.f1118a), a(this.b));
    }
}
