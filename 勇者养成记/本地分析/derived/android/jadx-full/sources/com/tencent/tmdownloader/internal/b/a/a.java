package com.tencent.tmdownloader.internal.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.tmassistantbase.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantbase.a.c f1117a;
    private static final java.lang.Class[] b = {com.tencent.tmdownloader.internal.b.c.g.class, com.tencent.tmdownloader.internal.b.c.j.class, com.tencent.tmdownloader.internal.b.c.e.class, com.tencent.tmdownloader.internal.b.c.h.class, com.tencent.tmdownloader.internal.b.c.c.class, com.tencent.tmdownloader.internal.b.c.k.class, com.tencent.tmdownloader.internal.b.c.f.class, com.tencent.tmdownloader.internal.b.c.i.class, com.tencent.tmdownloader.internal.b.c.d.class, com.tencent.tmassistantsdk.internal.e.a.d.class, com.tencent.tmassistantsdk.internal.e.a.c.class};

    public a(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static synchronized com.tencent.tmassistantbase.a.c e() {
        android.content.Context contextB;
        if (f1117a == null && (contextB = com.tencent.tmassistantbase.util.k.a().b()) != null) {
            f1117a = new com.tencent.tmdownloader.internal.b.a.a(contextB, "tmassistant_sdk_v2.db", null, 4);
        }
        return f1117a;
    }

    @Override // com.tencent.tmassistantbase.a.c
    public java.lang.Class[] a() {
        return b;
    }

    @Override // com.tencent.tmassistantbase.a.c
    public int b() {
        return 4;
    }
}
