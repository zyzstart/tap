package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkDownloadMgr extends com.dodjoy.dodlib.DodLibBaseMgr {
    static java.lang.String mProgDownID = "com.dodjoy.xgame.down_prog_id";
    static java.lang.String mProgDownUri = "com.dodjoy.xgame.down_prog_uri";
    public android.content.Context mContext;
    android.content.BroadcastReceiver mReceiver = null;
    java.lang.String mTitle;

    public ApkDownloadMgr(java.lang.String str) {
        this.mTitle = null;
        this.mTitle = str;
    }

    private java.lang.String GetAPkFileName(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf <= 0) {
            return null;
        }
        java.lang.String strSubstring = str.substring(iLastIndexOf + 1);
        if (strSubstring.endsWith(".apk")) {
            return strSubstring;
        }
        return null;
    }

    private void RmvExistDownID() {
    }

    private java.lang.String getBytesAndStatus(android.app.DownloadManager downloadManager, long j) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        try {
            cursorQuery = downloadManager.query(new android.app.DownloadManager.Query().setFilterById(j));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        java.lang.String strConvStatusReason = "";
                        if (i3 == 16 || i3 == 4) {
                            strConvStatusReason = ConvStatusReason(i3, cursorQuery.getInt(cursorQuery.getColumnIndex("reason")));
                        } else if (i3 == 8 && !IsApkFileValid(android.net.Uri.parse(cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"))).getPath())) {
                            i3 = 0;
                        }
                        java.lang.String str = java.lang.String.format("{\"DownloadedSize\":%d,\"TotalSize\":%d,\"Status\":%d,\"StatusReason\":\"%s\"}", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), strConvStatusReason);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return str;
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

    private java.lang.String getDownloadPath(android.content.Context context, long j) {
        android.database.Cursor cursorQuery = ((android.app.DownloadManager) this.mContext.getSystemService("download")).query(new android.app.DownloadManager.Query().setFilterById(j));
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    protected java.lang.String ConvStatusReason(int i, int i2) {
        if (i == 16) {
            switch (i2) {
                case 1001:
                case android.support.v4.view.PointerIconCompat.TYPE_CELL /* 1006 */:
                    return "存储空间不够";
                case 1002:
                case 1004:
                case com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi /* 1005 */:
                    return "网络下载失败，请稍后重试";
                case 1003:
                case 1008:
                default:
                    return "未知错误";
                case 1007:
                    return "找不到存储卡";
                case 1009:
                    return "文件已经下载成功";
            }
        }
        if (i != 4) {
            return "";
        }
        switch (i2) {
            case 1:
                return "等待重新下载";
            case 2:
                return "网络无法连接";
            case 3:
                return "请在WIFI环境下下载更新";
            default:
                return "未知原因";
        }
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        this.mContext = activity;
        return true;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public void Destroy() {
        android.content.BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }

    public java.lang.String GetDownloadStateData(java.lang.String str) {
        java.lang.String strGetExistDownUri = GetExistDownUri();
        if (strGetExistDownUri != null && strGetExistDownUri.compareTo(str) != 0) {
            return null;
        }
        android.app.DownloadManager downloadManager = (android.app.DownloadManager) this.mContext.getSystemService("download");
        long jGetExistDownID = GetExistDownID();
        if (jGetExistDownID <= 0) {
            return null;
        }
        return getBytesAndStatus(downloadManager, jGetExistDownID);
    }

    public long GetExistDownID() {
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences != null) {
            return defaultSharedPreferences.getLong(mProgDownID, 0L);
        }
        android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
        return 0L;
    }

    public java.lang.String GetExistDownUri() {
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences != null) {
            return defaultSharedPreferences.getString(mProgDownUri, null);
        }
        android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
        return null;
    }

    public boolean InstallApk() {
        android.net.Uri uri;
        long jGetExistDownID = GetExistDownID();
        if (jGetExistDownID <= 0 || (uri = android.net.Uri.parse(getDownloadPath(this.mContext, jGetExistDownID))) == null) {
            return false;
        }
        java.lang.String path = uri.getPath();
        if (!IsApkFileValid(path)) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            intent.setDataAndType(android.support.v4.content.FileProvider.getUriForFile(this.mContext, "com.dodjoy.agame.fileprovider", new java.io.File(path)), com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        } else {
            intent.setDataAndType(uri, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        }
        intent.addFlags(268435456);
        intent.addFlags(1);
        this.mContext.startActivity(intent);
        RmvExistDownID();
        return true;
    }

    public boolean IsApkFileValid(java.lang.String str) {
        return new java.io.File(android.net.Uri.parse(str).getPath()).exists();
    }

    public boolean ManualDownload(java.lang.String str) {
        this.mContext.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
        return true;
    }

    public boolean StartDownload(java.lang.String str) {
        android.app.DownloadManager downloadManager = (android.app.DownloadManager) this.mContext.getSystemService("download");
        if (downloadManager == null) {
            android.util.Log.e("dodjoy", "getSystemService(DOWNLOAD_SERVICE) failed");
            return false;
        }
        android.util.Log.e("dodjoy", "downloadUrl:" + str);
        downloadManager.remove(GetExistDownID());
        android.net.Uri uri = android.net.Uri.parse(str);
        if (uri == null) {
            android.util.Log.e("dodjoy", "invalid download uri:" + str);
            return false;
        }
        java.lang.String strGetAPkFileName = GetAPkFileName(str);
        if (strGetAPkFileName == null) {
            android.util.Log.e("dodjoy", "invalid apk download url: " + str);
            return false;
        }
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(2);
        request.setVisibleInDownloadsUi(true);
        request.setMimeType(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        request.setNotificationVisibility(0);
        request.setDestinationInExternalFilesDir(this.mContext, "prog", strGetAPkFileName);
        request.setTitle(this.mTitle);
        long jEnqueue = downloadManager.enqueue(request);
        android.content.SharedPreferences defaultSharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this.mContext);
        if (defaultSharedPreferences == null) {
            android.util.Log.e("dodjoy", "getDefaultSharedPreferences failed");
            return false;
        }
        android.content.SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putLong(mProgDownID, jEnqueue);
        editorEdit.putString(mProgDownUri, str);
        editorEdit.commit();
        if (this.mReceiver == null) {
            this.mReceiver = new com.dodjoy.dodlib.DodDownCompleteReciver(this);
            this.mContext.registerReceiver(this.mReceiver, new android.content.IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
        return true;
    }
}
