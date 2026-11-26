package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ServiceFreeActionResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f1110a;
    public byte[] revertField;

    public ServiceFreeActionResponse() {
        this.revertField = null;
    }

    public ServiceFreeActionResponse(byte[] bArr) {
        this.revertField = null;
        this.revertField = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1110a == null) {
            f1110a = new byte[]{0};
        }
        this.revertField = jceInputStream.read(f1110a, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        byte[] bArr = this.revertField;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }
}
