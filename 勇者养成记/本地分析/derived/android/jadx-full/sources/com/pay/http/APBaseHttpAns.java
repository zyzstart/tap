package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APBaseHttpAns implements com.pay.http.IAPHttpAns {
    private com.pay.http.APBaseHttpReq httpClient;
    private com.pay.http.APHttpHandle httpHandler;
    public java.lang.String httpReqKey;
    private java.util.HashMap httpReqMap;
    private com.pay.http.IAPHttpAnsObserver observer;
    private final int REQUESTMAX = 1;
    public int resultCode = -1;
    public java.lang.String resultMsg = "";
    public java.lang.String errorMsg = "";
    private int requestAgainCount = 0;

    public APBaseHttpAns(com.pay.http.APHttpHandle aPHttpHandle, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver, java.util.HashMap map, java.lang.String str) {
        this.httpReqKey = "";
        this.httpHandler = aPHttpHandle;
        this.httpReqMap = map;
        this.httpReqKey = str;
        this.observer = iAPHttpAnsObserver;
        aPHttpHandle.register(str, iAPHttpAnsObserver);
    }

    private void register(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        this.httpReqMap.put(this.httpReqKey, aPBaseHttpReq);
    }

    private void sendErrorMessage() {
        android.os.Message message = new android.os.Message();
        message.what = 4;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void sendFinishMessage(byte[] bArr) {
        android.os.Message message = new android.os.Message();
        message.what = 3;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void sendStopMessage() {
        android.os.Message message = new android.os.Message();
        message.what = 5;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void unRegister() {
        this.httpReqMap.remove(this.httpReqKey);
    }

    public java.lang.String getErrorMessage() {
        return this.errorMsg;
    }

    public java.lang.String getHttpReqKey() {
        return this.httpReqKey;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public java.lang.String getResultMessage() {
        return this.resultMsg;
    }

    @Override // com.pay.http.IAPHttpAns
    public void onError(com.pay.http.APBaseHttpReq aPBaseHttpReq, int i, java.lang.String str) {
        this.errorMsg = str;
        this.resultMsg = str;
        this.resultCode = i;
        unRegister();
        onErrorAns(aPBaseHttpReq);
        sendErrorMessage();
    }

    public void onErrorAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.IAPHttpAns
    public void onFinish(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        unRegister();
        if (aPBaseHttpReq.getContent() == null) {
            this.resultCode = -1;
            this.resultMsg = "";
            sendErrorMessage();
        } else {
            this.httpClient = aPBaseHttpReq;
            onFinishAns(aPBaseHttpReq.getContent(), aPBaseHttpReq);
            sendFinishMessage(aPBaseHttpReq.getContent());
        }
    }

    public void onFinishAns(byte[] bArr, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.IAPHttpAns
    public void onReceive(byte[] bArr, int i, long j, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        onReceiveAns(bArr, i, j, aPBaseHttpReq);
    }

    public void onReceiveAns(byte[] bArr, int i, long j, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStart(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        register(aPBaseHttpReq);
        onStartAns(aPBaseHttpReq);
    }

    public void onStartAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStop(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        unRegister();
        onStopAns(aPBaseHttpReq);
        sendStopMessage();
    }

    public void onStopAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    public void reRegister() {
        this.httpHandler.register(this.httpReqKey, this.observer);
    }

    public void requestAgain() {
        int i;
        if (this.httpClient == null || (i = this.requestAgainCount) > 1) {
            reRegister();
            onError(this.httpClient, -1, "");
        } else {
            this.requestAgainCount = i + 1;
            reRegister();
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.pay.http.APBaseHttpAns.1
                @Override // java.lang.Runnable
                public void run() throws java.lang.Throwable {
                    com.pay.http.APBaseHttpAns.this.httpClient.requestAgain();
                }
            }).start();
        }
    }
}
