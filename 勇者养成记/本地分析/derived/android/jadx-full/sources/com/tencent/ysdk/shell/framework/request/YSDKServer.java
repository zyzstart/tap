package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKServer {
    private static final java.lang.String LOG_TAG = "YSDK_SERVER";
    private static final int MSG_REQUEST = 0;
    private static volatile com.tencent.ysdk.shell.framework.request.YSDKServer instance;
    private android.os.Handler mCallHandler;

    private YSDKServer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest(final com.tencent.ysdk.shell.framework.request.HttpRequest httpRequest) {
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.request.YSDKServer.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.framework.request.YSDKServer.this.executeRequestInExecutor(httpRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequestInExecutor(com.tencent.ysdk.shell.framework.request.HttpRequest httpRequest) {
        httpRequest.requestTime = java.lang.System.currentTimeMillis();
        java.lang.String url = httpRequest.getUrl();
        com.tencent.ysdk.shell.framework.request.BaseConnection hTTPSConnection = url.startsWith("https:") ? new com.tencent.ysdk.shell.framework.request.HTTPSConnection(url, httpRequest.getOriginHostName()) : new com.tencent.ysdk.shell.framework.request.HTTPConnection(url);
        java.lang.String strDoRequest = hTTPSConnection.doRequest(httpRequest);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "=======================================");
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, httpRequest.getClass().toString());
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, url);
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, strDoRequest);
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, java.lang.String.valueOf(hTTPSConnection.getResponseCode()));
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, hTTPSConnection.getResponseMessage());
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "=======================================");
        }
        if (hTTPSConnection.getResponseCode() == 200) {
            httpRequest.mHttpResponseHandler.onSuccess(hTTPSConnection.getResponseCode(), strDoRequest);
            return;
        }
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(strDoRequest)) {
            httpRequest.mHttpResponseHandler.onSuccess(hTTPSConnection.getResponseCode(), strDoRequest);
            return;
        }
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, httpRequest.getClass().getName());
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "responseBody is null");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(hTTPSConnection.getResponseMessage())) {
            httpRequest.mHttpResponseHandler.onFailure(hTTPSConnection.getResponseCode(), "");
        } else {
            httpRequest.mHttpResponseHandler.onFailure(hTTPSConnection.getResponseCode(), hTTPSConnection.getResponseMessage());
        }
    }

    public static com.tencent.ysdk.shell.framework.request.YSDKServer getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.request.YSDKServer.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.request.YSDKServer();
                    instance.init();
                }
            }
        }
        return instance;
    }

    public void doRequest(com.tencent.ysdk.shell.framework.request.HttpRequest httpRequest) {
        android.os.Message messageObtainMessage = this.mCallHandler.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = httpRequest;
        this.mCallHandler.sendMessage(messageObtainMessage);
    }

    public void init() {
        this.mCallHandler = new android.os.Handler(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(2)) { // from class: com.tencent.ysdk.shell.framework.request.YSDKServer.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 0) {
                    return;
                }
                if (message.obj == null || !(message.obj instanceof com.tencent.ysdk.shell.framework.request.HttpRequest)) {
                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.request.YSDKServer.LOG_TAG, message.toString());
                } else {
                    com.tencent.ysdk.shell.framework.request.YSDKServer.this.executeRequest((com.tencent.ysdk.shell.framework.request.HttpRequest) message.obj);
                }
            }
        };
    }
}
