package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class StatReportRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1039a = new java.util.ArrayList();
    public java.util.ArrayList data;

    static {
        f1039a.add(new com.tencent.tmassistantbase.jce.StatItem());
    }

    public StatReportRequest() {
        this.data = null;
    }

    public StatReportRequest(java.util.ArrayList arrayList) {
        this.data = null;
        this.data = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.data = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1039a, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((java.util.Collection) this.data, 0);
    }
}
