package com.tencent.ysdk.hades;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HadesManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.ysdk.hades.HadesManager f1389a;
    private android.content.Context b;

    private HadesManager() {
    }

    public static synchronized com.tencent.ysdk.hades.HadesManager getInstance() {
        if (f1389a == null) {
            f1389a = new com.tencent.ysdk.hades.HadesManager();
        }
        return f1389a;
    }

    public android.content.Context getContext() {
        return this.b;
    }

    public boolean load(java.lang.String str, java.lang.String str2) {
        return com.tencent.ysdk.hades.Hades.a(this.b, str, str2);
    }

    public void setContext(android.content.Context context) {
        this.b = context;
    }
}
