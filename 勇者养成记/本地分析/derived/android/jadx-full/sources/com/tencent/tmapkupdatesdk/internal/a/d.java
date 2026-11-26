package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    short f990a;
    short b;
    short c;
    short d;
    int e;
    int f;
    short g;
    byte[] h;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.f990a = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.b = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.c = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.d = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.e = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.f = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        int iA = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.g = iA;
        byte[] bArr = new byte[iA];
        this.h = bArr;
        dataInputStream.read(bArr, 0, iA);
    }

    public void a(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeInt(1347093766);
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.f990a));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.b));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.c));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.d));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.e));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.f));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.g));
        if (this.g > 0) {
            dataOutputStream.write(this.h);
        }
    }
}
