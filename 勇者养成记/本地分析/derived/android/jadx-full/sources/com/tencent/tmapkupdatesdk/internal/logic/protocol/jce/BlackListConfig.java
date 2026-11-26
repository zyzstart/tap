package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BlackListConfig extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig.class.desiredAssertionStatus();
    static java.util.ArrayList cache_blackList;
    public java.util.ArrayList blackList;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        cache_blackList = arrayList;
        arrayList.add("");
    }

    public BlackListConfig() {
        this.blackList = null;
    }

    public BlackListConfig(java.util.ArrayList arrayList) {
        this.blackList = null;
        this.blackList = arrayList;
    }

    public java.lang.String className() {
        return "SDKSys.BlackListConfig";
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
        new com.qq.taf.jce.JceDisplayer(sb, i).display((java.util.Collection) this.blackList, "blackList");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        new com.qq.taf.jce.JceDisplayer(sb, i).displaySimple((java.util.Collection) this.blackList, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        return com.qq.taf.jce.JceUtil.equals(this.blackList, ((com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BlackListConfig) obj).blackList);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmdownloader.internal.protocol.SDKSys.BlackListConfig";
    }

    public java.util.ArrayList getBlackList() {
        return this.blackList;
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
        this.blackList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_blackList, 0, true);
    }

    public void setBlackList(java.util.ArrayList arrayList) {
        this.blackList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write((java.util.Collection) this.blackList, 0);
    }
}
