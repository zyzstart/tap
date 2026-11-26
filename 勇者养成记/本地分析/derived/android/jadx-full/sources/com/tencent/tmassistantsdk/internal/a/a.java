package com.tencent.tmassistantsdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f1064a;

    public a() {
        this.f1064a = "";
        if ("mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.getExternalStorageDirectory().canWrite()) {
            this.f1064a = android.os.Environment.getExternalStorageDirectory().getPath() + "/tencent/assistant/";
            java.io.File file = new java.io.File(this.f1064a);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f1064a += ".SystemConfig.db";
        }
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (java.lang.Exception unused) {
        }
    }

    private android.database.sqlite.SQLiteDatabase b() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        for (int i = 0; i < 20; i++) {
            try {
                sQLiteDatabaseOpenOrCreateDatabase = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(this.f1064a, (android.database.sqlite.SQLiteDatabase.CursorFactory) null);
            } catch (android.database.sqlite.SQLiteException unused) {
            }
            if (sQLiteDatabaseOpenOrCreateDatabase != null) {
                b(sQLiteDatabaseOpenOrCreateDatabase);
                break;
            }
            android.os.SystemClock.sleep(50L);
        }
        return sQLiteDatabaseOpenOrCreateDatabase;
    }

    private void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        int version = sQLiteDatabase.getVersion();
        if (version != 1) {
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    sQLiteDatabase.execSQL("CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);");
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            sQLiteDatabase.setVersion(1);
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized android.database.sqlite.SQLiteDatabase c() {
        if (!new java.io.File(this.f1064a).exists()) {
            return null;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseOpenDatabase = null;
        for (int i = 0; i < 20; i++) {
            try {
                sQLiteDatabaseOpenDatabase = android.database.sqlite.SQLiteDatabase.openDatabase(this.f1064a, null, 1);
            } catch (android.database.sqlite.SQLiteException unused) {
            }
            if (sQLiteDatabaseOpenDatabase != null) {
                break;
            }
            android.os.SystemClock.sleep(50L);
        }
        return sQLiteDatabaseOpenDatabase;
    }

    public long a(com.tencent.tmassistantsdk.internal.a.c cVar) {
        byte[] bArrA;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseB;
        if (cVar == null || (bArrA = cVar.a()) == null || (sQLiteDatabaseB = b()) == null) {
            return -1L;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("itemData", bArrA);
        long jInsert = sQLiteDatabaseB.insert("channeldata", "", contentValues);
        a(sQLiteDatabaseB);
        return jInsert;
    }

    public java.util.ArrayList a() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC = c();
        java.util.ArrayList arrayList = null;
        if (sQLiteDatabaseC != null) {
            android.database.Cursor cursorRawQuery = sQLiteDatabaseC.rawQuery("select * from channeldata", null);
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                int columnIndex = cursorRawQuery.getColumnIndex("itemId");
                int columnIndex2 = cursorRawQuery.getColumnIndex("itemData");
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                do {
                    int i = cursorRawQuery.getInt(columnIndex);
                    com.tencent.tmassistantsdk.internal.a.c cVarA = com.tencent.tmassistantsdk.internal.a.c.a(cursorRawQuery.getBlob(columnIndex2));
                    if (cVarA != null) {
                        cVarA.f1066a = i;
                        arrayList2.add(cVarA);
                    }
                } while (cursorRawQuery.moveToNext());
                a(sQLiteDatabaseC);
                arrayList = arrayList2;
            }
            cursorRawQuery.close();
            a(sQLiteDatabaseC);
        }
        return arrayList;
    }

    public boolean a(long j) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseB = b();
        if (sQLiteDatabaseB == null) {
            return false;
        }
        sQLiteDatabaseB.delete("channeldata", "itemId=?", new java.lang.String[]{j + ""});
        a(sQLiteDatabaseB);
        return true;
    }
}
