package com.tencent.ysdk.shell.module.sandbox.pipe;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PipeSender implements android.content.ServiceConnection {
    private static final java.lang.String TAG = "pipe_sandbox";
    private static com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender sInstance;
    private java.util.List<android.util.Pair<java.lang.Integer, java.util.Map>> mEventCache = new java.util.ArrayList();
    private boolean mHasBind = false;
    private com.tencent.pipe.IPipeInterface mPipeInterface;

    private void bindService(android.content.Context context) {
        com.tencent.ysdk.libware.file.Logger.d(TAG, "request bind pipe service");
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.tencent.ysdk.framework.communicate.PipeService");
        intent.setPackage("com.tencent.android.qqdownloader");
        context.bindService(intent, getInstance(), 1);
    }

    public static com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender getInstance() {
        if (sInstance == null) {
            sInstance = new com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender();
        }
        return sInstance;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.tencent.ysdk.libware.file.Logger.d(TAG, "pipe service has connected");
        this.mHasBind = true;
        this.mPipeInterface = com.tencent.pipe.IPipeInterface.Stub.asInterface(iBinder);
        if (this.mEventCache.isEmpty() || this.mPipeInterface == null) {
            return;
        }
        java.util.Iterator<android.util.Pair<java.lang.Integer, java.util.Map>> it = this.mEventCache.iterator();
        while (it.hasNext()) {
            android.util.Pair<java.lang.Integer, java.util.Map> next = it.next();
            sendIPCEvent(((java.lang.Integer) next.first).intValue(), (java.util.Map) next.second);
            it.remove();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        this.mPipeInterface = null;
        this.mHasBind = false;
    }

    public void sendIPCEvent(int i, java.util.Map map) {
        if (map == null) {
            try {
                map = new java.util.HashMap();
            } catch (android.os.RemoteException e) {
                com.tencent.ysdk.libware.file.Logger.e(TAG, e);
                return;
            }
        }
        if (this.mPipeInterface != null) {
            this.mPipeInterface.sendEvent(i, map);
            com.tencent.ysdk.libware.file.Logger.d(TAG, "event : " + i + " has send");
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d(TAG, "service not connect");
        if (!this.mHasBind) {
            bindService(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        }
        if (this.mEventCache.add(new android.util.Pair<>(java.lang.Integer.valueOf(i), map))) {
            com.tencent.ysdk.libware.file.Logger.d(TAG, "event:" + i + " has cached");
        }
    }
}
