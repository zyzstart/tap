package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ApkDownUrl extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl.class.desiredAssertionStatus();
    static java.util.ArrayList cache_urlList;
    public java.lang.String diffApkMd5;
    public java.lang.String diffApkUrl;
    public long diffFileSize;
    public byte type;
    public java.util.ArrayList urlList;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        cache_urlList = arrayList;
        arrayList.add("");
    }

    public ApkDownUrl() {
        this.type = (byte) 0;
        this.urlList = null;
        this.diffApkMd5 = "";
        this.diffApkUrl = "";
        this.diffFileSize = 0L;
    }

    public ApkDownUrl(byte b, java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, long j) {
        this.type = (byte) 0;
        this.urlList = null;
        this.diffApkMd5 = "";
        this.diffApkUrl = "";
        this.diffFileSize = 0L;
        this.type = b;
        this.urlList = arrayList;
        this.diffApkMd5 = str;
        this.diffApkUrl = str2;
        this.diffFileSize = j;
    }

    public java.lang.String className() {
        return "SDKSys.ApkDownUrl";
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
        jceDisplayer.display(this.type, com.tencent.open.SocialConstants.PARAM_TYPE);
        jceDisplayer.display((java.util.Collection) this.urlList, "urlList");
        jceDisplayer.display(this.diffApkMd5, "diffApkMd5");
        jceDisplayer.display(this.diffApkUrl, "diffApkUrl");
        jceDisplayer.display(this.diffFileSize, "diffFileSize");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple((java.util.Collection) this.urlList, true);
        jceDisplayer.displaySimple(this.diffApkMd5, true);
        jceDisplayer.displaySimple(this.diffApkUrl, true);
        jceDisplayer.displaySimple(this.diffFileSize, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl apkDownUrl = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.ApkDownUrl) obj;
        return com.qq.taf.jce.JceUtil.equals(this.type, apkDownUrl.type) && com.qq.taf.jce.JceUtil.equals(this.urlList, apkDownUrl.urlList) && com.qq.taf.jce.JceUtil.equals(this.diffApkMd5, apkDownUrl.diffApkMd5) && com.qq.taf.jce.JceUtil.equals(this.diffApkUrl, apkDownUrl.diffApkUrl) && com.qq.taf.jce.JceUtil.equals(this.diffFileSize, apkDownUrl.diffFileSize);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmdownloader.internal.protocol.SDKSys.ApkDownUrl";
    }

    public java.lang.String getDiffApkMd5() {
        return this.diffApkMd5;
    }

    public java.lang.String getDiffApkUrl() {
        return this.diffApkUrl;
    }

    public long getDiffFileSize() {
        return this.diffFileSize;
    }

    public byte getType() {
        return this.type;
    }

    public java.util.ArrayList getUrlList() {
        return this.urlList;
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
        this.type = jceInputStream.read(this.type, 0, true);
        this.urlList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_urlList, 1, true);
        this.diffApkMd5 = jceInputStream.readString(2, false);
        this.diffApkUrl = jceInputStream.readString(3, false);
        this.diffFileSize = jceInputStream.read(this.diffFileSize, 4, false);
    }

    public void setDiffApkMd5(java.lang.String str) {
        this.diffApkMd5 = str;
    }

    public void setDiffApkUrl(java.lang.String str) {
        this.diffApkUrl = str;
    }

    public void setDiffFileSize(long j) {
        this.diffFileSize = j;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public void setUrlList(java.util.ArrayList arrayList) {
        this.urlList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((java.util.Collection) this.urlList, 1);
        java.lang.String str = this.diffApkMd5;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        java.lang.String str2 = this.diffApkUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.diffFileSize, 4);
    }
}
