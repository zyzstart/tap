package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ResponseHeadErrorCode implements java.io.Serializable {
    public static final int _EC_BUSINESS_ERROR = -11;
    public static final int _EC_SERVER_INTERNAL_ERROR = -10;
    private java.lang.String __T;
    private int __value;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1034a = !com.tencent.tmassistantbase.jce.ResponseHeadErrorCode.class.desiredAssertionStatus();
    private static com.tencent.tmassistantbase.jce.ResponseHeadErrorCode[] __values = new com.tencent.tmassistantbase.jce.ResponseHeadErrorCode[2];
    public static final com.tencent.tmassistantbase.jce.ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR = new com.tencent.tmassistantbase.jce.ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
    public static final com.tencent.tmassistantbase.jce.ResponseHeadErrorCode EC_BUSINESS_ERROR = new com.tencent.tmassistantbase.jce.ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");

    private ResponseHeadErrorCode(int i, int i2, java.lang.String str) {
        this.__T = new java.lang.String();
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.ResponseHeadErrorCode convert(int i) {
        int i2 = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.ResponseHeadErrorCode[] responseHeadErrorCodeArr = __values;
            if (i2 >= responseHeadErrorCodeArr.length) {
                if (f1034a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (responseHeadErrorCodeArr[i2].value() == i) {
                return __values[i2];
            }
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.ResponseHeadErrorCode convert(java.lang.String str) {
        int i = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.ResponseHeadErrorCode[] responseHeadErrorCodeArr = __values;
            if (i >= responseHeadErrorCodeArr.length) {
                if (f1034a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (responseHeadErrorCodeArr[i].toString().equals(str)) {
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
