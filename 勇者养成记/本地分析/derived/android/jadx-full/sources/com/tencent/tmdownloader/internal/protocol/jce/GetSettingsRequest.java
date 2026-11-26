package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetSettingsRequest extends com.qq.taf.jce.JceStruct {
    public java.lang.String reserve;

    public GetSettingsRequest() {
        this.reserve = "";
    }

    public GetSettingsRequest(java.lang.String str) {
        this.reserve = "";
        this.reserve = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.reserve = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.reserve;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }
}
