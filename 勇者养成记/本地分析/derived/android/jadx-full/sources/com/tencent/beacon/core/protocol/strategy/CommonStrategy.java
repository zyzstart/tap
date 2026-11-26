package com.tencent.beacon.core.protocol.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class CommonStrategy extends com.tencent.beacon.core.wup.JceStruct {
    static java.util.Map cache_cloudParas;
    static java.util.ArrayList cache_moduleList;
    public java.util.Map cloudParas;
    public java.util.ArrayList moduleList;
    public int queryInterval;
    public java.lang.String url;

    public CommonStrategy() {
        this.moduleList = null;
        this.queryInterval = 0;
        this.url = "";
        this.cloudParas = null;
    }

    public CommonStrategy(java.util.ArrayList arrayList, int i, java.lang.String str, java.util.Map map) {
        this.moduleList = null;
        this.queryInterval = 0;
        this.url = "";
        this.cloudParas = null;
        this.moduleList = arrayList;
        this.queryInterval = i;
        this.url = str;
        this.cloudParas = map;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        if (cache_moduleList == null) {
            cache_moduleList = new java.util.ArrayList();
            cache_moduleList.add(new com.tencent.beacon.core.protocol.strategy.ModuleStrategy());
        }
        this.moduleList = (java.util.ArrayList) aVar.a((java.lang.Object) cache_moduleList, 0, true);
        this.queryInterval = aVar.a(this.queryInterval, 1, true);
        this.url = aVar.a(2, true);
        if (cache_cloudParas == null) {
            java.util.HashMap map = new java.util.HashMap();
            cache_cloudParas = map;
            map.put("", "");
        }
        this.cloudParas = (java.util.Map) aVar.a((java.lang.Object) cache_cloudParas, 3, false);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a((java.util.Collection) this.moduleList, 0);
        bVar.a(this.queryInterval, 1);
        bVar.a(this.url, 2);
        java.util.Map map = this.cloudParas;
        if (map != null) {
            bVar.a(map, 3);
        }
    }
}
