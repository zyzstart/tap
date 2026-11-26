package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodDownCompleteReciver extends android.content.BroadcastReceiver {
    java.lang.String mDownErr = null;
    com.dodjoy.dodlib.ApkDownloadMgr mDownloader;

    DodDownCompleteReciver(com.dodjoy.dodlib.ApkDownloadMgr apkDownloadMgr) {
        this.mDownloader = null;
        this.mDownloader = apkDownloadMgr;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent.getAction().equals("android.intent.action.DOWNLOAD_COMPLETE") && intent.getLongExtra("extra_download_id", -1L) == this.mDownloader.GetExistDownID()) {
            this.mDownloader.InstallApk();
        }
    }
}
