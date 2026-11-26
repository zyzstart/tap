package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ReqHead extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    public int assistantAPILevel;
    public int assistantVersionCode;
    public int cmdId;
    public byte encryptWithPack;
    public java.lang.String hostPackageName;
    public int hostVersionCode;
    public com.tencent.tmassistantbase.jce.Net net;
    public java.lang.String phoneGuid;
    public java.lang.String qua;
    public int requestId;
    public com.tencent.tmassistantbase.jce.RomInfo romInfo;
    public com.tencent.tmassistantbase.jce.SdkInfo sdkInfo;
    public com.tencent.tmassistantbase.jce.Terminal terminal;
    public com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra;
    public com.tencent.tmassistantbase.jce.Ticket ticket;
    public int yybVersion;
    static final /* synthetic */ boolean g = !com.tencent.tmassistantbase.jce.ReqHead.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.tmassistantbase.jce.Terminal f1031a = new com.tencent.tmassistantbase.jce.Terminal();
    static com.tencent.tmassistantbase.jce.Net b = new com.tencent.tmassistantbase.jce.Net();
    static com.tencent.tmassistantbase.jce.SdkInfo c = new com.tencent.tmassistantbase.jce.SdkInfo();
    static com.tencent.tmassistantbase.jce.RomInfo d = new com.tencent.tmassistantbase.jce.RomInfo();
    static com.tencent.tmassistantbase.jce.Ticket e = new com.tencent.tmassistantbase.jce.Ticket();
    static com.tencent.tmassistantbase.jce.TerminalExtra f = new com.tencent.tmassistantbase.jce.TerminalExtra();

    public ReqHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.phoneGuid = "";
        this.qua = "";
        this.encryptWithPack = (byte) 0;
        this.terminal = null;
        this.assistantAPILevel = 0;
        this.assistantVersionCode = 0;
        this.net = null;
        this.hostPackageName = "";
        this.hostVersionCode = 0;
        this.sdkInfo = null;
        this.romInfo = null;
        this.ticket = null;
        this.terminalExtra = null;
        this.yybVersion = 0;
    }

    public ReqHead(int i, int i2, java.lang.String str, java.lang.String str2, byte b2, com.tencent.tmassistantbase.jce.Terminal terminal, int i3, int i4, com.tencent.tmassistantbase.jce.Net net, java.lang.String str3, int i5, com.tencent.tmassistantbase.jce.SdkInfo sdkInfo, com.tencent.tmassistantbase.jce.RomInfo romInfo, com.tencent.tmassistantbase.jce.Ticket ticket, com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra, int i6) {
        this.requestId = 0;
        this.cmdId = 0;
        this.phoneGuid = "";
        this.qua = "";
        this.encryptWithPack = (byte) 0;
        this.terminal = null;
        this.assistantAPILevel = 0;
        this.assistantVersionCode = 0;
        this.net = null;
        this.hostPackageName = "";
        this.hostVersionCode = 0;
        this.sdkInfo = null;
        this.romInfo = null;
        this.ticket = null;
        this.terminalExtra = null;
        this.yybVersion = 0;
        this.requestId = i;
        this.cmdId = i2;
        this.phoneGuid = str;
        this.qua = str2;
        this.encryptWithPack = b2;
        this.terminal = terminal;
        this.assistantAPILevel = i3;
        this.assistantVersionCode = i4;
        this.net = net;
        this.hostPackageName = str3;
        this.hostVersionCode = i5;
        this.sdkInfo = sdkInfo;
        this.romInfo = romInfo;
        this.ticket = ticket;
        this.terminalExtra = terminalExtra;
        this.yybVersion = i6;
    }

    public java.lang.String className() {
        return "jce.ReqHead";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (g) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
        jceDisplayer.display(this.qua, com.tencent.ysdk.shell.module.report.impl.ReportComm.QUA);
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.terminal, "terminal");
        jceDisplayer.display(this.assistantAPILevel, "assistantAPILevel");
        jceDisplayer.display(this.assistantVersionCode, "assistantVersionCode");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.net, "net");
        jceDisplayer.display(this.hostPackageName, "hostPackageName");
        jceDisplayer.display(this.hostVersionCode, "hostVersionCode");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.sdkInfo, "sdkInfo");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.romInfo, "romInfo");
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.ticket, com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET);
        jceDisplayer.display((com.qq.taf.jce.JceStruct) this.terminalExtra, "terminalExtra");
        jceDisplayer.display(this.yybVersion, "yybVersion");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.phoneGuid, true);
        jceDisplayer.displaySimple(this.qua, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.terminal, true);
        jceDisplayer.displaySimple(this.assistantAPILevel, true);
        jceDisplayer.displaySimple(this.assistantVersionCode, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.net, true);
        jceDisplayer.displaySimple(this.hostPackageName, true);
        jceDisplayer.displaySimple(this.hostVersionCode, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.sdkInfo, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.romInfo, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.ticket, true);
        jceDisplayer.displaySimple((com.qq.taf.jce.JceStruct) this.terminalExtra, true);
        jceDisplayer.displaySimple(this.yybVersion, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.ReqHead reqHead = (com.tencent.tmassistantbase.jce.ReqHead) obj;
        return com.qq.taf.jce.JceUtil.equals(this.requestId, reqHead.requestId) && com.qq.taf.jce.JceUtil.equals(this.cmdId, reqHead.cmdId) && com.qq.taf.jce.JceUtil.equals(this.phoneGuid, reqHead.phoneGuid) && com.qq.taf.jce.JceUtil.equals(this.qua, reqHead.qua) && com.qq.taf.jce.JceUtil.equals(this.encryptWithPack, reqHead.encryptWithPack) && com.qq.taf.jce.JceUtil.equals(this.terminal, reqHead.terminal) && com.qq.taf.jce.JceUtil.equals(this.assistantAPILevel, reqHead.assistantAPILevel) && com.qq.taf.jce.JceUtil.equals(this.assistantVersionCode, reqHead.assistantVersionCode) && com.qq.taf.jce.JceUtil.equals(this.net, reqHead.net) && com.qq.taf.jce.JceUtil.equals(this.hostPackageName, reqHead.hostPackageName) && com.qq.taf.jce.JceUtil.equals(this.hostVersionCode, reqHead.hostVersionCode) && com.qq.taf.jce.JceUtil.equals(this.sdkInfo, reqHead.sdkInfo) && com.qq.taf.jce.JceUtil.equals(this.romInfo, reqHead.romInfo) && com.qq.taf.jce.JceUtil.equals(this.ticket, reqHead.ticket) && com.qq.taf.jce.JceUtil.equals(this.terminalExtra, reqHead.terminalExtra) && com.qq.taf.jce.JceUtil.equals(this.yybVersion, reqHead.yybVersion);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmassistantbase.jce.ReqHead";
    }

    public int getAssistantAPILevel() {
        return this.assistantAPILevel;
    }

    public int getAssistantVersionCode() {
        return this.assistantVersionCode;
    }

    public int getCmdId() {
        return this.cmdId;
    }

    public byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public java.lang.String getHostPackageName() {
        return this.hostPackageName;
    }

    public int getHostVersionCode() {
        return this.hostVersionCode;
    }

    public com.tencent.tmassistantbase.jce.Net getNet() {
        return this.net;
    }

    public java.lang.String getPhoneGuid() {
        return this.phoneGuid;
    }

    public java.lang.String getQua() {
        return this.qua;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public com.tencent.tmassistantbase.jce.RomInfo getRomInfo() {
        return this.romInfo;
    }

    public com.tencent.tmassistantbase.jce.SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public com.tencent.tmassistantbase.jce.Terminal getTerminal() {
        return this.terminal;
    }

    public com.tencent.tmassistantbase.jce.TerminalExtra getTerminalExtra() {
        return this.terminalExtra;
    }

    public com.tencent.tmassistantbase.jce.Ticket getTicket() {
        return this.ticket;
    }

    public int getYybVersion() {
        return this.yybVersion;
    }

    public int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.phoneGuid = jceInputStream.readString(2, true);
        this.qua = jceInputStream.readString(3, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 4, false);
        this.terminal = (com.tencent.tmassistantbase.jce.Terminal) jceInputStream.read((com.qq.taf.jce.JceStruct) f1031a, 5, false);
        this.assistantAPILevel = jceInputStream.read(this.assistantAPILevel, 6, false);
        this.assistantVersionCode = jceInputStream.read(this.assistantVersionCode, 7, false);
        this.net = (com.tencent.tmassistantbase.jce.Net) jceInputStream.read((com.qq.taf.jce.JceStruct) b, 8, false);
        this.hostPackageName = jceInputStream.readString(9, false);
        this.hostVersionCode = jceInputStream.read(this.hostVersionCode, 10, false);
        this.sdkInfo = (com.tencent.tmassistantbase.jce.SdkInfo) jceInputStream.read((com.qq.taf.jce.JceStruct) c, 11, false);
        this.romInfo = (com.tencent.tmassistantbase.jce.RomInfo) jceInputStream.read((com.qq.taf.jce.JceStruct) d, 12, false);
        this.ticket = (com.tencent.tmassistantbase.jce.Ticket) jceInputStream.read((com.qq.taf.jce.JceStruct) e, 13, false);
        this.terminalExtra = (com.tencent.tmassistantbase.jce.TerminalExtra) jceInputStream.read((com.qq.taf.jce.JceStruct) f, 14, false);
        this.yybVersion = jceInputStream.read(this.yybVersion, 15, false);
    }

    public void setAssistantAPILevel(int i) {
        this.assistantAPILevel = i;
    }

    public void setAssistantVersionCode(int i) {
        this.assistantVersionCode = i;
    }

    public void setCmdId(int i) {
        this.cmdId = i;
    }

    public void setEncryptWithPack(byte b2) {
        this.encryptWithPack = b2;
    }

    public void setHostPackageName(java.lang.String str) {
        this.hostPackageName = str;
    }

    public void setHostVersionCode(int i) {
        this.hostVersionCode = i;
    }

    public void setNet(com.tencent.tmassistantbase.jce.Net net) {
        this.net = net;
    }

    public void setPhoneGuid(java.lang.String str) {
        this.phoneGuid = str;
    }

    public void setQua(java.lang.String str) {
        this.qua = str;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public void setRomInfo(com.tencent.tmassistantbase.jce.RomInfo romInfo) {
        this.romInfo = romInfo;
    }

    public void setSdkInfo(com.tencent.tmassistantbase.jce.SdkInfo sdkInfo) {
        this.sdkInfo = sdkInfo;
    }

    public void setTerminal(com.tencent.tmassistantbase.jce.Terminal terminal) {
        this.terminal = terminal;
    }

    public void setTerminalExtra(com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra) {
        this.terminalExtra = terminalExtra;
    }

    public void setTicket(com.tencent.tmassistantbase.jce.Ticket ticket) {
        this.ticket = ticket;
    }

    public void setYybVersion(int i) {
        this.yybVersion = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.phoneGuid, 2);
        jceOutputStream.write(this.qua, 3);
        jceOutputStream.write(this.encryptWithPack, 4);
        com.tencent.tmassistantbase.jce.Terminal terminal = this.terminal;
        if (terminal != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) terminal, 5);
        }
        jceOutputStream.write(this.assistantAPILevel, 6);
        jceOutputStream.write(this.assistantVersionCode, 7);
        com.tencent.tmassistantbase.jce.Net net = this.net;
        if (net != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) net, 8);
        }
        java.lang.String str = this.hostPackageName;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.hostVersionCode, 10);
        com.tencent.tmassistantbase.jce.SdkInfo sdkInfo = this.sdkInfo;
        if (sdkInfo != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) sdkInfo, 11);
        }
        com.tencent.tmassistantbase.jce.RomInfo romInfo = this.romInfo;
        if (romInfo != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) romInfo, 12);
        }
        com.tencent.tmassistantbase.jce.Ticket ticket = this.ticket;
        if (ticket != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) ticket, 13);
        }
        com.tencent.tmassistantbase.jce.TerminalExtra terminalExtra = this.terminalExtra;
        if (terminalExtra != null) {
            jceOutputStream.write((com.qq.taf.jce.JceStruct) terminalExtra, 14);
        }
        jceOutputStream.write(this.yybVersion, 15);
    }
}
