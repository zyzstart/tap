package com.tencent.ysdk.shell.module.user.impl.qq.db;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserTableModel extends com.tencent.ysdk.shell.framework.database.BaseTableModel {
    public static final java.lang.String TABLE_CREATE_SQL = "[REDACTED]";
    public static final java.lang.String TABLE_DROP_SQL = "DROP TABLE IF EXISTS qq_user_info";
    public static final java.lang.String TABLE_NAME = "qq_user_info";
    public static final java.lang.String TAG = "QQUserTableModel";
    private static final java.lang.String col_access_token = "[REDACTED]";
    private static final java.lang.String col_access_token_expire = "[REDACTED]";
    private static final java.lang.String col_age = "age";
    private static final java.lang.String col_city = "city";
    private static final java.lang.String col_country = "country";
    private static final java.lang.String col_create_at = "create_at";
    private static final java.lang.String col_gender = "gender";
    private static final java.lang.String col_is_active = "is_active";
    private static final java.lang.String col_nickname = "nickname";
    private static final java.lang.String col_open_id = "open_id";
    private static final java.lang.String col_pay_token = "[REDACTED]";
    private static final java.lang.String col_pay_token_expire = "[REDACTED]";
    private static final java.lang.String col_pf = "pf";
    private static final java.lang.String col_pf_key = "pf_key";
    private static final java.lang.String col_pic = "pictureUrl";
    private static final java.lang.String col_province = "province";
    private static final java.lang.String col_qq = "qq";
    private static final java.lang.String col_regChannel = "regc";
    private static final java.lang.String col_update_at = "update_at";
    private static final java.lang.String col_user_id = "user_id";

    public static int clearUserLoginRet() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("[REDACTED]", "[REDACTED]");
        contentValues.put(col_access_token_expire, (java.lang.Integer) 0);
        contentValues.put(col_pay_token, "[REDACTED]");
        contentValues.put(col_pay_token_expire, (java.lang.Integer) 0);
        contentValues.put("pf", "");
        contentValues.put(col_pf_key, "");
        contentValues.put(col_is_active, (java.lang.Integer) 0);
        contentValues.put(col_regChannel, "");
        contentValues.put(col_update_at, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        int iUpdate = com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().update(TABLE_NAME, contentValues, null, null);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "clearUserLoginRet rows:" + iUpdate);
        return iUpdate;
    }

    public static int deleteAll() {
        return deleteAll(com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance(), TABLE_NAME);
    }

    private static com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet getColumnData(android.database.Cursor cursor) {
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
        if (cursor != null) {
            try {
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    java.lang.String stringByName = getStringByName(cursor, "open_id");
                    if (stringByName == null) {
                        stringByName = "";
                    }
                    qQUserLoginRet.open_id = stringByName;
                    java.lang.String desStringByName = getDesStringByName(cursor, "[REDACTED]");
                    if (desStringByName == null) {
                        desStringByName = "";
                    }
                    qQUserLoginRet.access_token = desStringByName;
                    qQUserLoginRet.access_token_expire = getLongByName(cursor, col_access_token_expire);
                    java.lang.String desStringByName2 = getDesStringByName(cursor, col_pay_token);
                    if (desStringByName2 == null) {
                        desStringByName2 = "";
                    }
                    qQUserLoginRet.pay_token = desStringByName2;
                    qQUserLoginRet.pay_token_expire = getLongByName(cursor, col_pay_token_expire);
                    java.lang.String desStringByName3 = getDesStringByName(cursor, "pf");
                    if (desStringByName3 == null) {
                        desStringByName3 = "";
                    }
                    qQUserLoginRet.pf = desStringByName3;
                    java.lang.String desStringByName4 = getDesStringByName(cursor, col_pf_key);
                    if (desStringByName4 == null) {
                        desStringByName4 = "";
                    }
                    qQUserLoginRet.pf_key = desStringByName4;
                    java.lang.String desStringByName5 = getDesStringByName(cursor, col_regChannel);
                    if (android.text.TextUtils.isEmpty(desStringByName5)) {
                        desStringByName5 = com.tencent.ysdk.module.user.UserLoginRet.DEFAULT_CHANNEL;
                    }
                    qQUserLoginRet.setRegChannel(desStringByName5);
                    qQUserLoginRet.create_timestamp = getLongByName(cursor, col_create_at);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return qQUserLoginRet;
    }

    private static com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo getUserInfoFromColumnData(android.database.Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return new com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo();
        }
        com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo = new com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo();
        try {
            getUserInfoFromColumnDataInner(cursor, userInnerPersonInfo);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
        return userInnerPersonInfo;
    }

    private static void getUserInfoFromColumnDataInner(android.database.Cursor cursor, com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo) {
        cursor.moveToFirst();
        java.lang.String stringByName = getStringByName(cursor, "open_id");
        if (stringByName == null) {
            stringByName = "";
        }
        userInnerPersonInfo.openId = stringByName;
        java.lang.String desStringByName = getDesStringByName(cursor, "user_id");
        if (desStringByName == null) {
            desStringByName = "";
        }
        userInnerPersonInfo.userId = desStringByName;
        java.lang.String desStringByName2 = getDesStringByName(cursor, col_nickname);
        if (desStringByName2 == null) {
            desStringByName2 = "";
        }
        userInnerPersonInfo.nickName = desStringByName2;
        java.lang.String desStringByName3 = getDesStringByName(cursor, col_gender);
        if (desStringByName3 == null) {
            desStringByName3 = "";
        }
        userInnerPersonInfo.gender = desStringByName3;
        java.lang.String desStringByName4 = getDesStringByName(cursor, col_pic);
        com.tencent.ysdk.framework.common.ePlatform eplatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
        if (desStringByName4 == null) {
            desStringByName4 = "";
        }
        userInnerPersonInfo.setPicURLs(eplatform, desStringByName4);
        java.lang.String desStringByName5 = getDesStringByName(cursor, "country");
        if (desStringByName5 == null) {
            desStringByName5 = "";
        }
        userInnerPersonInfo.country = desStringByName5;
        java.lang.String desStringByName6 = getDesStringByName(cursor, "province");
        if (desStringByName6 == null) {
            desStringByName6 = "";
        }
        userInnerPersonInfo.province = desStringByName6;
        java.lang.String desStringByName7 = getDesStringByName(cursor, "city");
        if (desStringByName7 == null) {
            desStringByName7 = "";
        }
        userInnerPersonInfo.city = desStringByName7;
    }

    private static boolean hasUserLoginRet(java.lang.String str) {
        com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
        dBQueryParams.setTable(TABLE_NAME);
        dBQueryParams.setSelection(" open_id = ? ");
        boolean z = false;
        dBQueryParams.setSelectionArgs(new java.lang.String[]{str});
        android.database.Cursor cursorQueryInfo = com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().queryInfo(dBQueryParams);
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

    private static boolean insertUserLoginRet(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        return com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().insert(TABLE_NAME, null, userLoginRet2CV(qQUserLoginRet)) != -1;
    }

    private static boolean insertUserPersonInfo(com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "insertUserPersonInfo:");
        return com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().insert(TABLE_NAME, null, personInfo2CV(userInnerPersonInfo)) != -1;
    }

    private static android.content.ContentValues personInfo2CV(com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        putValues(contentValues, "open_id", userInnerPersonInfo.openId);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.userId)) {
            putEnValues(contentValues, "user_id", userInnerPersonInfo.userId);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.gender)) {
            putEnValues(contentValues, col_gender, userInnerPersonInfo.gender);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.nickName)) {
            putEnValues(contentValues, col_nickname, userInnerPersonInfo.nickName);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.pictureURL)) {
            putEnValues(contentValues, col_pic, userInnerPersonInfo.pictureURL);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.country)) {
            putEnValues(contentValues, "country", userInnerPersonInfo.country);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.province)) {
            putEnValues(contentValues, "province", userInnerPersonInfo.province);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(userInnerPersonInfo.city)) {
            putEnValues(contentValues, "city", userInnerPersonInfo.city);
        }
        putValues(contentValues, col_create_at, java.lang.System.currentTimeMillis());
        putValues(contentValues, col_update_at, java.lang.System.currentTimeMillis());
        return contentValues;
    }

    public static com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet readLastUserLoginRet() {
        com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
        dBQueryParams.setTable(TABLE_NAME);
        dBQueryParams.setOrderBy(" `update_at` DESC ");
        dBQueryParams.setLimit("1");
        android.database.Cursor cursorQueryInfo = com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().queryInfo(dBQueryParams);
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet columnData = getColumnData(cursorQueryInfo);
        if (cursorQueryInfo != null) {
            cursorQueryInfo.close();
        }
        return columnData;
    }

    public static com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo readPersonInfoByOpenId(java.lang.String str) {
        com.tencent.ysdk.shell.framework.database.DBQueryParams dBQueryParams = new com.tencent.ysdk.shell.framework.database.DBQueryParams();
        dBQueryParams.setTable(TABLE_NAME);
        dBQueryParams.setSelection(" `open_id` = ? ");
        dBQueryParams.setSelectionArgs(new java.lang.String[]{str});
        dBQueryParams.setLimit("1");
        android.database.Cursor cursorQueryInfo = com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().queryInfo(dBQueryParams);
        com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInfoFromColumnData = getUserInfoFromColumnData(cursorQueryInfo);
        if (cursorQueryInfo != null) {
            cursorQueryInfo.close();
        }
        return userInfoFromColumnData;
    }

    public static boolean savePersonInfo(com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "savePersonInfo:");
        if (userInnerPersonInfo == null || userInnerPersonInfo.openId == null) {
            return false;
        }
        return hasUserLoginRet(userInnerPersonInfo.openId) ? updateUserPersonInfo(userInnerPersonInfo) : insertUserPersonInfo(userInnerPersonInfo);
    }

    public static boolean saveUserLoginRet(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        if (qQUserLoginRet == null || qQUserLoginRet.open_id == null) {
            return false;
        }
        return hasUserLoginRet(qQUserLoginRet.open_id) ? updateUserLoginRet(qQUserLoginRet) : insertUserLoginRet(qQUserLoginRet);
    }

    private static boolean updateUserLoginRet(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        return com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().update(TABLE_NAME, userLoginRet2CV(qQUserLoginRet), " `open_id` = ? ", new java.lang.String[]{qQUserLoginRet.open_id}) != 0;
    }

    private static boolean updateUserPersonInfo(com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo userInnerPersonInfo) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "updateUserPersonInfo:");
        return com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserDBHelper.getInstance().update(TABLE_NAME, personInfo2CV(userInnerPersonInfo), " `open_id` = ? ", new java.lang.String[]{userInnerPersonInfo.openId}) != 0;
    }

    private static android.content.ContentValues userLoginRet2CV(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        putValues(contentValues, "open_id", qQUserLoginRet.open_id);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qQUserLoginRet.access_token)) {
            putEnValues(contentValues, "[REDACTED]", qQUserLoginRet.access_token);
            putValues(contentValues, col_access_token_expire, qQUserLoginRet.access_token_expire);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qQUserLoginRet.pay_token)) {
            putEnValues(contentValues, col_pay_token, qQUserLoginRet.pay_token);
            putValues(contentValues, col_pay_token_expire, qQUserLoginRet.pay_token_expire);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qQUserLoginRet.pf)) {
            putEnValues(contentValues, "pf", qQUserLoginRet.pf);
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qQUserLoginRet.pf_key)) {
            putEnValues(contentValues, col_pf_key, qQUserLoginRet.pf_key);
        }
        if (!com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDefauleChannel(qQUserLoginRet.getRegChannel())) {
            putEnValues(contentValues, col_regChannel, qQUserLoginRet.getRegChannel());
        }
        long jCurrentTimeMillis = qQUserLoginRet.create_timestamp;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        }
        putValues(contentValues, col_create_at, jCurrentTimeMillis);
        putValues(contentValues, col_update_at, java.lang.System.currentTimeMillis());
        putValues(contentValues, col_is_active, 1);
        return contentValues;
    }
}
