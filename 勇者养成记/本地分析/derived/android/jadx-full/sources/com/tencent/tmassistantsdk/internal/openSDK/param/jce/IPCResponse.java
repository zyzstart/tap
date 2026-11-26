package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IPCResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead f1107a;
    static byte[] b;
    public byte[] body;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead head;

    public IPCResponse() {
        this.head = null;
        this.body = null;
    }

    public IPCResponse(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead iPCHead, byte[] bArr) {
        this.head = null;
        this.body = null;
        this.head = iPCHead;
        this.body = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1107a == null) {
            f1107a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead();
        }
        this.head = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead) jceInputStream.read((com.qq.taf.jce.JceStruct) f1107a, 0, true);
        if (b == null) {
            b = new byte[]{0};
        }
        this.body = jceInputStream.read(b, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.head, 0);
        jceOutputStream.write(this.body, 1);
    }
}
