package com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantAuthorizedManager {
    protected static final java.lang.String CLIENT_NAME = "downloadSDKClient";
    protected static final java.lang.String TAG = "OpensdkToMsdkManager";
    protected static com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager mInstance;
    protected android.content.Context mContext;
    protected com.tencent.tmassistantsdk.internal.d.a mHttpRequest = null;
    protected com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.ITMAssistantAuthorizedListener mToMsdkListener = null;
    protected com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo mAuthorizedInfo = null;
    protected java.lang.String mDownloadUrl = null;
    protected int mSupportVersionCode = 0;
    protected int authorizedState = 0;
    protected boolean hasNotify = false;
    protected boolean isInstallFinished = false;
    protected long insertActionId = -1;
    protected com.tencent.tmassistantsdk.internal.a.b sdkChannel = null;
    protected com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a dialog = null;
    protected com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 mOpenSDK = null;
    protected android.os.HandlerThread mSubMessagehandlerThread = null;
    protected android.os.Handler mSubMessageHandler = null;
    protected android.os.Handler mMainMessageHandler = null;
    protected com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient mClient = null;
    protected com.tencent.tmassistantsdk.internal.d.b mRequestListener = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b(this);
    protected android.view.View.OnClickListener retryBtnListener = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.d(this);
    protected android.view.View.OnClickListener negativeBtnListenner = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.e(this);
    protected android.view.View.OnClickListener positiveBtnListener = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.f(this);
    protected com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener mDownloadSDKListener = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.i(this);

    private TMAssistantAuthorizedManager(android.content.Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static synchronized com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedManager(context);
        }
        return mInstance;
    }

    protected void continueDownload() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "continueDownload");
        this.mSubMessageHandler.post(new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.c(this));
    }

    protected com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient getClient() {
        android.content.Context context = this.mContext;
        if (context == null) {
            return null;
        }
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient = this.mClient;
        if (tMAssistantDownloadClient != null) {
            return tMAssistantDownloadClient;
        }
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClientA = com.tencent.tmassistantsdk.b.a(context).a(CLIENT_NAME);
        tMAssistantDownloadClientA.registerDownloadTaskListener(this.mDownloadSDKListener);
        this.mClient = tMAssistantDownloadClientA;
        return tMAssistantDownloadClientA;
    }

    public void getUserAuthorizedInfo(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo, android.content.Context context) {
        if (context != null) {
            this.mContext = context;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "getUserAuthorizedInfo method called!");
        this.hasNotify = false;
        if (this.mHttpRequest != null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "mHttpRequest != null, request didn't finish!");
            return;
        }
        if (tMAssistantAuthorizedInfo == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "AuthorizedInfo object is null!");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "authorizedInfo = " + tMAssistantAuthorizedInfo);
        this.mAuthorizedInfo = tMAssistantAuthorizedInfo;
        if (this.mHttpRequest == null) {
            this.authorizedState = 1;
            com.tencent.tmassistantsdk.internal.d.a aVar = new com.tencent.tmassistantsdk.internal.d.a();
            this.mHttpRequest = aVar;
            aVar.a(this.mRequestListener);
            this.mHttpRequest.a(tMAssistantAuthorizedInfo);
        }
    }

    protected void handleDownloadContinue(long j, long j2) {
        android.content.Context context = this.mContext;
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(context);
        java.lang.String string = this.mContext.getString(rVar.a("white_list_positive_continue"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        float f = j2;
        sb.append((int) (((100 * j) + 0.0f) / f));
        sb.append("%)");
        java.lang.String string2 = sb.toString();
        this.dialog.i.setText(string + string2);
        android.widget.ProgressBar progressBar = this.dialog.h;
        progressBar.setProgress((int) (((((float) j) + 0.0f) / f) * ((float) progressBar.getMax())));
        if (this.dialog.h.getProgress() > 0) {
            this.dialog.a(rVar.b("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void handleDownloadFailed() {
        android.content.Context context = this.mContext;
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(context);
        this.dialog.a(true);
        this.dialog.i.setText(this.mContext.getString(rVar.a("white_list_positive_retry")));
        if (this.dialog.h.getProgress() > 0) {
            this.dialog.a(rVar.b("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void handleDownloading(long j, long j2) {
        android.content.Context context = this.mContext;
        if (context == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        java.lang.String string = this.mContext.getString(new com.tencent.tmassistantbase.util.r(context).a("white_list_positive_downloading"));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        float f = j2;
        sb.append((int) (((100 * j) + 0.0f) / f));
        sb.append("%)");
        java.lang.String string2 = sb.toString();
        this.dialog.i.setText(string + string2);
        android.widget.ProgressBar progressBar = this.dialog.h;
        progressBar.setProgress((int) (((((float) j) + 0.0f) / f) * ((float) progressBar.getMax())));
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "handleDownloading : receivedlen:" + j + " | totalLen:" + j2);
    }

    protected void handleInstall(java.lang.String str, int i) {
        android.content.Context context = this.mContext;
        if (context == null) {
            return;
        }
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(context);
        this.dialog.a(true);
        this.dialog.i.setText(this.mContext.getString(rVar.a("white_list_positive_install")));
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        this.isInstallFinished = true;
        if (i == 1) {
            return;
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(str)), com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
        this.mContext.startActivity(intent);
    }

    public void initOpenSDK(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.ITMAssistantAuthorizedListener iTMAssistantAuthorizedListener) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "mListener = " + iTMAssistantAuthorizedListener);
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = com.tencent.tmassistantsdk.TMAssistantCallYYB_V1.getInstance();
        this.mOpenSDK = tMAssistantCallYYB_V1;
        tMAssistantCallYYB_V1.initTMAssistantCallYYBApi(this.mContext);
        this.mToMsdkListener = iTMAssistantAuthorizedListener;
        this.sdkChannel = new com.tencent.tmassistantsdk.internal.a.b();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("OpenSDKToMsdkManager");
        this.mSubMessagehandlerThread = handlerThread;
        handlerThread.start();
        this.mSubMessageHandler = new android.os.Handler(this.mSubMessagehandlerThread.getLooper());
        this.mMainMessageHandler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a(this));
    }

    protected boolean isExitsAction(long j) {
        java.lang.String str;
        java.lang.String str2;
        if (j < 0) {
            str = TAG;
            str2 = "actionId < 0,return false";
        } else {
            com.tencent.tmassistantsdk.internal.a.b bVar = this.sdkChannel;
            if (bVar == null) {
                str = TAG;
                str2 = "sdkChannel == null,return false";
            } else {
                for (com.tencent.tmassistantsdk.internal.a.c cVar : bVar.a()) {
                    if (cVar.f1066a == j && cVar.i - cVar.h <= 300000) {
                        com.tencent.tmassistantbase.util.TMLog.i(TAG, "isExitsAction,return true");
                        return true;
                    }
                }
                str = TAG;
                str2 = "return false";
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
        return false;
    }

    protected void notifyAuthorizedFinished(boolean z, com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.TMAssistantAuthorizedInfo tMAssistantAuthorizedInfo) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
        if (this.mToMsdkListener == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "before notifyAuthorizedFinished: mToMsdkListener = null !");
        }
        if (this.mToMsdkListener == null || this.mAuthorizedInfo == null) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "notifyAuthorizedFinished: result:" + z);
        this.mToMsdkListener.onAuthorizedFinished(z, this.mAuthorizedInfo);
        this.mHttpRequest = null;
        this.hasNotify = true;
    }

    public void onDestroy() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDestroy start");
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a aVar = this.dialog;
        if (aVar != null && aVar.isShowing()) {
            this.dialog.dismiss();
        }
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = this.mOpenSDK;
        if (tMAssistantCallYYB_V1 != null) {
            tMAssistantCallYYB_V1.destroyQQDownloaderOpenSDK();
        }
        this.mToMsdkListener = null;
        this.hasNotify = false;
        this.isInstallFinished = false;
        this.authorizedState = 0;
        this.mHttpRequest = null;
        this.mAuthorizedInfo = null;
        this.sdkChannel = null;
        this.insertActionId = -1L;
        android.content.Context context = this.mContext;
        if (context != null) {
            com.tencent.tmassistantsdk.b.b(context);
        }
        this.mClient = null;
    }

    protected void onNetworkException(int i) {
        android.content.Context context;
        java.lang.String str;
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mContext == null");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "errorCode = " + i);
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(this.mContext);
        if (1 == i) {
            context = this.mContext;
            str = "white_list_network_not_connected";
        } else {
            context = this.mContext;
            str = "white_list_network_error";
        }
        java.lang.String string = context.getString(rVar.a(str));
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c();
        cVar.f1090a = this.mContext.getString(rVar.a("white_list_dlg_title"));
        cVar.b = string;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a();
        aVar.c = 3;
        arrayList.add(aVar);
        java.lang.String string2 = this.mContext.getString(rVar.a("white_list_negtive_known"));
        aVar.f1088a = string2;
        aVar.b = string2;
        cVar.c = arrayList;
        showDialog(cVar);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "network error happened!");
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.mAuthorizedInfo);
        if (tipsInfoLogA != null) {
            tipsInfoLogA.networkErrorTipsCount++;
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        }
    }

    protected void onNetworkFinishedFailed(int i) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "errorCode = " + i);
        if (i == 606 || i == 602 || i == 601 || i == 704) {
            onServerException(i);
        } else {
            onNetworkException(i);
        }
    }

    protected void onNetworkFinishedSuccess(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.b bVar) {
        this.mDownloadUrl = bVar.d;
        this.mSupportVersionCode = bVar.e;
        this.mHttpRequest = null;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + bVar.f1089a + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
        if (bVar.f1089a == 1) {
            this.authorizedState = 2;
            com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar = bVar.b;
            if (cVar != null) {
                showDialog(cVar);
                return;
            } else {
                notifyAuthorizedFinished(true, this.mAuthorizedInfo);
                return;
            }
        }
        this.authorizedState = 3;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar2 = bVar.b;
        if (cVar2 != null) {
            showDialog(cVar2);
        } else {
            onServerException(bVar.c);
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "not in white list and no tips!");
        }
    }

    public void onResume() {
        int i;
        android.content.Context context;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onResume start");
        tryToCloseDialog();
        if (this.hasNotify || (i = this.authorizedState) == 2) {
            return;
        }
        if ((i == 3 || i == 0) && (context = this.mContext) != null) {
            getUserAuthorizedInfo(this.mAuthorizedInfo, context);
        }
    }

    protected void onServerException(int i) {
        android.content.Context context;
        java.lang.String str;
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mContext == null");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "errorCode = " + i);
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(this.mContext);
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c();
        cVar.f1090a = this.mContext.getString(rVar.a("white_list_dlg_title"));
        if (i == 602 || i == 601) {
            context = this.mContext;
            str = "white_list_network_error";
        } else {
            context = this.mContext;
            str = "white_list_server_error";
        }
        cVar.b = context.getString(rVar.a(str));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a();
        aVar.c = 4;
        java.lang.String string = this.mContext.getString(rVar.a("white_list_positive_retry_again"));
        aVar.f1088a = string;
        aVar.b = string;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar2 = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a();
        aVar2.c = 3;
        java.lang.String string2 = this.mContext.getString(rVar.a("white_list_negtive"));
        aVar2.f1088a = string2;
        aVar2.b = string2;
        arrayList.add(aVar);
        arrayList.add(aVar2);
        cVar.c = arrayList;
        showDialog(cVar);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.mAuthorizedInfo);
        if (tipsInfoLogA != null) {
            tipsInfoLogA.networkErrorTipsCount++;
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        }
    }

    protected void pauseDownloadTask(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "downloadUrl = null,return");
            return;
        }
        if (this.mAuthorizedInfo == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mAuthorizedInfo = null,return");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "downloadUrl = " + str);
        this.mSubMessageHandler.post(new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.h(this, str));
    }

    protected void showDialog(com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.c cVar) {
        java.util.ArrayList arrayList;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a aVar;
        android.view.View.OnClickListener onClickListener;
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a aVar2;
        java.lang.String string;
        if (this.mContext == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "mContext == null");
            return;
        }
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a aVar3 = this.dialog;
        if (aVar3 != null && aVar3.isShowing()) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "dialog isShowing");
            return;
        }
        android.content.Context context = this.mContext;
        if ((context instanceof android.app.Activity) && ((android.app.Activity) context).isFinishing()) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "context is finishing!  context" + this.mContext);
            return;
        }
        com.tencent.tmassistantbase.util.r rVar = new com.tencent.tmassistantbase.util.r(this.mContext);
        if (cVar == null || (arrayList = cVar.c) == null || arrayList.size() <= 0) {
            return;
        }
        com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a aVar4 = new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.a.a(this.mContext, rVar.e("while_list_dialog"), arrayList.size());
        this.dialog = aVar4;
        aVar4.show();
        this.dialog.a(cVar.f1090a);
        this.dialog.b(cVar.b);
        for (int i = 0; i < arrayList.size(); i++) {
            com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a aVar5 = (com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.b.a) arrayList.get(i);
            int i2 = aVar5.c;
            if (i2 == 3) {
                this.dialog.d(aVar5.f1088a);
                this.dialog.b(this.negativeBtnListenner);
            } else {
                if (i2 == 4) {
                    this.dialog.c(aVar5.b);
                    aVar = this.dialog;
                    onClickListener = this.retryBtnListener;
                } else {
                    try {
                        int iCheckQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                        if (iCheckQQDownloaderInstalled != 0) {
                            if (iCheckQQDownloaderInstalled == 1) {
                                aVar2 = this.dialog;
                                string = aVar5.b;
                            } else if (iCheckQQDownloaderInstalled == 2) {
                                aVar2 = this.dialog;
                                string = this.mContext.getString(rVar.a("white_list_positive_update"));
                            }
                            aVar2.c(string);
                            continueDownload();
                        } else {
                            this.dialog.c(aVar5.f1088a);
                            com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.mAuthorizedInfo);
                            if (tipsInfoLogA != null) {
                                tipsInfoLogA.authorizedTipsCount++;
                                com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    this.dialog.a(aVar5);
                    aVar = this.dialog;
                    onClickListener = this.positiveBtnListener;
                }
                aVar.a(onClickListener);
            }
        }
    }

    protected void startDownloadTask(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "downloadUrl = null,return");
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "downloadUrl = " + str + ",jumpUrl = " + str2);
        this.dialog.a(false);
        this.mSubMessageHandler.post(new com.tencent.tmassistantsdk.internal.openSDK.opensdktomsdk.g(this, str2, str));
    }

    protected void startToQQDownloaderAuthorized(java.lang.String str) {
        com.tencent.tmassistantsdk.TMAssistantCallYYB_V1 tMAssistantCallYYB_V1;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "jumpUrl = " + str);
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.tmassistantsdk.internal.protocol.jce.TipsInfoLog tipsInfoLogA = com.tencent.tmassistantsdk.internal.c.h.h().a(this.mAuthorizedInfo);
        if (tipsInfoLogA != null) {
            tipsInfoLogA.authorizedBtnClickCount++;
            com.tencent.tmassistantsdk.internal.c.h.h().a(tipsInfoLogA);
        }
        android.content.Context context = this.mContext;
        if (context == null || (tMAssistantCallYYB_V1 = this.mOpenSDK) == null) {
            return;
        }
        tMAssistantCallYYB_V1.startToAuthorized(context, str);
    }

    protected void tryToCloseDialog() {
        java.lang.String str;
        java.lang.String str2;
        if (this.mOpenSDK == null) {
            str = TAG;
            str2 = "mOpenSDK == null,return";
        } else {
            if (this.mContext != null) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "tryToCloseDialog");
                try {
                    int iCheckQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                    if (this.isInstallFinished && iCheckQQDownloaderInstalled == 0) {
                        this.mHttpRequest = null;
                        this.isInstallFinished = false;
                        this.mDownloadUrl = null;
                        if (this.dialog.isShowing()) {
                            this.dialog.dismiss();
                        }
                        com.tencent.tmassistantsdk.b.b(this.mContext);
                        this.mClient = null;
                        if (isExitsAction(this.insertActionId)) {
                            this.mOpenSDK.startQQDownloader(this.mContext);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            str = TAG;
            str2 = "mContext == null,return";
        }
        com.tencent.tmassistantbase.util.TMLog.e(str, str2);
    }
}
