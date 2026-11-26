package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class FileInfoV2 extends com.qq.taf.jce.JceStruct {
    public java.lang.String fileMd5OrCrc;
    public int offset;

    public FileInfoV2() {
        this.fileMd5OrCrc = "";
        this.offset = 0;
    }

    public FileInfoV2(java.lang.String str, int i) {
        this.fileMd5OrCrc = "";
        this.offset = 0;
        this.fileMd5OrCrc = str;
        this.offset = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.fileMd5OrCrc = jceInputStream.readString(0, false);
        this.offset = jceInputStream.read(this.offset, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.fileMd5OrCrc;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.offset, 1);
    }
}
