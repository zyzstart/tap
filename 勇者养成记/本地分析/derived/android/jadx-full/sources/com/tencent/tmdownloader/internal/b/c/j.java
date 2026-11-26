package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j implements com.tencent.tmassistantbase.a.a.a {
    private static int a(java.lang.String str, java.lang.String str2, java.lang.String str3, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (str == null || str2 == null) {
            return -1;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("settingField", str);
            contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, str2);
            contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, str3);
            int iUpdate = sQLiteDatabase.update("settingInfo", contentValues, "settingField = ?", new java.lang.String[]{str});
            if (iUpdate > 0) {
                return iUpdate;
            }
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadSettingTable", "exception: ", e);
            e.printStackTrace();
            return -2;
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
            if (writableDatabase == null || a(str, str2, str3, writableDatabase) > 0) {
                return;
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("settingField", str);
            contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, str2);
            contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, str3);
            writableDatabase.insert("settingInfo", null, contentValues);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadSettingTable", "exception: ", e);
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053 A[DONT_GENERATE, PHI: r1
  0x0053: PHI (r1v3 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:20:0x0051, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.HashMap b() {
        java.util.HashMap map = new java.util.HashMap();
        android.database.Cursor cursorRawQuery = null;
        try {
            android.database.sqlite.SQLiteDatabase readableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getReadableDatabase();
            if (readableDatabase == null || (cursorRawQuery = readableDatabase.rawQuery("select * from settingInfo", null)) == null || !cursorRawQuery.moveToFirst()) {
                return map;
            }
            do {
                map.put(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("settingField")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT)));
            } while (cursorRawQuery.moveToNext());
            return map;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("DownloadSettingTable", "exception: ", e);
            e.printStackTrace();
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
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
