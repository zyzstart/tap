package com.tencent.open.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e extends com.tencent.open.log.Tracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.tencent.open.log.e f712a = new com.tencent.open.log.e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (i == 1) {
            android.util.Log.v(str, str2, th);
            return;
        }
        if (i == 2) {
            android.util.Log.d(str, str2, th);
            return;
        }
        if (i == 4) {
            android.util.Log.i(str, str2, th);
            return;
        }
        if (i == 8) {
            android.util.Log.w(str, str2, th);
        } else if (i == 16 || i == 32) {
            android.util.Log.e(str, str2, th);
        }
    }
}
