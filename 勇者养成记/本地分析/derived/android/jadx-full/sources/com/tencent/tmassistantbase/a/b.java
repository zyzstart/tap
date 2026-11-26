package com.tencent.tmassistantbase.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.database.sqlite.SQLiteDatabase f1003a;

    public b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.f1003a = sQLiteDatabase;
    }

    public int a(java.lang.String str, android.content.ContentValues contentValues, java.lang.String str2, java.lang.String[] strArr) {
        try {
            return this.f1003a.update(str, contentValues, str2, strArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public long a(java.lang.String str, java.lang.String str2, android.content.ContentValues contentValues) {
        try {
            return this.f1003a.insert(str, str2, contentValues);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            return this.f1003a.query(str, strArr, str2, strArr2, str3, str4, str5);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
