package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.tmdownloader.internal.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.b.c.c f1121a;

    public static synchronized com.tencent.tmdownloader.internal.b.c.c f() {
        if (f1121a == null) {
            f1121a = new com.tencent.tmdownloader.internal.b.c.c();
        }
        return f1121a;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String[] b(int i) {
        return new java.lang.String[]{d()};
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String c() {
        return "businessDownloadLogData";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String d() {
        return "CREATE TABLE if not exists businessDownloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String e() {
        return "INSERT INTO businessDownloadLogData logData = ?";
    }
}
