package com.tencent.ydkbeacon.pack;

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

    public com.tencent.ydkbeacon.pack.JceStruct newInit() {
        return null;
    }

    public abstract void readFrom(com.tencent.ydkbeacon.pack.a aVar);

    public byte[] toByteArray() {
        com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b();
        writeTo(bVar);
        return bVar.b();
    }

    public byte[] toByteArray(java.lang.String str) {
        com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b();
        bVar.d = str;
        writeTo(bVar);
        return bVar.b();
    }

    public abstract void writeTo(com.tencent.ydkbeacon.pack.b bVar);
}
