package com.tencent.hlyyb.common.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f extends android.database.sqlite.SQLiteOpenHelper {
    public f(com.tencent.hlyyb.common.d.b.a.e eVar, android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    private void a() {
        int count;
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int iA = com.tencent.hlyyb.common.a.e.a("apn_cache_num", 1, 100, 30);
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            android.database.Cursor cursorQuery = null;
            try {
                cursorQuery = writableDatabase.query("halley_scoll_schedule_tbl", new java.lang.String[]{"apn"}, null, null, null, null, "key");
                if (cursorQuery != null && (count = cursorQuery.getCount() - iA) > 0 && cursorQuery.moveToFirst()) {
                    while (true) {
                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("apn"));
                        if (!android.text.TextUtils.isEmpty(string) && !arrayList.contains(string)) {
                            arrayList.add(string);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        int i = count - 1;
                        if (count <= 0) {
                            break;
                        } else {
                            count = i;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (arrayList.size() > 0) {
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        writableDatabase.delete("halley_scoll_schedule_tbl", "apn=?", new java.lang.String[]{(java.lang.String) it.next()});
                    }
                }
            } catch (java.lang.Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final synchronized com.tencent.hlyyb.common.a.a a(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursorQuery;
        try {
            try {
                cursorQuery = getReadableDatabase().query("halley_scoll_schedule_tbl", null, "apn=? and appid_domain=?", new java.lang.String[]{str, str2}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            com.tencent.hlyyb.common.a.a aVar = new com.tencent.hlyyb.common.a.a();
                            aVar.b(cursorQuery.getString(cursorQuery.getColumnIndex(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IP)));
                            aVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("port")));
                            aVar.a((byte) cursorQuery.getInt(cursorQuery.getColumnIndex("iptype")));
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return aVar;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final synchronized void a(java.lang.String str, java.lang.String str2, com.tencent.hlyyb.common.a.a aVar) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            int iDelete = writableDatabase.delete("halley_scoll_schedule_tbl", "apn=? and appid_domain=?", new java.lang.String[]{str, str2});
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("apn", str);
            contentValues.put("appid_domain", str2);
            contentValues.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IP, aVar.a());
            contentValues.put("port", java.lang.Integer.valueOf(aVar.c()));
            contentValues.put("iptype", java.lang.Byte.valueOf(aVar.b()));
            contentValues.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            if (-1 != writableDatabase.insert("halley_scoll_schedule_tbl", null, contentValues) && iDelete <= 0) {
                a();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_scoll_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,appid_domain TEXT,ip TEXT,port INTEGER,iptype INTEGER,timestamp INTEGER);");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_scoll_schedule_tbl");
            } catch (android.database.SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_scoll_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,appid_domain TEXT,ip TEXT,port INTEGER,iptype INTEGER,timestamp INTEGER);");
            } catch (android.database.SQLException e) {
                throw e;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version != 0) {
                if (version <= 0) {
                    onUpgrade(sQLiteDatabase, version, 1);
                } else if (version > 1) {
                    onDowngrade(sQLiteDatabase, version, 1);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_scoll_schedule_tbl");
            } catch (android.database.SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_scoll_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,appid_domain TEXT,ip TEXT,port INTEGER,iptype INTEGER,timestamp INTEGER);");
            } catch (android.database.SQLException e) {
                throw e;
            }
        } catch (java.lang.Exception unused2) {
        }
    }
}
