package com.tencent.yybsdk.apkpatch.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static java.lang.String a() {
        return b("/log");
    }

    public static void a(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.exists() || file.isDirectory()) {
            return;
        }
        file.delete();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0049 A[Catch: IOException -> 0x0045, TRY_LEAVE, TryCatch #0 {IOException -> 0x0045, blocks: (B:26:0x0041, B:30:0x0049), top: B:34:0x0041 }] */
    public static void a(java.lang.String str, int i) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.length() == i) {
            return;
        }
        java.nio.channels.FileChannel fileChannel = null;
        try {
            fileOutputStream = new java.io.FileOutputStream(str);
            try {
                java.nio.channels.FileChannel channel = fileOutputStream.getChannel();
                try {
                    channel.write(java.nio.ByteBuffer.allocate(1), i - 1);
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return new java.io.File(str).renameTo(new java.io.File(str2));
    }

    public static java.lang.String b() {
        java.lang.String str;
        if (c()) {
            try {
                str = android.os.Environment.getExternalStorageDirectory().getPath() + "/tencent/tassistant";
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            try {
                android.content.Context contextB = com.tencent.yybsdk.apkpatch.s.a().b();
                if (contextB == null) {
                    return null;
                }
                str = contextB.getFilesDir().getAbsolutePath() + "/tassistant";
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static java.lang.String b(java.lang.String str) {
        java.lang.String strB = b();
        if (!android.text.TextUtils.isEmpty(str)) {
            strB = strB + str;
        }
        return c(strB);
    }

    private static java.lang.String c(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static boolean c() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.getExternalStorageDirectory().canWrite();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
