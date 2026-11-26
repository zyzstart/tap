package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareManagerBBS {
    private java.lang.String description;
    private java.io.File mFile;
    private com.tencent.ysdk.shell.module.share.impl.ShareModule.BBSShareCallBack shareCallBack;
    private java.lang.String title;

    public ShareManagerBBS(com.tencent.ysdk.shell.module.share.impl.ShareModule.BBSShareCallBack bBSShareCallBack) {
        this.shareCallBack = bBSShareCallBack;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public com.tencent.ysdk.shell.module.share.impl.ShareModule.BBSShareCallBack getShareCallBack() {
        return this.shareCallBack;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.io.File getmFile() {
        return this.mFile;
    }

    public void shareToBBS(java.io.File file, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mFile = file;
        this.title = str;
        this.description = str2;
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().loadUrlInH5(str3).regOnShareSceneManager(this);
    }
}
