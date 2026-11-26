package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CdnDownMgr extends com.dodjoy.dodlib.DodLibBaseMgr {
    private android.content.Context mContext;
    private com.dodjoy.download.AndroidDownloader mDownloader;
    private java.util.List<com.dodjoy.dodlib.CdnDownTaskData> mTaskList = new java.util.ArrayList();
    private java.lang.String mTitle = null;

    private void CheckNextDownTask() throws java.lang.Throwable {
        for (int i = 0; i < this.mTaskList.size(); i++) {
            com.dodjoy.dodlib.CdnDownTaskData cdnDownTaskData = this.mTaskList.get(i);
            if (!CheckTaskDone(cdnDownTaskData)) {
                if (this.mDownloader.IsDownloading(cdnDownTaskData.urlPath)) {
                    return;
                }
                this.mDownloader.StartDownload(this.mTitle, cdnDownTaskData.urlPath, cdnDownTaskData.destDir);
                return;
            }
        }
    }

    private boolean CheckTaskDone(com.dodjoy.dodlib.CdnDownTaskData cdnDownTaskData) {
        if (cdnDownTaskData.isDone) {
            return true;
        }
        java.lang.String strGetUrlFileName = com.dodjoy.download.AndroidDownUtil.GetUrlFileName(cdnDownTaskData.urlPath);
        java.io.File file = new java.io.File(com.dodjoy.download.AndroidDownUtil.GetDownFullFilePath(this.mContext, cdnDownTaskData.destDir + "/" + strGetUrlFileName));
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        cdnDownTaskData.isDone = file.length() == ((long) cdnDownTaskData.fileSize);
        return cdnDownTaskData.isDone;
    }

    public void EnqueueDownTask(java.lang.String str, java.lang.String str2, int i) {
        this.mTaskList.add(new com.dodjoy.dodlib.CdnDownTaskData(str, str2, i));
    }

    public com.dodjoy.download.DownloadStateData GetDownloadState() throws java.lang.Throwable {
        com.dodjoy.download.DownloadStateData downloadStateData = new com.dodjoy.download.DownloadStateData();
        int i = 0;
        for (int i2 = 0; i2 < this.mTaskList.size(); i2++) {
            i += this.mTaskList.get(i2).fileSize;
        }
        downloadStateData.status = 8;
        int i3 = 0;
        for (int i4 = 0; i4 < this.mTaskList.size(); i4++) {
            com.dodjoy.dodlib.CdnDownTaskData cdnDownTaskData = this.mTaskList.get(i4);
            if (!cdnDownTaskData.isDone) {
                com.dodjoy.download.DownloadStateData downloadStateDataGetCurrStateData = this.mDownloader.GetCurrStateData();
                if (downloadStateDataGetCurrStateData != null) {
                    downloadStateData.status = downloadStateDataGetCurrStateData.status;
                    downloadStateData.reason = downloadStateDataGetCurrStateData.reason;
                    i3 += downloadStateDataGetCurrStateData.downloadedSize;
                    if (downloadStateData.status != 8) {
                        break;
                    }
                    cdnDownTaskData.isDone = true;
                    CheckNextDownTask();
                    return GetDownloadState();
                }
                downloadStateData.status = 16;
                downloadStateData.reason = -1;
                break;
            }
            i3 += cdnDownTaskData.fileSize;
        }
        downloadStateData.totalSize = i;
        downloadStateData.downloadedSize = i3;
        return downloadStateData;
    }

    public void OnCreate(android.content.Context context) {
        this.mContext = context.getApplicationContext();
        this.mDownloader = new com.dodjoy.download.AndroidDownloader(context, "com.dod.cdn.down");
    }

    public void StartDonwload(java.lang.String str) throws java.lang.Throwable {
        this.mTitle = str;
        for (int i = 0; i < this.mTaskList.size(); i++) {
            com.dodjoy.dodlib.CdnDownTaskData cdnDownTaskData = this.mTaskList.get(i);
            if (!CheckTaskDone(cdnDownTaskData)) {
                if (this.mDownloader.IsDownloading(cdnDownTaskData.urlPath)) {
                    return;
                }
                this.mDownloader.StartDownload(this.mTitle, cdnDownTaskData.urlPath, cdnDownTaskData.destDir);
                return;
            }
        }
    }

    public void StopDownload() throws java.lang.Throwable {
        if (this.mDownloader.IsDownloading()) {
            this.mDownloader.StopDownload();
        }
    }
}
