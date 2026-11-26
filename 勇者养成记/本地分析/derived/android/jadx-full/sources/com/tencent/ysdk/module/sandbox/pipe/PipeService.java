package com.tencent.ysdk.module.sandbox.pipe;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PipeService extends android.app.Service {
    private static final java.lang.String TAG = "pipe_plugin";
    com.tencent.pipe.IPipeInterface.Stub mStub = new com.tencent.pipe.IPipeInterface.Stub() { // from class: com.tencent.ysdk.module.sandbox.pipe.PipeService.1
        @Override // com.tencent.pipe.IPipeInterface
        public java.util.Map sendEvent(int i, java.util.Map map) {
            return com.tencent.ysdk.innerapi.DynamicInnerApi.pipeEventDispatchEvent(i, map);
        }
    };

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.mStub;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.tencent.ysdk.libware.file.Logger.d(TAG, "PipeService onCreate");
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.tencent.ysdk.libware.file.Logger.d(TAG, "PipeService onStartCommand");
        return super.onStartCommand(intent, i, i2);
    }
}
