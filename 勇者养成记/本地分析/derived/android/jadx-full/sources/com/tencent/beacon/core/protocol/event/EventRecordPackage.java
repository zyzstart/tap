package com.tencent.beacon.core.protocol.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EventRecordPackage extends com.tencent.beacon.core.wup.JceStruct implements java.lang.Cloneable {
    static java.util.ArrayList cache_list;
    public java.util.ArrayList list = null;

    protected java.lang.Object clone() {
        return super.clone();
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        if (cache_list == null) {
            cache_list = new java.util.ArrayList();
            cache_list.add(new com.tencent.beacon.core.protocol.event.EventRecord());
        }
        this.list = (java.util.ArrayList) aVar.a((java.lang.Object) cache_list, 0, true);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a((java.util.Collection) this.list, 0);
    }
}
