package com.tencent.beacon.core.protocol.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EventRecord extends com.tencent.beacon.core.wup.JceStruct implements java.lang.Cloneable {
    public java.lang.String apn = "";
    public java.lang.String srcIp = "";
    public java.lang.String eventName = "";
    public boolean eventResult = true;
    public long packageSize = 0;
    public long cosumeTime = 0;
    public java.lang.String eventValue = "";
    public long eventTime = 0;
    public int eventType = 0;

    protected java.lang.Object clone() {
        return super.clone();
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void readFrom(com.tencent.beacon.core.wup.a aVar) {
        this.apn = aVar.a(0, true);
        this.srcIp = aVar.a(1, true);
        this.eventName = aVar.a(2, true);
        this.eventResult = aVar.a(this.eventResult, 3, true);
        this.packageSize = aVar.a(this.packageSize, 4, true);
        this.cosumeTime = aVar.a(this.cosumeTime, 5, true);
        this.eventValue = aVar.a(6, true);
        this.eventTime = aVar.a(this.eventTime, 7, true);
        this.eventType = aVar.a(this.eventType, 8, false);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public void writeTo(com.tencent.beacon.core.wup.b bVar) {
        bVar.a(this.apn, 0);
        bVar.a(this.srcIp, 1);
        bVar.a(this.eventName, 2);
        bVar.a(this.eventResult, 3);
        bVar.a(this.packageSize, 4);
        bVar.a(this.cosumeTime, 5);
        bVar.a(this.eventValue, 6);
        bVar.a(this.eventTime, 7);
        bVar.a(this.eventType, 8);
    }
}
