package com.tencent.ydkbeacon.a.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends android.database.sqlite.SQLiteOpenHelper {
    public c(java.lang.String str) {
        super(com.tencent.ydkbeacon.a.c.c.d().c(), "ydkbeacon_db_" + str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setPageSize(4096L);
        sQLiteDatabase.enableWriteAheadLogging();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        com.tencent.ydkbeacon.a.e.c.a("[DB]", 0, "DBOpenHelper onCreate.", new java.lang.Object[0]);
        try {
            java.util.Iterator it = com.tencent.ydkbeacon.a.d.b.f1193a.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL((java.lang.String) it.next());
            }
        } catch (android.database.SQLException e) {
            com.tencent.ydkbeacon.a.b.d.b().a("601", "error msg: " + e.getMessage(), e);
            com.tencent.ydkbeacon.a.e.c.b("[DB] crate db table error!", new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.e.c.a(e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
        com.tencent.ydkbeacon.a.e.c.a("[DB]", 0, "OpenHelper onDowngrade %d to %d.", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.ydkbeacon.a.e.c.a("[DB]", 0, "OpenHelper onUpgrade: %d to %d.", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }
}
