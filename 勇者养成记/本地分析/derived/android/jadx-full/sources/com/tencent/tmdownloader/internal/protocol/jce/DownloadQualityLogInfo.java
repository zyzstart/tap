package com.tencent.tmdownloader.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class DownloadQualityLogInfo extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static java.util.ArrayList f1142a;
    public java.lang.String clientIp;
    public long costTime;
    public byte downType;
    public java.util.ArrayList downloadChunkLogList;
    public long endTime;
    public java.lang.String extMsg;
    public long memorySize;
    public long pkg_size;
    public long remainsdCardSize;
    public byte result;
    public java.lang.String sdkVersion;
    public long startTime;
    public java.lang.String taskId;
    public int taskResult;
    public java.lang.String usedcard;

    public DownloadQualityLogInfo() {
        this.taskId = "";
        this.sdkVersion = "";
        this.memorySize = 0L;
        this.remainsdCardSize = 0L;
        this.pkg_size = 0L;
        this.costTime = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.downType = (byte) 0;
        this.extMsg = "";
        this.taskResult = 0;
        this.result = (byte) 0;
        this.usedcard = "";
        this.downloadChunkLogList = null;
        this.clientIp = "";
    }

    public DownloadQualityLogInfo(java.lang.String str, java.lang.String str2, long j, long j2, long j3, long j4, long j5, long j6, byte b, java.lang.String str3, int i, byte b2, java.lang.String str4, java.util.ArrayList arrayList, java.lang.String str5) {
        this.taskId = "";
        this.sdkVersion = "";
        this.memorySize = 0L;
        this.remainsdCardSize = 0L;
        this.pkg_size = 0L;
        this.costTime = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.downType = (byte) 0;
        this.extMsg = "";
        this.taskResult = 0;
        this.result = (byte) 0;
        this.usedcard = "";
        this.downloadChunkLogList = null;
        this.clientIp = "";
        this.taskId = str;
        this.sdkVersion = str2;
        this.memorySize = j;
        this.remainsdCardSize = j2;
        this.pkg_size = j3;
        this.costTime = j4;
        this.startTime = j5;
        this.endTime = j6;
        this.downType = b;
        this.extMsg = str3;
        this.taskResult = i;
        this.result = b2;
        this.usedcard = str4;
        this.downloadChunkLogList = arrayList;
        this.clientIp = str5;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.taskId = jceInputStream.readString(0, false);
        this.sdkVersion = jceInputStream.readString(1, false);
        this.memorySize = jceInputStream.read(this.memorySize, 2, false);
        this.remainsdCardSize = jceInputStream.read(this.remainsdCardSize, 3, false);
        this.pkg_size = jceInputStream.read(this.pkg_size, 4, false);
        this.costTime = jceInputStream.read(this.costTime, 5, false);
        this.startTime = jceInputStream.read(this.startTime, 6, false);
        this.endTime = jceInputStream.read(this.endTime, 7, false);
        this.downType = jceInputStream.read(this.downType, 8, false);
        this.extMsg = jceInputStream.readString(9, false);
        this.taskResult = jceInputStream.read(this.taskResult, 10, false);
        this.result = jceInputStream.read(this.result, 11, false);
        this.usedcard = jceInputStream.readString(12, false);
        if (f1142a == null) {
            f1142a = new java.util.ArrayList();
            f1142a.add(new com.tencent.tmdownloader.internal.protocol.jce.DownloadNewChunkLogInfo());
        }
        this.downloadChunkLogList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) f1142a, 13, false);
        this.clientIp = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.taskId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        java.lang.String str2 = this.sdkVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.memorySize, 2);
        jceOutputStream.write(this.remainsdCardSize, 3);
        jceOutputStream.write(this.pkg_size, 4);
        jceOutputStream.write(this.costTime, 5);
        jceOutputStream.write(this.startTime, 6);
        jceOutputStream.write(this.endTime, 7);
        jceOutputStream.write(this.downType, 8);
        java.lang.String str3 = this.extMsg;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        jceOutputStream.write(this.taskResult, 10);
        jceOutputStream.write(this.result, 11);
        java.lang.String str4 = this.usedcard;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        java.util.ArrayList arrayList = this.downloadChunkLogList;
        if (arrayList != null) {
            jceOutputStream.write((java.util.Collection) arrayList, 13);
        }
        java.lang.String str5 = this.clientIp;
        if (str5 != null) {
            jceOutputStream.write(str5, 14);
        }
    }
}
