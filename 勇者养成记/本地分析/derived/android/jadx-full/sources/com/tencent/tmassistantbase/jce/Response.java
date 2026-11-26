package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Response extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantbase.jce.RspHead f1033a;
    static byte[] b;
    public byte[] body;
    public com.tencent.tmassistantbase.jce.RspHead head;

    public Response() {
        this.head = null;
        this.body = null;
    }

    public Response(com.tencent.tmassistantbase.jce.RspHead rspHead, byte[] bArr) {
        this.head = null;
        this.body = null;
        this.head = rspHead;
        this.body = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1033a == null) {
            f1033a = new com.tencent.tmassistantbase.jce.RspHead();
        }
        this.head = (com.tencent.tmassistantbase.jce.RspHead) jceInputStream.read((com.qq.taf.jce.JceStruct) f1033a, 0, true);
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
