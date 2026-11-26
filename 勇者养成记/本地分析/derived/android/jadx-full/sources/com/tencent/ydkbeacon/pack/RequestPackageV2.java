package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RequestPackageV2 extends com.tencent.ydkbeacon.pack.JceStruct implements java.lang.Cloneable {
    static java.util.Map cache_common;
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.ydkbeacon.pack.RequestPackageV2.class.desiredAssertionStatus();
    static java.util.ArrayList cache_events = new java.util.ArrayList();
    public int platformId = 0;
    public java.lang.String mainAppKey = "[REDACTED]";
    public java.lang.String appVersion = "";
    public java.lang.String sdkVersion = "";
    public java.util.ArrayList events = null;
    public java.lang.String packageName = "";
    public java.util.Map common = null;
    public java.lang.String model = "";
    public java.lang.String osVersion = "";
    public java.lang.String reserved = "";
    public java.lang.String sdkId = "";

    static {
        cache_events.add(new com.tencent.ydkbeacon.pack.EventRecordV2());
        java.util.HashMap map = new java.util.HashMap();
        cache_common = map;
        map.put("", "");
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
        this.platformId = aVar.a(this.platformId, 0, true);
        this.mainAppKey = aVar.a(1, true);
        this.appVersion = aVar.a(2, true);
        this.sdkVersion = aVar.a(3, true);
        this.events = (java.util.ArrayList) aVar.a((java.lang.Object) cache_events, 4, true);
        this.packageName = aVar.a(5, false);
        this.common = (java.util.Map) aVar.a((java.lang.Object) cache_common, 6, false);
        this.model = aVar.a(7, false);
        this.osVersion = aVar.a(8, false);
        this.reserved = aVar.a(9, false);
        this.sdkId = aVar.a(10, false);
    }

    public java.lang.String toString() {
        return "[REDACTED]" + this.platformId + "[REDACTED]" + this.mainAppKey + "[REDACTED]" + this.appVersion + "[REDACTED]" + this.sdkVersion + "[REDACTED]" + this.packageName + "[REDACTED]" + this.model + "[REDACTED]" + this.osVersion + "[REDACTED]" + this.reserved + "[REDACTED]" + this.sdkId + "[REDACTED]";
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        bVar.a(this.platformId, 0);
        bVar.a(this.mainAppKey, 1);
        bVar.a(this.appVersion, 2);
        bVar.a(this.sdkVersion, 3);
        bVar.a((java.util.Collection) this.events, 4);
        java.lang.String str = this.packageName;
        if (str != null) {
            bVar.a(str, 5);
        }
        java.util.Map map = this.common;
        if (map != null) {
            bVar.a(map, 6);
        }
        java.lang.String str2 = this.model;
        if (str2 != null) {
            bVar.a(str2, 7);
        }
        java.lang.String str3 = this.osVersion;
        if (str3 != null) {
            bVar.a(str3, 8);
        }
        java.lang.String str4 = this.reserved;
        if (str4 != null) {
            bVar.a(str4, 9);
        }
        java.lang.String str5 = this.sdkId;
        if (str5 != null) {
            bVar.a(str5, 10);
        }
    }
}
