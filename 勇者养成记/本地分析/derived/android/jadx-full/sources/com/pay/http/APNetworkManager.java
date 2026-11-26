package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APNetworkManager {
    public static final java.lang.String HTTP_KEY_DATAREPORT = "datareport";
    public static final java.lang.String HTTP_KEY_INITREPORT = "initreport";
    private static com.pay.http.APNetworkManager gInstance;
    private java.util.HashMap httpReqMap = new java.util.HashMap();

    private static class APNetworkManagerHolder {
        private static final com.pay.http.APNetworkManager INSTANCE = new com.pay.http.APNetworkManager();

        private APNetworkManagerHolder() {
        }
    }

    public static void cancelRequest(java.lang.String str) {
        com.pay.http.APBaseHttpReq aPBaseHttpReq = (com.pay.http.APBaseHttpReq) gInstance.httpReqMap.get(str);
        if (aPBaseHttpReq != null) {
            aPBaseHttpReq.stopRequest();
            gInstance.httpReqMap.remove(str);
        }
    }

    public static com.pay.http.APNetworkManager getInstance() {
        if (gInstance == null) {
            gInstance = com.pay.http.APNetworkManager.APNetworkManagerHolder.INSTANCE;
        }
        return gInstance;
    }

    public static void release() {
        gInstance = null;
    }

    public void cancelPreRequest() {
        if (gInstance.httpReqMap != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.util.Map.Entry entry : gInstance.httpReqMap.entrySet()) {
                if (entry != null) {
                    arrayList.add((com.pay.http.APBaseHttpReq) entry.getValue());
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.pay.http.APBaseHttpReq aPBaseHttpReq = (com.pay.http.APBaseHttpReq) arrayList.get(i);
                if (aPBaseHttpReq != null) {
                    aPBaseHttpReq.stopRequest();
                }
            }
            gInstance.httpReqMap.clear();
        }
    }

    public void dataReport(java.lang.String str, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver) {
        if (android.text.TextUtils.isEmpty(com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        com.pay.network.model.APDataReportReq aPDataReportReq = new com.pay.network.model.APDataReportReq();
        aPDataReportReq.setHttpAns(new com.pay.network.model.APDataReportAns(com.pay.http.APHttpHandle.getIntanceHandel(), iAPHttpAnsObserver, this.httpReqMap, HTTP_KEY_DATAREPORT));
        aPDataReportReq.startService(str);
    }
}
