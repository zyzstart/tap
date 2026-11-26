package com.dodjoy.dodlib;

/* JADX INFO: compiled from: CdnDownMgr.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class CdnDownTaskData {
    public java.lang.String destDir;
    public int fileSize;
    public boolean isDone = false;
    public java.lang.String urlPath;

    public CdnDownTaskData(java.lang.String str, java.lang.String str2, int i) {
        this.fileSize = 0;
        this.destDir = str;
        this.urlPath = str2;
        this.fileSize = i;
    }
}
