package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.tencent.tmassistantbase.a.a.a {
    private static int a(com.tencent.tmdownloader.internal.b.b.a aVar, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (aVar == null) {
            return -1;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            a(contentValues, aVar);
            int iUpdate = sQLiteDatabase.update("clientinfo", contentValues, "clientId = ? and taskUrl = ?", new java.lang.String[]{aVar.f1119a, aVar.c});
            if (iUpdate > 0) {
                return iUpdate;
            }
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("ClientInfoTable", "exception: ", e);
            e.printStackTrace();
            return -2;
        }
    }

    private static void a(android.content.ContentValues contentValues, com.tencent.tmdownloader.internal.b.b.a aVar) {
        if (aVar != null) {
            contentValues.put("clientId", aVar.f1119a);
            contentValues.put("taskId", java.lang.Integer.valueOf(aVar.b));
            contentValues.put("taskUrl", aVar.c);
        }
    }

    public static void a(com.tencent.tmdownloader.internal.b.b.a aVar) {
        if (aVar != null) {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
                if (writableDatabase == null || a(aVar, writableDatabase) > 0) {
                    return;
                }
                android.content.ContentValues contentValues = new android.content.ContentValues();
                a(contentValues, aVar);
                writableDatabase.insert("clientinfo", null, contentValues);
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.e("ClientInfoTable", "exception: ", e);
                e.printStackTrace();
            }
        }
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("clientinfo", "taskUrl = ?", new java.lang.String[]{str});
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("ClientInfoTable", "exception: ", e);
            e.printStackTrace();
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmdownloader.internal.b.b.a aVar = new com.tencent.tmdownloader.internal.b.b.a();
        aVar.f1119a = str;
        aVar.c = str2;
        a(aVar);
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void a(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String[] a(int i, int i2) {
        return null;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public void b(int i, int i2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
