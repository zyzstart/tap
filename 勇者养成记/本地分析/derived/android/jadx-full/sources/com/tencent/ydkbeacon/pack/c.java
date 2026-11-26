package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.HashMap f1278a;
    public java.util.HashMap b = new java.util.HashMap();
    com.tencent.ydkbeacon.pack.a c = new com.tencent.ydkbeacon.pack.a();
    public java.lang.String d = "GBK";
    public final com.tencent.ydkbeacon.pack.RequestPacket e = new com.tencent.ydkbeacon.pack.RequestPacket();

    static {
        java.util.HashMap map = new java.util.HashMap();
        f1278a = map;
        map.put("", new byte[0]);
    }

    private java.lang.Object a(byte[] bArr, java.lang.Object obj) {
        this.c.a(bArr);
        this.c.a(this.d);
        return this.c.a(obj, 0, true);
    }

    private byte[] a(java.nio.ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        byte[] bArr = new byte[iPosition];
        java.lang.System.arraycopy(byteBuffer.array(), 0, bArr, 0, iPosition);
        return bArr;
    }

    private void b() {
        com.tencent.ydkbeacon.pack.a aVar = new com.tencent.ydkbeacon.pack.a(this.e.sBuffer);
        aVar.a(this.d);
        this.b = aVar.a((java.util.Map) f1278a, 0, false);
    }

    public java.lang.Object a(java.lang.String str, java.lang.Object obj) throws java.lang.Exception {
        if (!this.b.containsKey(str)) {
            return null;
        }
        try {
            return a((byte[]) this.b.get(str), obj);
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception(e);
        }
    }

    public void a(int i) {
        this.e.iRequestId = i;
    }

    public void a(java.lang.String str) {
        this.e.sFuncName = str;
    }

    public void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new java.lang.IllegalArgumentException("decode package must include size head");
        }
        try {
            com.tencent.ydkbeacon.pack.a aVar = new com.tencent.ydkbeacon.pack.a(bArr, 4);
            aVar.a(this.d);
            this.e.readFrom(aVar);
            b();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public byte[] a() {
        com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b(0);
        bVar.a(this.d);
        bVar.a((java.util.Map) this.b, 0);
        com.tencent.ydkbeacon.pack.RequestPacket requestPacket = this.e;
        requestPacket.iVersion = (short) 3;
        requestPacket.sBuffer = a(bVar.a());
        com.tencent.ydkbeacon.pack.b bVar2 = new com.tencent.ydkbeacon.pack.b(0);
        bVar2.a(this.d);
        this.e.writeTo(bVar2);
        byte[] bArrA = a(bVar2.a());
        int length = bArrA.length + 4;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    public void b(java.lang.String str) {
        this.e.sServantName = str;
    }

    public void b(java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (obj instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b();
        bVar.a(this.d);
        bVar.a(obj, 0);
        this.b.put(str, a(bVar.a()));
    }
}
