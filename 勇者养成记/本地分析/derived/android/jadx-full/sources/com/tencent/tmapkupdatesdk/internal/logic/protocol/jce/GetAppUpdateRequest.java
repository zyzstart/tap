package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetAppUpdateRequest extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest.class.desiredAssertionStatus();
    static java.util.ArrayList cache_appInfoForUpdateList = new java.util.ArrayList();
    public java.util.ArrayList appInfoForUpdateList;
    public short clientPatchCaps;
    public byte flag;

    static {
        cache_appInfoForUpdateList.add(new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppInfoForUpdate());
    }

    public GetAppUpdateRequest() {
        this.appInfoForUpdateList = null;
        this.flag = (byte) 0;
        this.clientPatchCaps = (short) 0;
    }

    public GetAppUpdateRequest(java.util.ArrayList arrayList, byte b, short s) {
        this.appInfoForUpdateList = null;
        this.flag = (byte) 0;
        this.clientPatchCaps = (short) 0;
        this.appInfoForUpdateList = arrayList;
        this.flag = b;
        this.clientPatchCaps = s;
    }

    public java.lang.String className() {
        return "jce.GetAppUpdateRequest";
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
        jceDisplayer.display((java.util.Collection) this.appInfoForUpdateList, "appInfoForUpdateList");
        jceDisplayer.display(this.flag, "flag");
        jceDisplayer.display(this.clientPatchCaps, "clientPatchCaps");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple((java.util.Collection) this.appInfoForUpdateList, true);
        jceDisplayer.displaySimple(this.flag, true);
        jceDisplayer.displaySimple(this.clientPatchCaps, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest getAppUpdateRequest = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest) obj;
        return com.qq.taf.jce.JceUtil.equals(this.appInfoForUpdateList, getAppUpdateRequest.appInfoForUpdateList) && com.qq.taf.jce.JceUtil.equals(this.flag, getAppUpdateRequest.flag) && com.qq.taf.jce.JceUtil.equals(this.clientPatchCaps, getAppUpdateRequest.clientPatchCaps);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateRequest";
    }

    public java.util.ArrayList getAppInfoForUpdateList() {
        return this.appInfoForUpdateList;
    }

    public short getClientPatchCaps() {
        return this.clientPatchCaps;
    }

    public byte getFlag() {
        return this.flag;
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
        this.appInfoForUpdateList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_appInfoForUpdateList, 0, true);
        this.flag = jceInputStream.read(this.flag, 1, false);
        this.clientPatchCaps = jceInputStream.read(this.clientPatchCaps, 2, false);
    }

    public void setAppInfoForUpdateList(java.util.ArrayList arrayList) {
        this.appInfoForUpdateList = arrayList;
    }

    public void setClientPatchCaps(short s) {
        this.clientPatchCaps = s;
    }

    public void setFlag(byte b) {
        this.flag = b;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((java.util.Collection) this.appInfoForUpdateList, 0);
        jceOutputStream.write(this.flag, 1);
        jceOutputStream.write(this.clientPatchCaps, 2);
    }
}
