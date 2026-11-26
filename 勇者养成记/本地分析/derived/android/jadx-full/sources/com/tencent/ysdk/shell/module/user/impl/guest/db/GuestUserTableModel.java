package com.tencent.ysdk.shell.module.user.impl.guest.db;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GuestUserTableModel extends com.tencent.ysdk.shell.framework.database.BaseTableModel {
    public static final java.lang.String TABLE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS [guest_user_info] ([open_id] NVARCHAR(128)  UNIQUE NOT NULL,[pf] NVARCHAR(64)  NULL,[pf_key] NVARCHAR(128)  NULL,[regc] NVARCHAR(64)  NULL,[is_active] BOOLEAN  NULL,[create_at] TIMESTAMP  NULL,[update_at] TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL)";
    public static final java.lang.String TABLE_DROP_SQL = "DROP TABLE IF EXISTS guest_user_info";
    public static final java.lang.String TABLE_NAME = "guest_user_info";
    public static final java.lang.String TAG = "GuestUserTableModel";
    private static final java.lang.String col_create_at = "create_at";
    private static final java.lang.String col_is_active = "is_active";
    private static final java.lang.String col_open_id = "open_id";
    private static final java.lang.String col_pf = "pf";
    private static final java.lang.String col_pf_key = "pf_key";
    private static final java.lang.String col_regChannel = "regc";
    private static final java.lang.String col_update_at = "update_at";

    public static int clearUserLoginRet() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("pf", "");
        contentValues.put(col_pf_key, "");
        contentValues.put(col_is_active, (java.lang.Integer) 0);
        contentValues.put(col_regChannel, "");
        contentValues.put(col_update_at, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        int iUpdate = com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance().update(TABLE_NAME, contentValues, null, null);
        com.tencent.ysdk.shell.libware.file.Logger.d("GuestUserDBHelper", "clearUserLoginRet rows:" + iUpdate);
        return iUpdate;
    }

    public static int deleteAll() {
        return deleteAll(com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance(), TABLE_NAME);
    }

    private static com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet getColumnData(android.database.Cursor cursor) {
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet();
        if (cursor != null) {
            try {
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    java.lang.String desStringByName = getDesStringByName(cursor, col_regChannel);
                    if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(desStringByName)) {
                        desStringByName = com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
                    }
                    guestUserLoginRet.setRegChannel(desStringByName);
                    java.lang.String stringByName = getStringByName(cursor, "open_id");
                    if (stringByName == null) {
                        stringByName = "";
                    }
                    guestUserLoginRet.open_id = stringByName;
                    java.lang.String desStringByName2 = getDesStringByName(cursor, "pf");
                    if (desStringByName2 == null) {
                        desStringByName2 = "";
                    }
                    guestUserLoginRet.pf = desStringByName2;
                    java.lang.String desStringByName3 = getDesStringByName(cursor, col_pf_key);
                    if (desStringByName3 == null) {
                        desStringByName3 = "";
                    }
                    guestUserLoginRet.pf_key = desStringByName3;
                    guestUserLoginRet.create_timestamp = getLongByName(cursor, col_create_at);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return guestUserLoginRet;
    }

    private static boolean hasUserLoginRet(java.lang.String str) {
        com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
        dBQueryParams.setTable(TABLE_NAME);
        dBQueryParams.setSelection(" open_id = ? ");
        boolean z = false;
        dBQueryParams.setSelectionArgs(new java.lang.String[]{str});
        android.database.Cursor cursorQueryInfo = com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance().queryInfo(dBQueryParams);
        if (cursorQueryInfo != null) {
            try {
                if (cursorQueryInfo.getCount() > 0) {
                    z = true;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (cursorQueryInfo != null) {
            cursorQueryInfo.close();
        }
        return z;
    }

    private static boolean insertUserLoginRet(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        return com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance().insert(TABLE_NAME, null, userLoginRet2CV(guestUserLoginRet)) != -1;
    }

    public static com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet readLastUserLoginRet() {
        com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
        dBQueryParams.setTable(TABLE_NAME);
        dBQueryParams.setOrderBy(" `update_at` DESC ");
        dBQueryParams.setLimit("1");
        android.database.Cursor cursorQueryInfo = com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance().queryInfo(dBQueryParams);
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet columnData = getColumnData(cursorQueryInfo);
        if (cursorQueryInfo != null) {
            cursorQueryInfo.close();
        }
        return columnData;
    }

    public static boolean saveUserLoginRet(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        if (guestUserLoginRet == null || guestUserLoginRet.open_id == null) {
            return false;
        }
        return hasUserLoginRet(guestUserLoginRet.open_id) ? updateUserLoginRet(guestUserLoginRet) : insertUserLoginRet(guestUserLoginRet);
    }

    private static boolean updateUserLoginRet(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        return com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserDBHelper.getInstance().update(TABLE_NAME, userLoginRet2CV(guestUserLoginRet), " `open_id` = ? ", new java.lang.String[]{guestUserLoginRet.open_id}) != 0;
    }

    private static android.content.ContentValues userLoginRet2CV(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        putValues(contentValues, "open_id", guestUserLoginRet.open_id);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(guestUserLoginRet.pf)) {
            putEnValues(contentValues, "pf", guestUserLoginRet.pf);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(guestUserLoginRet.pf_key)) {
            putEnValues(contentValues, col_pf_key, guestUserLoginRet.pf_key);
        }
        if (!com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDefauleChannel(guestUserLoginRet.getRegChannel())) {
            putEnValues(contentValues, col_regChannel, guestUserLoginRet.getRegChannel());
        }
        long jCurrentTimeMillis = guestUserLoginRet.create_timestamp;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        }
        putValues(contentValues, col_create_at, jCurrentTimeMillis);
        putValues(contentValues, col_update_at, java.lang.System.currentTimeMillis());
        putValues(contentValues, col_is_active, 1);
        return contentValues;
    }
}
