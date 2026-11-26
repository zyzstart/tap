package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QimeiSDK {
    private static volatile com.tencent.beacon.qimei.QimeiSDK instance;
    private java.lang.String beaconId = "";
    private android.content.Context mContext;
    private com.tencent.beacon.qimei.IAsyncQimeiListener mListener;

    private QimeiSDK() {
    }

    public static com.tencent.beacon.qimei.QimeiSDK getInstance() {
        if (instance == null) {
            synchronized (com.tencent.beacon.qimei.QimeiSDK.class) {
                if (instance == null) {
                    instance = new com.tencent.beacon.qimei.QimeiSDK();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isInit() {
        if (this.mContext != null) {
            return true;
        }
        com.tencent.beacon.core.e.d.d("[qimei] QimeiSdk not init", new java.lang.Object[0]);
        return false;
    }

    public synchronized java.lang.String getAppKey() {
        return com.tencent.beacon.core.info.b.b(this.mContext).a();
    }

    @java.lang.Deprecated
    public synchronized java.lang.String getBeaconIdInfo(android.content.Context context) {
        if (com.tencent.beacon.core.e.j.b(this.beaconId)) {
            this.beaconId = com.tencent.beacon.core.BeaconIdJNI.a(context, android.os.Build.VERSION.SDK_INT);
        }
        return this.beaconId;
    }

    public synchronized com.tencent.beacon.qimei.Qimei getQimei(android.content.Context context) {
        if (!isInit() && context == null) {
            return null;
        }
        return com.tencent.beacon.qimei.a.a(context).b();
    }

    public synchronized void getQimei(com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.qimei.f(this, iAsyncQimeiListener));
    }

    public synchronized java.lang.String getQimeiByKey(android.content.Context context, java.lang.String str) {
        if (!isInit() && context == null) {
            return "";
        }
        if (com.tencent.beacon.core.e.j.b(str)) {
            return "";
        }
        java.util.Map qimeiMap = com.tencent.beacon.qimei.a.a(context).b().getQimeiMap();
        if (qimeiMap == null) {
            return "";
        }
        return (java.lang.String) qimeiMap.get(str);
    }

    @java.lang.Deprecated
    public synchronized java.lang.String getQimeiInternal(android.content.Context context) {
        if (!isInit() && context == null) {
            return "";
        }
        com.tencent.beacon.qimei.Qimei qimeiB = com.tencent.beacon.qimei.a.a(context).b();
        if (com.tencent.beacon.core.e.j.b(qimeiB.getQimeiOld())) {
            return "";
        }
        return qimeiB.getQimeiOld();
    }

    public synchronized java.lang.String getQimeiNew(android.content.Context context) {
        if (!isInit() && context == null) {
            return "";
        }
        java.lang.String qimeiNew = com.tencent.beacon.qimei.a.a(context).b().getQimeiNew();
        return !com.tencent.beacon.core.e.j.b(qimeiNew) ? qimeiNew : "";
    }

    public synchronized com.tencent.beacon.qimei.QimeiSDK init(android.content.Context context) {
        if (!isInit()) {
            this.mContext = context;
            com.tencent.beacon.qimei.e.a(context).c();
            com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener = this.mListener;
            if (iAsyncQimeiListener != null) {
                getQimei(iAsyncQimeiListener);
            }
        }
        return this;
    }

    public com.tencent.beacon.qimei.QimeiSDK setAppKey(java.lang.String str) {
        if (!com.tencent.beacon.core.e.j.b(str)) {
            com.tencent.beacon.core.info.b.b = str;
        }
        return this;
    }

    public synchronized com.tencent.beacon.qimei.QimeiSDK setLogAble(boolean z) {
        com.tencent.beacon.core.e.d.b(z);
        com.tencent.beacon.core.e.d.c(z);
        return this;
    }

    public com.tencent.beacon.qimei.QimeiSDK setOmgId(java.lang.String str) {
        if (!com.tencent.beacon.core.e.j.b(str)) {
            com.tencent.beacon.core.info.c.c = str;
        }
        return this;
    }
}
