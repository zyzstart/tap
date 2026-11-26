package com.tencent.tmassistantsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantCallYYB_V2 extends com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB implements com.tencent.tmassistantsdk.ITMAssistantCallBackListener, com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d {
    protected static final java.lang.String TAG = "TMAssistantCallYYB_V2";
    protected static com.tencent.tmassistantsdk.TMAssistantCallYYB_V2 mInstance;
    protected java.util.concurrent.CopyOnWriteArrayList mTaskList;

    protected TMAssistantCallYYB_V2() {
        this.mTaskList = null;
        this.mTaskList = new java.util.concurrent.CopyOnWriteArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void addToTaskList(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        java.util.concurrent.CopyOnWriteArrayList<com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct> copyOnWriteArrayList;
        java.lang.String str;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct);
        if (tMAssistantCallYYBParamStruct != null && (copyOnWriteArrayList = this.mTaskList) != null) {
            boolean z = false;
            for (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct2 : copyOnWriteArrayList) {
                java.lang.String str2 = tMAssistantCallYYBParamStruct2.taskAppId;
                if (str2 != null) {
                    if (str2.equals(tMAssistantCallYYBParamStruct.taskAppId) && ((str = tMAssistantCallYYBParamStruct2.taskPackageName) == null || str.equals(tMAssistantCallYYBParamStruct.taskPackageName))) {
                        z = true;
                        break;
                    }
                } else {
                    java.lang.String str3 = tMAssistantCallYYBParamStruct2.taskPackageName;
                    if (str3 != null && str3.equals(tMAssistantCallYYBParamStruct.taskPackageName)) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                this.mTaskList.add(tMAssistantCallYYBParamStruct);
            }
        }
    }

    private int getBatchRequestType(boolean z, int i) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "isUpdateAll = " + z + ",operation = " + i);
        int i2 = 2;
        if (!z) {
            switch (i) {
                case 0:
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 8;
                    break;
                case 3:
                    i2 = 7;
                    break;
            }
        } else {
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 5;
                    break;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "batchRequestType = " + i2);
        return i2;
    }

    public static synchronized com.tencent.tmassistantsdk.TMAssistantCallYYB_V2 getInstance() {
        if (mInstance == null) {
            mInstance = new com.tencent.tmassistantsdk.TMAssistantCallYYB_V2();
        }
        return mInstance;
    }

    private void onProgressChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j, long j2) {
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener = (com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get();
            if (iTMAssistantCallBackListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMAssistantCallBackListener.OnDownloadTaskProgressChanged(tMAssistantCallYYBParamStruct, j, j2);
            }
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnDownloadTaskProgressChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j, long j2) {
        if (tMAssistantCallYYBParamStruct != null) {
            onProgressChanged(tMAssistantCallYYBParamStruct, j, j2);
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnDownloadTaskStateChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i, int i2, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",state = " + i + ",errorCode = " + i2 + ",errorMsg = " + str);
        if (tMAssistantCallYYBParamStruct != null) {
            onStateChanged(tMAssistantCallYYBParamStruct, i, i2, str);
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnQQDownloaderInvalid() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "OnQQDownloaderInvalid");
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener = (com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get();
            if (iTMAssistantCallBackListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMAssistantCallBackListener.OnQQDownloaderInvalid();
            }
        }
    }

    @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
    public void OnServiceFree() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "OnServiceFree start");
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener = (com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get();
            if (iTMAssistantCallBackListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMAssistantCallBackListener.OnServiceFree();
            }
        }
    }

    public long addBatchUpdateOperationToDB(java.util.ArrayList arrayList, boolean z, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        byte[] bArrA;
        boolean z2 = arrayList == null || arrayList.size() == 0;
        int batchRequestType = getBatchRequestType(z2, i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("appList = ");
        sb.append(arrayList == null ? "null" : java.lang.Integer.valueOf(arrayList.size()));
        sb.append(",isNeedSwitchView = ");
        sb.append(z);
        sb.append(",via = ");
        sb.append(str);
        sb.append(",uin = ");
        sb.append(str2);
        sb.append(",uinType = ");
        sb.append(str3);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        if (batchRequestType != 3 && !z2) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) it.next();
                if (tMAssistantCallYYBParamStruct != null) {
                    addToTaskList(tMAssistantCallYYBParamStruct);
                }
            }
        }
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest batchDownloadActionRequestB = com.tencent.tmassistantsdk.internal.openSDK.d.b(batchRequestType, arrayList, str, str2, str3);
        long jBuildAddDBData = (batchDownloadActionRequestB == null || (bArrA = com.tencent.tmassistantsdk.internal.openSDK.d.a(batchDownloadActionRequestB, "")) == null) ? -1L : buildAddDBData(bArrA);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jBuildAddDBData);
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAppDetail(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        addToTaskList(tMAssistantCallYYBParamStruct);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z, z2, tMAssistantCallYYBParamStruct.actionFlag, null, 2, string);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("result = ");
        sb.append(jBuildAddDBData);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V2_addDownloadTaskFromAppDetail"));
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromAuthorize(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",verifyType = " + str);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        addToTaskList(tMAssistantCallYYBParamStruct);
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, true, true, tMAssistantCallYYBParamStruct.actionFlag, str, 3, string);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jBuildAddDBData);
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V2_addDownloadTaskFromAuthorize"));
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public long addDownloadTaskFromTaskList(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        addToTaskList(tMAssistantCallYYBParamStruct);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        long jBuildAddDBData = super.buildAddDBData(tMAssistantCallYYBParamStruct, z, z2, tMAssistantCallYYBParamStruct.actionFlag, null, 1, string);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("result = ");
        sb.append(jBuildAddDBData);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V2_addDownloadTaskFromTaskList"));
        return jBuildAddDBData;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void destroyQQDownloaderOpenSDK() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "mContext = " + this.mContext);
        com.tencent.tmassistantsdk.internal.c.e.a().d();
        com.tencent.tmassistantsdk.internal.c.e.a().b();
        android.content.Context context = this.mContext;
        if (context != null) {
            com.tencent.tmassistantsdk.internal.openSDK.d.a(context).b();
            com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled.a().b();
            com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled.a().b(this.mContext);
        }
        com.tencent.tmassistantbase.util.k.a().c();
        this.mContext = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.ArrayList getBatchTaskState(java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("mContext shouldn't be null !");
        }
        if (arrayList == null || arrayList.size() <= 0) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "appList is null");
            throw new java.lang.Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "appList = " + arrayList.size() + ",via = " + str + ",uin = " + str2 + ",uinType = " + str3);
        int qQDownloadApiLevel = com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.mContext);
        if (qQDownloadApiLevel > 1) {
            if (qQDownloadApiLevel >= 4) {
                java.util.ArrayList arrayListA = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(arrayList, str, str2, str3);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("result = ");
                sb.append(arrayListA == null ? "null" : java.lang.Integer.valueOf(arrayListA.size()));
                com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
                return arrayListA;
            }
            com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfoA = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a((com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) arrayList.get(0));
            if (tMAssistantCallYYBTaskInfoA != null) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                arrayList2.add(tMAssistantCallYYBTaskInfoA);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + arrayList2.size());
                return arrayList2;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = null");
        return null;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo getDownloadTaskState(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) throws java.lang.Exception {
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("Context shouldn't be null !");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "param is null");
            throw new java.lang.Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct);
        com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfoA = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(tMAssistantCallYYBParamStruct);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + tMAssistantCallYYBTaskInfoA);
        return tMAssistantCallYYBTaskInfoA;
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public int initTMAssistantCallYYBApi(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context);
        this.mContext = context.getApplicationContext();
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = com.tencent.tmassistantbase.util.k.c(this.mContext);
        com.tencent.tmassistantbase.util.k.a().a(this.mContext);
        this.sdkAPILevel = 2;
        android.content.Context context2 = this.mContext;
        if (context2 != null) {
            com.tencent.tmassistantsdk.internal.openSDK.d.a(context2).a(this);
            com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled.a().a(this.mContext);
            com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled.a().a(this);
        }
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b();
        com.tencent.tmassistantsdk.internal.c.e.a();
        return super.initTMAssistantCallYYBApi(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d
    public synchronized void onQQDownloaderInstalled(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "received qqdownload install broadcase!");
        java.util.concurrent.CopyOnWriteArrayList<com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct> copyOnWriteArrayList = this.mTaskList;
        if (copyOnWriteArrayList != null) {
            for (com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct : copyOnWriteArrayList) {
                if (tMAssistantCallYYBParamStruct != null) {
                    try {
                        getDownloadTaskState(tMAssistantCallYYBParamStruct);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    this.mTaskList.remove(tMAssistantCallYYBParamStruct);
                }
            }
        }
    }

    public void releaseIPCConnected() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "mContext = " + this.mContext);
        android.content.Context context = this.mContext;
        if (context != null) {
            com.tencent.tmassistantsdk.internal.openSDK.d.a(context).c();
        }
    }

    public void startToAppDetail(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2, int i) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2 + ",operation = " + i);
        if (tMAssistantCallYYBParamStruct != null) {
            java.lang.String oplist = super.formatOplist(z, z2);
            int i2 = 1 == i ? 1 : 4;
            addToTaskList(tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(tMAssistantCallYYBParamStruct, i2, oplist, tMAssistantCallYYBParamStruct.actionFlag, (java.lang.String) null);
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToAuthorized(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "param is null");
            throw new java.lang.Exception("QQDownloaderParam param cann't be null!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",param = " + tMAssistantCallYYBParamStruct + ",verifyType = " + str);
        if (tMAssistantCallYYBParamStruct != null) {
            addToTaskList(tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(tMAssistantCallYYBParamStruct, 3, super.formatOplist(true, true), tMAssistantCallYYBParamStruct.actionFlag, str);
        }
    }

    public void startToAuthorized(android.content.Context context, java.lang.String str) {
        android.content.Context context2;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",jumpUrl = " + str);
        java.lang.String encryptUrl = super.formatEncryptUrl(str);
        if (android.text.TextUtils.isEmpty(str) || (context2 = this.mContext) == null) {
            return;
        }
        com.tencent.tmassistantsdk.internal.openSDK.d.a(context2).a(encryptUrl);
    }

    public int startToBatchUpdateOperation(android.content.Context context, java.util.ArrayList arrayList, boolean z, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context + ",appList = " + arrayList + ",isNeedSwitchView = " + z + ",operation = " + i + ",via = " + str + ",uin = " + str2 + ",uinType = " + str3);
        int qQDownloadApiLevel = com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB.getQQDownloadApiLevel(context);
        boolean z2 = true;
        if (qQDownloadApiLevel <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "TMAssistantDownloadTaskState.UN_INSTALLED");
            return 1;
        }
        if (qQDownloadApiLevel < 4) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "TMAssistantDownloadTaskState.LOWWER_VERSION_INSTALLED");
            return 2;
        }
        if (arrayList != null && arrayList.size() != 0) {
            z2 = false;
        }
        int batchRequestType = getBatchRequestType(z2, i);
        if (!com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(batchRequestType, arrayList, str, str2, str3)) {
            com.tencent.tmassistantbase.util.TMLog.w(TAG, "handleBatchRequestAction return false with batchRequestType=" + batchRequestType);
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "TMAssistantDownloadTaskState.ALREADY_INSTALLED");
        return 0;
    }

    public void startToDownloadTaskList(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2, int i) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        if (tMAssistantCallYYBParamStruct == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "param is null");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2 + ",operation = " + i);
        if (tMAssistantCallYYBParamStruct != null) {
            java.lang.String oplist = super.formatOplist(z, z2);
            int i2 = 1 == i ? 2 : 5;
            addToTaskList(tMAssistantCallYYBParamStruct);
            com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(tMAssistantCallYYBParamStruct, i2, oplist, tMAssistantCallYYBParamStruct.actionFlag, (java.lang.String) null);
        }
    }

    @Override // com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB
    public void startToWebView(android.content.Context context, java.lang.String str) throws java.lang.Exception {
        android.content.Context context2;
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
        if (android.text.TextUtils.isEmpty(str) || (context2 = this.mContext) == null) {
            return;
        }
        com.tencent.tmassistantsdk.internal.openSDK.d.a(context2).a(intentUriPath);
    }
}
