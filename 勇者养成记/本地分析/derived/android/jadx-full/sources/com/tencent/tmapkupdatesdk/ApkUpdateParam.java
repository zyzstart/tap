package com.tencent.tmapkupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkUpdateParam {
    public int actionFlag;
    public java.lang.String packageName;
    public int targetGrayVersionCode;
    public int targetVersionCode;

    public ApkUpdateParam(java.lang.String str, int i, int i2) {
        this.packageName = str;
        this.actionFlag = i;
        this.targetVersionCode = i2;
    }
}
