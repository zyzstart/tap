package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead f1106a;
    static byte[] b;
    public byte[] body;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead head;

    public IPCRequest() {
        this.head = null;
        this.body = null;
    }

    public IPCRequest(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead iPCHead, byte[] bArr) {
        this.head = null;
        this.body = null;
        this.head = iPCHead;
        this.body = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1106a == null) {
            f1106a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead();
        }
        this.head = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead) jceInputStream.read((com.qq.taf.jce.JceStruct) f1106a, 0, true);
        if (b == null) {
            b = new byte[]{0};
        }
        this.body = jceInputStream.read(b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.head, 0);
        byte[] bArr = this.body;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }
}
