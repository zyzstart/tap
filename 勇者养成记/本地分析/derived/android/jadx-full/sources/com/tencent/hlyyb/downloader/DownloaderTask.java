package com.tencent.hlyyb.downloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface DownloaderTask {
    void addHeader(java.lang.String str, java.lang.String str2);

    void addListener(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener);

    int getAverageSpeed();

    com.tencent.hlyyb.downloader.DownloaderTaskCategory getCategory();

    java.lang.String getContentDisposition();

    java.lang.String getContentType();

    long getCostTime();

    int getFailCode();

    java.lang.String getFailInfo();

    java.lang.String getHtmlUrl();

    java.lang.String getId();

    java.lang.String getInitSaveName();

    long getKnownSize();

    int getPercentage();

    com.tencent.hlyyb.downloader.DownloaderTaskPriority getPriority();

    java.lang.String getRealSaveName();

    int getRealTimeSpeed();

    long getReceivedLength();

    java.lang.String getSaveDir();

    java.lang.String getSavePath();

    long getStartTime();

    com.tencent.hlyyb.downloader.DownloaderTaskStatus getStatus();

    java.lang.Object getTag();

    long getTotalLength();

    int getType();

    java.lang.String getUniqueKey();

    java.lang.String getUrl();

    boolean isCompleted();

    boolean isDeleted();

    boolean isEaseTask();

    boolean isFailed();

    boolean isPaused();

    boolean isPausedOnMobile();

    boolean isRunning();

    boolean isSupportRange();

    boolean isUsingTempFile();

    boolean isWaiting();

    void pause();

    void removeAllListeners();

    void removeListener(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener);

    boolean resume();

    void setApkId(java.lang.String str);

    void setAppId(java.lang.String str);

    void setAppScene(java.lang.String str);

    void setBakUrl(java.lang.String str);

    void setCategory(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory);

    void setFullApkSize(long j);

    void setId(java.lang.String str);

    void setMultiSectionOn(boolean z);

    void setNotPreOccupySpace();

    void setNotUseTempFile();

    void setOcUrlList(java.util.List list);

    void setPauseTaskOnMobile(boolean z);

    void setPriority(com.tencent.hlyyb.downloader.DownloaderTaskPriority downloaderTaskPriority);

    void setReportMd5(boolean z);

    void setTag(java.lang.Object obj);

    void setType(int i);
}
