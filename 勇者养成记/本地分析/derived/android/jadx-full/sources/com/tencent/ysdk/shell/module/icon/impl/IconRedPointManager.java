package com.tencent.ysdk.shell.module.icon.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconRedPointManager {
    public static java.lang.String TAG = "ICON_RedPointMgr";

    public static boolean needShowRedPoint(java.lang.String str, java.lang.String str2) {
        android.util.Log.d(TAG, "Check need Show RedPoint:");
        java.lang.String str3 = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id;
        if (android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            android.util.Log.e(TAG, "param is Empty !");
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str3);
        sb.append(str);
        boolean z = java.lang.Long.parseLong(str2) > java.lang.Long.parseLong((java.lang.String) com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.get(sb.toString(), "0"));
        android.util.Log.d(TAG, "iconID:" + str + " ts:" + str2 + " needShow" + z);
        return z;
    }

    public static void stateUpdate(java.lang.String str, java.lang.String str2) {
        android.util.Log.d(TAG, "state Update iconID:" + str + " ts:" + str2);
        java.lang.String str3 = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id;
        if (android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            android.util.Log.e(TAG, "param is Empty !");
            return;
        }
        java.lang.String str4 = str3 + str;
        if (needShowRedPoint(str, str2)) {
            com.tencent.ysdk.shell.libware.util.AppSharePreferenceMgr.put(str4, str2);
        }
        com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInnerAPI.notifyStateChange(str, false);
        com.tencent.ysdk.shell.module.icon.IconInnerAPI.notifyStateChange(str, false);
    }
}
