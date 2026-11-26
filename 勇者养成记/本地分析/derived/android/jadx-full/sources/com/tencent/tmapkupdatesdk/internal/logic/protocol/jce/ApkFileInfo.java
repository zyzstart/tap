package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ApkFileInfo extends com.qq.taf.jce.JceStruct {
    static java.util.Map cache_fileCRC32 = new java.util.HashMap();
    static java.util.Map cache_fileInfos;
    public long apkId;
    public java.util.Map fileCRC32;
    public java.util.Map fileInfos;
    public int localVersionCode;
    public java.lang.String localVersionName;
    public java.lang.String manifestMd5;
    public java.lang.String packageName;

    static {
        cache_fileCRC32.put("", 0L);
        cache_fileInfos = new java.util.HashMap();
        cache_fileInfos.put("", new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.FileInfoV2());
    }

    public ApkFileInfo() {
        this.apkId = 0L;
        this.manifestMd5 = "";
        this.packageName = "";
        this.fileCRC32 = null;
        this.localVersionName = "";
        this.localVersionCode = 0;
        this.fileInfos = null;
    }

    public ApkFileInfo(long j, java.lang.String str, java.lang.String str2, java.util.Map map, java.lang.String str3, int i, java.util.Map map2) {
        this.apkId = 0L;
        this.manifestMd5 = "";
        this.packageName = "";
        this.fileCRC32 = null;
        this.localVersionName = "";
        this.localVersionCode = 0;
        this.fileInfos = null;
        this.apkId = j;
        this.manifestMd5 = str;
        this.packageName = str2;
        this.fileCRC32 = map;
        this.localVersionName = str3;
        this.localVersionCode = i;
        this.fileInfos = map2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.apkId = jceInputStream.read(this.apkId, 0, true);
        this.manifestMd5 = jceInputStream.readString(1, true);
        this.packageName = jceInputStream.readString(2, true);
        this.fileCRC32 = (java.util.Map) jceInputStream.read((java.lang.Object) cache_fileCRC32, 3, true);
        this.localVersionName = jceInputStream.readString(4, false);
        this.localVersionCode = jceInputStream.read(this.localVersionCode, 5, false);
        this.fileInfos = (java.util.Map) jceInputStream.read((java.lang.Object) cache_fileInfos, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.apkId, 0);
        jceOutputStream.write(this.manifestMd5, 1);
        jceOutputStream.write(this.packageName, 2);
        jceOutputStream.write(this.fileCRC32, 3);
        java.lang.String str = this.localVersionName;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.localVersionCode, 5);
        java.util.Map map = this.fileInfos;
        if (map != null) {
            jceOutputStream.write(map, 6);
        }
    }
}
