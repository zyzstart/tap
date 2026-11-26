package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BatchReportConfig extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig.class.desiredAssertionStatus();
    public long batchReportInterval;
    public int batchReportMaxCount;
    public int reportRetryCount;

    public BatchReportConfig() {
        this.batchReportMaxCount = 0;
        this.batchReportInterval = 0L;
        this.reportRetryCount = 0;
    }

    public BatchReportConfig(int i, long j, int i2) {
        this.batchReportMaxCount = 0;
        this.batchReportInterval = 0L;
        this.reportRetryCount = 0;
        this.batchReportMaxCount = i;
        this.batchReportInterval = j;
        this.reportRetryCount = i2;
    }

    public java.lang.String className() {
        return "jce.BatchReportConfig";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.batchReportMaxCount, "batchReportMaxCount");
        jceDisplayer.display(this.batchReportInterval, "batchReportInterval");
        jceDisplayer.display(this.reportRetryCount, "reportRetryCount");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.batchReportMaxCount, true);
        jceDisplayer.displaySimple(this.batchReportInterval, true);
        jceDisplayer.displaySimple(this.reportRetryCount, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig batchReportConfig = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig) obj;
        return com.qq.taf.jce.JceUtil.equals(this.batchReportMaxCount, batchReportConfig.batchReportMaxCount) && com.qq.taf.jce.JceUtil.equals(this.batchReportInterval, batchReportConfig.batchReportInterval) && com.qq.taf.jce.JceUtil.equals(this.reportRetryCount, batchReportConfig.reportRetryCount);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmassistant.common.jce.BatchReportConfig";
    }

    public long getBatchReportInterval() {
        return this.batchReportInterval;
    }

    public int getBatchReportMaxCount() {
        return this.batchReportMaxCount;
    }

    public int getReportRetryCount() {
        return this.reportRetryCount;
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
        this.batchReportMaxCount = jceInputStream.read(this.batchReportMaxCount, 0, true);
        this.batchReportInterval = jceInputStream.read(this.batchReportInterval, 1, true);
        this.reportRetryCount = jceInputStream.read(this.reportRetryCount, 2, true);
    }

    public void setBatchReportInterval(long j) {
        this.batchReportInterval = j;
    }

    public void setBatchReportMaxCount(int i) {
        this.batchReportMaxCount = i;
    }

    public void setReportRetryCount(int i) {
        this.reportRetryCount = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchReportMaxCount, 0);
        jceOutputStream.write(this.batchReportInterval, 1);
        jceOutputStream.write(this.reportRetryCount, 2);
    }
}
