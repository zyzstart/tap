package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ValueType implements java.io.Serializable {
    public static final int _BYTE = 1;
    public static final int _MAP = 0;
    public static final int _UNKNOWN = 2;
    private java.lang.String __T;
    private int __value;
    private static com.tencent.ydkbeacon.pack.ValueType[] __values = new com.tencent.ydkbeacon.pack.ValueType[3];
    public static final com.tencent.ydkbeacon.pack.ValueType MAP = new com.tencent.ydkbeacon.pack.ValueType(0, 0, "MAP");
    public static final com.tencent.ydkbeacon.pack.ValueType BYTE = new com.tencent.ydkbeacon.pack.ValueType(1, 1, "BYTE");
    public static final com.tencent.ydkbeacon.pack.ValueType UNKNOWN = new com.tencent.ydkbeacon.pack.ValueType(2, 2, "UNKNOWN");

    private ValueType(int i, int i2, java.lang.String str) {
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    public static com.tencent.ydkbeacon.pack.ValueType convert(int i) {
        for (com.tencent.ydkbeacon.pack.ValueType valueType : __values) {
            if (valueType.value() == i) {
                return valueType;
            }
        }
        return null;
    }

    public static com.tencent.ydkbeacon.pack.ValueType convert(java.lang.String str) {
        for (com.tencent.ydkbeacon.pack.ValueType valueType : __values) {
            if (valueType.toString().equals(str)) {
                return valueType;
            }
        }
        return null;
    }

    public java.lang.String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }
}
