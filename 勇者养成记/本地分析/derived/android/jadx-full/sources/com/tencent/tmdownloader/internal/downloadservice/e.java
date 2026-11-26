package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements com.tencent.hlyyb.downloader.DownloaderTaskListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmdownloader.internal.downloadservice.d f1134a;

    e(com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        this.f1134a = dVar;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        this.f1134a.j = downloaderTask.getRealSaveName();
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskCompletedSubloop saveFileName = " + downloaderTask.getRealSaveName());
        this.f1134a.b(downloaderTask.getReceivedLength());
        com.tencent.tmdownloader.internal.downloadservice.d dVar = this.f1134a;
        dVar.m = 0;
        dVar.a(4);
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskCompletedSubloop mReceivedBytes=" + this.f1134a.h + ",totalSize=" + this.f1134a.i);
        this.f1134a.a(downloaderTask);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        this.f1134a.j = downloaderTask.getRealSaveName();
        com.tencent.tmassistantbase.util.TMLog.i("PreventHold", "下载模块探测到的filesize为" + downloaderTask.getTotalLength());
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskDetectedSubloop saveFileName = " + downloaderTask.getRealSaveName());
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskDetectedSubloop percent=" + downloaderTask.getPercentage() + ",receivedBytes=" + downloaderTask.getReceivedLength());
        this.f1134a.a(downloaderTask.getTotalLength());
        this.f1134a.a(2);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskFailedMainloop");
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskFailedSubloop failCode=" + downloaderTask.getFailCode() + ". getSavePath=" + downloaderTask.getSavePath());
        this.f1134a.j = downloaderTask.getRealSaveName();
        this.f1134a.b(downloaderTask.getFailCode());
        com.tencent.tmdownloader.internal.downloadservice.d dVar = this.f1134a;
        dVar.i = 0L;
        dVar.h = 0L;
        dVar.a(5);
        this.f1134a.b(downloaderTask);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskPausedMainloop");
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.d("_DownloadInfo", "halleyTest onTaskPausedSubloop pauseType=" + downloaderTask.isPausedOnMobile() + ",mIsPausedByMoble=" + this.f1134a.I);
        this.f1134a.a(3);
        this.f1134a.c(downloaderTask);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskPendingMainloop");
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        long receivedLength = downloaderTask.getReceivedLength();
        com.tencent.tmdownloader.internal.downloadservice.d dVar = this.f1134a;
        if (receivedLength != dVar.h) {
            dVar.b(downloaderTask.getReceivedLength());
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.i("_DownloadInfo", "halleyTest onTaskStartedMainloop");
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        com.tencent.tmassistantbase.util.TMLog.d("_DownloadInfo", "halleyTest onTaskStartedSubloop saveFileName = " + downloaderTask.getRealSaveName());
        com.tencent.tmassistantbase.util.TMLog.d("_DownloadInfo", "halleyTest onTaskStartedSubloop percent=" + downloaderTask.getPercentage() + ",receivedBytes=" + downloaderTask.getReceivedLength());
        this.f1134a.a(2);
    }
}
