package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetConfigRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1026a = new java.util.ArrayList();
    public java.util.ArrayList typeList;

    static {
        f1026a.add(0);
    }

    public GetConfigRequest() {
        this.typeList = null;
    }

    public GetConfigRequest(java.util.ArrayList arrayList) {
        this.typeList = null;
        this.typeList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.typeList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1026a, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((java.util.Collection) this.typeList, 0);
    }
}
