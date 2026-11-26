package com.pay.network.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APDataReportReq extends com.pay.http.APHttpReqPost {
    public APDataReportReq() {
        java.lang.String offerId = com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId();
        if (android.text.TextUtils.isEmpty(offerId)) {
            return;
        }
        setReportUrl(java.lang.String.format(com.pay.http.APPluginUrlConf.AP_LOGREPORT_FCG, offerId), java.lang.String.format(com.pay.http.APPluginUrlConf.AP_LOGREPORT_FCG, offerId), java.lang.String.format(com.pay.http.APPluginUrlConf.AP_LOGREPORT_FCG, offerId));
    }

    public void startService(java.lang.String str) {
        if (str.equals("") || android.text.TextUtils.isEmpty(com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        this.httpParam.reqParam.clear();
        this.httpParam.reqParam.put(str, "");
        startRequest();
    }
}
