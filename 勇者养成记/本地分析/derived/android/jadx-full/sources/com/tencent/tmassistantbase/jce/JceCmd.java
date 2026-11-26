package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JceCmd implements java.io.Serializable {
    public static final int _Empty = 0;
    public static final int _GetAppSimpleDetail = 5;
    public static final int _GetAppUpdate = 3;
    public static final int _GetCallerSetting = 6;
    public static final int _GetConfig = 7;
    public static final int _GetHalleyUrl = 10;
    public static final int _GetHotSdkUpdate = 11;
    public static final int _GetPush = 8;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    public static final int _StatReport = 9;
    private java.lang.String __T;
    private int __value;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1029a = !com.tencent.tmassistantbase.jce.JceCmd.class.desiredAssertionStatus();
    private static com.tencent.tmassistantbase.jce.JceCmd[] __values = new com.tencent.tmassistantbase.jce.JceCmd[12];
    public static final com.tencent.tmassistantbase.jce.JceCmd Empty = new com.tencent.tmassistantbase.jce.JceCmd(0, 0, "Empty");
    public static final com.tencent.tmassistantbase.jce.JceCmd ReportLog = new com.tencent.tmassistantbase.jce.JceCmd(1, 1, "ReportLog");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetSettings = new com.tencent.tmassistantbase.jce.JceCmd(2, 2, "GetSettings");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetAppUpdate = new com.tencent.tmassistantbase.jce.JceCmd(3, 3, "GetAppUpdate");
    public static final com.tencent.tmassistantbase.jce.JceCmd ReportApkFileInfo = new com.tencent.tmassistantbase.jce.JceCmd(4, 4, "ReportApkFileInfo");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetAppSimpleDetail = new com.tencent.tmassistantbase.jce.JceCmd(5, 5, "GetAppSimpleDetail");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetCallerSetting = new com.tencent.tmassistantbase.jce.JceCmd(6, 6, "GetCallerSetting");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetConfig = new com.tencent.tmassistantbase.jce.JceCmd(7, 7, "GetConfig");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetPush = new com.tencent.tmassistantbase.jce.JceCmd(8, 8, "GetPush");
    public static final com.tencent.tmassistantbase.jce.JceCmd StatReport = new com.tencent.tmassistantbase.jce.JceCmd(9, 9, "StatReport");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetHalleyUrl = new com.tencent.tmassistantbase.jce.JceCmd(10, 10, "GetHalleyUrl");
    public static final com.tencent.tmassistantbase.jce.JceCmd GetHotSdkUpdate = new com.tencent.tmassistantbase.jce.JceCmd(11, 11, "GetHotSdkUpdate");

    private JceCmd(int i, int i2, java.lang.String str) {
        this.__T = new java.lang.String();
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.JceCmd convert(int i) {
        int i2 = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.JceCmd[] jceCmdArr = __values;
            if (i2 >= jceCmdArr.length) {
                if (f1029a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (jceCmdArr[i2].value() == i) {
                return __values[i2];
            }
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.JceCmd convert(java.lang.String str) {
        int i = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.JceCmd[] jceCmdArr = __values;
            if (i >= jceCmdArr.length) {
                if (f1029a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (jceCmdArr[i].toString().equals(str)) {
                return __values[i];
            }
            i++;
        }
    }

    public java.lang.String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }
}
