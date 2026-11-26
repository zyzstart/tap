package com.dmlt.tracking.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UinInfo {
    private java.lang.String channelName;
    private int region;
    private int uin;

    public UinInfo(int i, int i2, java.lang.String str) {
        this.uin = i;
        this.region = i2;
        this.channelName = str;
    }

    public java.lang.String getChannelName() {
        return this.channelName;
    }

    public int getRegion() {
        return this.region;
    }

    public int getUin() {
        return this.uin;
    }
}
