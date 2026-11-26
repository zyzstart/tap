package com.tencent.hlyyb.downloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface DownloaderTaskListener {
    void onTaskCompletedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskCompletedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskDetectedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskDetectedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskFailedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskFailedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskPausedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskPausedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskPendingMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskReceivedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskReceivedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskStartedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);

    void onTaskStartedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask);
}
