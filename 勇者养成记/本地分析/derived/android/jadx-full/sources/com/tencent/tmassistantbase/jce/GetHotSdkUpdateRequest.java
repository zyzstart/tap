package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetHotSdkUpdateRequest extends com.qq.taf.jce.JceStruct {
    public java.lang.String ext;

    public GetHotSdkUpdateRequest() {
        this.ext = "";
    }

    public GetHotSdkUpdateRequest(java.lang.String str) {
        this.ext = "";
        this.ext = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ext = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.ext;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }
}
