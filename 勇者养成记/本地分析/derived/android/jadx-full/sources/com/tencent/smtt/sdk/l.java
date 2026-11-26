package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class l extends android.os.HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.l f934a;

    public l(java.lang.String str) {
        super(str);
    }

    public static synchronized com.tencent.smtt.sdk.l a() {
        if (f934a == null) {
            com.tencent.smtt.sdk.l lVar = new com.tencent.smtt.sdk.l("TbsHandlerThread");
            f934a = lVar;
            lVar.start();
        }
        return f934a;
    }
}
