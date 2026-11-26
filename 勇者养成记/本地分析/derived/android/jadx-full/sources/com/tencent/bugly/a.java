package com.tencent.bugly;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {
    public int id;
    public java.lang.String moduleName;
    public java.lang.String version;
    public java.lang.String versionKey;

    public abstract java.lang.String[] getTables();

    public abstract void init(android.content.Context context, boolean z, com.tencent.bugly.BuglyStrategy buglyStrategy);

    public void onDbCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            for (java.lang.String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onDbUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() == null) {
                return;
            }
            for (java.lang.String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            onDbCreate(sQLiteDatabase);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onServerStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBean) {
    }
}
