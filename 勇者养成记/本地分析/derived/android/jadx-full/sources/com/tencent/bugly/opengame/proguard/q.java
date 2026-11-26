package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class q extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f403a = "bugly_db";
    private static int b = 15;
    private android.content.Context c;
    private java.util.List d;

    public q(android.content.Context context, java.util.List list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(f403a);
        sb.append("_");
        com.tencent.bugly.opengame.crashreport.common.info.a.a(context).getClass();
        sb.append("opengame");
        super(context, sb.toString(), (android.database.sqlite.SQLiteDatabase.CursorFactory) null, b);
        this.c = context;
        this.d = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            java.lang.String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i = 0; i < 3; i++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + strArr[i], new java.lang.String[0]);
            }
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
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
                com.tencent.bugly.opengame.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.bugly.opengame.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
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
                com.tencent.bugly.opengame.proguard.x.d("[Database] Try to get db(count: %d).", java.lang.Integer.valueOf(i));
                if (i == 5) {
                    com.tencent.bugly.opengame.proguard.x.e("[Database] Failed to get db.", new java.lang.Object[0]);
                }
                try {
                    java.lang.Thread.sleep(200L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            com.tencent.bugly.opengame.proguard.x.d("[Database] db error delay error record 1min.", new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002");
            sb.append(" (_id");
            sb.append(" integer primary key autoincrement, _time");
            sb.append(" INTEGER, _datas");
            sb.append(" blob)");
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
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
            com.tencent.bugly.opengame.proguard.x.c(sb.toString(), new java.lang.Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new java.lang.String[0]);
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                th.printStackTrace();
            }
        }
        java.util.List list = this.d;
        if (list == null) {
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((com.tencent.bugly.opengame.a) it.next()).onDbCreate(sQLiteDatabase);
            } catch (java.lang.Throwable th2) {
                if (!com.tencent.bugly.opengame.proguard.x.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    @android.annotation.TargetApi(11)
    public final synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.tencent.bugly.opengame.crashreport.common.info.b.c() >= 11) {
            com.tencent.bugly.opengame.proguard.x.d("[Database] Downgrade %d to %d drop tables.", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            java.util.List list = this.d;
            if (list != null) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((com.tencent.bugly.opengame.a) it.next()).onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (java.lang.Throwable th) {
                        if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            com.tencent.bugly.opengame.proguard.x.d("[Database] Failed to drop, delete db.", new java.lang.Object[0]);
            java.io.File databasePath = this.c.getDatabasePath(f403a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.tencent.bugly.opengame.proguard.x.d("[Database] Upgrade %d to %d , drop tables!", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            java.util.List list = this.d;
            if (list != null) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((com.tencent.bugly.opengame.a) it.next()).onDbUpgrade(sQLiteDatabase, i, i2);
                    } catch (java.lang.Throwable th) {
                        if (!com.tencent.bugly.opengame.proguard.x.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            com.tencent.bugly.opengame.proguard.x.d("[Database] Failed to drop, delete db.", new java.lang.Object[0]);
            java.io.File databasePath = this.c.getDatabasePath(f403a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }
}
