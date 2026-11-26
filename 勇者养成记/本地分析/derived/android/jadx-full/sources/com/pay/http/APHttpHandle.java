package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APHttpHandle extends android.os.Handler {
    private static com.pay.http.APHttpHandle handle;
    private static byte[] lock = new byte[0];
    private java.util.HashMap observerMap = new java.util.HashMap();

    private APHttpHandle() {
    }

    public static com.pay.http.APHttpHandle getIntanceHandel() {
        synchronized (lock) {
            if (handle == null) {
                try {
                    if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread() && android.os.Looper.myLooper() == null) {
                        android.os.Looper.prepare();
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.i("APHttpHandle", e.toString());
                }
                handle = new com.pay.http.APHttpHandle();
            }
        }
        return handle;
    }

    private void runObserverOnMainThread(android.os.Message message) {
        try {
            int i = message.what;
            com.pay.http.APBaseHttpAns aPBaseHttpAns = (com.pay.http.APBaseHttpAns) message.obj;
            java.lang.String httpReqKey = aPBaseHttpAns.getHttpReqKey();
            com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver = (com.pay.http.IAPHttpAnsObserver) this.observerMap.get(httpReqKey);
            if (iAPHttpAnsObserver == null) {
                android.util.Log.i("HttpHandler", "observer is null");
                return;
            }
            unregister(httpReqKey);
            if (i == 3) {
                iAPHttpAnsObserver.onFinish(aPBaseHttpAns);
            } else if (i == 4) {
                iAPHttpAnsObserver.onError(aPBaseHttpAns);
            } else {
                if (i != 5) {
                    return;
                }
                iAPHttpAnsObserver.onStop(aPBaseHttpAns);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        runObserverOnMainThread(message);
    }

    public void register(java.lang.String str, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver) {
        java.util.HashMap map = this.observerMap;
        if (map != null) {
            map.put(str, iAPHttpAnsObserver);
        }
    }

    public void release() {
        handle = null;
    }

    public void unregister(java.lang.String str) {
        java.util.HashMap map = this.observerMap;
        if (map != null) {
            map.remove(str);
        }
    }
}
