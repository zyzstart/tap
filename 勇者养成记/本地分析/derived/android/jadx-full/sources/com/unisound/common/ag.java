package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.content.Context f1468a;

    public ag(android.content.Context context) {
        this.f1468a = context.getApplicationContext();
    }

    private boolean b(java.lang.String str) {
        return android.support.v4.content.ContextCompat.checkSelfPermission(this.f1468a, str) == -1;
    }

    public int a(java.lang.String str) {
        return android.support.v4.content.PermissionChecker.checkPermission(this.f1468a, str, android.os.Process.myPid(), android.os.Process.myUid(), this.f1468a.getPackageName());
    }

    public boolean a(java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (b(str)) {
                return true;
            }
        }
        return false;
    }
}
