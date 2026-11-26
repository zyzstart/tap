package com.tencent.tmassistantbase.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.tmassistantbase.a.a.a {
    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE if not exists st_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,data TEXT);";
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        if (i2 == 3) {
            return new java.lang.String[]{"delete from st_data where type in (5, 14, 15)"};
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
