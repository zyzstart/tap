package com.dodjoy.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AndroidDownloader {
    android.content.Context mContext;
    java.lang.String mProgDownIdKey = null;
    java.lang.String mProgDownUrlKey = null;

    public AndroidDownloader(android.content.Context context, java.lang.String str) {
        Init(context, str);
    }

    private void DoStopDownload(long j) throws java.lang.Throwable {
        com.dodjoy.download.DownloadStateData downloadStateDataGetDownStateData = GetDownStateData(j);
        if (downloadStateDataGetDownStateData == null || downloadStateDataGetDownStateData.status != 8) {
            ((android.app.DownloadManager) this.mContext.getSystemService("download")).remove(j);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("file is downloaded success, dont remove: ");
        sb.append(downloadStateDataGetDownStateData.localFilePath);
        android.util.Log.e("dodjoy", sb.toString() != null ? downloadStateDataGetDownStateData.localFilePath : "null");
    }

    private com.dodjoy.download.DownloadStateData GetDownStateData(long j) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        android.app.DownloadManager downloadManager = (android.app.DownloadManager) this.mContext.getSystemService("download");
        int i = 0;
        try {
            cursorQuery = downloadManager.query(new android.app.DownloadManager.Query().setFilterById(j));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        com.dodjoy.download.DownloadStateData downloadStateData = new com.dodjoy.download.DownloadStateData();
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        if (i4 == 16 || i4 == 4) {
                            i = cursorQuery.getInt(cursorQuery.getColumnIndex("reason"));
                        } else if (i4 == 8) {
                            android.net.Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(j);
                            if (uriForDownloadedFile == null) {
                                i4 = 0;
                            } else {
                                downloadStateData.localFilePath = uriForDownloadedFile.getPath();
                            }
                        }
                        downloadStateData.downloadedSize = i2;
                        downloadStateData.totalSize = i3;
                        downloadStateData.status = i4;
                        downloadStateData.reason = i;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return downloadStateData;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private void Init(android.content.Context context, java.lang.String str) {
        this.mContext = context;
        this.mProgDownIdKey = str;
        this.mProgDownUrlKey = this.mProgDownIdKey + "_url";
    }

    private boolean IsDownloadingStatus(int i) {
        return i == 1 || i == 4 || i == 2;
    }

    private void ResetDownId() {
        SetDownId(0L, "");
    }

    private void SetDownId(long j, java.lang.String str) {
        if (this.mProgDownIdKey == null) {
            return;
        }
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences == null) {
            android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putLong(this.mProgDownIdKey, j);
        editorEdit.putString(this.mProgDownUrlKey, str);
        editorEdit.commit();
    }

    public com.dodjoy.download.DownloadStateData GetCurrStateData() {
        long jGetExistDownId = GetExistDownId();
        if (jGetExistDownId > 0) {
            return GetDownStateData(jGetExistDownId);
        }
        return null;
    }

    public long GetExistDownId() {
        if (this.mProgDownIdKey == null) {
            return 0L;
        }
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences != null) {
            return defaultSharedPreferences.getLong(this.mProgDownIdKey, 0L);
        }
        android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
        return 0L;
    }

    public java.lang.String GetExistDownUri() {
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences != null) {
            return defaultSharedPreferences.getString(this.mProgDownUrlKey, null);
        }
        android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
        return null;
    }

    public boolean IsDownloading() {
        com.dodjoy.download.DownloadStateData downloadStateDataGetCurrStateData = GetCurrStateData();
        if (downloadStateDataGetCurrStateData != null) {
            return IsDownloadingStatus(downloadStateDataGetCurrStateData.status);
        }
        return false;
    }

    public boolean IsDownloading(java.lang.String str) {
        com.dodjoy.download.DownloadStateData downloadStateDataGetDownStateData;
        long jGetExistDownId = GetExistDownId();
        if (jGetExistDownId <= 0 || (downloadStateDataGetDownStateData = GetDownStateData(jGetExistDownId)) == null || !GetExistDownUri().equals(str)) {
            return false;
        }
        return IsDownloadingStatus(downloadStateDataGetDownStateData.status);
    }

    public boolean StartDownload(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        StopDownload();
        java.lang.String strGetUrlFileName = com.dodjoy.download.AndroidDownUtil.GetUrlFileName(str2);
        java.lang.String strGetDownFullFilePath = com.dodjoy.download.AndroidDownUtil.GetDownFullFilePath(this.mContext, str3 + "/" + strGetUrlFileName);
        java.io.File file = new java.io.File(strGetDownFullFilePath);
        if (file.exists()) {
            file.delete();
            android.util.Log.e("dodjoy", "delete last down file: " + strGetDownFullFilePath);
        } else {
            android.util.Log.e("dodjoy", "file not downloaded, reload all: " + strGetDownFullFilePath);
        }
        android.net.Uri uri = android.net.Uri.parse(str2);
        if (uri == null) {
            android.util.Log.e("dodjoy", "invalid download uri:" + str2);
            return false;
        }
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(3);
        request.setVisibleInDownloadsUi(true);
        request.setMimeType(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        request.setNotificationVisibility(0);
        request.setDestinationInExternalFilesDir(this.mContext, str3, strGetUrlFileName);
        request.setTitle(str);
        long jEnqueue = ((android.app.DownloadManager) this.mContext.getSystemService("download")).enqueue(request);
        if (jEnqueue > 0) {
            SetDownId(jEnqueue, str2);
            return true;
        }
        android.util.Log.e("dodjoy", "DownloadManager enqueue failed: " + str2);
        return false;
    }

    public void StopDownload() throws java.lang.Throwable {
        long jGetExistDownId = GetExistDownId();
        if (jGetExistDownId > 0) {
            DoStopDownload(jGetExistDownId);
            ResetDownId();
        }
    }
}
