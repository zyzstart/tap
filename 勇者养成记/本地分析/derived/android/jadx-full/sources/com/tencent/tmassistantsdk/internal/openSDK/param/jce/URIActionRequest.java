package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class URIActionRequest extends com.qq.taf.jce.JceStruct {
    public java.lang.String uri;

    public URIActionRequest() {
        this.uri = "";
    }

    public URIActionRequest(java.lang.String str) {
        this.uri = "";
        this.uri = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.uri = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uri, 0);
    }
}
