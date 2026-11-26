package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1246a;

    public static class a extends android.database.sqlite.SQLiteOpenHelper {
        /* JADX WARN: Illegal instructions before constructor call */
        public a(@android.support.annotation.Nullable android.content.Context context, @android.support.annotation.Nullable java.lang.String str) {
            java.lang.String str2;
            if (android.text.TextUtils.isEmpty(str)) {
                str2 = "ydkbeacon_db";
            } else {
                str2 = "ydkbeacon_db_" + str;
            }
            super(context, str2, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 30);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas"));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.tencent.ydkbeacon.a.e.c.a("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", "ydkbeacon_db", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
    }

    public static synchronized com.tencent.ydkbeacon.d.i a(android.content.Context context, int i) {
        android.database.sqlite.SQLiteDatabase writableDatabase;
        com.tencent.ydkbeacon.d.i iVar;
        android.database.Cursor cursor = null;
        iVarA = null;
        com.tencent.ydkbeacon.d.i iVarA = null;
        cursor = null;
        android.database.Cursor cursor2 = null;
        cursor = null;
        try {
            if (context == null) {
                com.tencent.ydkbeacon.a.e.c.e("[db] context is null", new java.lang.Object[0]);
                return null;
            }
            try {
                try {
                    writableDatabase = new com.tencent.ydkbeacon.d.j.a(context, com.tencent.ydkbeacon.a.c.c.d().f()).getWritableDatabase();
                    try {
                        if (writableDatabase == null) {
                            com.tencent.ydkbeacon.a.e.c.e("[db] getWritableDatabase fail!", new java.lang.Object[0]);
                            if (writableDatabase != null && writableDatabase.isOpen()) {
                                writableDatabase.close();
                            }
                            return null;
                        }
                        java.util.Locale locale = java.util.Locale.US;
                        java.lang.Object[] objArr = new java.lang.Object[2];
                        objArr[0] = "_key";
                        objArr[1] = java.lang.Integer.valueOf(i);
                        android.database.Cursor cursorQuery = writableDatabase.query("t_strategy", null, java.lang.String.format(locale, " %s = %d ", objArr), null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToNext() && (iVarA = a(cursorQuery)) != null) {
                                    com.tencent.ydkbeacon.a.e.c.a("[db] read strategy key: %d", java.lang.Integer.valueOf(iVarA.b));
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                iVar = null;
                                cursor2 = cursorQuery;
                                com.tencent.ydkbeacon.a.b.d.b().a("605", "[db] TB: t_strategy query fail!");
                                com.tencent.ydkbeacon.a.e.c.a(e);
                                if (cursor2 != null && !cursor2.isClosed()) {
                                    cursor2.close();
                                }
                                if (writableDatabase == null || !writableDatabase.isOpen()) {
                                    iVarA = iVar;
                                } else {
                                    iVarA = iVar;
                                }
                                return iVarA;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                cursor = cursorQuery;
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (writableDatabase != null && writableDatabase.isOpen()) {
                                    writableDatabase.close();
                                }
                                throw th;
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        if (writableDatabase != null && writableDatabase.isOpen()) {
                            writableDatabase.close();
                        }
                        return iVarA;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        iVar = null;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    iVar = null;
                    writableDatabase = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    writableDatabase = null;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            throw th4;
        }
    }

    private static com.tencent.ydkbeacon.d.i a(android.database.Cursor cursor) {
        if (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }
        com.tencent.ydkbeacon.a.e.c.a("[db] parse bean.", new java.lang.Object[0]);
        com.tencent.ydkbeacon.d.i iVar = new com.tencent.ydkbeacon.d.i();
        iVar.f1245a = cursor.getLong(cursor.getColumnIndex("_id"));
        iVar.b = cursor.getInt(cursor.getColumnIndex("_key"));
        iVar.c = cursor.getBlob(cursor.getColumnIndex("_datas"));
        return iVar;
    }

    public static java.lang.String a() {
        if (!android.text.TextUtils.isEmpty(f1246a)) {
            return f1246a;
        }
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        f1246a = aVarA.getString("initsdkdate", "");
        if (!com.tencent.ydkbeacon.a.e.b.c().equals(f1246a)) {
            aVarA.edit().putString("initsdkdate", com.tencent.ydkbeacon.a.e.b.c());
        }
        return f1246a;
    }

    public static boolean b() {
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        int i = com.tencent.ydkbeacon.a.e.b.c().equals(a()) ? aVarA.getInt("QUERY_TIMES_KEY", 0) : 0;
        if (i <= com.tencent.ydkbeacon.d.a.a().c()) {
            aVarA.edit().putInt("QUERY_TIMES_KEY", i + 1);
            return false;
        }
        com.tencent.ydkbeacon.a.e.c.d("[strategy] sdk init max times", new java.lang.Object[0]);
        return true;
    }

    public static boolean c() {
        com.tencent.ydkbeacon.d.b bVarB = ((com.tencent.ydkbeacon.module.StrategyModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.STRATEGY)).b();
        if (bVarB.k()) {
            com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long j = ((jCurrentTimeMillis / 60000) + 480) % 1440;
            if (j >= 0 && j <= 30 && jCurrentTimeMillis - aVarA.getLong(com.tencent.beacon.core.strategy.StrategyQueryModule.LAST_SUCCESS_STRATEGY_QUERY_TIME, 0L) <= 90000000) {
                return true;
            }
            if (com.tencent.ydkbeacon.a.e.b.c().equals(a())) {
                return aVarA.getInt(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, 0) >= bVarB.c();
            }
            aVarA.edit().putInt(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, 0);
        }
        return false;
    }

    public static void d() {
        com.tencent.ydkbeacon.d.b bVarB = ((com.tencent.ydkbeacon.module.StrategyModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.STRATEGY)).b();
        if (bVarB == null || !bVarB.k()) {
            return;
        }
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        aVarA.edit().putInt(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, aVarA.getInt(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, 0) + 1).putLong(com.tencent.beacon.core.strategy.StrategyQueryModule.LAST_SUCCESS_STRATEGY_QUERY_TIME, java.lang.System.currentTimeMillis());
    }
}
