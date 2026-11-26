package com.tencent.ysdk.shell.framework.database;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseTableModel {
    protected static com.tencent.ysdk.a.e t;

    protected static int deleteAll(com.tencent.ysdk.shell.framework.database.BaseDBHelper baseDBHelper, java.lang.String str) {
        try {
            return baseDBHelper.getWritableDatabase().delete(str, null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected static com.tencent.ysdk.a.e ge() {
        try {
            if (t == null) {
                t = new com.tencent.ysdk.a.e(gk());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    protected static java.lang.String getDesString(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] bArrF2 = ge().f2(str);
            return bArrF2 != null ? new java.lang.String(bArrF2) : str;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    protected static java.lang.String getDesStringByName(android.database.Cursor cursor, java.lang.String str) {
        return getDesString(cursor.getString(cursor.getColumnIndex(str)));
    }

    protected static int getIntByName(android.database.Cursor cursor, java.lang.String str) {
        return cursor.getInt(cursor.getColumnIndex(str));
    }

    protected static long getLongByName(android.database.Cursor cursor, java.lang.String str) {
        return cursor.getLong(cursor.getColumnIndex(str));
    }

    protected static java.lang.String getStringByName(android.database.Cursor cursor, java.lang.String str) {
        return cursor.getString(cursor.getColumnIndex(str));
    }

    protected static byte[] gk() {
        java.lang.String androidId;
        try {
            androidId = com.tencent.ysdk.shell.libware.device.DeviceUtils.getAndroidId(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            androidId = "";
        }
        byte[] bArr = new byte[0];
        try {
            return com.tencent.ysdk.a.a.b(androidId);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    protected static void putEnValues(android.content.ContentValues contentValues, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            contentValues.put(str, "");
            return;
        }
        try {
            java.lang.String strF3 = ge().f3(str2.getBytes());
            if (android.text.TextUtils.isEmpty(strF3)) {
                contentValues.put(str, str2);
            } else {
                contentValues.put(str, strF3);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            contentValues.put(str, str2);
        }
    }

    protected static void putValues(android.content.ContentValues contentValues, java.lang.String str, int i) {
        contentValues.put(str, java.lang.Integer.valueOf(i));
    }

    protected static void putValues(android.content.ContentValues contentValues, java.lang.String str, long j) {
        contentValues.put(str, java.lang.Long.valueOf(j));
    }

    protected static void putValues(android.content.ContentValues contentValues, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            contentValues.put(str, "");
        } else {
            contentValues.put(str, str2);
        }
    }
}
