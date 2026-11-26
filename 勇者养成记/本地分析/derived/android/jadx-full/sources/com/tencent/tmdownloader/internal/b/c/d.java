package com.tencent.tmdownloader.internal.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d implements com.tencent.tmassistantbase.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String[] f1122a = {"key"};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void a(java.lang.String str, java.util.List list) {
        int size = list.size();
        if (!android.text.TextUtils.isEmpty(str) && size != 0 && com.tencent.tmdownloader.internal.b.a.a.e() != null) {
            if (size > 20) {
                size = 20;
            }
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            writableDatabase.beginTransaction();
            try {
                try {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    for (int i = 0; i < size; i++) {
                        java.lang.String str2 = (java.lang.String) list.get(i);
                        if (str2 != null) {
                            contentValues.put("key", com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REPORT);
                            contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, str);
                            contentValues.put("blob", str2.getBytes("UTF-8"));
                            writableDatabase.insert("reportInfo", null, contentValues);
                        }
                        contentValues.clear();
                    }
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        writableDatabase.endTransaction();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                    }
                }
            } catch (java.lang.Throwable th) {
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    writableDatabase.endTransaction();
                }
                throw th;
            }
        }
    }

    public static synchronized void b() {
        if (com.tencent.tmdownloader.internal.b.a.a.e() == null) {
            return;
        }
        android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.delete("reportInfo", "key = ?", new java.lang.String[]{com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REPORT});
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0092 A[Catch: all -> 0x009d, PHI: r2
  0x0092: PHI (r2v5 android.database.Cursor) = (r2v4 android.database.Cursor), (r2v6 android.database.Cursor) binds: [B:27:0x0090, B:21:0x0087] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:8:0x0010, B:28:0x0092, B:32:0x0099, B:33:0x009c, B:10:0x001c, B:12:0x002a, B:14:0x003d, B:16:0x0043, B:18:0x0072, B:19:0x007e, B:26:0x008d), top: B:41:0x0003, inners: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.util.Map c() {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
        if (com.tencent.tmdownloader.internal.b.a.a.e() == null) {
            return concurrentHashMap;
        }
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.tencent.tmdownloader.internal.b.a.a.e().getWritableDatabase().query("reportInfo", new java.lang.String[]{com.tencent.open.SocialConstants.PARAM_TYPE, "blob"}, "key = ?", new java.lang.String[]{com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REPORT}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    do {
                        int iIntValue = java.lang.Integer.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex(com.tencent.open.SocialConstants.PARAM_TYPE))).intValue();
                        java.lang.String str = new java.lang.String(cursorQuery.getBlob(cursorQuery.getColumnIndex("blob")), "UTF-8");
                        java.util.List arrayList = (java.util.List) concurrentHashMap.get(java.lang.Integer.valueOf(iIntValue));
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                            concurrentHashMap.put(java.lang.Integer.valueOf(iIntValue), arrayList);
                        }
                        arrayList.add(str);
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return concurrentHashMap;
        } catch (java.lang.Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static synchronized java.util.Map d() {
        java.util.Map mapC;
        mapC = c();
        b();
        return mapC;
    }

    @Override // com.tencent.tmassistantbase.a.a.a
    public java.lang.String a() {
        return "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
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
