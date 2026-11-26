package com.tencent.ysdk.shell.libware.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DownloadManager {
    public static final java.lang.String LOG_TAG = "YSDK DOWNLOAD";
    private static final int MSG_ADD_NEW_ITEM = 1;
    private static volatile com.tencent.ysdk.shell.libware.download.DownloadManager instance;
    private android.os.Handler mDownLoadHandler;
    private java.util.ArrayList<com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener> mListener = new java.util.ArrayList<>();

    public class DownloadItem {
        public long mFileLength;
        public java.net.URL mFileUrl;
        public java.lang.String mHashValue;
        public java.lang.String mLocalFilePath;
        public float mPercent = 0.0f;

        public DownloadItem(java.net.URL url, java.lang.String str, java.lang.String str2) {
            this.mFileUrl = url;
            this.mLocalFilePath = str;
            this.mHashValue = str2;
        }
    }

    public interface DownloadListener {
        void onErr(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem);

        void onSuccess(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem);
    }

    private class HandlerInTemp extends android.os.Handler {
        public HandlerInTemp(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            if (!(message.obj instanceof com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem)) {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, "addToDownloadQueueAsync para is bad");
            } else {
                com.tencent.ysdk.shell.libware.download.DownloadManager.this.addToDownloadQueueAsync((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem) message.obj);
            }
        }
    }

    private DownloadManager() {
        this.mDownLoadHandler = null;
        this.mDownLoadHandler = new com.tencent.ysdk.shell.libware.download.DownloadManager.HandlerInTemp(com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().getLooper(3));
    }

    public static void delFileByPath(java.lang.String str) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        new java.io.File(str).delete();
    }

    public static com.tencent.ysdk.shell.libware.download.DownloadManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.libware.download.DownloadManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.libware.download.DownloadManager();
                }
            }
        }
        return instance;
    }

    public void addListener(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener downloadListener) {
        this.mListener.add(downloadListener);
    }

    public void addToDownloadQueue(java.net.URL url, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, url);
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, str);
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, str2);
        if (url == null || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str) || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "url or filePath or hashValue is null");
            return;
        }
        this.mDownLoadHandler.sendMessage(this.mDownLoadHandler.obtainMessage(1, new com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem(url, str, str2)));
    }

    public void addToDownloadQueueAsync(final com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadItem downloadItem) {
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.libware.download.DownloadManager.1
            /* JADX WARN: Code duplicated, block: B:47:0x01b3 A[Catch: all -> 0x01d6, TryCatch #2 {all -> 0x01d6, blocks: (B:6:0x0070, B:7:0x0076, B:9:0x007d, B:10:0x0095, B:12:0x00ad, B:14:0x00bc, B:16:0x00e2, B:17:0x00ec, B:19:0x00f2, B:20:0x00fe, B:22:0x0124, B:23:0x012e, B:25:0x0134, B:26:0x0140, B:28:0x0175, B:29:0x017f, B:31:0x0185, B:45:0x01a2, B:47:0x01b3, B:48:0x01bd, B:50:0x01c3), top: B:58:0x0001 }] */
            /* JADX WARN: Code duplicated, block: B:50:0x01c3 A[Catch: all -> 0x01d6, LOOP:4: B:48:0x01bd->B:50:0x01c3, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x01d6, blocks: (B:6:0x0070, B:7:0x0076, B:9:0x007d, B:10:0x0095, B:12:0x00ad, B:14:0x00bc, B:16:0x00e2, B:17:0x00ec, B:19:0x00f2, B:20:0x00fe, B:22:0x0124, B:23:0x012e, B:25:0x0134, B:26:0x0140, B:28:0x0175, B:29:0x017f, B:31:0x0185, B:45:0x01a2, B:47:0x01b3, B:48:0x01bd, B:50:0x01c3), top: B:58:0x0001 }] */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                java.io.BufferedInputStream bufferedInputStream;
                java.io.Closeable closeable;
                java.io.BufferedOutputStream bufferedOutputStream;
                java.lang.Exception e;
                java.util.Iterator it;
                try {
                    try {
                        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) downloadItem.mFileUrl.openConnection();
                        httpURLConnection.setConnectTimeout(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                        httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
                        httpURLConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint,application/msword, */*");
                        httpURLConnection.setRequestProperty("Charset", "UTF-8");
                        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727;.NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        httpURLConnection.connect();
                        downloadItem.mFileLength = httpURLConnection.getContentLength();
                        byte[] bArr = new byte[4096];
                        bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            java.io.File file = new java.io.File(downloadItem.mLocalFilePath + "_temp");
                            bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                            long j = 0;
                            try {
                                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                                while (true) {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, i);
                                    messageDigest.update(bArr, 0, i);
                                    bufferedOutputStream.flush();
                                    j += (long) i;
                                    downloadItem.mPercent = j / downloadItem.mFileLength;
                                }
                                java.lang.String lowerCase = com.tencent.ysdk.shell.libware.encrypt.HexUtils.bytes2HexStr(messageDigest.digest()).toLowerCase(java.util.Locale.CHINA);
                                if (!lowerCase.equalsIgnoreCase(downloadItem.mHashValue)) {
                                    com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, "fileMd5:" + lowerCase + ";hashValue:" + downloadItem.mHashValue);
                                    com.tencent.ysdk.shell.libware.download.DownloadManager.delFileByPath(downloadItem.mLocalFilePath);
                                    if (com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.size() > 0) {
                                        java.util.Iterator it2 = com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.iterator();
                                        while (it2.hasNext()) {
                                            ((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener) it2.next()).onErr(downloadItem);
                                        }
                                    }
                                } else if (file.renameTo(new java.io.File(downloadItem.mLocalFilePath))) {
                                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, "rename succ：" + downloadItem.mLocalFilePath);
                                    if (com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.size() > 0) {
                                        java.util.Iterator it3 = com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.iterator();
                                        while (it3.hasNext()) {
                                            ((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener) it3.next()).onSuccess(downloadItem);
                                        }
                                    }
                                } else {
                                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, "rename failed：" + downloadItem.mLocalFilePath);
                                    if (com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.size() > 0) {
                                        java.util.Iterator it4 = com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.iterator();
                                        while (it4.hasNext()) {
                                            ((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener) it4.next()).onErr(downloadItem);
                                        }
                                    }
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, e);
                                if (com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.size() > 0) {
                                    it = com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.iterator();
                                    while (it.hasNext()) {
                                        ((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener) it.next()).onErr(downloadItem);
                                    }
                                }
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            bufferedOutputStream = null;
                            e = e;
                            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.libware.download.DownloadManager.LOG_TAG, e);
                            if (com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.size() > 0) {
                                it = com.tencent.ysdk.shell.libware.download.DownloadManager.this.mListener.iterator();
                                while (it.hasNext()) {
                                    ((com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener) it.next()).onErr(downloadItem);
                                }
                            }
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedOutputStream);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            closeable = null;
                            th = th;
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                            com.tencent.ysdk.shell.libware.file.Closer.closeStream(closeable);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(closeable);
                        throw th;
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                    closeable = null;
                }
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedInputStream);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedOutputStream);
            }
        });
    }

    public void removeListener(com.tencent.ysdk.shell.libware.download.DownloadManager.DownloadListener downloadListener) {
        this.mListener.remove(downloadListener);
    }
}
