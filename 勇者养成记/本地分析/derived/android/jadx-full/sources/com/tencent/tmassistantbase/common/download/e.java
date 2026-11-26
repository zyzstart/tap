package com.tencent.tmassistantbase.common.download;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantbase.common.download.e f1022a;
    protected static android.os.HandlerThread b;

    private e(android.os.Looper looper) {
        super(looper);
    }

    public static synchronized com.tencent.tmassistantbase.common.download.e a() {
        if (f1022a == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("TMAssistantDownloadSDKMessageThread");
            b = handlerThread;
            handlerThread.start();
            f1022a = new com.tencent.tmassistantbase.common.download.e(b.getLooper());
        }
        return f1022a;
    }

    public void a(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        if (iTMAssistantDownloadClientListener == null || tMAssistantDownloadClient == null) {
            return;
        }
        android.os.Message messageObtainMessage = a().obtainMessage();
        messageObtainMessage.what = 3;
        messageObtainMessage.obj = new com.tencent.tmassistantbase.util.o(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
        messageObtainMessage.sendToTarget();
    }

    public void a(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener, java.lang.String str, int i, int i2, java.lang.String str2) {
        if (iTMAssistantDownloadClientListener == null || tMAssistantDownloadClient == null) {
            return;
        }
        android.os.Message messageObtainMessage = a().obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = new com.tencent.tmassistantbase.util.o(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("url", str);
        bundle.putInt("state", i);
        bundle.putInt(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, i2);
        bundle.putString("errorMsg", str2);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public void a(com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient, com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener, java.lang.String str, long j, long j2) {
        if (iTMAssistantDownloadClientListener == null || tMAssistantDownloadClient == null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMAssistantDownloadSDKMessageThread", "listenr:" + iTMAssistantDownloadClientListener + " === sdkClient" + tMAssistantDownloadClient);
            return;
        }
        android.os.Message messageObtainMessage = a().obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = new com.tencent.tmassistantbase.util.o(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("url", str);
        bundle.putLong("receiveDataLen", j);
        bundle.putLong("totalDataLen", j2);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public void a(byte[] bArr, java.util.ArrayList arrayList) {
        if (bArr == null || arrayList == null) {
            return;
        }
        android.os.Message messageObtainMessage = a().obtainMessage();
        messageObtainMessage.what = 4;
        messageObtainMessage.obj = new com.tencent.tmassistantbase.util.o(bArr, arrayList);
        messageObtainMessage.sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 1) {
            com.tencent.tmassistantbase.util.o oVar = (com.tencent.tmassistantbase.util.o) message.obj;
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient = (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient) oVar.f1058a;
            com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener = (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) oVar.b;
            android.os.Bundle data = message.getData();
            java.lang.String string = data.getString("url");
            int i2 = data.getInt("state");
            int i3 = data.getInt(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE);
            java.lang.String string2 = data.getString("errorMsg");
            if (iTMAssistantDownloadClientListener != null) {
                iTMAssistantDownloadClientListener.OnDownloadSDKTaskStateChanged(tMAssistantDownloadClient, string, i2, i3, string2);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            com.tencent.tmassistantbase.util.o oVar2 = (com.tencent.tmassistantbase.util.o) message.obj;
            com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient2 = (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient) oVar2.f1058a;
            com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener2 = (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) oVar2.b;
            if (iTMAssistantDownloadClientListener2 != null) {
                iTMAssistantDownloadClientListener2.OnDwonloadSDKServiceInvalid(tMAssistantDownloadClient2);
                return;
            }
            return;
        }
        com.tencent.tmassistantbase.util.o oVar3 = (com.tencent.tmassistantbase.util.o) message.obj;
        com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient tMAssistantDownloadClient3 = (com.tencent.tmassistantbase.common.download.TMAssistantDownloadClient) oVar3.f1058a;
        com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener3 = (com.tencent.tmassistantbase.common.download.ITMAssistantDownloadClientListener) oVar3.b;
        android.os.Bundle data2 = message.getData();
        java.lang.String string3 = data2.getString("url");
        long j = data2.getLong("receiveDataLen");
        long j2 = data2.getLong("totalDataLen");
        if (iTMAssistantDownloadClientListener3 != null) {
            iTMAssistantDownloadClientListener3.OnDownloadSDKTaskProgressChanged(tMAssistantDownloadClient3, string3, j, j2);
        }
    }
}
