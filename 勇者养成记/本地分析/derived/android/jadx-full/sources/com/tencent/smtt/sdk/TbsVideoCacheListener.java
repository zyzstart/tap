package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface TbsVideoCacheListener {
    void onVideoDownloadCompletion(com.tencent.smtt.sdk.TbsVideoCacheTask tbsVideoCacheTask, long j, long j2, android.os.Bundle bundle);

    void onVideoDownloadError(com.tencent.smtt.sdk.TbsVideoCacheTask tbsVideoCacheTask, int i, java.lang.String str, android.os.Bundle bundle);

    void onVideoDownloadInit(com.tencent.smtt.sdk.TbsVideoCacheTask tbsVideoCacheTask, int i, java.lang.String str, android.os.Bundle bundle);

    void onVideoDownloadProgress(com.tencent.smtt.sdk.TbsVideoCacheTask tbsVideoCacheTask, int i, long j, int i2, android.os.Bundle bundle);

    void onVideoDownloadStart(com.tencent.smtt.sdk.TbsVideoCacheTask tbsVideoCacheTask, android.os.Bundle bundle);
}
