package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QimeiSDK implements com.tencent.ydkbeacon.a.a.d {
    public static final java.lang.String TAG = "[Qimei]";
    private static volatile com.tencent.ydkbeacon.qimei.QimeiSDK instance;
    private java.lang.String appKey;
    private android.content.Context mContext;
    private java.lang.String beaconId = "";
    private final java.util.List qimeiListeners = java.util.Collections.synchronizedList(new java.util.ArrayList(3));
    private java.lang.String omgID = "";
    private java.lang.String oaID = "";

    private QimeiSDK() {
    }

    public static com.tencent.ydkbeacon.qimei.QimeiSDK getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ydkbeacon.qimei.QimeiSDK.class) {
                if (instance == null) {
                    instance = new com.tencent.ydkbeacon.qimei.QimeiSDK();
                }
            }
        }
        return instance;
    }

    private synchronized boolean isInit() {
        if (this.mContext != null) {
            return true;
        }
        com.tencent.ydkbeacon.a.e.c.d("[qimei] QimeiSdk not init", new java.lang.Object[0]);
        return false;
    }

    private boolean isUpdateQimei() {
        if (com.tencent.ydkbeacon.qimei.f.b()) {
            return false;
        }
        com.tencent.ydkbeacon.qimei.Qimei qimei = getQimei();
        return qimei == null || qimei.isEmpty() || com.tencent.ydkbeacon.qimei.f.a() || com.tencent.ydkbeacon.qimei.f.c() || com.tencent.ydkbeacon.a.c.b.h();
    }

    public synchronized java.lang.String getAppKey() {
        return this.appKey;
    }

    @java.lang.Deprecated
    public synchronized java.lang.String getBeaconIdInfo() {
        if (android.text.TextUtils.isEmpty(this.beaconId)) {
            this.beaconId = com.tencent.ydkbeacon.b.a.a(android.os.Build.VERSION.SDK_INT);
        }
        return this.beaconId;
    }

    public synchronized android.content.Context getContext() {
        return this.mContext;
    }

    @java.lang.Deprecated
    public java.lang.String getOAID() {
        return "";
    }

    public java.lang.String getOmgID() {
        return this.omgID;
    }

    public com.tencent.ydkbeacon.qimei.Qimei getQimei() {
        if (isInit() || com.tencent.ydkbeacon.a.c.c.d().c() != null) {
            return com.tencent.ydkbeacon.qimei.a.a().b();
        }
        return null;
    }

    public synchronized void getQimei(com.tencent.ydkbeacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.qimei.d(this, iAsyncQimeiListener));
    }

    @java.lang.Deprecated
    public synchronized java.lang.String getQimeiInternal() {
        if (!isInit()) {
            return "";
        }
        com.tencent.ydkbeacon.qimei.Qimei qimeiB = com.tencent.ydkbeacon.qimei.a.a().b();
        if (android.text.TextUtils.isEmpty(qimeiB.getQimeiOld())) {
            return "";
        }
        return qimeiB.getQimeiOld();
    }

    public synchronized com.tencent.ydkbeacon.qimei.QimeiSDK init(android.content.Context context) {
        if (!isInit()) {
            com.tencent.ydkbeacon.a.e.c.a(TAG, "QimeiSDK init!", new java.lang.Object[0]);
            this.mContext = context;
            com.tencent.ydkbeacon.a.a.b.a().a(1, this);
            boolean zIsUpdateQimei = isUpdateQimei();
            com.tencent.ydkbeacon.a.e.c.a(TAG, "isUpdate Qimei: %s", java.lang.Boolean.valueOf(zIsUpdateQimei));
            if (zIsUpdateQimei) {
                com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.qimei.c(context));
            }
        }
        return this;
    }

    public void logQimeiCallbackError(java.lang.Throwable th) {
        com.tencent.ydkbeacon.a.e.c.b("[qimei] onQimeiDispatch error!", th.getMessage());
        com.tencent.ydkbeacon.a.e.c.a(th);
        com.tencent.ydkbeacon.a.b.d.b().a("514", "QimeiDispatch error", th);
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    @android.support.annotation.WorkerThread
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        if (cVar.f1177a == 1) {
            synchronized (this.qimeiListeners) {
                try {
                    com.tencent.ydkbeacon.qimei.Qimei qimeiB = com.tencent.ydkbeacon.qimei.a.a().b();
                    if (qimeiB == null || !qimeiB.isEmpty()) {
                        java.util.Iterator it = this.qimeiListeners.iterator();
                        while (it.hasNext()) {
                            try {
                                ((com.tencent.ydkbeacon.qimei.IAsyncQimeiListener) it.next()).onQimeiDispatch(qimeiB);
                            } catch (java.lang.Throwable th) {
                                logQimeiCallbackError(th);
                            }
                        }
                        this.qimeiListeners.clear();
                    }
                } catch (java.lang.Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public com.tencent.ydkbeacon.qimei.QimeiSDK setAppKey(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.appKey = str;
        }
        return this;
    }

    public synchronized com.tencent.ydkbeacon.qimei.QimeiSDK setLogAble(boolean z) {
        com.tencent.ydkbeacon.a.e.c.a(z);
        com.tencent.ydkbeacon.a.e.c.b(z);
        return this;
    }

    @java.lang.Deprecated
    public void setOAID(java.lang.String str) {
    }

    public com.tencent.ydkbeacon.qimei.QimeiSDK setOmgId(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.omgID = str;
        }
        return this;
    }
}
