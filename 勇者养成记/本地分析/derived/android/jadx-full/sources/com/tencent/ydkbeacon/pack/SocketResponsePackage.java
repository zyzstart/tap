package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class SocketResponsePackage extends com.tencent.ydkbeacon.pack.JceStruct {
    static byte[] cache_body;
    static java.util.Map cache_header;
    public byte[] body;
    public java.util.Map header;
    public java.lang.String msg;
    public int statusCode;

    static {
        java.util.HashMap map = new java.util.HashMap();
        cache_header = map;
        map.put("", "");
        cache_body = new byte[]{0};
    }

    public SocketResponsePackage() {
        this.statusCode = 0;
        this.header = null;
        this.body = null;
        this.msg = "";
    }

    public SocketResponsePackage(int i, java.util.Map map, byte[] bArr, java.lang.String str) {
        this.statusCode = 0;
        this.header = null;
        this.body = null;
        this.msg = "";
        this.statusCode = i;
        this.header = map;
        this.body = bArr;
        this.msg = str;
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void readFrom(com.tencent.ydkbeacon.pack.a aVar) {
        this.statusCode = aVar.a(this.statusCode, 0, true);
        this.header = (java.util.Map) aVar.a((java.lang.Object) cache_header, 1, true);
        this.body = aVar.a(cache_body, 2, true);
        this.msg = aVar.a(3, false);
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        bVar.a(this.statusCode, 0);
        bVar.a(this.header, 1);
        bVar.a(this.body, 2);
        java.lang.String str = this.msg;
        if (str != null) {
            bVar.a(str, 3);
        }
    }
}
