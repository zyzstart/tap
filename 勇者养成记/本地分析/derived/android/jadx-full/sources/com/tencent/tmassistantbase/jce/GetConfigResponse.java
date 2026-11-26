package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetConfigResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1027a = new java.util.ArrayList();
    public int ret;
    public java.util.ArrayList settingList;

    static {
        f1027a.add(new com.tencent.tmassistantbase.jce.ConfigItem());
    }

    public GetConfigResponse() {
        this.ret = 0;
        this.settingList = null;
    }

    public GetConfigResponse(int i, java.util.ArrayList arrayList) {
        this.ret = 0;
        this.settingList = null;
        this.ret = i;
        this.settingList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.settingList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1027a, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((java.util.Collection) this.settingList, 1);
    }
}
