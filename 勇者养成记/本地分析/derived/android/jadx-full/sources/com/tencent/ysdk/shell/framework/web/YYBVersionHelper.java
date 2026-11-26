package com.tencent.ysdk.shell.framework.web;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YYBVersionHelper {
    public static java.lang.String getYYBListVersion() {
        try {
            java.lang.String[] list = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getAssets().list("");
            if (list != null && list.length > 0) {
                for (java.lang.String str : list) {
                    if (!android.text.TextUtils.isEmpty(str) && str.startsWith("yyblite_")) {
                        java.lang.String[] strArrSplit = str.split("_");
                        return strArrSplit.length > 1 ? strArrSplit[1] : str;
                    }
                }
                return "0";
            }
            return "0";
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e("getYYBListVersion error:" + e.getMessage());
            return "0";
        }
    }
}
