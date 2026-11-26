package com.tencent.yybsdk.apkpatch.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.yybsdk.apkpatch.e.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.yybsdk.apkpatch.e.a.a f1412a;
    private static final java.lang.Class[] b = {com.tencent.yybsdk.apkpatch.e.b.a.class};

    private a(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static com.tencent.yybsdk.apkpatch.e.a.a a(android.content.Context context) {
        if (f1412a == null && context != null) {
            f1412a = new com.tencent.yybsdk.apkpatch.e.a.a(context, "tmapkpatch_sdk.db", null, 6);
        }
        return f1412a;
    }

    @Override // com.tencent.yybsdk.apkpatch.e.a.b
    public int a() {
        return 6;
    }

    @Override // com.tencent.yybsdk.apkpatch.e.a.b
    public java.lang.Class[] b() {
        return b;
    }
}
