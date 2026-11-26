package com.tencent.hlyyb.downloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface Downloader {
    void addNewTask(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    com.tencent.hlyyb.downloader.DownloaderTask createNewTask(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener);

    com.tencent.hlyyb.downloader.DownloaderTask createNewTask(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener, long j, java.lang.String str4);

    void deleteTask(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask, boolean z);

    void deleteTaskByKey(java.lang.String str, boolean z);

    java.util.List getAllTasks();

    java.util.List getCancelledTasks();

    java.util.List getCompletedTasks();

    java.util.List getFailedTasks();

    java.util.List getIncompleteTasks();

    java.util.List getRunningTasks();

    java.lang.String getVersion();

    java.util.List getWaitingTasks();

    void pauseTasks(boolean z, boolean z2);

    void resumeTasks(boolean z, boolean z2);

    void setNotNetworkWaitMillis(int i);

    void setPhoneGuid(java.lang.String str);

    void setProgressInterval(int i);

    void setQua1(java.lang.String str);

    void setQua2(java.lang.String str);

    void setTaskNumForCategory(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory, int i);

    void setTempFileSubfix(java.lang.String str);
}
