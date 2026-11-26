package com.tencent.tmassistantsdk.internal.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class StatStdReport extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1111a = !com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport.class.desiredAssertionStatus();
    public java.lang.String extraData;
    public java.lang.String name;
    public int scene;
    public long time;
    public java.lang.String traceId;
    public java.lang.String versionInfo;

    public StatStdReport() {
        this.name = "";
        this.scene = 0;
        this.extraData = "";
        this.time = 0L;
        this.versionInfo = "";
        this.traceId = "";
    }

    public StatStdReport(java.lang.String str, int i, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4) {
        this.name = "";
        this.scene = 0;
        this.extraData = "";
        this.time = 0L;
        this.versionInfo = "";
        this.traceId = "";
        this.name = str;
        this.scene = i;
        this.extraData = str2;
        this.time = j;
        this.versionInfo = str3;
        this.traceId = str4;
    }

    public java.lang.String className() {
        return "jce.StatStdReport";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (f1111a) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.name, "name");
        jceDisplayer.display(this.scene, com.tencent.tmselfupdatesdk.TMSelfUpdateConst.BUNDLE_KEY_SCENE);
        jceDisplayer.display(this.extraData, "extraData");
        jceDisplayer.display(this.time, "time");
        jceDisplayer.display(this.versionInfo, "versionInfo");
        jceDisplayer.display(this.traceId, "traceId");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.name, true);
        jceDisplayer.displaySimple(this.scene, true);
        jceDisplayer.displaySimple(this.extraData, true);
        jceDisplayer.displaySimple(this.time, true);
        jceDisplayer.displaySimple(this.versionInfo, true);
        jceDisplayer.displaySimple(this.traceId, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport statStdReport = (com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport) obj;
        return com.qq.taf.jce.JceUtil.equals(this.name, statStdReport.name) && com.qq.taf.jce.JceUtil.equals(this.scene, statStdReport.scene) && com.qq.taf.jce.JceUtil.equals(this.extraData, statStdReport.extraData) && com.qq.taf.jce.JceUtil.equals(this.time, statStdReport.time) && com.qq.taf.jce.JceUtil.equals(this.versionInfo, statStdReport.versionInfo) && com.qq.taf.jce.JceUtil.equals(this.traceId, statStdReport.traceId);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport";
    }

    public java.lang.String getExtraData() {
        return this.extraData;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public int getScene() {
        return this.scene;
    }

    public long getTime() {
        return this.time;
    }

    public java.lang.String getTraceId() {
        return this.traceId;
    }

    public java.lang.String getVersionInfo() {
        return this.versionInfo;
    }

    public int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, true);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.extraData = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
        this.versionInfo = jceInputStream.readString(4, false);
        this.traceId = jceInputStream.readString(5, false);
    }

    public void setExtraData(java.lang.String str) {
        this.extraData = str;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setScene(int i) {
        this.scene = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTraceId(java.lang.String str) {
        this.traceId = str;
    }

    public void setVersionInfo(java.lang.String str) {
        this.versionInfo = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.name, 0);
        jceOutputStream.write(this.scene, 1);
        java.lang.String str = this.extraData;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.time, 3);
        java.lang.String str2 = this.versionInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        java.lang.String str3 = this.traceId;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }
}
