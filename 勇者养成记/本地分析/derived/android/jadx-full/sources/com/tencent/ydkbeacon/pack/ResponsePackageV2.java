package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ResponsePackageV2 extends com.tencent.ydkbeacon.pack.ResponseCommon implements java.lang.Cloneable {
    public int result = 0;
    public java.lang.String msg = "";

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void readFrom(com.tencent.ydkbeacon.pack.a aVar) {
        this.result = aVar.a(this.result, 0, true);
        this.srcGatewayIp = aVar.a(1, true);
        this.serverTime = aVar.a(this.serverTime, 2, true);
        this.msg = aVar.a(3, true);
    }

    @Override // com.tencent.ydkbeacon.pack.JceStruct
    public void writeTo(com.tencent.ydkbeacon.pack.b bVar) {
        bVar.a(this.result, 0);
        bVar.a(this.srcGatewayIp, 1);
        bVar.a(this.serverTime, 2);
        bVar.a(this.msg, 3);
    }
}
