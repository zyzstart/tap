package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RomInfo extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1035a = !com.tencent.tmassistantbase.jce.RomInfo.class.desiredAssertionStatus();
    public int rootFlag;
    public java.lang.String sysId;
    public java.lang.String sysVersionCode;
    public java.lang.String sysVersionName;

    public RomInfo() {
        this.sysId = "";
        this.sysVersionName = "";
        this.sysVersionCode = "";
        this.rootFlag = 0;
    }

    public RomInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        this.sysId = "";
        this.sysVersionName = "";
        this.sysVersionCode = "";
        this.rootFlag = 0;
        this.sysId = str;
        this.sysVersionName = str2;
        this.sysVersionCode = str3;
        this.rootFlag = i;
    }

    public java.lang.String className() {
        return "jce.RomInfo";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (f1035a) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.sysId, "sysId");
        jceDisplayer.display(this.sysVersionName, "sysVersionName");
        jceDisplayer.display(this.sysVersionCode, "sysVersionCode");
        jceDisplayer.display(this.rootFlag, "rootFlag");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.sysId, true);
        jceDisplayer.displaySimple(this.sysVersionName, true);
        jceDisplayer.displaySimple(this.sysVersionCode, true);
        jceDisplayer.displaySimple(this.rootFlag, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.RomInfo romInfo = (com.tencent.tmassistantbase.jce.RomInfo) obj;
        return com.qq.taf.jce.JceUtil.equals(this.sysId, romInfo.sysId) && com.qq.taf.jce.JceUtil.equals(this.sysVersionName, romInfo.sysVersionName) && com.qq.taf.jce.JceUtil.equals(this.sysVersionCode, romInfo.sysVersionCode) && com.qq.taf.jce.JceUtil.equals(this.rootFlag, romInfo.rootFlag);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmassistantbase.jce.RomInfo";
    }

    public int getRootFlag() {
        return this.rootFlag;
    }

    public java.lang.String getSysId() {
        return this.sysId;
    }

    public java.lang.String getSysVersionCode() {
        return this.sysVersionCode;
    }

    public java.lang.String getSysVersionName() {
        return this.sysVersionName;
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
        this.sysId = jceInputStream.readString(0, false);
        this.sysVersionName = jceInputStream.readString(1, false);
        this.sysVersionCode = jceInputStream.readString(2, false);
        this.rootFlag = jceInputStream.read(this.rootFlag, 3, false);
    }

    public void setRootFlag(int i) {
        this.rootFlag = i;
    }

    public void setSysId(java.lang.String str) {
        this.sysId = str;
    }

    public void setSysVersionCode(java.lang.String str) {
        this.sysVersionCode = str;
    }

    public void setSysVersionName(java.lang.String str) {
        this.sysVersionName = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.sysId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        java.lang.String str2 = this.sysVersionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        java.lang.String str3 = this.sysVersionCode;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.rootFlag, 3);
    }
}
