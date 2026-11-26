package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q extends java.io.DataInputStream implements com.tencent.yybsdk.apkpatch.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1439a;
    private com.tencent.yybsdk.apkpatch.h b;
    private com.tencent.yybsdk.apkpatch.g c;
    private com.tencent.yybsdk.apkpatch.f d;
    private java.util.List e;
    private java.util.List f;
    private int g;
    private long h;

    public q(java.io.InputStream inputStream) {
        super(inputStream);
        this.g = 0;
        this.h = 0L;
    }

    public int a(com.tencent.yybsdk.apkpatch.g gVar) {
        com.tencent.yybsdk.apkpatch.g.f fVar;
        com.tencent.yybsdk.apkpatch.g.f fVar2;
        if (gVar.f1423a.c == 0) {
            return ((this.c.f1423a.b & 8) == 8 && (fVar2 = gVar.b) != null && fVar2.f1427a == 1347094280) ? fVar2.f : gVar.f1423a.h;
        }
        return ((this.c.f1423a.b & 8) == 8 && (fVar = gVar.b) != null && fVar.f1427a == 1347094280) ? fVar.e : gVar.f1423a.g;
    }

    public int a(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.g gVar = this.c;
        if (gVar == null) {
            throw new java.io.IOException("getNextEntryHeader first");
        }
        int i3 = gVar.d - this.f1439a;
        if (i3 <= 0) {
            return -1;
        }
        if (i3 < i2) {
            i2 = i3;
        }
        int i4 = read(bArr, i, i2);
        if (i4 > 0) {
            this.f1439a += i4;
        }
        this.h += (long) i4;
        return i4;
    }

    public long a() {
        return this.h;
    }

    public java.util.List b() throws java.io.IOException {
        this.e = new java.util.ArrayList(this.b.o);
        for (int i = 0; i < this.b.o; i++) {
            this.e.add(new com.tencent.yybsdk.apkpatch.d(readInt(), readInt(), readInt(), readByte()));
        }
        return this.e;
    }

    public java.util.List c() throws java.io.IOException {
        this.f = new java.util.ArrayList(this.b.o);
        for (int i = 0; i < this.b.o; i++) {
            this.f.add(new com.tencent.yybsdk.apkpatch.e(readInt(), readInt(), readInt(), readByte()));
        }
        return this.f;
    }

    public com.tencent.yybsdk.apkpatch.f d() throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.f fVar = new com.tencent.yybsdk.apkpatch.f();
        this.d = fVar;
        fVar.f1414a = new com.tencent.yybsdk.apkpatch.g.h();
        this.d.f1414a.a(this);
        com.tencent.yybsdk.apkpatch.f fVar2 = this.d;
        if ((fVar2.f1414a.b & 8) == 8) {
            fVar2.b = new com.tencent.yybsdk.apkpatch.g.f();
            this.d.b.a(this);
        }
        this.d.c = readByte();
        com.tencent.yybsdk.apkpatch.f fVar3 = this.d;
        if (fVar3.c == 2) {
            fVar3.d = readInt();
            this.d.e = readInt();
        }
        this.h += (long) this.d.a();
        return this.d;
    }

    public com.tencent.yybsdk.apkpatch.h e() throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.h hVar = new com.tencent.yybsdk.apkpatch.h();
        this.b = hVar;
        hVar.f1430a = readUnsignedShort();
        this.b.b = readShort();
        this.b.c = readShort();
        byte[] bArr = new byte[32];
        read(bArr, 0, 32);
        com.tencent.yybsdk.apkpatch.h hVar2 = this.b;
        int i = hVar2.c;
        if (i == 32 || i == 64) {
            this.b.d = bArr;
        } else {
            hVar2.f = bArr;
        }
        byte[] bArr2 = new byte[32];
        read(bArr2, 0, 32);
        com.tencent.yybsdk.apkpatch.h hVar3 = this.b;
        int i2 = hVar3.c;
        if (i2 == 32 || i2 == 64) {
            this.b.e = bArr2;
        } else {
            hVar3.g = bArr2;
        }
        this.b.h = readInt();
        this.b.i = readShort();
        int i3 = this.b.i;
        if (i3 <= 0) {
            throw new java.io.IOException("patchFileHeader.packageNameSize = " + ((int) this.b.i));
        }
        byte[] bArr3 = new byte[i3];
        read(bArr3, 0, i3);
        com.tencent.yybsdk.apkpatch.h hVar4 = this.b;
        hVar4.j = bArr3;
        hVar4.k = readShort();
        int i4 = this.b.k;
        if (i4 > 0) {
            byte[] bArr4 = new byte[i4];
            read(bArr4, 0, i4);
            this.b.l = bArr4;
        } else if (i4 < 0) {
            throw new java.io.IOException("patchFileHeaderV2.localVersionNameSize = " + ((int) this.b.k));
        }
        this.b.m = readInt();
        com.tencent.yybsdk.apkpatch.h hVar5 = this.b;
        if (hVar5.m <= 0) {
            throw new java.io.IOException("patchFileHeaderV2.fileItemCount = " + this.b.m);
        }
        if (hVar5.c == 64) {
            hVar5.n = readInt();
            com.tencent.yybsdk.apkpatch.h hVar6 = this.b;
            if (hVar6.n <= 0) {
                throw new java.io.IOException("patchFileHeaderV2.newApkSize = " + this.b.n);
            }
            hVar6.o = readInt();
            com.tencent.yybsdk.apkpatch.h hVar7 = this.b;
            if (hVar7.o <= 0) {
                throw new java.io.IOException("patchFileHeaderV2.diffFileCount = " + this.b.o);
            }
            hVar7.p = readInt();
            if (this.b.p <= 0) {
                throw new java.io.IOException("patchFileHeaderV2.oldMergeTotalSize = " + this.b.p);
            }
        }
        long j = this.h;
        com.tencent.yybsdk.apkpatch.h hVar8 = this.b;
        this.h = j + ((long) (hVar8.k + 164 + hVar8.i));
        return hVar8;
    }

    public com.tencent.yybsdk.apkpatch.i f() {
        com.tencent.yybsdk.apkpatch.i iVar = new com.tencent.yybsdk.apkpatch.i();
        iVar.f1431a = readByte();
        this.h++;
        return iVar;
    }

    public com.tencent.yybsdk.apkpatch.g g() throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.h hVar = this.b;
        if (hVar == null) {
            throw new java.io.IOException("PatchHeader is null.");
        }
        if (this.g >= hVar.m) {
            this.f1439a = 0;
            this.c = null;
            return null;
        }
        com.tencent.yybsdk.apkpatch.g gVar = new com.tencent.yybsdk.apkpatch.g();
        this.c = gVar;
        gVar.f1423a = new com.tencent.yybsdk.apkpatch.g.h();
        this.f1439a = 0;
        this.c.f1423a.a(this);
        com.tencent.yybsdk.apkpatch.g gVar2 = this.c;
        if ((gVar2.f1423a.b & 8) == 8) {
            gVar2.b = new com.tencent.yybsdk.apkpatch.g.f();
            this.c.b.a(this);
        }
        this.c.c = readByte();
        com.tencent.yybsdk.apkpatch.g gVar3 = this.c;
        gVar3.d = a(gVar3);
        this.g++;
        this.h += (long) (this.c.a() + 1);
        return this.c;
    }

    public long h() throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.g gVar = this.c;
        if (gVar == null) {
            throw new java.io.IOException("getNextEntryHeader first");
        }
        long j = this.h;
        long j2 = gVar.d;
        this.h = j + j2;
        return skip(j2);
    }

    public int i() {
        return this.g;
    }
}
