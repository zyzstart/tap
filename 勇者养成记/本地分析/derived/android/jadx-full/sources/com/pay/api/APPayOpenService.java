package com.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPayOpenService {
    private static com.tencent.midas.api.IAPMidasPayCallBack midasCallBack = new com.tencent.midas.api.IAPMidasPayCallBack() { // from class: com.pay.api.APPayOpenService.1
        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(com.tencent.midas.api.APMidasResponse aPMidasResponse) {
            if (com.pay.api.APPayOpenService.serviceDelegate != null) {
                com.pay.api.APPayResponseInfo aPPayResponseInfo = new com.pay.api.APPayResponseInfo();
                try {
                    com.tencent.midas.comm.APBeanUtil.copyProperties(aPMidasResponse, aPPayResponseInfo);
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.i("APPayOpenService", "midasCallBack copyProperties error:" + e.toString());
                }
                com.pay.api.APPayOpenService.serviceDelegate.PayOpenServiceCallBack(aPPayResponseInfo);
            }
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (com.pay.api.APPayOpenService.serviceDelegate != null) {
                com.pay.api.APPayOpenService.serviceDelegate.PayOpenServiceNeedLogin();
            }
        }
    };
    private static com.pay.api.IAPPayOpenServiceCallBack serviceDelegate;

    public static com.pay.api.IAPPayOpenServiceCallBack GetDelegate() {
        return serviceDelegate;
    }

    public static void LaunchOpenServiceView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, int i, java.lang.String str10) {
        com.tencent.midas.api.request.APMidasMonthRequest aPMidasMonthRequest = new com.tencent.midas.api.request.APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i;
        aPMidasMonthRequest.remark = str10;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
    }

    public static void LaunchOpenServiceView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, int i, java.lang.String str10, java.lang.String str11, boolean z, java.lang.String str12) {
        com.tencent.midas.api.request.APMidasSubscribeRequest aPMidasSubscribeRequest = new com.tencent.midas.api.request.APMidasSubscribeRequest();
        setCommParams(aPMidasSubscribeRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasSubscribeRequest.serviceCode = str8;
        aPMidasSubscribeRequest.serviceName = str9;
        aPMidasSubscribeRequest.resId = i;
        aPMidasSubscribeRequest.saveValue = str10;
        aPMidasSubscribeRequest.productId = str11;
        aPMidasSubscribeRequest.isCanChange = z;
        aPMidasSubscribeRequest.remark = str12;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasSubscribeRequest, midasCallBack);
    }

    public static void LaunchOpenServiceView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, int i, java.lang.String str10, boolean z, java.lang.String str11) {
        com.tencent.midas.api.request.APMidasMonthRequest aPMidasMonthRequest = new com.tencent.midas.api.request.APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i;
        aPMidasMonthRequest.saveValue = str10;
        aPMidasMonthRequest.isCanChange = z;
        aPMidasMonthRequest.remark = str11;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
    }

    public static void LaunchOpenServiceView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, int i, java.lang.String str10, boolean z, java.lang.String str11, boolean z2) {
        com.tencent.midas.api.request.APMidasMonthRequest aPMidasMonthRequest = new com.tencent.midas.api.request.APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i;
        aPMidasMonthRequest.remark = str11;
        aPMidasMonthRequest.autoPay = z2;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
    }

    public static void SetDelegate(com.pay.api.IAPPayOpenServiceCallBack iAPPayOpenServiceCallBack) {
        serviceDelegate = iAPPayOpenServiceCallBack;
    }

    @java.lang.Deprecated
    public static void SetNeedReloginInSDK(boolean z) {
    }

    public static void release() {
        serviceDelegate = null;
    }

    private static void setCommParams(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        aPMidasBaseRequest.offerId = com.pay.AndroidPay.singleton().offerId;
        aPMidasBaseRequest.openId = str;
        aPMidasBaseRequest.openKey = str2;
        aPMidasBaseRequest.sessionId = str3;
        aPMidasBaseRequest.sessionType = str4;
        aPMidasBaseRequest.zoneId = str5;
        aPMidasBaseRequest.pf = str6;
        aPMidasBaseRequest.pfKey = str7;
    }
}
