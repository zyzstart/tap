package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class StatCfg extends com.qq.taf.jce.JceStruct {
    public int internal;
    public short lineNum;
    public byte netType;
    public byte type;

    public StatCfg() {
        this.type = (byte) 0;
        this.netType = (byte) 0;
        this.lineNum = (short) 0;
        this.internal = 0;
    }

    public StatCfg(byte b, byte b2, short s, int i) {
        this.type = (byte) 0;
        this.netType = (byte) 0;
        this.lineNum = (short) 0;
        this.internal = 0;
        this.type = b;
        this.netType = b2;
        this.lineNum = s;
        this.internal = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.netType = jceInputStream.read(this.netType, 1, true);
        this.lineNum = jceInputStream.read(this.lineNum, 2, false);
        this.internal = jceInputStream.read(this.internal, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.netType, 1);
        jceOutputStream.write(this.lineNum, 2);
        jceOutputStream.write(this.internal, 3);
    }
}
