package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class q extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f445a = "bugly_db";
    private static int b = 15;
    private android.content.Context c;
    private java.util.List<com.tencent.bugly.a> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(android.content.Context context, java.util.List<com.tencent.bugly.a> list) {
        super(context, f445a + "_", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, b);
        com.tencent.bugly.crashreport.common.info.a.a(context).getClass();
        this.c = context;
        this.d = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            for (java.lang.String str : new java.lang.String[]{"t_lr", "t_ui", "t_pf"}) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str, new java.lang.String[0]);
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        android.database.sqlite.SQLiteDatabase readableDatabase;
        readableDatabase = null;
        int i = 0;
        while (readableDatabase == null && i < 5) {
            i++;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (java.lang.Throwable unused) {
                com.tencent.bugly.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.bugly.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        android.database.sqlite.SQLiteDatabase writableDatabase;
        writableDatabase = null;
        int i = 0;
        while (writableDatabase == null && i < 5) {
            i++;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (java.lang.Throwable unused) {
                com.tencent.bugly.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.bugly.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            com.tencent.bugly.proguard.x.d("[Database] db error delay error record 1min.", new java.lang.Object[0]);
        }
        return writableDatabase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _ut");
            sb.append(" int");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" ) ");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tp");
            sb.append(" int");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _pc");
            sb.append(" text");
            sb.append(" , _th");
            sb.append(" text");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr");
            sb.append(" ( _id");
            sb.append(" INTEGER PRIMARY KEY");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _s1");
            sb.append(" text");
            sb.append(" , _up");
            sb.append(" int");
            sb.append(" , _me");
            sb.append(" int");
            sb.append(" , _uc");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(" ) ");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _dUrl");
            sb.append(" varchar(100), _sFile");
            sb.append(" varchar(100), _sLen");
            sb.append(" INTEGER, _tLen");
            sb.append(" INTEGER, _MD5");
            sb.append(" varchar(100), _DLTIME");
            sb.append(" INTEGER)");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _time");
            sb.append(" INTEGER, _datas");
            sb.append(" blob)");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002");
            sb.append(" ( _id");
            sb.append(" integer");
            sb.append(" , _tp");
            sb.append(" text");
            sb.append(" , _tm");
            sb.append(" int");
            sb.append(" , _dt");
            sb.append(" blob");
            sb.append(",primary key(_id");
            sb.append(",_tp");
            sb.append(" )) ");
            com.tencent.bugly.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.b(th)) {
                th.printStackTrace();
            }
        }
        if (this.d == null) {
            return;
        }
        java.util.Iterator<com.tencent.bugly.a> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (java.lang.Throwable th2) {
                if (!com.tencent.bugly.proguard.x.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    @android.annotation.TargetApi(11)
    public final synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
            com.tencent.bugly.proguard.x.d("[Database] Downgrade %d to %d drop tables.", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            if (this.d != null) {
                java.util.Iterator<com.tencent.bugly.a> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (java.lang.Throwable th) {
                        if (!com.tencent.bugly.proguard.x.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            com.tencent.bugly.proguard.x.d("[Database] Failed to drop, delete db.", new java.lang.Object[0]);
            java.io.File databasePath = this.c.getDatabasePath(f445a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.tencent.bugly.proguard.x.d("[Database] Upgrade %d to %d , drop tables!", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            if (this.d != null) {
                java.util.Iterator<com.tencent.bugly.a> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbUpgrade(sQLiteDatabase, i, i2);
                    } catch (java.lang.Throwable th) {
                        if (!com.tencent.bugly.proguard.x.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            com.tencent.bugly.proguard.x.d("[Database] Failed to drop, delete db.", new java.lang.Object[0]);
            java.io.File databasePath = this.c.getDatabasePath(f445a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }
}
