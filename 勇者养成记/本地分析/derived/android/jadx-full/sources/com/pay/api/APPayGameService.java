package com.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPayGameService {
    public static final java.lang.String ACCOUNT_TYPE_COMMON = "common";
    public static final java.lang.String ACCOUNT_TYPE_SECURITY = "[REDACTED]";
    public static final int LOGINPLATFORM_MOBILEQQ = 2;
    public static final int LOGINPLATFORM_WECHAT = 1;
    public static final java.lang.String PAY_CHANNEL_BANK = "bank";
    public static final java.lang.String PAY_CHANNEL_WECHAT = "wechat";
    private static com.tencent.midas.api.IAPMidasPayCallBack midasCallBack = new com.tencent.midas.api.IAPMidasPayCallBack() { // from class: com.pay.api.APPayGameService.1
        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(com.tencent.midas.api.APMidasResponse aPMidasResponse) {
            if (com.pay.api.APPayGameService.serviceDelegate != null) {
                com.pay.api.APPayResponseInfo aPPayResponseInfo = new com.pay.api.APPayResponseInfo();
                try {
                    com.tencent.midas.comm.APBeanUtil.copyProperties(aPMidasResponse, aPPayResponseInfo);
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.i("APPayGameService", "midas callBack copyProperties error:" + e.toString());
                }
                com.tencent.midas.comm.APLog.i("midasCallBack", com.tencent.pipe.IPipeInterface.CMD_MIDASPAYCALLBACK);
                com.pay.api.APPayGameService.serviceDelegate.PayGameServiceCallBack(aPPayResponseInfo);
            }
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (com.pay.api.APPayGameService.serviceDelegate != null) {
                com.tencent.midas.comm.APLog.i("midasCallBack", com.tencent.pipe.IPipeInterface.CMD_MIDASPAYNEEDLOGIN);
                com.pay.api.APPayGameService.serviceDelegate.PayGameNeedLogin();
            }
        }
    };
    private static com.pay.api.IAPPayGameServiceCallBack serviceDelegate;

    public static com.pay.api.IAPPayGameServiceCallBack GetDelegate() {
        return serviceDelegate;
    }

    public static void LauchVmallView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.mallType = 2;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
    }

    public static void LaunchGroupBuyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.mallType = 1;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
    }

    public static void LaunchMPSaveCurrencyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, int i, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13) {
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.resId = i;
        com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo aPMidasMPInfo = aPMidasGameRequest.mpInfo;
        aPMidasMPInfo.payChannel = str10;
        aPMidasMPInfo.discountType = str11;
        aPMidasMPInfo.discountUrl = str12;
        aPMidasMPInfo.extras = str13;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
    }

    public static void LaunchMPSaveGoodsView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, int i, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12) {
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 1;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.goodsTokenUrl = str8;
        aPMidasGoodsRequest.resId = i;
        com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo aPMidasMPInfo = aPMidasGoodsRequest.mpInfo;
        aPMidasMPInfo.payChannel = str9;
        aPMidasMPInfo.discountType = str10;
        aPMidasMPInfo.discountUrl = str11;
        aPMidasMPInfo.extras = str12;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
    }

    public static void LaunchMp(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver) {
        startMpNetWork(str, str2, str3, str4, str5, str6, str7, "", iAPHttpAnsObserver);
    }

    public static void LaunchMp(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver) {
        startMpNetWork(str, str2, str3, str4, str5, str6, str7, str8, iAPHttpAnsObserver);
    }

    public static void LaunchSaveCurrencyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, int i) {
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = "";
        aPMidasGameRequest.isCanChange = true;
        aPMidasGameRequest.resId = i;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
    }

    public static void LaunchSaveCurrencyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, int i, java.lang.String str9, java.lang.String str10) {
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = "";
        aPMidasGameRequest.isCanChange = true;
        aPMidasGameRequest.resId = i;
        com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo aPMidasMPInfo = aPMidasGameRequest.mpInfo;
        aPMidasMPInfo.drmInfo = str9;
        aPMidasMPInfo.discoutId = str10;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
    }

    public static void LaunchSaveCurrencyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, boolean z, int i) {
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.isCanChange = z;
        aPMidasGameRequest.resId = i;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
    }

    public static void LaunchSaveCurrencyView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, boolean z, int i, java.lang.String str10, java.lang.String str11) {
        com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.isCanChange = z;
        aPMidasGameRequest.resId = i;
        com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo aPMidasMPInfo = aPMidasGameRequest.mpInfo;
        aPMidasMPInfo.drmInfo = str10;
        aPMidasMPInfo.discoutId = str11;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
    }

    public static void LaunchSaveGoodsView(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, int i) {
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 1;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.goodsTokenUrl = str8;
        aPMidasGoodsRequest.resId = i;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
    }

    public static void LaunchSaveGoodsViewWithoutToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, boolean z, java.lang.String str10) {
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = new com.tencent.midas.api.request.APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 2;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.prodcutId = str8;
        aPMidasGoodsRequest.saveValue = str9;
        aPMidasGoodsRequest.isCanChange = z;
        com.tencent.midas.api.APMidasPayAPI.launchPay(com.pay.AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
    }

    public static void SetDelegate(com.pay.api.IAPPayGameServiceCallBack iAPPayGameServiceCallBack) {
        serviceDelegate = iAPPayGameServiceCallBack;
    }

    @java.lang.Deprecated
    public static void SetNeedReloginInSDK(boolean z) {
    }

    public static void release() {
        serviceDelegate = null;
    }

    @java.lang.Deprecated
    public static void reportCrashApLog(java.lang.Throwable th) {
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
        aPMidasBaseRequest.extendInfo.unit = com.pay.AndroidPay.singleton().unit;
        aPMidasBaseRequest.extendInfo.isShowNum = com.pay.AndroidPay.singleton().isShowNum;
        aPMidasBaseRequest.resData = com.pay.AndroidPay.singleton().resdata;
        aPMidasBaseRequest.extendInfo.isShowListOtherNum = com.pay.AndroidPay.singleton().isShowListOtherNum;
    }

    private static void startMpNetWork(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, final com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver) {
        com.tencent.midas.api.request.APMidasNetRequest aPMidasNetRequest = new com.tencent.midas.api.request.APMidasNetRequest();
        setCommParams(aPMidasNetRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasNetRequest.reqType = com.tencent.midas.api.request.APMidasNetRequest.NET_REQ_MP;
        if (str8 != null || "".equals(str8)) {
            aPMidasNetRequest.mpInfo.drmInfo = str8;
        }
        final com.pay.network.model.APMpAns aPMpAns = new com.pay.network.model.APMpAns(com.pay.http.APHttpHandle.getIntanceHandel(), iAPHttpAnsObserver, new java.util.HashMap(), com.tencent.midas.api.request.APMidasNetRequest.NET_REQ_MP);
        com.tencent.midas.api.APMidasPayAPI.launchNet(com.pay.AndroidPay.singleton().fromActivity, aPMidasNetRequest, new com.tencent.midas.api.IAPMidasNetCallBack() { // from class: com.pay.api.APPayGameService.2
            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public void MidasNetError(java.lang.String str9, int i, java.lang.String str10) {
                com.pay.network.model.APMpAns aPMpAns2 = aPMpAns;
                aPMpAns2.resultCode = i;
                aPMpAns2.resultMsg = str10;
                iAPHttpAnsObserver.onError(aPMpAns2);
            }

            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public void MidasNetFinish(java.lang.String str9, java.lang.String str10) {
                aPMpAns.onFinishAns(str10.getBytes(), null);
                iAPHttpAnsObserver.onFinish(aPMpAns);
            }

            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public void MidasNetStop(java.lang.String str9) {
                iAPHttpAnsObserver.onStop(aPMpAns);
            }
        });
    }
}
