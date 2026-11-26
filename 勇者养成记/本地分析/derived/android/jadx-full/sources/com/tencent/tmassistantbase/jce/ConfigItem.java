package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ConfigItem extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f1025a = {0};
    public byte[] configuration;
    public int type;

    public ConfigItem() {
        this.type = 0;
        this.configuration = null;
    }

    public ConfigItem(int i, byte[] bArr) {
        this.type = 0;
        this.configuration = null;
        this.type = i;
        this.configuration = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.configuration = jceInputStream.read(f1025a, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.configuration, 1);
    }
}
