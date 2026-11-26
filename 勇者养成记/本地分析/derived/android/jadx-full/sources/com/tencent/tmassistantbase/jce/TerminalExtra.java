package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TerminalExtra extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f1040a = !com.tencent.tmassistantbase.jce.TerminalExtra.class.desiredAssertionStatus();
    public java.lang.String abiList;
    public short apiLevel;
    public int cpuCoresNum;
    public int cpuMaxFreq;
    public int cpuMinFreq;
    public java.lang.String cpuName;
    public java.lang.String fingerprint;
    public java.lang.String model;
    public long ramTotalSize;
    public java.lang.String romName;
    public java.lang.String romVersion;
    public short storageSpeed;

    public TerminalExtra() {
        this.cpuName = "";
        this.cpuCoresNum = 0;
        this.cpuMaxFreq = 0;
        this.cpuMinFreq = 0;
        this.ramTotalSize = 0L;
        this.romName = "";
        this.romVersion = "";
        this.fingerprint = "";
        this.model = "";
        this.apiLevel = (short) 0;
        this.storageSpeed = (short) 0;
        this.abiList = "";
    }

    public TerminalExtra(java.lang.String str, int i, int i2, int i3, long j, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, short s, short s2, java.lang.String str6) {
        this.cpuName = "";
        this.cpuCoresNum = 0;
        this.cpuMaxFreq = 0;
        this.cpuMinFreq = 0;
        this.ramTotalSize = 0L;
        this.romName = "";
        this.romVersion = "";
        this.fingerprint = "";
        this.model = "";
        this.apiLevel = (short) 0;
        this.storageSpeed = (short) 0;
        this.abiList = "";
        this.cpuName = str;
        this.cpuCoresNum = i;
        this.cpuMaxFreq = i2;
        this.cpuMinFreq = i3;
        this.ramTotalSize = j;
        this.romName = str2;
        this.romVersion = str3;
        this.fingerprint = str4;
        this.model = str5;
        this.apiLevel = s;
        this.storageSpeed = s2;
        this.abiList = str6;
    }

    public java.lang.String className() {
        return "jce.TerminalExtra";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (f1040a) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.cpuName, "cpuName");
        jceDisplayer.display(this.cpuCoresNum, "cpuCoresNum");
        jceDisplayer.display(this.cpuMaxFreq, "cpuMaxFreq");
        jceDisplayer.display(this.cpuMinFreq, "cpuMinFreq");
        jceDisplayer.display(this.ramTotalSize, "ramTotalSize");
        jceDisplayer.display(this.romName, "romName");
        jceDisplayer.display(this.romVersion, "romVersion");
        jceDisplayer.display(this.fingerprint, "fingerprint");
        jceDisplayer.display(this.model, com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL);
        jceDisplayer.display(this.apiLevel, "apiLevel");
        jceDisplayer.display(this.storageSpeed, "storageSpeed");
        jceDisplayer.display(this.abiList, "abiList");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.cpuName, true);
        jceDisplayer.displaySimple(this.cpuCoresNum, true);
        jceDisplayer.displaySimple(this.cpuMaxFreq, true);
        jceDisplayer.displaySimple(this.cpuMinFreq, true);
        jceDisplayer.displaySimple(this.ramTotalSize, true);
        jceDisplayer.displaySimple(this.romName, true);
        jceDisplayer.displaySimple(this.romVersion, true);
        jceDisplayer.displaySimple(this.fingerprint, true);
        jceDisplayer.displaySimple(this.model, true);
        jceDisplayer.displaySimple(this.apiLevel, true);
        jceDisplayer.displaySimple(this.storageSpeed, true);
        jceDisplayer.displaySimple(this.abiList, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra = (com.tencent.tmassistantbase.jce.TerminalExtra) obj;
        return com.qq.taf.jce.JceUtil.equals(this.cpuName, terminalExtra.cpuName) && com.qq.taf.jce.JceUtil.equals(this.cpuCoresNum, terminalExtra.cpuCoresNum) && com.qq.taf.jce.JceUtil.equals(this.cpuMaxFreq, terminalExtra.cpuMaxFreq) && com.qq.taf.jce.JceUtil.equals(this.cpuMinFreq, terminalExtra.cpuMinFreq) && com.qq.taf.jce.JceUtil.equals(this.ramTotalSize, terminalExtra.ramTotalSize) && com.qq.taf.jce.JceUtil.equals(this.romName, terminalExtra.romName) && com.qq.taf.jce.JceUtil.equals(this.romVersion, terminalExtra.romVersion) && com.qq.taf.jce.JceUtil.equals(this.fingerprint, terminalExtra.fingerprint) && com.qq.taf.jce.JceUtil.equals(this.model, terminalExtra.model) && com.qq.taf.jce.JceUtil.equals(this.apiLevel, terminalExtra.apiLevel) && com.qq.taf.jce.JceUtil.equals(this.storageSpeed, terminalExtra.storageSpeed) && com.qq.taf.jce.JceUtil.equals(this.abiList, terminalExtra.abiList);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmassistantbase.jce.TerminalExtra";
    }

    public java.lang.String getAbiList() {
        return this.abiList;
    }

    public short getApiLevel() {
        return this.apiLevel;
    }

    public int getCpuCoresNum() {
        return this.cpuCoresNum;
    }

    public int getCpuMaxFreq() {
        return this.cpuMaxFreq;
    }

    public int getCpuMinFreq() {
        return this.cpuMinFreq;
    }

    public java.lang.String getCpuName() {
        return this.cpuName;
    }

    public java.lang.String getFingerprint() {
        return this.fingerprint;
    }

    public java.lang.String getModel() {
        return this.model;
    }

    public long getRamTotalSize() {
        return this.ramTotalSize;
    }

    public java.lang.String getRomName() {
        return this.romName;
    }

    public java.lang.String getRomVersion() {
        return this.romVersion;
    }

    public short getStorageSpeed() {
        return this.storageSpeed;
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
        this.cpuName = jceInputStream.readString(0, false);
        this.cpuCoresNum = jceInputStream.read(this.cpuCoresNum, 1, false);
        this.cpuMaxFreq = jceInputStream.read(this.cpuMaxFreq, 2, false);
        this.cpuMinFreq = jceInputStream.read(this.cpuMinFreq, 3, false);
        this.ramTotalSize = jceInputStream.read(this.ramTotalSize, 4, false);
        this.romName = jceInputStream.readString(5, false);
        this.romVersion = jceInputStream.readString(6, false);
        this.fingerprint = jceInputStream.readString(7, false);
        this.model = jceInputStream.readString(8, false);
        this.apiLevel = jceInputStream.read(this.apiLevel, 9, false);
        this.storageSpeed = jceInputStream.read(this.storageSpeed, 10, false);
        this.abiList = jceInputStream.readString(11, false);
    }

    public void setAbiList(java.lang.String str) {
        this.abiList = str;
    }

    public void setApiLevel(short s) {
        this.apiLevel = s;
    }

    public void setCpuCoresNum(int i) {
        this.cpuCoresNum = i;
    }

    public void setCpuMaxFreq(int i) {
        this.cpuMaxFreq = i;
    }

    public void setCpuMinFreq(int i) {
        this.cpuMinFreq = i;
    }

    public void setCpuName(java.lang.String str) {
        this.cpuName = str;
    }

    public void setFingerprint(java.lang.String str) {
        this.fingerprint = str;
    }

    public void setModel(java.lang.String str) {
        this.model = str;
    }

    public void setRamTotalSize(long j) {
        this.ramTotalSize = j;
    }

    public void setRomName(java.lang.String str) {
        this.romName = str;
    }

    public void setRomVersion(java.lang.String str) {
        this.romVersion = str;
    }

    public void setStorageSpeed(short s) {
        this.storageSpeed = s;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        java.lang.String str = this.cpuName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.cpuCoresNum, 1);
        jceOutputStream.write(this.cpuMaxFreq, 2);
        jceOutputStream.write(this.cpuMinFreq, 3);
        jceOutputStream.write(this.ramTotalSize, 4);
        java.lang.String str2 = this.romName;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        java.lang.String str3 = this.romVersion;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        java.lang.String str4 = this.fingerprint;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        java.lang.String str5 = this.model;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.apiLevel, 9);
        jceOutputStream.write(this.storageSpeed, 10);
        java.lang.String str6 = this.abiList;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
    }
}
