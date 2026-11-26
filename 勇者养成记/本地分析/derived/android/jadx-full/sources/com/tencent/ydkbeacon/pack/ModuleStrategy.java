package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ModuleStrategy extends com.tencent.ydkbeacon.pack.JceStruct {
    static java.util.Map cache_detail;
    static java.util.ArrayList cache_preventEventCode;
    static java.util.ArrayList cache_sampleEvent;
    public static java.lang.Object cache_sms;
    public java.util.Map detail;
    public byte mId;
    public byte onOff;
    public java.util.ArrayList preventEventCode;
    public java.util.ArrayList sampleEvent;
    public java.lang.Object sms;
    public java.lang.String url;

    public ModuleStrategy() {
        this.mId = (byte) 0;
        this.onOff = (byte) 0;
        this.url = "";
        this.detail = null;
        this.preventEventCode = null;
        this.sms = null;
        this.sampleEvent = null;
    }

    public ModuleStrategy(byte b, byte b2, java.lang.String str, java.util.Map map, java.util.ArrayList arrayList, java.lang.Object obj, java.util.ArrayList arrayList2) {
        this.mId = (byte) 0;
        this.onOff = (byte) 0;
        this.url = "";
        this.detail = null;
        this.preventEventCode = null;
        this.sms = null;
        this.sampleEvent = null;
        this.mId = b;
        this.onOff = b2;
        this.url = str;
        this.detail = map;
        this.preventEventCode = arrayList;
        this.sms = obj;
        this.sampleEvent = arrayList2;
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void readFrom(com.tencent.ydkbeacon.pack.a aVar) {
        this.mId = aVar.a(this.mId, 0, true);
        this.onOff = aVar.a(this.onOff, 1, true);
        this.url = aVar.a(2, true);
        if (cache_detail == null) {
            java.util.HashMap map = new java.util.HashMap();
            cache_detail = map;
            map.put("", "");
        }
        this.detail = (java.util.Map) aVar.a((java.lang.Object) cache_detail, 3, true);
        if (cache_preventEventCode == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            cache_preventEventCode = arrayList;
            arrayList.add("");
        }
        this.preventEventCode = (java.util.ArrayList) aVar.a((java.lang.Object) cache_preventEventCode, 4, false);
        java.lang.Object obj = cache_sms;
        if (obj != null) {
            this.sms = aVar.a(obj, 5, false);
        }
        if (cache_sampleEvent == null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            cache_sampleEvent = arrayList2;
            arrayList2.add("");
        }
        this.sampleEvent = (java.util.ArrayList) aVar.a((java.lang.Object) cache_sampleEvent, 6, false);
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        bVar.a(this.mId, 0);
        bVar.a(this.onOff, 1);
        bVar.a(this.url, 2);
        bVar.a(this.detail, 3);
        java.util.ArrayList arrayList = this.preventEventCode;
        if (arrayList != null) {
            bVar.a((java.util.Collection) arrayList, 4);
        }
        java.lang.Object obj = this.sms;
        if (obj != null) {
            bVar.a(obj, 5);
        }
        java.util.ArrayList arrayList2 = this.sampleEvent;
        if (arrayList2 != null) {
            bVar.a((java.util.Collection) arrayList2, 6);
        }
    }
}
