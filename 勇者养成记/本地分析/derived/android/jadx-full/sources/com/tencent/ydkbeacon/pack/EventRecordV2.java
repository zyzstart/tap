package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EventRecordV2 extends com.tencent.ydkbeacon.pack.JceStruct implements java.lang.Cloneable {
    static byte[] cache_byteValue;
    static java.util.Map cache_mapValue;
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.ydkbeacon.pack.EventRecordV2.class.desiredAssertionStatus();
    static int cache_valueType = 0;
    public java.lang.String appKey = "[REDACTED]";
    public java.lang.String apn = "";
    public java.lang.String srcIp = "";
    public java.lang.String eventCode = "";
    public int valueType = 0;
    public java.util.Map mapValue = null;
    public byte[] byteValue = null;
    public long eventTime = 0;
    public boolean eventResult = true;
    public int eventType = 0;
    public java.lang.String reserved = "";

    static {
        java.util.HashMap map = new java.util.HashMap();
        cache_mapValue = map;
        map.put("", "");
        cache_byteValue = new byte[]{0};
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void readFrom(com.tencent.ydkbeacon.pack.a aVar) {
        this.appKey = aVar.a(0, false);
        this.apn = aVar.a(1, false);
        this.srcIp = aVar.a(2, false);
        this.eventCode = aVar.a(3, true);
        this.valueType = aVar.a(this.valueType, 4, false);
        this.mapValue = (java.util.Map) aVar.a((java.lang.Object) cache_mapValue, 5, false);
        this.byteValue = aVar.a(cache_byteValue, 6, false);
        this.eventTime = aVar.a(this.eventTime, 7, true);
        this.eventResult = aVar.a(this.eventResult, 8, false);
        this.eventType = aVar.a(this.eventType, 9, false);
        this.reserved = aVar.a(10, false);
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        java.lang.String str = this.appKey;
        if (str != null) {
            bVar.a(str, 0);
        }
        java.lang.String str2 = this.apn;
        if (str2 != null) {
            bVar.a(str2, 1);
        }
        java.lang.String str3 = this.srcIp;
        if (str3 != null) {
            bVar.a(str3, 2);
        }
        bVar.a(this.eventCode, 3);
        bVar.a(this.valueType, 4);
        java.util.Map map = this.mapValue;
        if (map != null) {
            bVar.a(map, 5);
        }
        byte[] bArr = this.byteValue;
        if (bArr != null) {
            bVar.a(bArr, 6);
        }
        bVar.a(this.eventTime, 7);
        bVar.a(this.eventResult, 8);
        bVar.a(this.eventType, 9);
        java.lang.String str4 = this.reserved;
        if (str4 != null) {
            bVar.a(str4, 10);
        }
    }
}
