package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class QueryDownloadTaskRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam f1109a;
    public com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam baseParam;

    public QueryDownloadTaskRequest() {
        this.baseParam = null;
    }

    public QueryDownloadTaskRequest(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam) {
        this.baseParam = null;
        this.baseParam = iPCBaseParam;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        if (f1109a == null) {
            f1109a = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        }
        this.baseParam = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam) jceInputStream.read((com.qq.taf.jce.JceStruct) f1109a, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((com.qq.taf.jce.JceStruct) this.baseParam, 0);
    }
}
