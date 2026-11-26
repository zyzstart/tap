package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {
    private static com.tencent.tmselfupdatesdk.g d;
    private com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient f;
    private android.content.Context g;
    private java.lang.String h = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f1165a = "";
    protected java.lang.String b = "";
    private java.lang.String i = "";
    protected java.lang.String c = "";
    private boolean j = true;
    private boolean k = false;
    private com.tencent.tmassistantbase.common.c n = new com.tencent.tmselfupdatesdk.h(this);
    private com.tencent.tmassistantsdk.ITMAssistantCallBackListener o = new com.tencent.tmselfupdatesdk.j(this);
    private com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener p = new com.tencent.tmselfupdatesdk.n(this);
    private java.lang.ref.ReferenceQueue l = new java.lang.ref.ReferenceQueue();
    private java.util.ArrayList m = new java.util.ArrayList();
    private android.os.Handler e = new android.os.Handler(com.tencent.tmassistantbase.util.l.a().getLooper());

    private g() {
    }

    private int a(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i) {
        com.tencent.tmselfupdatesdk.p.a(3, 202, 0);
        tMAssistantCallYYBParamStruct.via = this.c;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "param: (param.SNGAppId = " + tMAssistantCallYYBParamStruct.SNGAppId + "; param.taskPackageName = " + tMAssistantCallYYBParamStruct.taskPackageName + "; param.channelId = " + tMAssistantCallYYBParamStruct.channelId + "; param.via = " + tMAssistantCallYYBParamStruct.via + ")");
        a(this.g, tMAssistantCallYYBParamStruct, i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("returnValue: ");
        sb.append(0);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", sb.toString());
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
        return 0;
    }

    public static synchronized com.tencent.tmselfupdatesdk.g a() {
        if (d == null) {
            d = new com.tencent.tmselfupdatesdk.g();
        }
        return d;
    }

    private void a(int i, int i2) {
        int i3;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "<reportUpdateState>,state = " + i + ",errorCode = " + i2);
        int i4 = 6;
        if (i == 100) {
            i2 = 0;
            i4 = 4;
            i3 = com.tencent.pipe.IPipeInterface.EVENT_PAY_IS_LOGIN;
        } else if (i != 102) {
            switch (i) {
                case 4:
                    if (!l()) {
                        i4 = 4;
                        i3 = 303;
                    } else {
                        i4 = 4;
                        i3 = 302;
                    }
                    break;
                case 5:
                case 6:
                    i3 = !l() ? com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR : 402;
                    break;
                default:
                    i4 = -1;
                    i3 = -1;
                    break;
            }
        } else {
            i3 = 401;
        }
        if (-1 != i4) {
            com.tencent.tmselfupdatesdk.p.a(i4, i3, i2);
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "<reportUpdateState>,state = " + i + " is not report state,return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
        long j;
        long j2;
        int i;
        java.util.Iterator it = this.m.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "listener == null");
            } else {
                if (tMAssistantDownloadTaskInfo != null) {
                    i = tMAssistantDownloadTaskInfo.mState;
                    j = tMAssistantDownloadTaskInfo.mReceiveDataLen;
                    j2 = tMAssistantDownloadTaskInfo.mTotalDataLen;
                } else {
                    j = -1;
                    j2 = -1;
                    i = -1;
                }
                if (obj instanceof com.tencent.tmselfupdatesdk.YYBDownloadListener) {
                    ((com.tencent.tmselfupdatesdk.YYBDownloadListener) obj).onCheckDownloadYYBState(this.h, i, j, j2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i, int i2, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "state: " + i + "; errorCode: " + i2 + "; errorMsg: " + str2);
        java.util.Iterator it = this.m.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "listener == null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.YYBDownloadListener) {
                ((com.tencent.tmselfupdatesdk.YYBDownloadListener) obj).onDownloadYYBStateChanged(str, i, i2, str2);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    private com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct j() {
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct();
        tMAssistantCallYYBParamStruct.SNGAppId = "1234";
        tMAssistantCallYYBParamStruct.taskPackageName = this.g.getPackageName();
        tMAssistantCallYYBParamStruct.channelId = this.i;
        return tMAssistantCallYYBParamStruct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo downloadTaskState;
        try {
            downloadTaskState = h().getDownloadTaskState(this.h);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            downloadTaskState = null;
        }
        if (downloadTaskState != null) {
            java.lang.String str = downloadTaskState.mSavePath;
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "yyb apk has yet exists：url:" + this.h + ";  yybpath:" + str);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            if ("com.tencent.android.qqdownloader".equals(com.tencent.tmassistantbase.util.a.b(this.g, str))) {
                com.tencent.tmselfupdatesdk.p.a(9, java.lang.String.valueOf(109), "com.tencent.android.qqdownloader");
                com.tencent.tmassistantbase.util.a.a(this.g, str);
            }
            this.k = true;
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "isFromStartUpdate;startUpdate():" + this.k);
        }
    }

    private boolean l() {
        return com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled() == 0;
    }

    private void m() {
        com.tencent.tmselfupdatesdk.p.a(3, 203, 0);
    }

    public int a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.g = context;
        this.c = str;
        this.b = str3;
        this.h = "http://www.myapp.com/downcenter/a/50801?[REDACTED]" + this.b;
        this.i = str2;
        com.tencent.tmassistantbase.common.PackageInstallReceiver.a().a(this.n);
        com.tencent.tmassistantbase.common.PackageInstallReceiver.a().a(this.g);
        int iInitTMAssistantCallYYBApi = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().initTMAssistantCallYYBApi(this.g);
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().registerListener(this.o);
        return iInitTMAssistantCallYYBApi;
    }

    public int a(java.lang.String str, java.lang.String str2, com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        try {
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdate_SaveUpdateManager", "downloadNormalFile. url=" + str + ". filename=" + str2);
            return a(iTMAssistantDownloadClientListener).startDownloadTask(str, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS, str2, new android.os.Bundle());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return com.tencent.safecloud.device.openlib.DeviceConfig.ERR_CONNECT;
        }
    }

    public com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient a(com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "getPatchClient enter");
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient downloadSDKClient = com.tencent.tmdownloader.TMAssistantDownloadManager.getInstance(this.g).getDownloadSDKClient("patch_download_client");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "getPatchClient. client name:patch_download_client");
        if (downloadSDKClient != null && iTMAssistantDownloadClientListener != null) {
            downloadSDKClient.registerDownloadTaskListener(iTMAssistantDownloadClientListener);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "getPatchClient returnValue(client): " + downloadSDKClient);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "getPatchClient exit");
        return downloadSDKClient;
    }

    void a(int i, int i2, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "onAppStateChanged state: " + i + "; errorCode: " + i2 + "; errorMsg: " + str);
        java.util.Iterator it = this.m.iterator();
        while (it.hasNext()) {
            java.lang.Object obj = ((java.lang.ref.WeakReference) it.next()).get();
            if (obj == null) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "listener == null");
            } else if (obj instanceof com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) {
                ((com.tencent.tmselfupdatesdk.ITMSelfUpdateListener) obj).onDownloadAppStateChanged(i, i2, str);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "test0629 state = " + i + ", 100:success, 102:failture");
        a(i, i2);
    }

    public void a(android.content.Context context, com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "checkQQDownloaderInstalled: " + i);
        if (tMAssistantCallYYBParamStruct != null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "param: (param.SNGAppId = " + tMAssistantCallYYBParamStruct.SNGAppId + "; param.taskPackageName = " + tMAssistantCallYYBParamStruct.taskPackageName + "; param.channelId = " + tMAssistantCallYYBParamStruct.channelId + "; param.via = " + tMAssistantCallYYBParamStruct.via + ")");
            tMAssistantCallYYBParamStruct.cutEocdMd5 = this.f1165a;
        }
        if (i == 0) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "param: (param.SNGAppId = " + tMAssistantCallYYBParamStruct.SNGAppId + "; param.taskPackageName = " + tMAssistantCallYYBParamStruct.taskPackageName + "; param.channelId = " + tMAssistantCallYYBParamStruct.channelId + "; param.via = " + tMAssistantCallYYBParamStruct.via + "),startToAppDetail");
            com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().startToAppDetail(context, tMAssistantCallYYBParamStruct, true, true);
        } else {
            com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().addDownloadTaskFromAppDetail(tMAssistantCallYYBParamStruct, true, true);
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
    }

    public void a(java.lang.String str) {
        this.f1165a = str;
    }

    public void a(boolean z) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "startPreDownloadYYB enter");
        this.e.post(new com.tencent.tmselfupdatesdk.k(this, z));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "startPreDownloadYYB exit");
    }

    public boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        while (true) {
            java.lang.ref.Reference referencePoll = this.l.poll();
            if (referencePoll == null) {
                break;
            }
            this.m.remove(referencePoll);
        }
        java.util.Iterator it = this.m.iterator();
        while (it.hasNext()) {
            if (((java.lang.ref.WeakReference) it.next()).get() == obj) {
                return true;
            }
        }
        this.m.add(new java.lang.ref.WeakReference(obj, this.l));
        return true;
    }

    public void b() {
        this.m.clear();
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().unregisterListener(this.o);
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().destroyQQDownloaderOpenSDK();
    }

    public void c() {
        com.tencent.tmselfupdatesdk.p.a(24, java.lang.String.valueOf(108));
        this.e.post(new com.tencent.tmselfupdatesdk.l(this));
    }

    public void d() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "startYYBInstallIfDownloaded enter");
        this.e.post(new com.tencent.tmselfupdatesdk.m(this));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "startYYBInstallIfDownloaded exit");
    }

    public int e() throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        if (this.g == null) {
            com.tencent.tmassistantbase.util.TMLog.e("TMSelfUpdate_SaveUpdateManager", "exception: you must input an application context!");
            throw new java.lang.Exception("you must input an application or activity context!");
        }
        com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStructJ = j();
        int iF = f();
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "checkYYBInstalled flag:" + iF);
        if (iF == 0) {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_jump_yyb_update", "0");
            a(tMAssistantCallYYBParamStructJ, iF);
        } else {
            com.tencent.tmassistantbase.c.a.a.a().a("b_self_update_sdk_jump_yyb_update", "1");
            m();
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "yyb  uninstall! param: (param.SNGAppId = " + tMAssistantCallYYBParamStructJ.SNGAppId + "; param.taskPackageName = " + tMAssistantCallYYBParamStructJ.taskPackageName + "; param.channelId = " + tMAssistantCallYYBParamStructJ.channelId + "; param.via = " + tMAssistantCallYYBParamStructJ.via + ")");
            a(this.g, tMAssistantCallYYBParamStructJ, iF);
            a().a(true);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
        }
        return 0;
    }

    public int f() {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        int iCheckQQDownloaderInstalled = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance().checkQQDownloaderInstalled();
        if (iCheckQQDownloaderInstalled == 0) {
            str = "TMSelfUpdate_SaveUpdateManager";
            str2 = "yybExist: UpdateLogConst.YYB_INSTALLED";
        } else {
            str = "TMSelfUpdate_SaveUpdateManager";
            str2 = "yybExist: UpdateLogConst.YYB_NOT_INSTALL";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "returnValue: " + iCheckQQDownloaderInstalled);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
        return iCheckQQDownloaderInstalled;
    }

    public void g() {
        java.util.ArrayList arrayList = this.m;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient h() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "enter");
        if (this.f == null) {
            this.f = com.tencent.tmdownloader.TMAssistantDownloadManager.getInstance(com.tencent.tmassistantbase.util.k.a().b()).getDownloadSDKClient("selfUpdateSDK_client_yybupdate");
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "get selfUpdateSDK_client_yybupdate");
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient = this.f;
            if (tMAssistantDownloadClient != null) {
                tMAssistantDownloadClient.registerDownloadTaskListener(this.p);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "returnValue(client): " + this.f);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "exit");
        return this.f;
    }

    public void i() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "checkYYBDownloaded enter");
        this.e.post(new com.tencent.tmselfupdatesdk.o(this));
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_SaveUpdateManager", "checkYYBDownloaded exit");
    }
}
