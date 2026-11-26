package com.tencent.ysdk.shell.module.hades.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HadesModule {
    public HadesModule(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        init(str, str2, str3);
    }

    private java.io.File decode(java.io.File file, java.lang.String str) {
        com.tencent.ysdk.shell.module.hades.impl.request.AESHelper aESHelper = new com.tencent.ysdk.shell.module.hades.impl.request.AESHelper();
        java.io.File file2 = new java.io.File(file.getAbsolutePath() + "D");
        if (file2.exists()) {
            file2.delete();
        }
        if (aESHelper.aesCipher(2, file, file2, str)) {
            return file2;
        }
        return null;
    }

    private void init(java.lang.String str, java.lang.String str2, final java.lang.String str3) {
        com.tencent.ysdk.shell.libware.file.Logger.d("Hades", "init");
        try {
            final java.lang.String str4 = getApplicationContext().getApplicationInfo().dataDir + "/" + str2;
            final java.io.File file = new java.io.File(str4);
            if (file.exists()) {
                loadDex(file, str3);
            } else {
                java.net.URL url = new java.net.URL(str);
                final com.tencent.ysdk.shell.libware.download.DownloadManager downloadManager = com.tencent.ysdk.shell.libware.download.DownloadManager.getInstance();
                downloadManager.addListener(new com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener() { // from class: com.tencent.ysdk.shell.module.hades.impl.HadesModule.1
                    @Override // com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener
                    public void onErr(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem) {
                    }

                    @Override // com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener
                    public void onSuccess(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem) {
                        if (downloadItem.mLocalFilePath.equals(str4) || file.exists()) {
                            com.tencent.ysdk.shell.module.hades.impl.HadesModule.this.loadDex(file, str3);
                            downloadManager.removeListener(this);
                        }
                    }
                });
                downloadManager.addToDownloadQueue(url, str4, str2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadDex(java.io.File file, java.lang.String str) {
        com.tencent.ysdk.hades.HadesManager.getInstance().setContext(getActivity());
        java.io.File fileDecode = decode(file, str);
        if (fileDecode != null) {
            com.tencent.ysdk.hades.HadesManager.getInstance().load(fileDecode.getAbsolutePath(), str);
        }
    }

    public static void reportHadesEvent(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.libware.file.Logger.d("Hades", str + ":" + str2);
        com.tencent.ysdk.shell.module.hades.impl.HadesStat.reportHadesEvent(str, i, str2, map);
    }

    public android.app.Activity getActivity() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity();
    }

    public android.content.Context getApplicationContext() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
    }
}
