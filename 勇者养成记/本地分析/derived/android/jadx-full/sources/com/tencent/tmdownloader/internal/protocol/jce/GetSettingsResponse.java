package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetSettingsResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1143a;
    public int ret;
    public java.util.ArrayList settings;

    public GetSettingsResponse() {
        this.ret = 0;
        this.settings = null;
    }

    public GetSettingsResponse(int i, java.util.ArrayList arrayList) {
        this.ret = 0;
        this.settings = null;
        this.ret = i;
        this.settings = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (f1143a == null) {
            f1143a = new java.util.ArrayList();
            f1143a.add(new com.tencent.tmassistantbase.jce.SettingsCfg());
        }
        this.settings = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1143a, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        java.util.ArrayList arrayList = this.settings;
        if (arrayList != null) {
            jceOutputStream.write((java.util.Collection) arrayList, 1);
        }
    }
}
