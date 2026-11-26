package com.tencent.ysdk.shell.framework.database;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseDBHelper extends android.database.sqlite.SQLiteOpenHelper {
    public BaseDBHelper(android.content.Context context, java.lang.String str, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i);
    }

    public synchronized int delete(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        int iDelete;
        try {
            iDelete = getWritableDatabase().delete(str, str2, strArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            iDelete = 0;
        }
        return iDelete;
    }

    public synchronized long insert(java.lang.String str, java.lang.String str2, android.content.ContentValues contentValues) {
        long jInsert;
        try {
            jInsert = getWritableDatabase().insert(str, str2, contentValues);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            jInsert = -1;
        }
        return jInsert;
    }

    public synchronized android.database.Cursor queryInfo(com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams) {
        android.database.Cursor cursorQuery;
        try {
            cursorQuery = getReadableDatabase().query(dBQueryParams.getTable(), dBQueryParams.getColumns(), dBQueryParams.getSelection(), dBQueryParams.getSelectionArgs(), dBQueryParams.getGroupBy(), dBQueryParams.getHaving(), dBQueryParams.getOrderBy(), dBQueryParams.getLimit());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            cursorQuery = null;
        }
        return cursorQuery;
    }

    public synchronized int update(java.lang.String str, android.content.ContentValues contentValues, java.lang.String str2, java.lang.String[] strArr) {
        int iUpdate;
        try {
            iUpdate = getWritableDatabase().update(str, contentValues, str2, strArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            iUpdate = 0;
        }
        return iUpdate;
    }
}
