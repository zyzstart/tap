package com.tencent.yybsdk.apkpatch.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b extends android.database.sqlite.SQLiteOpenHelper {
    public b(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        for (java.lang.Class cls : b()) {
            java.lang.String strB = null;
            try {
                strB = ((com.tencent.yybsdk.apkpatch.e.b.b) cls.newInstance()).b();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (strB != null && strB.length() > 0) {
                sQLiteDatabase.execSQL(strB);
            }
        }
    }

    private void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        for (java.lang.Class cls : b()) {
            try {
                sQLiteDatabase.delete(((com.tencent.yybsdk.apkpatch.e.b.b) cls.newInstance()).a(), null, null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract int a();

    public abstract java.lang.Class[] b();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        android.database.sqlite.SQLiteDatabase readableDatabase;
        readableDatabase = super.getReadableDatabase();
        while (true) {
            if (readableDatabase.isDbLockedByCurrentThread() || readableDatabase.isDbLockedByOtherThreads()) {
                android.os.SystemClock.sleep(10L);
            }
        }
        return readableDatabase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        android.database.sqlite.SQLiteDatabase writableDatabase;
        writableDatabase = super.getWritableDatabase();
        while (true) {
            if (writableDatabase.isDbLockedByCurrentThread() || writableDatabase.isDbLockedByOtherThreads()) {
                android.os.SystemClock.sleep(10L);
            }
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
        for (java.lang.Class cls : b()) {
            try {
                ((com.tencent.yybsdk.apkpatch.e.b.b) cls.newInstance()).d();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        if (version == 0) {
            return;
        }
        if (version < a()) {
            onUpgrade(sQLiteDatabase, version, a());
        } else if (version > a()) {
            onDowngrade(sQLiteDatabase, version, a());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            for (java.lang.Class cls : b()) {
                try {
                    com.tencent.yybsdk.apkpatch.e.b.b bVar = (com.tencent.yybsdk.apkpatch.e.b.b) cls.newInstance();
                    int i3 = i + 1;
                    bVar.a(i, i3, sQLiteDatabase);
                    java.lang.String[] strArrA = bVar.a(i, i3);
                    if (strArrA != null) {
                        for (java.lang.String str : strArrA) {
                            try {
                                sQLiteDatabase.execSQL(str);
                            } catch (android.database.SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    bVar.b(i, i3, sQLiteDatabase);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            i++;
        }
    }
}
