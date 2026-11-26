package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class StatReportResponse extends com.qq.taf.jce.JceStruct {
    public int ret;

    public StatReportResponse() {
        this.ret = 0;
    }

    public StatReportResponse(int i) {
        this.ret = 0;
        this.ret = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
    }
}
