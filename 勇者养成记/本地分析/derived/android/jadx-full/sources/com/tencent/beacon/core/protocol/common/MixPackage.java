package com.tencent.beacon.core.protocol.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class MixPackage extends com.tencent.beacon.core.wup.JceStruct implements java.lang.Cloneable {
    static java.util.Map cache_mixMap;
    public java.util.Map mixMap = null;

    protected java.lang.Object clone() {
        return super.clone();
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        if (cache_mixMap == null) {
            cache_mixMap = new java.util.HashMap();
            cache_mixMap.put(0, new byte[]{0});
        }
        this.mixMap = (java.util.Map) aVar.a((java.lang.Object) cache_mixMap, 0, true);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a(this.mixMap, 0);
    }
}
