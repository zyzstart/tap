package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCCmd implements java.io.Serializable {
    public static final int _BatchDownloadAction = 9;
    public static final int _Empty = 0;
    public static final int _GetDownloadProgress = 3;
    public static final int _GetDownloadState = 2;
    public static final int _OperateDownloadTask = 1;
    public static final int _QueryDownloadTask = 4;
    public static final int _QueryLoginInfo = 6;
    public static final int _QueryLoginState = 7;
    public static final int _ServiceFreeAction = 8;
    public static final int _URIAction = 5;
    private java.lang.String __T;
    private int __value;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1104a = !com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd.class.desiredAssertionStatus();
    private static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd[] __values = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd[10];
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd Empty = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(0, 0, "Empty");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd OperateDownloadTask = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(1, 1, "OperateDownloadTask");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd GetDownloadState = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(2, 2, "GetDownloadState");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd GetDownloadProgress = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(3, 3, "GetDownloadProgress");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd QueryDownloadTask = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(4, 4, "QueryDownloadTask");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd URIAction = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(5, 5, "URIAction");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd QueryLoginInfo = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(6, 6, "QueryLoginInfo");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd QueryLoginState = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(7, 7, "QueryLoginState");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd ServiceFreeAction = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(8, 8, "ServiceFreeAction");
    public static final com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd BatchDownloadAction = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd(9, 9, "BatchDownloadAction");

    private IPCCmd(int i, int i2, java.lang.String str) {
        this.__T = new java.lang.String();
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd convert(int i) {
        int i2 = 0;
        while (true) {
            com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd[] iPCCmdArr = __values;
            if (i2 >= iPCCmdArr.length) {
                if (f1104a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (iPCCmdArr[i2].value() == i) {
                return __values[i2];
            }
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd convert(java.lang.String str) {
        int i = 0;
        while (true) {
            com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd[] iPCCmdArr = __values;
            if (i >= iPCCmdArr.length) {
                if (f1104a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (iPCCmdArr[i].toString().equals(str)) {
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
