package com.tencent.tmassistantbase.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmassistantbase.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.tmassistantbase.a.a f1002a;
    private static final java.lang.Class[] b = {com.tencent.tmassistantbase.a.a.b.class, com.tencent.tmassistantbase.a.a.c.class};

    public a(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, "jxlh_push.db", null, i);
    }

    public static synchronized com.tencent.tmassistantbase.a.a a(android.content.Context context) {
        if (f1002a == null) {
            f1002a = new com.tencent.tmassistantbase.a.a(context, "jxlh_push.db", null, 6);
        }
        return f1002a;
    }

    @Override // com.tencent.tmassistantbase.a.c
    public java.lang.Class[] a() {
        return b;
    }

    @Override // com.tencent.tmassistantbase.a.c
    public int b() {
        return 6;
    }
}
