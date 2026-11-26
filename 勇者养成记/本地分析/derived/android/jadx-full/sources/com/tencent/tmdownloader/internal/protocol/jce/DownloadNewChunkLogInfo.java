package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DownloadNewChunkLogInfo extends com.qq.taf.jce.JceStruct {
    public java.lang.String contentType;
    public long costTime;
    public java.lang.String downUrl;
    public long down_Size;
    public long endTime;
    public java.lang.String finalDownloadUrl;
    public java.lang.String jumpUrl;
    public java.lang.String networkType;
    public byte result;
    public long segId;
    public long startTime;
    public java.lang.String taskId;
    public int taskResult;

    public DownloadNewChunkLogInfo() {
        this.segId = 0L;
        this.taskId = "";
        this.downUrl = "";
        this.jumpUrl = "";
        this.finalDownloadUrl = "";
        this.networkType = "";
        this.contentType = "";
        this.down_Size = -2L;
        this.costTime = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.taskResult = 0;
        this.result = (byte) 0;
    }

    public DownloadNewChunkLogInfo(long j, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, long j2, long j3, long j4, long j5, int i, byte b) {
        this.segId = 0L;
        this.taskId = "";
        this.downUrl = "";
        this.jumpUrl = "";
        this.finalDownloadUrl = "";
        this.networkType = "";
        this.contentType = "";
        this.down_Size = -2L;
        this.costTime = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.taskResult = 0;
        this.result = (byte) 0;
        this.segId = j;
        this.taskId = str;
        this.downUrl = str2;
        this.jumpUrl = str3;
        this.finalDownloadUrl = str4;
        this.networkType = str5;
        this.contentType = str6;
        this.down_Size = j2;
        this.costTime = j3;
        this.startTime = j4;
        this.endTime = j5;
        this.taskResult = i;
        this.result = b;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.segId = jceInputStream.read(this.segId, 0, false);
        this.taskId = jceInputStream.readString(1, false);
        this.downUrl = jceInputStream.readString(2, false);
        this.jumpUrl = jceInputStream.readString(3, false);
        this.finalDownloadUrl = jceInputStream.readString(4, false);
        this.networkType = jceInputStream.readString(5, false);
        this.contentType = jceInputStream.readString(6, false);
        this.down_Size = jceInputStream.read(this.down_Size, 7, false);
        this.costTime = jceInputStream.read(this.costTime, 8, false);
        this.startTime = jceInputStream.read(this.startTime, 9, false);
        this.endTime = jceInputStream.read(this.endTime, 10, false);
        this.taskResult = jceInputStream.read(this.taskResult, 11, false);
        this.result = jceInputStream.read(this.result, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.segId, 0);
        java.lang.String str = this.taskId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        java.lang.String str2 = this.downUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        java.lang.String str3 = this.jumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        java.lang.String str4 = this.finalDownloadUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        java.lang.String str5 = this.networkType;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        java.lang.String str6 = this.contentType;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        jceOutputStream.write(this.down_Size, 7);
        jceOutputStream.write(this.costTime, 8);
        jceOutputStream.write(this.startTime, 9);
        jceOutputStream.write(this.endTime, 10);
        jceOutputStream.write(this.taskResult, 11);
        jceOutputStream.write(this.result, 12);
    }
}
