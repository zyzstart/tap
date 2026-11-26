package com.tencent.tmapkupdatesdk.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkUpdateDetail {
    public static final int UpdateMethod_ByPatch = 4;
    public static final int UpdateMethod_ByPatch_New = 5;
    public static final int UpdateMethod_GenPatch = 3;
    public static final int UpdateMethod_NoUpdate = 1;
    public static final int UpdateMethod_NoneRecord = 0;
    public static final int UpdateMethod_Normal = 2;
    public static final byte Update_OverwriteChannelid_Disable = 0;
    public static final byte Update_OverwriteChannelid_Enable = 1;
    public java.lang.String fileMd5;
    public java.lang.String newFeature;
    public int newapksize;
    public byte overwriteChannelid;
    public java.lang.String packageName;
    public int patchsize;
    public java.lang.String sigMd5;
    public int updatemethod;
    public java.lang.String url;
    public int versioncode;
    public java.lang.String versionname;
    public short patchAlgorithm = 0;
    public long apkId = 0;
    public long appId = 0;
    public java.lang.String localVersionName = "";
    public long localVersionCode = 0;
}
