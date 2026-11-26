package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetDownloadProgressResponse extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam f1102a;
    public long allTaskTotalLength;
    public long allTaskTotalProgress;
    public long receivedLen;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam requestParam;
    public long totalLen;

    public GetDownloadProgressResponse() {
        this.requestParam = null;
        this.receivedLen = 0L;
        this.totalLen = 0L;
        this.allTaskTotalProgress = 0L;
        this.allTaskTotalLength = 0L;
    }

    public GetDownloadProgressResponse(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam, long j, long j2, long j3, long j4) {
        this.requestParam = null;
        this.receivedLen = 0L;
        this.totalLen = 0L;
        this.allTaskTotalProgress = 0L;
        this.allTaskTotalLength = 0L;
        this.requestParam = iPCBaseParam;
        this.receivedLen = j;
        this.totalLen = j2;
        this.allTaskTotalProgress = j3;
        this.allTaskTotalLength = j4;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1102a == null) {
            f1102a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        }
        this.requestParam = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam) jceInputStream.read((com.qq.taf.jce.JceStruct) f1102a, 0, true);
        this.receivedLen = jceInputStream.read(this.receivedLen, 1, false);
        this.totalLen = jceInputStream.read(this.totalLen, 2, false);
        this.allTaskTotalProgress = jceInputStream.read(this.allTaskTotalProgress, 3, false);
        this.allTaskTotalLength = jceInputStream.read(this.allTaskTotalLength, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.receivedLen, 1);
        jceOutputStream.write(this.totalLen, 2);
        jceOutputStream.write(this.allTaskTotalProgress, 3);
        jceOutputStream.write(this.allTaskTotalLength, 4);
    }
}
