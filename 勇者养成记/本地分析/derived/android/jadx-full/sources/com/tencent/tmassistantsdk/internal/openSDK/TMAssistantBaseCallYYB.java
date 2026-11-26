package com.tencent.tmassistantsdk.internal.openSDK;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class TMAssistantBaseCallYYB {
    protected static final java.lang.String TAG = "BaseQQDownloaderOpenSDK";
    protected int sdkAPILevel = 1;
    protected android.content.Context mContext = null;
    protected java.lang.String hostPackageName = null;
    protected int hostVersionCode = 0;
    protected com.tencent.tmassistantsdk.internal.a.b sdkChannel = new com.tencent.tmassistantsdk.internal.a.b();
    protected java.lang.ref.ReferenceQueue mListenerQueue = new java.lang.ref.ReferenceQueue();
    protected java.util.List mWeakListenerArrayList = java.util.Collections.synchronizedList(new java.util.ArrayList());

    protected TMAssistantBaseCallYYB() {
    }

    public static int getQQDownloadApiLevel(android.content.Context context) {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null,return 0");
            return 0;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "appInfo is null,return 0");
                return 0;
            }
            int i = applicationInfo.metaData.getInt(com.tencent.assistant.sdk.remote.SDKConst.SDK_APILEVEL);
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "apiLevel = " + i);
            return i;
        } catch (java.lang.Exception unused) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "packagename not found！");
            return 0;
        }
    }

    public static boolean isExistActoin(long j) {
        java.lang.String str;
        java.lang.String str2;
        if (j < 0) {
            str = TAG;
            str2 = "actionId < 0,return false";
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "actionId = " + j);
            java.util.ArrayList<com.tencent.tmassistantsdk.internal.a.c> arrayListA = new com.tencent.tmassistantsdk.internal.a.b().a();
            if (arrayListA != null && arrayListA.size() > 0) {
                for (com.tencent.tmassistantsdk.internal.a.c cVar : arrayListA) {
                    if (cVar.f1066a == j && cVar.i - cVar.h <= 300000) {
                        com.tencent.tmassistantbase.util.TMLog.i(TAG, "actionId is exist,return true");
                        return true;
                    }
                }
            }
            str = TAG;
            str2 = "return false";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
        return false;
    }

    public abstract long addDownloadTaskFromAppDetail(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2);

    public abstract long addDownloadTaskFromAuthorize(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str);

    public abstract long addDownloadTaskFromTaskList(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2);

    public long addDownloadTaskFromWebview(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url = " + str);
        java.util.HashMap map = new java.util.HashMap();
        map.put("url", str);
        java.lang.String intentUriPath = formatIntentUriPath(5, map);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + intentUriPath);
        long jA = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, intentUriPath, jCurrentTimeMillis, jCurrentTimeMillis + 300000, 0, "", null);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("result = ");
        sb.append(jA);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        return jA;
    }

    public long buildAddDBData(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2, java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        java.util.Map mapParams;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2 + ",actionFlag = " + str + ",verifyType = " + str2 + ",actionType = " + i);
        if (android.text.TextUtils.isEmpty(str2)) {
            mapParams = formatMapParams(tMAssistantCallYYBParamStruct, z, z2, str3);
        } else {
            mapParams = formatMapParams(tMAssistantCallYYBParamStruct, true, true, str3);
            mapParams.put("verifytype", str2);
        }
        java.lang.String intentUriPath = formatIntentUriPath(i, mapParams);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String str4 = tMAssistantCallYYBParamStruct.cutEocdMd5;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "addDownloadTaskFromTaskList,hostPackageName=" + this.hostPackageName + "; hostVersionCode=" + this.hostVersionCode + "; hostUserIdentity=; dataItemType=0;dataItemAction=" + intentUriPath);
        long jA = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, intentUriPath, jCurrentTimeMillis, jCurrentTimeMillis + 300000, 0, str4, null);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("result = ");
        sb.append(jA);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        return jA;
    }

    protected long buildAddDBData(byte[] bArr) {
        if (bArr == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "IPCData is null,return -1");
            return -1L;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "IPCData length = " + bArr.length);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jA = this.sdkChannel.a(null, 0, null, 0, null, jCurrentTimeMillis, jCurrentTimeMillis + 300000, 1, "", bArr);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + jA);
        return jA;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    public int checkQQDownloaderInstalled() {
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mContext is null");
            throw new java.lang.Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "checkQQDownloaderInstalled start");
        android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
        int i = 0;
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null) {
                    if (this.sdkAPILevel > com.tencent.tmassistantbase.util.k.a().n()) {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "packagename not found！");
            }
        } else {
            i = 1;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + i);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    public int checkQQDownloaderInstalled(int i) throws java.lang.Exception {
        android.content.Context context = this.mContext;
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mContext is null");
            throw new java.lang.Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        int i2 = 0;
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null) {
                    int iO = com.tencent.tmassistantbase.util.k.a().o();
                    if (this.sdkAPILevel > com.tencent.tmassistantbase.util.k.a().n() || i > iO) {
                        i2 = 2;
                    }
                } else {
                    i2 = 1;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            i2 = 1;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "result = " + i2);
        return i2;
    }

    public abstract void destroyQQDownloaderOpenSDK();

    protected java.lang.String formatEncryptUrl(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url = " + str);
        java.lang.String str2 = "tmast://encrypt?encryptdata=" + java.net.URLEncoder.encode(com.tencent.tmassistantsdk.internal.openSDK.c.a(str));
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "finalPath = " + str2);
        return str2;
    }

    protected java.lang.String formatIntentUriPath(int i, java.util.Map map) {
        java.lang.String str;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "actionType = " + i + ",params = " + map);
        switch (i) {
            case 1:
                str = "download";
                break;
            case 2:
            case 3:
            default:
                str = "appdetails";
                break;
            case 4:
                str = "updatedownload";
                break;
            case 5:
                str = "webview";
                break;
        }
        java.lang.String str2 = "tpmast://" + str + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START;
        java.lang.String str3 = "";
        int i2 = 0;
        if (map != null && map.size() > 0) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                java.lang.String str4 = (java.lang.String) entry.getKey();
                java.lang.String str5 = (java.lang.String) entry.getValue();
                if (!android.text.TextUtils.isEmpty(str4) && !android.text.TextUtils.isEmpty(str5)) {
                    str3 = str3 + (i2 <= 0 ? "" : "&") + str4 + "=" + java.net.URLEncoder.encode(str5);
                }
                i2++;
            }
        }
        java.lang.String str6 = str2 + str3;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "path:" + str6);
        return formatEncryptUrl(str6);
    }

    protected java.util.Map formatMapParams(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, boolean z, boolean z2, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String oplist = formatOplist(z, z2);
        java.util.HashMap map = new java.util.HashMap();
        map.put("hostpname", this.hostPackageName);
        map.put("hostversioncode", java.lang.String.valueOf(this.hostVersionCode));
        map.put("sngappid", tMAssistantCallYYBParamStruct.SNGAppId);
        map.put("appid", tMAssistantCallYYBParamStruct.taskAppId);
        map.put("apkid", tMAssistantCallYYBParamStruct.taskApkId);
        map.put("pname", tMAssistantCallYYBParamStruct.taskPackageName);
        map.put("via", tMAssistantCallYYBParamStruct.via);
        map.put("uin", tMAssistantCallYYBParamStruct.uin);
        map.put("uintype", tMAssistantCallYYBParamStruct.uinType);
        map.put("versioncode", java.lang.String.valueOf(tMAssistantCallYYBParamStruct.taskVersion));
        map.put("oplist", oplist);
        map.put("channelid", tMAssistantCallYYBParamStruct.channelId);
        map.put("actionflag", tMAssistantCallYYBParamStruct.actionFlag);
        map.put("traceid", str);
        map.put("cutEocdMd5", tMAssistantCallYYBParamStruct.cutEocdMd5);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "mapParams = " + map);
        return map;
    }

    protected java.lang.String formatOplist(boolean z, boolean z2) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "isAutoDownload = " + z + ",isAutoInstall = " + z2);
        java.lang.String str = "";
        if (z && z2) {
            str = "1;2";
        } else if (z2) {
            str = "2";
        } else if (z) {
            str = "1";
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "oplist = " + str);
        return str;
    }

    public abstract com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo getDownloadTaskState(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct);

    public int initTMAssistantCallYYBApi(android.content.Context context) {
        try {
            com.tencent.tmassistantbase.util.k.a().d(context);
            return 0;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "initTMAssistantCallYYBApi Exception", e);
            return -1;
        }
    }

    protected void onStateChanged(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i, int i2, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "param = " + tMAssistantCallYYBParamStruct + ",state = " + i + ",errorCode = " + i2 + ",errorMsg = " + str);
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener = (com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get();
            if (iTMAssistantCallBackListener == null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMAssistantCallBackListener.OnDownloadTaskStateChanged(tMAssistantCallYYBParamStruct, i, i2, str);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean registerListener(com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        if (iTMAssistantCallBackListener == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "listener is null,return false");
            return false;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener = " + iTMAssistantCallBackListener);
        synchronized (this.mWeakListenerArrayList) {
            while (true) {
                java.lang.ref.Reference referencePoll = this.mListenerQueue.poll();
                if (referencePoll == null) {
                    break;
                }
                this.mWeakListenerArrayList.remove(referencePoll);
            }
            java.util.Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                if (((com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get()) == iTMAssistantCallBackListener) {
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener is existing,return true");
                    return true;
                }
            }
            this.mWeakListenerArrayList.add(new java.lang.ref.WeakReference(iTMAssistantCallBackListener, this.mListenerQueue));
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "create new listener,return true");
            return true;
        }
    }

    public boolean removeDownloadTask(long j) {
        if (j >= 0) {
            return this.sdkChannel.a(j);
        }
        return false;
    }

    public void startQQDownloader(android.content.Context context) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context = " + context);
        if (context != null) {
            android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
            if (context instanceof android.app.Application) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        }
    }

    public abstract void startToAuthorized(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, java.lang.String str);

    public void startToDownloadTaskList(android.content.Context context) throws java.lang.Exception {
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "context is null,return 0");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        java.lang.String str = "tmast://download?hostpname=" + this.hostPackageName + "&hostversion=" + this.hostVersionCode;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "path = " + str);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
        if (context instanceof android.app.Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public abstract void startToWebView(android.content.Context context, java.lang.String str);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean unregisterListener(com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        if (iTMAssistantCallBackListener == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "listener is null,return false");
            return false;
        }
        synchronized (this.mWeakListenerArrayList) {
            java.util.Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                if (((com.tencent.tmassistantsdk.ITMAssistantCallBackListener) ((java.lang.ref.WeakReference) it.next()).get()) == iTMAssistantCallBackListener) {
                    it.remove();
                    com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener is removed,return true");
                    return true;
                }
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "return false");
            return false;
        }
    }
}
