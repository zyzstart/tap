package com.tencent.beaconselfupdate.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {
    private static java.util.HashMap e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.HashMap f251a = new java.util.HashMap();
    private com.tencent.beaconselfupdate.d.a b = new com.tencent.beaconselfupdate.d.a();
    private java.lang.String c = "GBK";
    private com.tencent.beaconselfupdate.d.e d = new com.tencent.beaconselfupdate.d.e();

    public final void a() {
        this.d.b = 1;
    }

    public final void a(java.lang.String str) {
        this.d.d = str;
    }

    public final void a(java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (obj instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.beaconselfupdate.d.b bVar = new com.tencent.beaconselfupdate.d.b();
        bVar.a(this.c);
        bVar.a(obj, 0);
        java.nio.ByteBuffer byteBufferA = bVar.a();
        int iPosition = byteBufferA.position();
        byte[] bArr = new byte[iPosition];
        java.lang.System.arraycopy(byteBufferA.array(), 0, bArr, 0, iPosition);
        this.f251a.put(str, bArr);
    }

    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new java.lang.IllegalArgumentException("decode package must include size head");
        }
        try {
            com.tencent.beaconselfupdate.d.a aVar = new com.tencent.beaconselfupdate.d.a(bArr, (byte) 0);
            aVar.a(this.c);
            this.d.a(aVar);
            com.tencent.beaconselfupdate.d.a aVar2 = new com.tencent.beaconselfupdate.d.a(this.d.e);
            aVar2.a(this.c);
            if (e == null) {
                java.util.HashMap map = new java.util.HashMap();
                e = map;
                map.put("", new byte[0]);
            }
            this.f251a = aVar2.a(e);
        } catch (java.lang.Exception e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public final java.lang.Object b(java.lang.String str, java.lang.Object obj) throws java.lang.Exception {
        if (!this.f251a.containsKey(str)) {
            return null;
        }
        try {
            this.b.a((byte[]) this.f251a.get(str));
            this.b.a(this.c);
            return this.b.a(obj, 0, true);
        } catch (java.lang.Exception e2) {
            throw new java.lang.Exception(e2);
        }
    }

    public final void b(java.lang.String str) {
        this.d.c = str;
    }

    public final byte[] b() {
        com.tencent.beaconselfupdate.d.b bVar = new com.tencent.beaconselfupdate.d.b(0);
        bVar.a(this.c);
        bVar.a((java.util.Map) this.f251a, 0);
        com.tencent.beaconselfupdate.d.e eVar = this.d;
        eVar.f252a = (short) 3;
        java.nio.ByteBuffer byteBufferA = bVar.a();
        int iPosition = byteBufferA.position();
        byte[] bArr = new byte[iPosition];
        java.lang.System.arraycopy(byteBufferA.array(), 0, bArr, 0, iPosition);
        eVar.e = bArr;
        com.tencent.beaconselfupdate.d.b bVar2 = new com.tencent.beaconselfupdate.d.b(0);
        bVar2.a(this.c);
        this.d.a(bVar2);
        java.nio.ByteBuffer byteBufferA2 = bVar2.a();
        int iPosition2 = byteBufferA2.position();
        byte[] bArr2 = new byte[iPosition2];
        java.lang.System.arraycopy(byteBufferA2.array(), 0, bArr2, 0, iPosition2);
        int i = iPosition2 + 4;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i);
        byteBufferAllocate.putInt(i).put(bArr2).flip();
        return byteBufferAllocate.array();
    }
}
