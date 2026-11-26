package com.tencent.ysdk.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareRet {
    public static int ERR_BBS_ERR_COMM = 8004;
    public static int ERR_BBS_USER_CANCEL = 8003;
    public static int ERR_QQ_ERR_COMM = 8002;
    public static int ERR_QQ_ERR_USER_CANCEL = 8001;
    public static int ERR_WX_ERR_AUTH_DENIED = 7002;
    public static int ERR_WX_ERR_ERR_COMM = 7005;
    public static int ERR_WX_ERR_SENT_FAILED = 7003;
    public static int ERR_WX_ERR_UNKNOWN = 7006;
    public static int ERR_WX_ERR_UNSUPPORT = 7004;
    public static int ERR_WX_ERR_USER_CANCEL = 7001;
    public static int SUCCESS = 7000;
    public java.lang.String extInfo;
    public boolean isFromCap;
    public int retCode;
    public java.lang.String retMsg;
    public com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType;
    public java.lang.String url;

    public enum ShareType {
        WXFriend_Screen_Capture,
        WXTimeLine_Screen_Capture,
        QQFriend_Screen_Capture,
        QZone_Screen_Capture,
        WXFriend,
        WXTimeLine,
        QQFriend,
        QZone,
        BBS,
        WXFriendURL,
        WXTimeLineURL,
        QQFriendURL,
        QZoneURL
    }

    public java.lang.String toString() {
        return "ShareRet{retCode=" + this.retCode + ", retMsg='" + this.retMsg + "', shareType=" + this.shareType + ", isFromCap=" + this.isFromCap + ", extInfo='" + this.extInfo + "', url='" + this.url + "'}";
    }
}
