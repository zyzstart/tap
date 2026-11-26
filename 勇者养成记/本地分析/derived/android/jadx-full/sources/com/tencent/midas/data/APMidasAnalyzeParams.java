package com.tencent.midas.data;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasAnalyzeParams {

    private static class SingletonHolder {
        private static com.tencent.midas.data.APMidasAnalyzeParams instance = new com.tencent.midas.data.APMidasAnalyzeParams();

        private SingletonHolder() {
        }
    }

    private void AnalyzeCommParams(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        try {
            com.tencent.midas.data.APPluginDataInterface aPPluginDataInterfaceSingleton = com.tencent.midas.data.APPluginDataInterface.singleton();
            aPPluginDataInterfaceSingleton.setOfferId(aPMidasBaseRequest.offerId);
            aPPluginDataInterfaceSingleton.setOpenId(aPMidasBaseRequest.openId);
            aPPluginDataInterfaceSingleton.setOpenKey(aPMidasBaseRequest.openKey);
            aPPluginDataInterfaceSingleton.setSessionId(aPMidasBaseRequest.sessionId);
            aPPluginDataInterfaceSingleton.setSessionType(aPMidasBaseRequest.sessionType);
            aPPluginDataInterfaceSingleton.setPf(aPMidasBaseRequest.pf);
            aPPluginDataInterfaceSingleton.setPfKey(aPMidasBaseRequest.pfKey);
            aPPluginDataInterfaceSingleton.setZoneId(aPMidasBaseRequest.zoneId);
            aPPluginDataInterfaceSingleton.setDiscountUrl(aPMidasBaseRequest.mpInfo.discountUrl);
            aPPluginDataInterfaceSingleton.setReserv(aPMidasBaseRequest.reserv);
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("AnalyzeCommParams", e.toString());
        }
    }

    public static com.tencent.midas.data.APMidasAnalyzeParams getInstance() {
        return com.tencent.midas.data.APMidasAnalyzeParams.SingletonHolder.instance;
    }

    public void AnalyzeParams(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        if (aPMidasBaseRequest != null) {
            AnalyzeCommParams(aPMidasBaseRequest);
            setSaveType(aPMidasBaseRequest);
        }
    }

    public void setSaveType(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        com.tencent.midas.data.APPluginDataInterface aPPluginDataInterfaceSingleton = com.tencent.midas.data.APPluginDataInterface.singleton();
        try {
            if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGameRequest) {
                if (aPMidasBaseRequest.acctType.equals("qb")) {
                    aPPluginDataInterfaceSingleton.setSaveType(3);
                } else {
                    aPPluginDataInterfaceSingleton.setSaveType(0);
                }
            } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGoodsRequest) {
                aPPluginDataInterfaceSingleton.setSaveType(1);
            } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasMonthRequest) {
                aPPluginDataInterfaceSingleton.setSaveType(4);
            } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasSubscribeRequest) {
                aPPluginDataInterfaceSingleton.setSaveType(5);
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("setSaveType", e.toString());
        }
    }
}
