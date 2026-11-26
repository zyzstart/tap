package com.pay.network.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APDataReportAns extends com.pay.http.APBaseHttpAns {
    public APDataReportAns(com.pay.http.APHttpHandle aPHttpHandle, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver, java.util.HashMap map, java.lang.String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, map, str);
    }

    private void progressJson(byte[] bArr, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        com.tencent.midas.comm.APLog.i("MidasPlugin.jar APDataReportAns", "report ok");
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        progressJson(bArr, aPBaseHttpReq);
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i, long j, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }
}
