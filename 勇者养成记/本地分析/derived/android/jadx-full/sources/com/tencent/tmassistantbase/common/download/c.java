package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class c implements android.content.ServiceConnection {
    public static final java.lang.String CONNTECTSTATE_CONNECTING = "CONNECTING";
    public static final java.lang.String CONNTECTSTATE_FINISH = "FINISH";
    public static final java.lang.String CONNTECTSTATE_INIT = "INIT";
    protected static final java.lang.String TAG = "TMAssistantDownloadClientBase";
    public java.lang.String mClientKey;
    protected android.content.Context mContext;
    protected java.lang.String mDwonloadServiceName;
    protected java.lang.String connectState = CONNTECTSTATE_INIT;
    protected android.os.IInterface mServiceInterface = null;
    protected android.os.IInterface mServiceCallback = null;
    protected final java.lang.Object mThreadlock = new java.lang.Object();

    public c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.mDwonloadServiceName = null;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "context: " + context + "; clientKey: " + str + "; downloadServiceName: " + str2);
        this.mContext = context;
        this.mClientKey = str;
        this.mDwonloadServiceName = str2;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    protected abstract android.content.Intent getBindServiceIntent();

    protected android.os.IInterface getServiceInterface() throws java.lang.Exception {
        android.content.Context context = this.mContext;
        if (context != null && context.getMainLooper().getThread().getId() == java.lang.Thread.currentThread().getId()) {
            com.tencent.tmassistantbase.util.TMLog.e(TAG, "TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
            throw new java.lang.Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
        }
        if (this.mServiceInterface == null) {
            initTMAssistantDownloadSDK();
            this.connectState = CONNTECTSTATE_CONNECTING;
            synchronized (this.mThreadlock) {
                this.mThreadlock.wait(10000L);
            }
        }
        android.os.IInterface iInterface = this.mServiceInterface;
        if (iInterface != null) {
            return iInterface;
        }
        com.tencent.tmassistantbase.util.TMLog.e(TAG, "TMAssistantDownloadSDKClient ServiceInterface is null");
        throw new java.lang.Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
    }

    public synchronized boolean initTMAssistantDownloadSDK() {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        if (this.connectState == CONNTECTSTATE_FINISH) {
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return true;
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + java.lang.Thread.currentThread().getId());
        this.connectState = CONNTECTSTATE_INIT;
        if (this.mServiceInterface != null) {
            this.connectState = CONNTECTSTATE_FINISH;
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: true");
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
            return true;
        }
        boolean zBindService = false;
        if (this.mContext != null && this.mDwonloadServiceName != null) {
            try {
                zBindService = this.mContext.bindService(getBindServiceIntent(), this, 1);
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "Exception: ", e);
                android.util.Log.w(TAG, "test1220 Exception: ", e);
                e.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "returnValue: " + zBindService);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        return zBindService;
    }

    protected abstract void onDownloadSDKServiceInvalid();

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "ComponentName:" + componentName + "; IBinder:" + iBinder);
        stubAsInterface(iBinder);
        this.connectState = CONNTECTSTATE_FINISH;
        synchronized (this.mThreadlock) {
            this.mThreadlock.notifyAll();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + iBinder + ",threadId:" + java.lang.Thread.currentThread().getId());
        try {
            if (this.mServiceInterface != null && this.mServiceCallback != null) {
                registerServiceCallback();
            }
            iBinder.linkToDeath(new com.tencent.tmassistantbase.common.download.d(this), 0);
        } catch (android.os.RemoteException e) {
            com.tencent.tmassistantbase.util.TMLog.w(TAG, "exception:", e);
            onDownloadSDKServiceInvalid();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "ComponentName:" + componentName);
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey);
        synchronized (this) {
            this.mServiceInterface = null;
            this.connectState = CONNTECTSTATE_INIT;
            synchronized (this.mThreadlock) {
                this.mThreadlock.notifyAll();
            }
            onDownloadSDKServiceInvalid();
        }
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
    }

    protected abstract void registerServiceCallback();

    protected abstract void stubAsInterface(android.os.IBinder iBinder);

    public synchronized void unInitTMAssistantDownloadSDK() {
        android.content.Context context;
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "enter");
        com.tencent.tmassistantbase.util.TMLog.i(TAG, "clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + java.lang.Thread.currentThread().getId());
        if (this.mServiceInterface == null || this.mServiceCallback == null) {
            context = this.mContext;
            if (context != null && this.mServiceInterface != null) {
                context.unbindService(this);
            }
            this.mServiceInterface = null;
            this.mServiceCallback = null;
            this.connectState = CONNTECTSTATE_INIT;
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        } else {
            try {
                unRegisterServiceCallback();
            } catch (android.os.RemoteException e) {
                com.tencent.tmassistantbase.util.TMLog.w(TAG, "Exception: ", e);
            }
            context = this.mContext;
            if (context != null) {
                context.unbindService(this);
            }
            this.mServiceInterface = null;
            this.mServiceCallback = null;
            this.connectState = CONNTECTSTATE_INIT;
            com.tencent.tmassistantbase.util.TMLog.i(TAG, "exit");
        }
        throw th;
    }

    protected abstract void unRegisterServiceCallback();
}
