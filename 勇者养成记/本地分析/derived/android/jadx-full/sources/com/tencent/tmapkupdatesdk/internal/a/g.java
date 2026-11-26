package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    short f993a;
    short b;
    short c;
    short d;
    short e;
    int f;
    int g;
    int h;
    short i;
    short j;
    byte[] k;
    byte[] l;

    public static void a(com.tencent.tmapkupdatesdk.internal.a.b bVar, java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        int i;
        bVar.q = dataOutputStream.size();
        dataOutputStream.writeInt(1347093252);
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.b));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.c));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.d));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.e));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.f));
        if ((bVar.c & 8) == 8) {
            i = 0;
            dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(0));
            dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(0));
        } else {
            dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.g));
            dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.h));
            i = bVar.i;
        }
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(i));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.j));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(bVar.k));
        if (bVar.j > 0) {
            dataOutputStream.write(bVar.s);
        }
        if (bVar.k > 0) {
            dataOutputStream.write(bVar.t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.f993a = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.b = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.c = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.d = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.e = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.f = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.g = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.h = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.i = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        int iA = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.j = iA;
        int i = this.i;
        byte[] bArr = new byte[i];
        this.k = bArr;
        this.l = new byte[iA];
        dataInputStream.read(bArr, 0, i);
        dataInputStream.read(this.l, 0, this.j);
    }
}
