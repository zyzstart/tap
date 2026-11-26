package com.tencent.beacon.core.wup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RequestPacket extends com.tencent.beacon.core.wup.JceStruct {
    static java.util.Map cache_context;
    static byte[] cache_sBuffer;
    public java.util.Map context;
    public byte[] sBuffer;
    public java.util.Map status;
    public short iVersion = 3;
    public byte cPacketType = 0;
    public int iMessageType = 0;
    public int iRequestId = 0;
    public java.lang.String sServantName = null;
    public java.lang.String sFuncName = null;
    public int iTimeout = 0;

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        try {
            this.iVersion = aVar.a(this.iVersion, 1, true);
            this.cPacketType = aVar.a(this.cPacketType, 2, true);
            this.iMessageType = aVar.a(this.iMessageType, 3, true);
            this.iRequestId = aVar.a(this.iRequestId, 4, true);
            this.sServantName = aVar.a(5, true);
            this.sFuncName = aVar.a(6, true);
            if (cache_sBuffer == null) {
                cache_sBuffer = new byte[]{0};
            }
            this.sBuffer = aVar.a(cache_sBuffer, 7, true);
            this.iTimeout = aVar.a(this.iTimeout, 8, true);
            if (cache_context == null) {
                java.util.HashMap map = new java.util.HashMap();
                cache_context = map;
                map.put("", "");
            }
            this.context = (java.util.Map) aVar.a((java.lang.Object) cache_context, 9, true);
            if (cache_context == null) {
                java.util.HashMap map2 = new java.util.HashMap();
                cache_context = map2;
                map2.put("", "");
            }
            this.status = (java.util.Map) aVar.a((java.lang.Object) cache_context, 10, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a(this.iVersion, 1);
        bVar.a(this.cPacketType, 2);
        bVar.a(this.iMessageType, 3);
        bVar.a(this.iRequestId, 4);
        bVar.a(this.sServantName, 5);
        bVar.a(this.sFuncName, 6);
        bVar.a(this.sBuffer, 7);
        bVar.a(this.iTimeout, 8);
        bVar.a(this.context, 9);
        bVar.a(this.status, 10);
    }
}
