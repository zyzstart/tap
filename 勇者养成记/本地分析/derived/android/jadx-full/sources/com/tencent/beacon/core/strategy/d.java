package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static synchronized int a(android.content.Context context, int i) {
        int iDelete;
        java.lang.String str;
        try {
            if (context == null || i < -1) {
                com.tencent.beacon.core.e.d.i("[db] params error.", new java.lang.Object[0]);
                return 0;
            }
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, com.tencent.beacon.core.info.b.b(context).a()).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beacon.core.e.d.b("get db fail!,return ", new java.lang.Object[0]);
                    return 0;
                }
                if (i > 0) {
                    java.lang.Object[] objArr = new java.lang.Object[2];
                    objArr[0] = "_key";
                    objArr[1] = java.lang.Integer.valueOf(i);
                    str = java.lang.String.format("%s = %d", objArr);
                } else {
                    str = null;
                }
                iDelete = writableDatabase.delete("t_strategy", str, null);
                try {
                    com.tencent.beacon.core.e.d.g("[db] key:%d , num: %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(iDelete));
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_strategy deleteStrategy fail!");
                    com.tencent.beacon.core.e.d.a(th);
                }
                return iDelete;
            } catch (java.lang.Throwable th2) {
                th = th2;
                iDelete = 0;
            }
        } catch (java.lang.Throwable th3) {
            throw th3;
        }
    }

    public static android.content.ContentValues a(com.tencent.beacon.core.strategy.k kVar) {
        if (kVar == null) {
            return null;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        long j = kVar.f196a;
        if (j >= 0) {
            contentValues.put("_id", java.lang.Long.valueOf(j));
        }
        contentValues.put("_key", java.lang.Integer.valueOf(kVar.b));
        contentValues.put("_datas", kVar.c);
        return contentValues;
    }

    public static com.tencent.beacon.core.strategy.k a(android.database.Cursor cursor) {
        if (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }
        com.tencent.beacon.core.e.d.a("[db] parse bean.", new java.lang.Object[0]);
        com.tencent.beacon.core.strategy.k kVar = new com.tencent.beacon.core.strategy.k();
        kVar.f196a = cursor.getLong(cursor.getColumnIndex("_id"));
        kVar.b = cursor.getInt(cursor.getColumnIndex("_key"));
        kVar.c = cursor.getBlob(cursor.getColumnIndex("_datas"));
        return kVar;
    }

    public static void a(android.content.Context context, int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        com.tencent.beacon.core.strategy.k kVar = new com.tencent.beacon.core.strategy.k();
        kVar.b = i;
        kVar.c = bArr;
        a(context, kVar);
    }

    public static synchronized boolean a(android.content.Context context, com.tencent.beacon.core.strategy.k kVar) {
        boolean z = false;
        if (context == null || kVar == null) {
            com.tencent.beacon.core.e.d.i("[db] context or bean is null}", new java.lang.Object[0]);
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, com.tencent.beacon.core.info.b.b(context).a()).getWritableDatabase();
            if (writableDatabase == null) {
                com.tencent.beacon.core.e.d.b("[db] get db fail!,return false ", new java.lang.Object[0]);
                return false;
            }
            android.content.ContentValues contentValuesA = a(kVar);
            if (contentValuesA != null) {
                long jReplace = writableDatabase.replace("t_strategy", "_id", contentValuesA);
                if (jReplace < 0) {
                    com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(context);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[db] TB: t_strategy updateStrategyBean fail! cid: ");
                    sb.append(jReplace);
                    iVarA.a("503", sb.toString());
                    com.tencent.beacon.core.e.d.i("[db] insert failure! return false ", new java.lang.Object[0]);
                } else {
                    kVar.f196a = jReplace;
                    com.tencent.beacon.core.e.d.e("[db] update strategy %d true ", java.lang.Integer.valueOf(kVar.b));
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_strategy updateStrategyBean fail! ", th);
            com.tencent.beacon.core.e.d.b("[db] error: %s", th.toString());
        }
    }

    public static synchronized com.tencent.beacon.core.strategy.k b(android.content.Context context, int i) {
        com.tencent.beacon.core.strategy.k kVar;
        android.database.Cursor cursor = null;
        kVarA = null;
        com.tencent.beacon.core.strategy.k kVarA = null;
        if (context == null) {
            com.tencent.beacon.core.e.d.i("[db] context is null", new java.lang.Object[0]);
            return null;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beacon.core.a.a.e.a(context, com.tencent.beacon.core.info.b.b(context).a()).getWritableDatabase();
            if (writableDatabase == null) {
                com.tencent.beacon.core.e.d.i("[db] getWritableDatabase fail!", new java.lang.Object[0]);
                return null;
            }
            java.util.Locale locale = java.util.Locale.US;
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = "_key";
            objArr[1] = java.lang.Integer.valueOf(i);
            android.database.Cursor cursorQuery = writableDatabase.query("t_strategy", null, java.lang.String.format(locale, " %s = %d ", objArr), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext() && (kVarA = a(cursorQuery)) != null) {
                        com.tencent.beacon.core.e.d.g("[db] read strategy key: %d", java.lang.Integer.valueOf(kVarA.b));
                    }
                } catch (java.lang.Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    kVar = null;
                    try {
                        com.tencent.beacon.core.d.i.a(context).a("503", "[db] TB: t_strategy query fail!");
                        com.tencent.beacon.core.e.d.a(th);
                        if (cursor == null || cursor.isClosed()) {
                            kVarA = kVar;
                        } else {
                            cursorQuery = cursor;
                            kVarA = kVar;
                        }
                        return kVarA;
                    } catch (java.lang.Throwable th2) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return kVarA;
        } catch (java.lang.Throwable th3) {
            th = th3;
            kVar = null;
        }
    }
}
