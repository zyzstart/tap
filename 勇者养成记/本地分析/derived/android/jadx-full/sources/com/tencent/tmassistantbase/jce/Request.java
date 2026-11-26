package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Request extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantbase.jce.ReqHead f1032a;
    static byte[] b;
    public byte[] body;
    public com.tencent.tmassistantbase.jce.ReqHead head;

    public Request() {
        this.head = null;
        this.body = null;
    }

    public Request(com.tencent.tmassistantbase.jce.ReqHead reqHead, byte[] bArr) {
        this.head = null;
        this.body = null;
        this.head = reqHead;
        this.body = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1032a == null) {
            f1032a = new com.tencent.tmassistantbase.jce.ReqHead();
        }
        this.head = (com.tencent.tmassistantbase.jce.ReqHead) jceInputStream.read((com.qq.taf.jce.JceStruct) f1032a, 0, true);
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
