package com.tencent.beaconselfupdate.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.Object f225a = new java.lang.Object();
    private static android.database.sqlite.SQLiteDatabase c;
    private android.content.Context b;

    private c(android.content.Context context) {
        super(context, "beacon_selfupdate_db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 23);
        this.b = context;
    }

    public static synchronized com.tencent.beaconselfupdate.a.a.c a(android.content.Context context) {
        return new com.tencent.beaconselfupdate.a.a.c(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorQuery = null;
        try {
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
            cursorQuery = sQLiteDatabase.query("sqlite_master", new java.lang.String[]{"name"}, "type = 'table'", null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
            if (arrayList.size() > 0) {
                for (java.lang.String str : arrayList) {
                    if (!str.equals("sqlite_sequence") && !str.equals("android_metadata")) {
                        sQLiteDatabase.execSQL(java.lang.String.format(java.util.Locale.US, "drop table if exists %s", str));
                        com.tencent.beaconselfupdate.c.a.g("drop %s", str);
                    }
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beaconselfupdate.c.a.a(th);
                return false;
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        int i = 0;
        while (c == null && i < 5) {
            i++;
            try {
                c = super.getWritableDatabase();
            } catch (java.lang.Exception unused) {
                com.tencent.beaconselfupdate.c.a.c("getWritableDatabase error count %d", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.beaconselfupdate.c.a.d("error get DB failed", new java.lang.Object[0]);
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (java.lang.InterruptedException e) {
                    com.tencent.beaconselfupdate.c.a.a(e);
                }
            }
        }
        return c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            java.lang.String[][] strArr = com.tencent.beaconselfupdate.a.a.b.f224a;
            if (strArr != null) {
                for (java.lang.String[] strArr2 : strArr) {
                    com.tencent.beaconselfupdate.c.a.g("table:%s", strArr2[0]);
                    sQLiteDatabase.execSQL(strArr2[1]);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beaconselfupdate.a.e.a(this.b);
        if (java.lang.Integer.parseInt(com.tencent.beaconselfupdate.a.e.c()) >= 11) {
            com.tencent.beaconselfupdate.c.a.g("downgrade a db  [%s] from v %d to  v%d , deleted all tables!", "beacon_selfupdate_db", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            if (a(sQLiteDatabase)) {
                com.tencent.beaconselfupdate.c.a.g("drop all success recreate!", new java.lang.Object[0]);
                onCreate(sQLiteDatabase);
            } else {
                com.tencent.beaconselfupdate.c.a.d("drop all fail try deleted file,may next time will success!", new java.lang.Object[0]);
                java.io.File databasePath = this.b.getDatabasePath("beacon_selfupdate_db");
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beaconselfupdate.c.a.g("upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_selfupdate_db", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        if (a(sQLiteDatabase)) {
            com.tencent.beaconselfupdate.c.a.g("drop all success recreate!", new java.lang.Object[0]);
            onCreate(sQLiteDatabase);
            return;
        }
        com.tencent.beaconselfupdate.c.a.d("drop all fail try deleted file,may next time will success!", new java.lang.Object[0]);
        java.io.File databasePath = this.b.getDatabasePath("beacon_selfupdate_db");
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
