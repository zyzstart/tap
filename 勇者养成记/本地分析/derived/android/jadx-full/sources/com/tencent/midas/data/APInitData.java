package com.tencent.midas.data;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APInitData {
    private static com.tencent.midas.data.APInitData gInstance;
    private static int initdataCount;
    private java.lang.String initGUID;
    private long initInterfaceTime;

    private APInitData() {
        this.initInterfaceTime = 0L;
        this.initGUID = "";
        initdataCount = 0;
        this.initInterfaceTime = 0L;
        this.initGUID = "";
    }

    public static int getInitdataCount() {
        int i = initdataCount;
        initdataCount = i + 1;
        return i;
    }

    public static void init() {
        gInstance = new com.tencent.midas.data.APInitData();
    }

    public static void setInitdataCount(int i) {
        initdataCount = i;
    }

    public static com.tencent.midas.data.APInitData singleton() {
        if (gInstance == null) {
            gInstance = new com.tencent.midas.data.APInitData();
        }
        return gInstance;
    }

    public java.lang.String getInitGUID() {
        return this.initGUID;
    }

    public long getInitInterfaceTime() {
        return this.initInterfaceTime;
    }

    public void setInitGUID(java.lang.String str) {
        this.initGUID = str;
    }

    public void setInitInterfaceTime(long j) {
        this.initInterfaceTime = j;
    }
}
