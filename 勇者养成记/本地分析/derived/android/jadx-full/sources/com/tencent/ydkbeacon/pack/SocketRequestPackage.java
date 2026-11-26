package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class SocketRequestPackage extends com.tencent.ydkbeacon.pack.JceStruct {
    static byte[] cache_body;
    static java.util.Map cache_header;
    public byte[] body;
    public java.util.Map header;

    static {
        java.util.HashMap map = new java.util.HashMap();
        cache_header = map;
        map.put("", "");
        cache_body = new byte[]{0};
    }

    public SocketRequestPackage() {
        this.header = null;
        this.body = null;
    }

    public SocketRequestPackage(java.util.Map map, byte[] bArr) {
        this.header = null;
        this.body = null;
        this.header = map;
        this.body = bArr;
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void readFrom(com.tencent.ydkbeacon.pack.a aVar) {
        this.header = (java.util.Map) aVar.a((java.lang.Object) cache_header, 0, true);
        this.body = aVar.a(cache_body, 1, true);
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        bVar.a(this.header, 0);
        bVar.a(this.body, 1);
    }
}
