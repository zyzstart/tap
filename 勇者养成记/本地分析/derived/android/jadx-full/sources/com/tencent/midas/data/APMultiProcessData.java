package com.tencent.midas.data;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMultiProcessData {
    private java.lang.String guid = "";
    private long payInterfaceTime = 0;
    private int intervalTime = 0;

    public java.lang.String getGuid() {
        return this.guid;
    }

    public int getIntervalTime() {
        return this.intervalTime;
    }

    public long getPayInterfaceTime() {
        return this.payInterfaceTime;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public void setIntervalTime(int i) {
        this.intervalTime = i;
    }

    public void setPayInterfaceTime(long j) {
        this.payInterfaceTime = j;
    }
}
