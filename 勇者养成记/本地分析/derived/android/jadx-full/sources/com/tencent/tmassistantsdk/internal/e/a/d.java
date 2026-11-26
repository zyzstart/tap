package com.tencent.tmassistantsdk.internal.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends com.tencent.tmassistantsdk.internal.e.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantsdk.internal.e.a.d f1077a;

    public static synchronized com.tencent.tmassistantsdk.internal.e.a.d f() {
        if (f1077a == null) {
            f1077a = new com.tencent.tmassistantsdk.internal.e.a.d();
        }
        return f1077a;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String[] b(int i) {
        if (i > 1) {
            return new java.lang.String[]{d()};
        }
        return null;
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String c() {
        return "TipsInfoLogData";
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String d() {
        return "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String e() {
        return "INSERT INTO TipsInfoLogData logData = ?";
    }
}
