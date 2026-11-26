package com.tencent.ydkbeacon.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class TunnelInfo {
    private java.lang.String appKey;
    private java.lang.String channelID;
    private java.lang.String version;

    public TunnelInfo(java.lang.String str) {
        this(str, "", "");
    }

    public TunnelInfo(java.lang.String str, java.lang.String str2) {
        this(str, "", str2);
    }

    public TunnelInfo(@android.support.annotation.NonNull java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.appKey = str;
        this.version = str2;
        this.channelID = com.tencent.ydkbeacon.event.c.c.a(str3);
    }

    public java.lang.String getAppKey() {
        return this.appKey;
    }

    public java.lang.String getChannelID() {
        return this.channelID;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public void setChannelID(java.lang.String str) {
        this.channelID = str;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }
}
