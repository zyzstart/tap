package com.tencent.tmassistantsdk.internal.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.tmassistantsdk.internal.e.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantsdk.internal.e.a.c f1076a;

    public static synchronized com.tencent.tmassistantsdk.internal.e.a.c f() {
        if (f1076a == null) {
            f1076a = new com.tencent.tmassistantsdk.internal.e.a.c();
        }
        return f1076a;
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
        return "BusinessInfoLogTable";
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String d() {
        return "CREATE TABLE if not exists BusinessInfoLogTable( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmassistantsdk.internal.e.a.a
    protected java.lang.String e() {
        return "INSERT INTO BusinessInfoLogTable logData = ?";
    }
}
