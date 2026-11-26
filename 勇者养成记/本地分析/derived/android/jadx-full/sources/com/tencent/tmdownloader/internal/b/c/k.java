package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k extends com.tencent.tmdownloader.internal.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.b.c.k f1125a;

    public static synchronized com.tencent.tmdownloader.internal.b.c.k f() {
        if (f1125a == null) {
            f1125a = new com.tencent.tmdownloader.internal.b.c.k();
        }
        return f1125a;
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
        return "InstallLogData";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String d() {
        return "CREATE TABLE if not exists InstallLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String e() {
        return "INSERT INTO InstallLogData logData = ?";
    }
}
