package com.tencent.ysdk.shell.module.user.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserInnerPersonInfo extends com.tencent.ysdk.module.user.PersonInfo {
    private static final java.lang.String SIZE_QQ_100 = "/100";
    private static final java.lang.String SIZE_QQ_30 = "/30";
    private static final java.lang.String SIZE_QQ_50 = "/50";
    private static final java.lang.String SIZE_WX_0 = "/0";
    private static final java.lang.String SIZE_WX_132 = "/132";
    private static final java.lang.String SIZE_WX_46 = "/46";
    private static final java.lang.String SIZE_WX_64 = "/64";
    private static final java.lang.String SIZE_WX_96 = "/96";
    public static final java.lang.String TAG = "YSDK_USER_PERSON";
    public java.lang.String pictureURL = "";

    private void setPicURLsInQQPlatform(java.lang.String str, java.lang.String str2) {
        if (!str2.endsWith(SIZE_QQ_30) && !str2.endsWith(SIZE_QQ_50) && !str2.endsWith(SIZE_QQ_100)) {
            try {
                com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(str);
                this.pictureSmall = safeJSONObject.getString("small_url");
                this.pictureMiddle = safeJSONObject.getString("middle_url");
                this.pictureLarge = safeJSONObject.getString("big_url");
                return;
            } catch (org.json.JSONException unused) {
                com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "bad avatar json string");
                return;
            }
        }
        java.lang.String strSubstring = str2.substring(0, str2.lastIndexOf("/"));
        this.pictureURL = strSubstring;
        this.pictureSmall = strSubstring + SIZE_QQ_30;
        this.pictureMiddle = strSubstring + SIZE_QQ_50;
        this.pictureLarge = strSubstring + SIZE_QQ_100;
    }

    private void setPicURLsInWxPlatform(java.lang.String str) {
        if (str.endsWith(SIZE_WX_0) || str.endsWith(SIZE_WX_46) || str.endsWith(SIZE_WX_96) || str.endsWith(SIZE_WX_132) || str.endsWith(SIZE_WX_64)) {
            str = str.substring(0, str.lastIndexOf("/"));
        }
        this.pictureURL = str;
        this.pictureSmall = str + SIZE_WX_46;
        this.pictureMiddle = str + SIZE_WX_96;
        this.pictureLarge = str + SIZE_WX_132;
    }

    public void setPicURLs(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str) {
        if (com.tencent.ysdk.framework.common.ePlatform.WX == eplatform) {
            setPicURLsInWxPlatform(str);
            return;
        }
        if (com.tencent.ysdk.framework.common.ePlatform.QQ == eplatform) {
            setPicURLsInQQPlatform(str, str);
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "bad platform:" + eplatform.platformStr());
    }

    public void setQQPicURLs(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.pictureSmall = str;
        this.pictureMiddle = str2;
        this.pictureLarge = str3;
    }

    @Override // com.tencent.ysdk.module.user.PersonInfo
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("pictureURL: " + this.pictureURL + "\n");
        return super.toString() + sb.toString();
    }
}
