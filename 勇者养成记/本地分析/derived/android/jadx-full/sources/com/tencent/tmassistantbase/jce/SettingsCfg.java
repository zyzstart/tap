package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class SettingsCfg extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f1037a;
    public byte[] cfg;
    public long revision;
    public byte type;

    public SettingsCfg() {
        this.type = (byte) 0;
        this.cfg = null;
        this.revision = 0L;
    }

    public SettingsCfg(byte b, byte[] bArr, long j) {
        this.type = (byte) 0;
        this.cfg = null;
        this.revision = 0L;
        this.type = b;
        this.cfg = bArr;
        this.revision = j;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        if (f1037a == null) {
            f1037a = new byte[]{0};
        }
        this.cfg = jceInputStream.read(f1037a, 1, true);
        this.revision = jceInputStream.read(this.revision, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.cfg, 1);
        jceOutputStream.write(this.revision, 2);
    }
}
