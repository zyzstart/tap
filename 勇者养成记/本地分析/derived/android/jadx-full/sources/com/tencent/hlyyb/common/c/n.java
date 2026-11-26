package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f561a = new java.util.concurrent.ConcurrentHashMap();
    private static final java.lang.Object b = new java.lang.Object();

    private n(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x005d A[DONT_GENERATE, PHI: r0 r10
  0x005d: PHI (r0v2 int) = (r0v0 int), (r0v6 int) binds: [B:32:0x005b, B:27:0x0052] A[DONT_GENERATE, DONT_INLINE]
  0x005d: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v9 android.database.Cursor) binds: [B:32:0x005b, B:27:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int a(boolean z, boolean z2) {
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        java.lang.String str;
        java.lang.String[] strArr;
        java.lang.String str2;
        java.lang.String[] strArr2;
        int count = 0;
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (z && z2) {
                cursorQuery = writableDatabase.query("halley_action_tbl", new java.lang.String[]{"key"}, null, null, null, null, null);
            } else {
                if (z) {
                    str = "halley_action_tbl";
                    strArr = new java.lang.String[]{"key"};
                    str2 = "state=?";
                    strArr2 = new java.lang.String[]{"add"};
                } else {
                    str = "halley_action_tbl";
                    strArr = new java.lang.String[]{"key"};
                    str2 = "state=?";
                    strArr2 = new java.lang.String[]{"remove"};
                }
                cursorQuery = writableDatabase.query(str, strArr, str2, strArr2, null, null, null);
            }
            if (cursorQuery != null) {
                try {
                    count = cursorQuery.getCount();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
            if (cursorQuery != null) {
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        return count;
    }

    public static com.tencent.hlyyb.common.c.n a(java.lang.String str) {
        com.tencent.hlyyb.common.c.n nVar;
        synchronized (b) {
            nVar = (com.tencent.hlyyb.common.c.n) f561a.get(str);
            if (nVar == null) {
                com.tencent.hlyyb.common.c.n nVar2 = new com.tencent.hlyyb.common.c.n(com.tencent.hlyyb.common.a.a(), "HalleyAction_" + com.tencent.hlyyb.common.a.c() + (com.tencent.hlyyb.common.a.b() ? "_test_" : "_") + com.tencent.hlyyb.common.a.j() + "_" + str + ".db", null, 2);
                f561a.put(str, nVar2);
                nVar = nVar2;
            }
        }
        return nVar;
    }

    public final void a(java.util.List list) {
        if (list.size() <= 0) {
            return;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("state", "remove");
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                long jLongValue = ((java.lang.Long) it.next()).longValue();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(jLongValue);
                writableDatabase.update("halley_action_tbl", contentValues, "key=?", new java.lang.String[]{sb.toString()});
            }
            java.util.Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = ((java.lang.Long) it2.next()).longValue();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(jLongValue2);
                writableDatabase.delete("halley_action_tbl", "key=?", new java.lang.String[]{sb2.toString()});
            }
            if (a(false, true) <= 0 || a(true, false) > 0) {
                return;
            }
            try {
                writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (android.database.SQLException unused) {
            }
            try {
                writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            } catch (android.database.SQLException e) {
                throw e;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    public final boolean a(int i) {
        if (a(true, true) <= i) {
            return false;
        }
        try {
            getWritableDatabase().delete("halley_action_tbl", null, null);
            return true;
        } catch (java.lang.Exception unused) {
            if (a(true, true) <= i) {
                return false;
            }
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
                } catch (android.database.SQLException unused2) {
                }
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
                    return false;
                } catch (android.database.SQLException e) {
                    throw e;
                }
            } catch (java.lang.Throwable unused3) {
                return false;
            }
        }
    }

    public final long b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, str);
            contentValues.put("state", "add");
            return writableDatabase.insert("halley_action_tbl", null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0068 A[DONT_GENERATE, PHI: r0
  0x0068: PHI (r0v2 android.database.Cursor) = (r0v1 android.database.Cursor), (r0v3 android.database.Cursor) binds: [B:17:0x0066, B:13:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List b(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = null;
        try {
            int i2 = 0;
            cursorQuery = getWritableDatabase().query("halley_action_tbl", null, "state=?", new java.lang.String[]{"add"}, null, null, null);
            if (cursorQuery != null) {
                int iMin = java.lang.Math.min(cursorQuery.getCount(), 11);
                if (cursorQuery.moveToFirst()) {
                    do {
                        arrayList.add(new com.tencent.hlyyb.common.c.o(cursorQuery.getLong(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA)), cursorQuery.getString(cursorQuery.getColumnIndex("state"))));
                        i2++;
                        if (i2 >= iMin) {
                            break;
                        }
                    } while (cursorQuery.moveToNext());
                }
            }
            if (cursorQuery != null) {
            }
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        } catch (android.database.SQLException e) {
            throw e;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (android.database.SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
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
                if (version < 2) {
                    onUpgrade(sQLiteDatabase, version, 2);
                } else if (version > 2) {
                    onDowngrade(sQLiteDatabase, version, 2);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (android.database.SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            } catch (android.database.SQLException e) {
                throw e;
            }
        } catch (java.lang.Exception unused2) {
        }
    }
}
