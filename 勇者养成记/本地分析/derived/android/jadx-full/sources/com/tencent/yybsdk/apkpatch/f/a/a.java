package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.Properties f1416a = new java.util.Properties();

    private a() throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop"));
                try {
                    this.f1416a.load(fileInputStream2);
                    fileInputStream2.close();
                } catch (java.lang.Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                    } else {
                        fileInputStream.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused3) {
            }
        } catch (java.lang.Exception unused4) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static com.tencent.yybsdk.apkpatch.f.a.a a() {
        return new com.tencent.yybsdk.apkpatch.f.a.a();
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return this.f1416a.getProperty(str, str2);
    }
}
