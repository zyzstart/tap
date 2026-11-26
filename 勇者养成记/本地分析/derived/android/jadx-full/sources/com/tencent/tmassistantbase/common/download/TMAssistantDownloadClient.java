package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMAssistantDownloadClient extends com.tencent.tmassistantbase.common.download.c {
    protected static final java.lang.String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
    protected static final java.lang.String TAG = "TMSelfUpdate_TMAssistantDownloadSDKClient";
    protected static final java.lang.String VIA = "ANDROIDSDK.DOWNLOAD";
    protected java.lang.ref.ReferenceQueue mListenerReferenceQueue;
    protected java.util.ArrayList mWeakListenerArrayList;

    public TMAssistantDownloadClient(android.content.Context context, java.lang.String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context: " + context + "; clientKey: " + str);
        this.mListenerReferenceQueue = new java.lang.ref.ReferenceQueue();
        this.mWeakListenerArrayList = new java.util.ArrayList();
        this.mServiceCallback = new com.tencent.tmassistantbase.common.download.b(this);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    public synchronized void cancelDownloadTask(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
            throw new java.lang.IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            try {
                dVar.c(this.mClientKey, str);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "cancelDownloadTask");
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "cancelDownloadTask Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "initTMAssistantDownloadSDK");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected android.content.Intent getBindServiceIntent() {
        return new android.content.Intent(this.mContext, java.lang.Class.forName(this.mDwonloadServiceName));
    }

    public synchronized com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo getDownloadTaskState(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
            throw new java.lang.IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        }
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            try {
                com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfoA = dVar.a(this.mClientKey, str);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue(taskInfo): " + tMAssistantDownloadTaskInfoA);
                return tMAssistantDownloadTaskInfoA;
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "getDownloadTaskState Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: null");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return null;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void onDownloadSDKServiceInvalid() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadSDKServiceInvalid enter");
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantbase.common.download.e.a().a(this, (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) ((java.lang.ref.WeakReference) it.next()).get());
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "onDownloadSDKServiceInvalid exit");
    }

    public synchronized void pauseDownloadTask(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
            throw new java.lang.IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            try {
                dVar.b(this.mClientKey, str);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "pauseDownloadTask");
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "pauseDownloadTask Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "initTMAssistantDownloadSDK");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean registerDownloadTaskListener(com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (iTMAssistantDownloadClientListener == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener == null");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: false");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return false;
        }
        while (true) {
            java.lang.ref.Reference referencePoll = this.mListenerReferenceQueue.poll();
            if (referencePoll == null) {
                break;
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "registerDownloadTaskListener removed listener!!!!");
            this.mWeakListenerArrayList.remove(referencePoll);
        }
        java.util.Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (((com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) ((java.lang.ref.WeakReference) it.next()).get()) == iTMAssistantDownloadClientListener) {
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                return true;
            }
        }
        this.mWeakListenerArrayList.add(new java.lang.ref.WeakReference(iTMAssistantDownloadClientListener, this.mListenerReferenceQueue));
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return true;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void registerServiceCallback() {
        ((com.tencent.tmassistantbase.aidl.d) this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistantbase.aidl.a) this.mServiceCallback);
    }

    public synchronized int startDownloadTask(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.util.Map map, android.os.Bundle bundle) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "startDownloadTask clientKey:" + this.mClientKey + ",url:" + str + "; priority: " + i + "; contentType: " + str2 + "; fileName = " + str3 + ",businessParams=" + bundle);
        if (map != null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "params.size: " + map.size());
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "params: null");
        }
        if (str == null) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
            throw new java.lang.IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
        if (str2.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS) && android.text.TextUtils.isEmpty(str3)) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "exception: if contentType is others, filename shouldn't be null!");
            throw new java.lang.IllegalArgumentException("if contentType is others, filename shouldn't be null!");
        }
        com.tencent.tmassistantbase.aidl.d dVar = (com.tencent.tmassistantbase.aidl.d) super.getServiceInterface();
        if (dVar != null) {
            if (bundle != null) {
                java.lang.String string = bundle.getString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_VIA);
                bundle.putString(com.tencent.tmassistantbase.common.download.TMAssistantDownloadConst.PARAM_VIA, "ANDROIDSDK.DOWNLOAD." + string);
            }
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "startDownloadTask");
            try {
                int iA = dVar.a(this.mClientKey, str, i, str2, str3, map, bundle);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: " + iA);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                return iA;
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "startDownloadTask Exception:", e);
            }
        } else {
            super.initTMAssistantDownloadSDK();
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "super.initTMAssistantDownloadSDK");
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: 0");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return 0;
    }

    public synchronized int startDownloadTask(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        int iStartDownloadTask;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url: " + str + "; contentType: " + str2);
        iStartDownloadTask = startDownloadTask(str, 1, str2, null, null, bundle);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("returnValue: ");
        sb.append(iStartDownloadTask);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return iStartDownloadTask;
    }

    public synchronized int startDownloadTask(java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Bundle bundle) {
        int iStartDownloadTask;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url: " + str + "; contentType: " + str2 + "; fileName: " + str3);
        iStartDownloadTask = startDownloadTask(str, 1, str2, str3, null, bundle);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("returnValue: ");
        sb.append(iStartDownloadTask);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, sb.toString());
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return iStartDownloadTask;
    }

    public synchronized int startDownloadTask(java.lang.String str, java.lang.String str2, java.util.Map map, android.os.Bundle bundle) {
        int iStartDownloadTask;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "url: " + str + "; contentType: " + str2);
        if (map != null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "params.size: " + map.size());
        } else {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "params: null");
        }
        iStartDownloadTask = startDownloadTask(str, 1, str2, null, map, bundle);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: " + iStartDownloadTask);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return iStartDownloadTask;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void stubAsInterface(android.os.IBinder iBinder) {
        this.mServiceInterface = com.tencent.tmassistantbase.aidl.e.a(iBinder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean unRegisterDownloadTaskListener(com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (iTMAssistantDownloadClientListener == null) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "listener == null");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: false");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return false;
        }
        for (java.lang.ref.WeakReference weakReference : this.mWeakListenerArrayList) {
            if (((com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) weakReference.get()) == iTMAssistantDownloadClientListener) {
                this.mWeakListenerArrayList.remove(weakReference);
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
                com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
                return true;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: false");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return false;
    }

    @Override // com.tencent.tmassistantbase.common.download.c
    protected void unRegisterServiceCallback() {
        ((com.tencent.tmassistantbase.aidl.d) this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistantbase.aidl.a) this.mServiceCallback);
    }
}
