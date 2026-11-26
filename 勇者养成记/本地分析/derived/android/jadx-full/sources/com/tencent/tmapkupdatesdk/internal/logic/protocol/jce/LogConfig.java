package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class LogConfig extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.LogConfig.class.desiredAssertionStatus();
    public int logStatus;

    public LogConfig() {
        this.logStatus = 0;
    }

    public LogConfig(int i) {
        this.logStatus = 0;
        this.logStatus = i;
    }

    public java.lang.String className() {
        return "jce.LogConfig";
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
        new com.qq.taf.jce.JceDisplayer(sb, i).display(this.logStatus, "logStatus");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        new com.qq.taf.jce.JceDisplayer(sb, i).displaySimple(this.logStatus, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        return com.qq.taf.jce.JceUtil.equals(this.logStatus, ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.LogConfig) obj).logStatus);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.LogConfig";
    }

    public int getLogStatus() {
        return this.logStatus;
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
        this.logStatus = jceInputStream.read(this.logStatus, 0, true);
    }

    public void setLogStatus(int i) {
        this.logStatus = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.logStatus, 0);
    }
}
