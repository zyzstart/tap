package com.tencent.ysdk.shell.module.user.impl.wx.db;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserDBHelper extends com.tencent.ysdk.shell.framework.database.BaseDBHelper {
    private static final java.lang.String DB_NAME = "WXUser";
    private static final int DB_VERSION = 4;
    private static volatile com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserDBHelper instance;

    private WXUserDBHelper(android.content.Context context, java.lang.String str, int i) {
        super(context, str, i);
    }

    public static com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserDBHelper getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserDBHelper.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserDBHelper(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), DB_NAME, 4);
                }
            }
        }
        return instance;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.TABLE_CREATE_SQL);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @android.annotation.SuppressLint({"Override"})
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.TABLE_DROP_SQL);
            onCreate(sQLiteDatabase);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.TABLE_DROP_SQL);
            onCreate(sQLiteDatabase);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
