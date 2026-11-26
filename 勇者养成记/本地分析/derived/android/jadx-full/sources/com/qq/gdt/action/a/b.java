package com.qq.gdt.action.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f67a = {"create index index_group on actions ( status,session_id,action_type ) ", "create index index_status_time on actions ( status,revised_action_time ) ", "create index index_time on actions ( revised_action_time ) "};
    private static volatile com.qq.gdt.action.a.b b;
    private android.content.Context c;
    private com.qq.gdt.action.a.b.a d;
    private final java.io.File e;
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger();
    private android.database.sqlite.SQLiteDatabase g;

    private static class a extends android.database.sqlite.SQLiteOpenHelper {
        a(android.content.Context context, java.lang.String str) {
            super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            com.qq.gdt.action.h.l.a("Creating a new gdt_action DB", new java.lang.Object[0]);
            sQLiteDatabase.execSQL("create table actions ( id INTEGER primary key autoincrement,session_id CHAR(32) not null,unique_id CHAR(32) not null,action_type TEXT not null,action_time BIGINT not null,action_param TEXT not null,revised_action_time BIGINT not null,status TINYINT not null ) ");
            for (java.lang.String str : com.qq.gdt.action.a.b.f67a) {
                sQLiteDatabase.execSQL(str);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.qq.gdt.action.h.l.a("Upgrading action sdk, replacing gdt_action DB", new java.lang.Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS actions");
            sQLiteDatabase.execSQL("create table actions ( id INTEGER primary key autoincrement,session_id CHAR(32) not null,unique_id CHAR(32) not null,action_type TEXT not null,action_time BIGINT not null,action_param TEXT not null,revised_action_time BIGINT not null,status TINYINT not null ) ");
            for (java.lang.String str : com.qq.gdt.action.a.b.f67a) {
                sQLiteDatabase.execSQL(str);
            }
        }
    }

    private b(android.content.Context context) {
        this.c = context.getApplicationContext();
        java.lang.String str = "gdt_action_" + com.qq.gdt.action.h.r.a(com.qq.gdt.action.h.d.a(this.c)) + ".db";
        com.qq.gdt.action.h.l.a("ActionDB full name is " + str, new java.lang.Object[0]);
        this.d = new com.qq.gdt.action.a.b.a(this.c, str);
        this.e = this.c.getDatabasePath(str);
    }

    private android.content.ContentValues a(com.qq.gdt.action.a.a aVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, aVar.f());
        contentValues.put("unique_id", aVar.a());
        contentValues.put("action_type", aVar.b());
        contentValues.put("action_time", java.lang.Long.valueOf(aVar.c()));
        contentValues.put("action_param", aVar.d() == null ? "" : aVar.d().toString());
        contentValues.put("revised_action_time", java.lang.Long.valueOf(aVar.g()));
        contentValues.put("status", (java.lang.Integer) 0);
        return contentValues;
    }

    public static com.qq.gdt.action.a.b a(android.content.Context context) {
        if (b == null) {
            synchronized (com.qq.gdt.action.a.b.class) {
                if (b == null) {
                    b = new com.qq.gdt.action.a.b(context);
                }
            }
        }
        return b;
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.database.Cursor cursor, boolean z) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Throwable th) {
                com.qq.gdt.action.h.l.a("Cursor close exception", th);
            }
        }
        if (sQLiteDatabase != null) {
            if (z) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (java.lang.Throwable th2) {
                    com.qq.gdt.action.h.l.a("Database close exception", th2);
                    return;
                }
            }
            d();
        }
    }

    private synchronized android.database.sqlite.SQLiteDatabase c() {
        if (this.f.incrementAndGet() == 1) {
            this.g = this.d.getWritableDatabase();
        }
        return this.g;
    }

    private synchronized void d() {
        if (this.f.decrementAndGet() == 0) {
            this.g.close();
        }
    }

    private int e() throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        try {
            sQLiteDatabaseC = c();
            try {
                try {
                    java.lang.String[] strArr = {java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 1296000000), java.lang.String.valueOf(com.qq.gdt.action.h.u.b() - 54000000)};
                    com.qq.gdt.action.h.l.a("Will delete actions with query:( status = 1 ) AND ( ( action_time < ? ) OR ( revised_action_time > 0 AND revised_action_time < ? )), values:" + java.util.Arrays.toString(strArr), new java.lang.Object[0]);
                    int iDelete = sQLiteDatabaseC.delete("actions", "( status = 1 ) AND ( ( action_time < ? ) OR ( revised_action_time > 0 AND revised_action_time < ? ))", strArr);
                    a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                    return iDelete;
                } catch (java.lang.Throwable unused) {
                    com.qq.gdt.action.h.l.c("Exception while delete actions out of date");
                    a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                    return 0;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                throw th;
            }
        } catch (java.lang.Throwable unused2) {
            sQLiteDatabaseC = null;
        }
    }

    private int f() throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        try {
            sQLiteDatabaseC = c();
            try {
                try {
                    com.qq.gdt.action.h.l.a("Will delete auto actions with query:( status = 1 ) AND (action_type in ('TICKET', 'PAGE_VIEW')), values:", new java.lang.Object[0]);
                    int iDelete = sQLiteDatabaseC.delete("actions", "( status = 1 ) AND (action_type in ('TICKET', 'PAGE_VIEW'))", null);
                    a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                    return iDelete;
                } catch (java.lang.Throwable unused) {
                    com.qq.gdt.action.h.l.c("Exception while delete actions outOfDate");
                    a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                    return 0;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            sQLiteDatabaseC = null;
            a(sQLiteDatabaseC, (android.database.Cursor) null, false);
            throw th;
        }
    }

    private int g() throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        android.database.Cursor cursor;
        android.database.Cursor cursorRawQuery = null;
        cursorRawQuery = null;
        cursorRawQuery = null;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseC = c();
            try {
                cursorRawQuery = sQLiteDatabaseC.rawQuery("SELECT COUNT(*) FROM actions", null);
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    a(sQLiteDatabaseC, cursorRawQuery, false);
                    return -1;
                }
                int i = cursorRawQuery.getInt(0);
                a(sQLiteDatabaseC, cursorRawQuery, false);
                return i;
            } catch (java.lang.Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseC;
                try {
                    com.qq.gdt.action.h.l.b("Exception while count all actions in db", th);
                    a(sQLiteDatabase, cursor, false);
                    return -1;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    android.database.Cursor cursor2 = cursor;
                    sQLiteDatabaseC = sQLiteDatabase;
                    cursorRawQuery = cursor2;
                    a(sQLiteDatabaseC, cursorRawQuery, false);
                    throw th;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabaseC = null;
        }
    }

    public int a(int i) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        android.database.Cursor cursor;
        android.database.Cursor cursorRawQuery = null;
        cursorRawQuery = null;
        cursorRawQuery = null;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        int i2 = -1;
        try {
            sQLiteDatabaseC = c();
            try {
                cursorRawQuery = sQLiteDatabaseC.rawQuery("SELECT COUNT(*) FROM actions WHERE status = " + i, null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.moveToFirst();
                    i2 = cursorRawQuery.getInt(0);
                }
                a(sQLiteDatabaseC, cursorRawQuery, false);
            } catch (java.lang.Exception e) {
                e = e;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseC;
                try {
                    com.qq.gdt.action.h.l.b("Count failed action exception", e);
                    a(sQLiteDatabase, cursor, false);
                } catch (java.lang.Throwable th) {
                    th = th;
                    android.database.Cursor cursor2 = cursor;
                    sQLiteDatabaseC = sQLiteDatabase;
                    cursorRawQuery = cursor2;
                    a(sQLiteDatabaseC, cursorRawQuery, false);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                a(sQLiteDatabaseC, cursorRawQuery, false);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabaseC = null;
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int a(java.util.List<java.lang.Long> list, int i) {
        int iUpdate;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        java.lang.String str;
        iUpdate = -3;
        try {
            try {
                sQLiteDatabaseC = c();
                try {
                    try {
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("status", java.lang.Integer.valueOf(i));
                        java.lang.String[] strArr = new java.lang.String[list.size()];
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("id");
                        sb.append(" IN ");
                        sb.append(" ( ");
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            strArr[i2] = java.lang.String.valueOf(list.get(i2));
                            if (i2 == list.size() - 1) {
                                str = com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START;
                            } else {
                                sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
                                str = ", ";
                            }
                            sb.append(str);
                        }
                        sb.append(" ) ");
                        iUpdate = sQLiteDatabaseC.update("actions", contentValues, sb.toString(), strArr);
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.qq.gdt.action.h.l.b("Database update actions status exception.", e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    a(sQLiteDatabaseC, (android.database.Cursor) null, false);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            sQLiteDatabaseC = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabaseC = null;
            a(sQLiteDatabaseC, (android.database.Cursor) null, false);
            throw th;
        }
        a(sQLiteDatabaseC, (android.database.Cursor) null, false);
        return iUpdate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.List<com.qq.gdt.action.a.a> a(int i, long j, long j2) throws java.lang.Throwable {
        android.database.Cursor cursor;
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.json.JSONObject jSONObject = null;
        try {
            sQLiteDatabaseC = c();
            try {
                android.database.Cursor cursorRawQuery = sQLiteDatabaseC.rawQuery("SELECT * FROM actions WHERE status = " + i + " AND id > " + j2 + " ORDER BY id ASC LIMIT " + j, null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            long j3 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("id"));
                            java.lang.String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID));
                            java.lang.String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("unique_id"));
                            java.lang.String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("action_type"));
                            long j4 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("action_time"));
                            long j5 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndexOrThrow("revised_action_time"));
                            java.lang.String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("action_param"));
                            org.json.JSONObject jSONObject2 = com.qq.gdt.action.h.t.a(string4) ? jSONObject : new org.json.JSONObject(string4);
                            cursor = cursorRawQuery;
                            try {
                                arrayList.add(new com.qq.gdt.action.a.a(j3, string, string2, string3, j4, j5, jSONObject2, i));
                                cursorRawQuery = cursor;
                                jSONObject = null;
                            } catch (java.lang.Exception e) {
                                e = e;
                                cursor2 = cursor;
                                sQLiteDatabase = sQLiteDatabaseC;
                                try {
                                    com.qq.gdt.action.h.l.b("Find actions by status exception", e);
                                    a(sQLiteDatabase, cursor2, false);
                                    return arrayList;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    android.database.Cursor cursor3 = cursor2;
                                    sQLiteDatabaseC = sQLiteDatabase;
                                    cursor = cursor3;
                                    a(sQLiteDatabaseC, cursor, false);
                                    throw th;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                a(sQLiteDatabaseC, cursor, false);
                                throw th;
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            cursor = cursorRawQuery;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            cursor = cursorRawQuery;
                        }
                    }
                }
                a(sQLiteDatabaseC, cursorRawQuery, false);
            } catch (java.lang.Exception e3) {
                e = e3;
                sQLiteDatabase = sQLiteDatabaseC;
                cursor2 = null;
                com.qq.gdt.action.h.l.b("Find actions by status exception", e);
                a(sQLiteDatabase, cursor2, false);
                return arrayList;
            } catch (java.lang.Throwable th4) {
                th = th4;
                cursor = null;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            sQLiteDatabase = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            cursor = null;
            sQLiteDatabaseC = null;
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.List<com.qq.gdt.action.a.c> a(long j) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        android.database.Cursor cursor;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorRawQuery = null;
        cursorRawQuery = null;
        cursorRawQuery = null;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseC = c();
            try {
                cursorRawQuery = sQLiteDatabaseC.rawQuery("select status, session_id, action_type, count(*) from actions where action_time > ? group by status, session_id, action_type", new java.lang.String[]{java.lang.String.valueOf(j)});
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        arrayList.add(new com.qq.gdt.action.a.c(cursorRawQuery.getInt(0), cursorRawQuery.getString(1), cursorRawQuery.getString(2), cursorRawQuery.getInt(3)));
                    }
                }
                a(sQLiteDatabaseC, cursorRawQuery, false);
            } catch (java.lang.Exception e) {
                e = e;
                cursor = cursorRawQuery;
                sQLiteDatabase = sQLiteDatabaseC;
                try {
                    com.qq.gdt.action.h.l.b("Count history actions by status, session_id, action_type exception", e);
                    a(sQLiteDatabase, cursor, false);
                } catch (java.lang.Throwable th) {
                    th = th;
                    sQLiteDatabaseC = sQLiteDatabase;
                    cursorRawQuery = cursor;
                    a(sQLiteDatabaseC, cursorRawQuery, false);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                a(sQLiteDatabaseC, cursorRawQuery, false);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            sQLiteDatabaseC = null;
        }
        return arrayList;
    }

    public void a() throws java.lang.Throwable {
        com.qq.gdt.action.h.l.a("Success cleaned " + e() + " out of date actions.", new java.lang.Object[0]);
        int iG = g();
        com.qq.gdt.action.h.l.a("Count all actions in db: " + iG, new java.lang.Object[0]);
        if (iG > 10000) {
            com.qq.gdt.action.h.l.a("Success deep-clean " + f() + " out of date actions.", new java.lang.Object[0]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(java.util.List<com.qq.gdt.action.a.a> list) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseC;
        boolean z;
        boolean z2 = false;
        try {
            sQLiteDatabaseC = c();
            try {
                try {
                    sQLiteDatabaseC.beginTransaction();
                    java.util.Iterator<com.qq.gdt.action.a.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        com.qq.gdt.action.a.a next = it.next();
                        long jInsert = sQLiteDatabaseC.insert("actions", null, a(next));
                        if (jInsert < 0) {
                            z = false;
                            break;
                        }
                        next.a(jInsert);
                    }
                    if (z) {
                        sQLiteDatabaseC.setTransactionSuccessful();
                    }
                    a(sQLiteDatabaseC, (android.database.Cursor) null, true);
                    z2 = z;
                } catch (java.lang.Exception e) {
                    e = e;
                    com.qq.gdt.action.h.l.b("Database add actions exception.", e);
                    a(sQLiteDatabaseC, (android.database.Cursor) null, true);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                a(sQLiteDatabaseC, (android.database.Cursor) null, true);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            sQLiteDatabaseC = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            sQLiteDatabaseC = null;
            a(sQLiteDatabaseC, (android.database.Cursor) null, true);
            throw th;
        }
        if (!z2) {
            java.util.Iterator<com.qq.gdt.action.a.a> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().a(-1L);
            }
        }
        return z2;
    }
}
