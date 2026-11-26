package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ReportLogRequest extends com.qq.taf.jce.JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f1030a;
    public java.lang.String hostAppPackageName;
    public int hostAppVersion;
    public java.lang.String hostUserId;
    public byte[] logData;
    public int logType;

    public ReportLogRequest() {
        this.logType = 0;
        this.logData = null;
        this.hostUserId = "";
        this.hostAppPackageName = "";
        this.hostAppVersion = 0;
    }

    public ReportLogRequest(int i, byte[] bArr, java.lang.String str, java.lang.String str2, int i2) {
        this.logType = 0;
        this.logData = null;
        this.hostUserId = "";
        this.hostAppPackageName = "";
        this.hostAppVersion = 0;
        this.logType = i;
        this.logData = bArr;
        this.hostUserId = str;
        this.hostAppPackageName = str2;
        this.hostAppVersion = i2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.logType = jceInputStream.read(this.logType, 0, false);
        if (f1030a == null) {
            f1030a = new byte[]{0};
        }
        this.logData = jceInputStream.read(f1030a, 1, false);
        this.hostUserId = jceInputStream.readString(2, false);
        this.hostAppPackageName = jceInputStream.readString(3, false);
        this.hostAppVersion = jceInputStream.read(this.hostAppVersion, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.logType, 0);
        byte[] bArr = this.logData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        java.lang.String str = this.hostUserId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        java.lang.String str2 = this.hostAppPackageName;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.hostAppVersion, 4);
    }
}
