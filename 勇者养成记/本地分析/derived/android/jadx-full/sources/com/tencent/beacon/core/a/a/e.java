package com.tencent.beacon.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f128a = new java.util.HashMap();
    private static java.util.Map b = new java.util.HashMap();
    protected android.content.Context c;
    private android.database.sqlite.SQLiteDatabase d;

    /* JADX WARN: Illegal instructions before constructor call */
    private e(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        if (com.tencent.beacon.core.e.j.b(str)) {
            str2 = "beacon_db";
        } else {
            str2 = "beacon_db_" + str;
        }
        super(context, str2, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, com.tencent.beacon.core.a.a.d.f127a);
        this.d = null;
        this.c = context;
    }

    public static synchronized com.tencent.beacon.core.a.a.e a(android.content.Context context, java.lang.String str) {
        com.tencent.beacon.core.a.a.e eVar;
        eVar = (com.tencent.beacon.core.a.a.e) f128a.get(str);
        if (eVar == null) {
            eVar = new com.tencent.beacon.core.a.a.e(context, str);
            f128a.put(str, eVar);
            b.put(str, new java.lang.Object());
        }
        return eVar;
    }

    public static java.lang.Object a(java.lang.String str) {
        java.lang.Object obj = b.get(str);
        if (obj != null) {
            return obj;
        }
        java.lang.Object obj2 = new java.lang.Object();
        b.put(str, obj2);
        return obj2;
    }

    private void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase)) {
            com.tencent.beacon.core.e.d.g("[db] drop all success recreate!", new java.lang.Object[0]);
            onCreate(sQLiteDatabase);
            return;
        }
        com.tencent.beacon.core.e.d.i("[db] drop all fail try deleted file,may next time will success!", new java.lang.Object[0]);
        java.io.File databasePath = this.c.getDatabasePath("beacon_db");
        if (databasePath == null || !databasePath.canWrite()) {
            return;
        }
        databasePath.delete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorQuery = null;
        try {
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
            java.lang.String[] strArr = new java.lang.String[1];
            strArr[0] = "name";
            cursorQuery = sQLiteDatabase.query("sqlite_master", strArr, "type = 'table'", null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
            if (arrayList.size() > 0) {
                for (java.lang.String str : arrayList) {
                    if (!str.equals("sqlite_sequence") && !str.equals("android_metadata")) {
                        sQLiteDatabase.execSQL(java.lang.String.format(java.util.Locale.US, "drop table if exists %s", str));
                        com.tencent.beacon.core.e.d.g("[db] drop %s", str);
                    }
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.tencent.beacon.core.d.i.a(this.c).a("503", "[db] drop all tables error! ", th);
                com.tencent.beacon.core.e.d.a(th);
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
    public synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        int i = 0;
        while (this.d == null && i < 5) {
            i++;
            try {
                this.d = super.getWritableDatabase();
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.i("[db] getWritableDatabase error count %d", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.beacon.core.d.i.a(this.c).a("503", "[db] get WritableDatabase error! ", e);
                    com.tencent.beacon.core.e.d.b("[db] error get DB failed", new java.lang.Object[0]);
                } else {
                    try {
                        java.lang.Thread.sleep(200L);
                    } catch (java.lang.InterruptedException e2) {
                        com.tencent.beacon.core.e.d.a(e2);
                    }
                }
            }
        }
        return this.d;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            java.lang.String[][] strArr = com.tencent.beacon.core.a.a.d.b;
            if (strArr != null) {
                for (java.lang.String[] strArr2 : strArr) {
                    com.tencent.beacon.core.e.d.g("[db] Table:%s", strArr2[0]);
                    sQLiteDatabase.execSQL(strArr2[1]);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @android.annotation.TargetApi(11)
    public synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.tencent.beacon.core.info.e.d(this.c).c() >= 11) {
            com.tencent.beacon.core.e.d.g("[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", "beacon_db", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beacon.core.e.d.g("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_db", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        b(sQLiteDatabase);
    }
}
