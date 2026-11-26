package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.ref.WeakReference f1047a;

    public e(com.tencent.tmassistantbase.network.NetworkMonitorReceiver networkMonitorReceiver) {
        this.f1047a = new java.lang.ref.WeakReference(networkMonitorReceiver);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver networkMonitorReceiver = (com.tencent.tmassistantbase.network.NetworkMonitorReceiver) this.f1047a.get();
        if (message.what != 67 || networkMonitorReceiver == null) {
            return;
        }
        networkMonitorReceiver.d();
    }
}
