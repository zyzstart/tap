package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    short f989a;
    short b;
    short c;
    short d;
    short e;
    short f;
    int g;
    int h;
    int i;
    short j;
    short k;
    short l;
    short m;
    short n;
    short o;
    int p;
    int q;
    boolean r;
    byte[] s;
    byte[] t;
    byte[] u;
    byte[] v;

    public void a(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.f989a = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.b = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.c = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.d = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.e = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.f = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.g = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.h = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.i = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.j = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.l = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.m = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.n = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.o = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readShort());
        this.p = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.q = com.tencent.tmapkupdatesdk.internal.a.a.a(dataInputStream.readInt());
        this.r = false;
        int i = this.j;
        byte[] bArr = new byte[i];
        this.s = bArr;
        this.u = new byte[this.l];
        this.v = new byte[this.m];
        dataInputStream.read(bArr, 0, i);
        dataInputStream.read(this.u, 0, this.l);
        dataInputStream.read(this.v, 0, this.m);
    }

    public void a(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeInt(1347092738);
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.f989a));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.b));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.c));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.d));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.e));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.f));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.g));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.h));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.i));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.j));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.l));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.m));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.n));
        dataOutputStream.writeShort(com.tencent.tmapkupdatesdk.internal.a.a.a(this.o));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.p));
        dataOutputStream.writeInt(com.tencent.tmapkupdatesdk.internal.a.a.a(this.q));
        if (this.j > 0) {
            dataOutputStream.write(this.s);
        }
        if (this.l > 0) {
            dataOutputStream.write(this.u);
        }
        if (this.m > 0) {
            dataOutputStream.write(this.v);
        }
    }

    public boolean a() {
        return (this.c & 8) != 0;
    }

    public void b(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.f989a = dataInputStream.readShort();
        this.b = dataInputStream.readShort();
        this.c = dataInputStream.readShort();
        this.d = dataInputStream.readShort();
        this.e = dataInputStream.readShort();
        this.f = dataInputStream.readShort();
        this.g = dataInputStream.readInt();
        this.h = dataInputStream.readInt();
        this.i = dataInputStream.readInt();
        this.j = dataInputStream.readShort();
        this.k = dataInputStream.readShort();
        this.l = dataInputStream.readShort();
        this.m = dataInputStream.readShort();
        this.n = dataInputStream.readShort();
        this.o = dataInputStream.readShort();
        this.p = dataInputStream.readInt();
        this.q = dataInputStream.readInt();
        this.r = dataInputStream.readBoolean();
        int i = this.j;
        byte[] bArr = new byte[i];
        this.s = bArr;
        this.t = new byte[this.k];
        this.u = new byte[this.l];
        this.v = new byte[this.m];
        dataInputStream.read(bArr, 0, i);
        dataInputStream.read(this.t, 0, this.k);
        dataInputStream.read(this.u, 0, this.l);
        dataInputStream.read(this.v, 0, this.m);
    }
}
