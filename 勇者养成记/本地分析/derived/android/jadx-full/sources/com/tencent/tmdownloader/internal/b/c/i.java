package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i extends com.tencent.tmdownloader.internal.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.b.c.i f1124a;

    public static synchronized com.tencent.tmdownloader.internal.b.c.i f() {
        if (f1124a == null) {
            f1124a = new com.tencent.tmdownloader.internal.b.c.i();
        }
        return f1124a;
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
        return "downloadQualityLogData";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String d() {
        return "CREATE TABLE if not exists downloadQualityLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmdownloader.internal.b.c.a
    protected java.lang.String e() {
        return "INSERT INTO downloadQualityLogData logData = ?";
    }
}
