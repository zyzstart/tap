package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantCallYYB_V1 extends com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB implements com.tencent.tmassistantsdk.internal.openSDK.b {
    public static final java.lang.String AUTHORITY = "com.tencent.android.qqdownloader.provider";
    public static final android.net.Uri CONTENT_URI = com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.b.f1080a;
    protected static final java.lang.String TAG = "TMAssistantCallYYB_V1";
    protected static com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 mInstance;
    java.util.Map mDownloadParams;
    protected int sdkAPILevel = 1;
    public java.lang.String mTaskId = null;

    private TMAssistantCallYYB_V1() {
        this.mDownloadParams = null;
        this.mDownloadParams = new java.util.concurrent.ConcurrentHashMap();
    }

    public static synchronized com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 getInstance() {
        if (mInstance == null) {
            mInstance = new com.tencent.tmassistantsdk.TMAssistantCallYYB_V1();
        }
        return mInstance;
    }

    private boolean isFileExist(java.lang.String str) {
        if (new java.io.File(str).exists()) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "File is exist");
            return true;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "File is not exist");
        return false;
    }

    private void relateToQQDownloader(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",param = " + tMAssistantCallYYBParamStruct + ",taskId = " + str);
        java.util.Map mapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, false, false, str);
        mapParams.put("taskid", str);
        java.lang.String intentUriPath = super.formatIntentUriPath(4, mapParams);
        android.content.Intent intent = new android.content.Intent(com.tencent.assistant.sdk.remote.SDKConst.SDK_RELATED_ACTION);
        intent.setPackage("com.tencent.android.qqdownloader");
        intent.putExtra(com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND, com.tencent.assistant.sdk.remote.SDKConst.COMMAND_REALTED_UPDATE_DOWNLOAD);
        intent.putExtra(com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_URL, intentUriPath);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAppDetail(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        java.util.Map map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_addDownloadTaskFromAppDetail"));
        }
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z, z2, tMAssistantCallYYBParamStruct.actionFlag, null, 2, string);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jBuildAddDBData);
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAuthorize(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",verifyType = " + str);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        java.util.Map map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_addDownloadTaskFromAuthorize"));
        }
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, true, true, tMAssistantCallYYBParamStruct.actionFlag, str, 3, string);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jBuildAddDBData);
        return jBuildAddDBData;
    }

    public long addDownloadTaskFromAuthorize(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url = " + str);
        java.lang.String encryptUrl = super.formatEncryptUrl(str);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jA = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, encryptUrl, jCurrentTimeMillis, jCurrentTimeMillis + 300000, 0, "", null);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jA);
        return jA;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromTaskList(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        java.util.Map map = this.mDownloadParams;
        if (map != null && tMAssistantCallYYBParamStruct != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_addDownloadTaskFromTaskList"));
        }
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z, z2, tMAssistantCallYYBParamStruct.actionFlag, null, 1, string);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jBuildAddDBData);
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void destroyQQDownloaderOpenSDK() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "mContext = " + this.mContext);
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().c();
        com.tencent.tmassistantsdk.internal.c.e.a().d();
        com.tencent.tmassistantsdk.internal.c.e.a().b();
        if (this.mContext != null) {
            com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver.a().b(this.mContext);
            com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver.a().b(this);
        }
        com.tencent.tmassistantbase.util.k.a().c();
        this.mContext = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo getDownloadTaskState(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) throws java.lang.Exception {
        ?? Query;
        com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo;
        ?? r2;
        ?? r3;
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("Context shouldn't be null !");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "param is null");
            throw new java.lang.Exception("QQDownloaderParam param cann't is null!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct);
        java.lang.String str = null;
        tMAssistantCallYYBTaskInfo = null;
        com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo2 = null;
        try {
            try {
                boolean z = false;
                Query = this.mContext.getContentResolver().query(CONTENT_URI, null, "packageName=? and versionCode=? and channelId=?", new java.lang.String[]{tMAssistantCallYYBParamStruct.taskPackageName, java.lang.String.valueOf(tMAssistantCallYYBParamStruct.taskVersion), tMAssistantCallYYBParamStruct.channelId}, null);
                try {
                    try {
                        com.tencent.tmassistantbase.util.TMLog.d(TAG, "getDownloadTaskState from qqdownloader , taskPackageName = " + tMAssistantCallYYBParamStruct.taskPackageName + ", taskVersion=" + java.lang.String.valueOf(tMAssistantCallYYBParamStruct.taskVersion) + ", channelId=" + tMAssistantCallYYBParamStruct.channelId);
                        if (Query != 0 && Query.moveToFirst()) {
                            com.tencent.tmassistantbase.util.TMLog.i(TAG, "relate to qqdownloader , packageName = " + tMAssistantCallYYBParamStruct.taskPackageName);
                            long j = Query.getLong(Query.getColumnIndex("apkId"));
                            java.lang.String str2 = (java.lang.String) com.tencent.tmassistantbase.util.k.c(Query.getString(Query.getColumnIndex("apkUrl"))).get(0);
                            java.lang.String string = Query.getString(Query.getColumnIndex(com.tencent.smtt.sdk.TbsReaderView.KEY_FILE_PATH));
                            long j2 = Query.getLong(Query.getColumnIndex("received_length"));
                            long j3 = Query.getLong(Query.getColumnIndex("total_length"));
                            int iA = com.tencent.tmassistantbase.util.k.a(Query.getInt(Query.getColumnIndex("state")));
                            com.tencent.tmassistantbase.util.TMLog.i(TAG, "getDownloadTaskState state = " + iA);
                            if (4 == iA && !isFileExist(string)) {
                                if (Query != 0) {
                                    Query.close();
                                }
                                return null;
                            }
                            tMAssistantCallYYBTaskInfo = new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(str2, string, iA, j2, j3, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
                            try {
                                if (this.mDownloadParams != null) {
                                    java.util.Iterator it = this.mDownloadParams.entrySet().iterator();
                                    while (it.hasNext()) {
                                        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct2 = (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) ((java.util.Map.Entry) it.next()).getValue();
                                        if (tMAssistantCallYYBParamStruct2 != null && tMAssistantCallYYBParamStruct2.taskPackageName.equals(tMAssistantCallYYBParamStruct.taskPackageName) && tMAssistantCallYYBParamStruct2.taskVersion == tMAssistantCallYYBParamStruct.taskVersion) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        com.tencent.tmassistantbase.util.TMLog.i(TAG, "relate to qqdownloader , packageName = " + tMAssistantCallYYBParamStruct.taskPackageName);
                                        java.lang.String string2 = java.util.UUID.randomUUID().toString();
                                        tMAssistantCallYYBParamStruct.taskApkId = java.lang.String.valueOf(j);
                                        this.mDownloadParams.put(string2, tMAssistantCallYYBParamStruct);
                                        relateToQQDownloader(this.mContext, tMAssistantCallYYBParamStruct, string2);
                                    }
                                }
                                tMAssistantCallYYBTaskInfo2 = tMAssistantCallYYBTaskInfo;
                            } catch (java.lang.Exception e) {
                                e = e;
                                r3 = Query;
                                e.printStackTrace();
                                com.tencent.tmassistantbase.util.TMLog.e(TAG, "getDownloadTaskState Exception", e);
                                r2 = r3;
                                if (r3 != 0) {
                                }
                                str = TAG;
                                com.tencent.tmassistantbase.util.TMLog.i(TAG, "taskInfo = " + tMAssistantCallYYBTaskInfo);
                                return tMAssistantCallYYBTaskInfo;
                            }
                            r3 = Query;
                            e.printStackTrace();
                            com.tencent.tmassistantbase.util.TMLog.e(TAG, "getDownloadTaskState Exception", e);
                            r2 = r3;
                            if (r3 != 0) {
                                r2.close();
                            }
                            str = TAG;
                            com.tencent.tmassistantbase.util.TMLog.i(TAG, "taskInfo = " + tMAssistantCallYYBTaskInfo);
                            return tMAssistantCallYYBTaskInfo;
                        }
                        if (Query != 0) {
                            tMAssistantCallYYBTaskInfo = tMAssistantCallYYBTaskInfo2;
                            r2 = Query;
                            r2.close();
                        } else {
                            tMAssistantCallYYBTaskInfo = tMAssistantCallYYBTaskInfo2;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        tMAssistantCallYYBTaskInfo = null;
                    }
                    str = TAG;
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "taskInfo = " + tMAssistantCallYYBTaskInfo);
                    return tMAssistantCallYYBTaskInfo;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (Query != 0) {
                        Query.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                Query = str;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            Query = 0;
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public int initTMAssistantCallYYBApi(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context);
        this.mContext = context.getApplicationContext();
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = com.tencent.tmassistantbase.util.k.c(this.mContext);
        com.tencent.tmassistantbase.util.k.a().a(this.mContext);
        this.sdkAPILevel = 1;
        com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver.a().a(this.mContext);
        com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver.a().a(this);
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b();
        com.tencent.tmassistantsdk.internal.c.e.a();
        return super.initTMAssistantCallYYBApi(context);
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.b
    public void onDownloadStateChanged(com.tencent.tmassistantsdk.internal.openSDK.e eVar) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "stateChangedParam = " + eVar);
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = eVar.f1084a;
        int iA = com.tencent.tmassistantbase.util.k.a(eVar.e);
        int iB = com.tencent.tmassistantbase.util.k.b(eVar.f);
        java.lang.String str = eVar.g;
        java.lang.String str2 = eVar.d;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadStateChanged state = " + iA);
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct2 = (str2 == null || str2.trim().length() <= 0) ? null : (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) this.mDownloadParams.get(str2);
        com.tencent.tmassistantbase.util.x.a(TAG, "test0629 onDownloadStateChanged mTaskId=" + this.mTaskId);
        java.lang.String str3 = this.mTaskId;
        if (str3 != null && str3.trim().length() > 0) {
            tMAssistantCallYYBParamStruct2 = (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) this.mDownloadParams.get(this.mTaskId);
        }
        com.tencent.tmassistantbase.util.x.a(TAG, "test0629 onDownloadStateChanged storeParam=" + tMAssistantCallYYBParamStruct2);
        if (tMAssistantCallYYBParamStruct2 != null) {
            com.tencent.tmassistantbase.util.x.a(TAG, "test0629 onDownloadStateChanged onStateChanged errorCode=" + iB);
            onStateChanged(tMAssistantCallYYBParamStruct2, iA, iB, str);
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadStateChanged storeParam = null");
        }
        if (6 == iA) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.util.Map.Entry entry : this.mDownloadParams.entrySet()) {
                com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct3 = (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) entry.getValue();
                java.lang.String str4 = (java.lang.String) entry.getKey();
                if (tMAssistantCallYYBParamStruct3 != null && !android.text.TextUtils.isEmpty(tMAssistantCallYYBParamStruct.taskPackageName) && tMAssistantCallYYBParamStruct3.taskPackageName.equals(tMAssistantCallYYBParamStruct.taskPackageName) && tMAssistantCallYYBParamStruct3.taskVersion == tMAssistantCallYYBParamStruct.taskVersion) {
                    arrayList.add(str4);
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mDownloadParams.remove((java.lang.String) it.next());
            }
        }
    }

    public void startToAppDetail(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        this.mTaskId = string;
        java.util.Map map = this.mDownloadParams;
        if (map != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
        }
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_startToAppDetail"));
        java.util.Map mapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z, z2, string);
        mapParams.put("taskid", string);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(super.formatIntentUriPath(2, mapParams)));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "startActivity Exception:", e);
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToAuthorized(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "QQDownloaderParam param is null");
            throw new java.lang.Exception("QQDownloaderParam param cann't be null!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",param = " + tMAssistantCallYYBParamStruct + ",verifyType = " + str);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        java.util.Map map = this.mDownloadParams;
        if (map != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
        }
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_startToAuthorized"));
        java.util.Map mapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, true, true, string);
        mapParams.put("verifytype", str);
        mapParams.put("taskid", string);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(super.formatIntentUriPath(3, mapParams)));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "startActivity Exception:", e);
        }
    }

    public void startToAuthorized(android.content.Context context, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",jumpUrl = " + str);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(formatEncryptUrl(str)));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "startActivity Exception:", e);
        }
    }

    public void startToDownloadTaskList(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "param is null");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        java.util.Map map = this.mDownloadParams;
        if (map != null) {
            map.put(string, tMAssistantCallYYBParamStruct);
        }
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V1_startToDownloadTaskList"));
        java.util.Map mapParams = super.formatMapParams(tMAssistantCallYYBParamStruct, z, z2, string);
        mapParams.put("taskid", string);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(super.formatIntentUriPath(1, mapParams)));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "startActivity Exception:", e);
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToWebView(android.content.Context context, java.lang.String str) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "url is null");
            throw new java.lang.Exception("param url shouldn't be null!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",url = " + str);
        java.util.HashMap map = new java.util.HashMap();
        map.put("url", str);
        java.lang.String intentUriPath = super.formatIntentUriPath(5, map);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "startToWebView finalPath:" + intentUriPath);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(intentUriPath));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "startActivity Exception:", e);
        }
    }
}
