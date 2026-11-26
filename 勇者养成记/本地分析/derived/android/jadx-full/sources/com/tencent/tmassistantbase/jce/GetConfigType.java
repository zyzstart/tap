package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetConfigType implements java.io.Serializable {
    public static final int _ACTIVE_PROCESS_CFG = 2;
    public static final int _PUSH_CFG = 1;
    private java.lang.String __T;
    private int __value;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1028a = !com.tencent.tmassistantbase.jce.GetConfigType.class.desiredAssertionStatus();
    private static com.tencent.tmassistantbase.jce.GetConfigType[] __values = new com.tencent.tmassistantbase.jce.GetConfigType[2];
    public static final com.tencent.tmassistantbase.jce.GetConfigType PUSH_CFG = new com.tencent.tmassistantbase.jce.GetConfigType(0, 1, "PUSH_CFG");
    public static final com.tencent.tmassistantbase.jce.GetConfigType ACTIVE_PROCESS_CFG = new com.tencent.tmassistantbase.jce.GetConfigType(1, 2, "ACTIVE_PROCESS_CFG");

    private GetConfigType(int i, int i2, java.lang.String str) {
        this.__T = new java.lang.String();
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.GetConfigType convert(int i) {
        int i2 = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.GetConfigType[] getConfigTypeArr = __values;
            if (i2 >= getConfigTypeArr.length) {
                if (f1028a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (getConfigTypeArr[i2].value() == i) {
                return __values[i2];
            }
            i2++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.tmassistantbase.jce.GetConfigType convert(java.lang.String str) {
        int i = 0;
        while (true) {
            com.tencent.tmassistantbase.jce.GetConfigType[] getConfigTypeArr = __values;
            if (i >= getConfigTypeArr.length) {
                if (f1028a) {
                    return null;
                }
                throw new java.lang.AssertionError();
            }
            if (getConfigTypeArr[i].toString().equals(str)) {
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
