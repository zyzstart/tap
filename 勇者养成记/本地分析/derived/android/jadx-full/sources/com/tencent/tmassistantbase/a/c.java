package com.tencent.tmassistantbase.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class c extends android.database.sqlite.SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1004a = "c";

    public c(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        com.tencent.tmassistantbase.util.TMLog.i(f1004a, "tables count:" + a().length);
        for (java.lang.Class cls : a()) {
            try {
                java.lang.String strA = ((com.tencent.tmassistantbase.a.a.a) cls.newInstance()).a();
                if (strA != null && strA.length() > 0) {
                    sQLiteDatabase.execSQL(strA);
                }
                com.tencent.tmassistantbase.util.TMLog.i(f1004a, "sql=" + strA);
            } catch (java.lang.IllegalAccessException e) {
                com.tencent.tmassistantbase.util.TMLog.e(f1004a, "exception: ", e);
                e.printStackTrace();
            } catch (java.lang.InstantiationException e2) {
                com.tencent.tmassistantbase.util.TMLog.e(f1004a, "exception: ", e2);
                e2.printStackTrace();
            }
        }
    }

    private android.database.sqlite.SQLiteDatabase e() {
        android.database.sqlite.SQLiteDatabase writableDatabase = super.getWritableDatabase();
        while (true) {
            if (!writableDatabase.isDbLockedByCurrentThread() && !writableDatabase.isDbLockedByOtherThreads()) {
                return writableDatabase;
            }
            android.os.SystemClock.sleep(10L);
        }
    }

    private android.database.sqlite.SQLiteDatabase f() {
        android.database.sqlite.SQLiteDatabase readableDatabase = super.getReadableDatabase();
        while (true) {
            if (!readableDatabase.isDbLockedByCurrentThread() && !readableDatabase.isDbLockedByOtherThreads()) {
                return readableDatabase;
            }
            android.os.SystemClock.sleep(10L);
        }
    }

    public abstract java.lang.Class[] a();

    public abstract int b();

    public synchronized com.tencent.tmassistantbase.a.b c() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseE;
        sQLiteDatabaseE = null;
        try {
            sQLiteDatabaseE = e();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            android.os.SystemClock.sleep(10L);
            try {
                sQLiteDatabaseE = e();
            } catch (java.lang.Throwable th2) {
                android.util.Log.w("download_db", "get write db final fail." + th2);
                th2.printStackTrace();
            }
        }
        return new com.tencent.tmassistantbase.a.b(sQLiteDatabaseE);
    }

    public synchronized com.tencent.tmassistantbase.a.b d() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseF;
        sQLiteDatabaseF = null;
        try {
            sQLiteDatabaseF = f();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            android.os.SystemClock.sleep(10L);
            try {
                sQLiteDatabaseF = f();
            } catch (java.lang.Throwable th2) {
                android.util.Log.w("download_db", "get read db final fail." + th2);
                th2.printStackTrace();
            }
        }
        return new com.tencent.tmassistantbase.a.b(sQLiteDatabaseF);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        android.database.sqlite.SQLiteDatabase readableDatabase;
        readableDatabase = null;
        try {
            readableDatabase = super.getReadableDatabase();
            while (true) {
                if (!readableDatabase.isDbLockedByCurrentThread() && !readableDatabase.isDbLockedByOtherThreads()) {
                    break;
                }
                android.os.SystemClock.sleep(10L);
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1004a, "exception: ", e);
            e.printStackTrace();
        }
        return readableDatabase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        android.database.sqlite.SQLiteDatabase writableDatabase;
        writableDatabase = null;
        try {
            writableDatabase = super.getWritableDatabase();
            while (true) {
                if (!writableDatabase.isDbLockedByCurrentThread() && !writableDatabase.isDbLockedByOtherThreads()) {
                    break;
                }
                android.os.SystemClock.sleep(10L);
            }
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1004a, "exception: ", e);
            e.printStackTrace();
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        com.tencent.tmassistantbase.util.TMLog.i(f1004a, " dbversion:" + version + " newVersion:" + b());
        if (version == 0) {
            return;
        }
        if (version < b()) {
            onUpgrade(sQLiteDatabase, version, b());
        } else if (version > b()) {
            onDowngrade(sQLiteDatabase, version, b());
        } else {
            a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            for (java.lang.Class cls : a()) {
                try {
                    com.tencent.tmassistantbase.a.a.a aVar = (com.tencent.tmassistantbase.a.a.a) cls.newInstance();
                    int i3 = i + 1;
                    aVar.a(i, i3, sQLiteDatabase);
                    java.lang.String[] strArrA = aVar.a(i, i3);
                    if (strArrA != null) {
                        for (java.lang.String str : strArrA) {
                            sQLiteDatabase.execSQL(str);
                        }
                    }
                    aVar.b(i, i3, sQLiteDatabase);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }
}
