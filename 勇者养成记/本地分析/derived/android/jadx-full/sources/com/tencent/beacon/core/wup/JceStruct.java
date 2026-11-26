package com.tencent.beacon.core.wup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class JceStruct implements java.io.Serializable {
    public static final byte BYTE = 0;
    public static final byte DOUBLE = 5;
    public static final byte FLOAT = 4;
    public static final byte INT = 2;
    public static final int JCE_MAX_STRING_LENGTH = 104857600;
    public static final byte LIST = 9;
    public static final byte LONG = 3;
    public static final byte MAP = 8;
    public static final byte SHORT = 1;
    public static final byte SIMPLE_LIST = 13;
    public static final byte STRING1 = 6;
    public static final byte STRING4 = 7;
    public static final byte STRUCT_BEGIN = 10;
    public static final byte STRUCT_END = 11;
    public static final byte ZERO_TAG = 12;

    public com.tencent.beacon.core.wup.JceStruct newInit() {
        return null;
    }

    public abstract void readFrom(com.tencent.beacon.core.wup.a aVar);

    public byte[] toByteArray() {
        com.tencent.beacon.core.wup.b bVar = new com.tencent.beacon.core.wup.b();
        writeTo(bVar);
        return bVar.b();
    }

    public byte[] toByteArray(java.lang.String str) {
        com.tencent.beacon.core.wup.b bVar = new com.tencent.beacon.core.wup.b();
        bVar.d = str;
        writeTo(bVar);
        return bVar.b();
    }

    public abstract void writeTo(com.tencent.beacon.core.wup.b bVar);
}
