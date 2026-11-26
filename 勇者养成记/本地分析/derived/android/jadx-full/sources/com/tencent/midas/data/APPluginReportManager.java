package com.tencent.midas.data;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginReportManager {
    public static final java.lang.String MIDASPLUGIN_ENTER_ABILITY = "sdk.plugin.enter.ability";
    public static final java.lang.String MIDASPLUGIN_FORMAT_APKLOAD_ERROR = "sdk.loadapk_error";
    public static final java.lang.String MIDASPLUGIN_FORMAT_APKLOAD_FAIL = "sdk.loadapk_fail";
    public static final java.lang.String MIDASPLUGIN_FORMAT_TIME = "sdk.plugin.time";
    public static final java.lang.String MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON = "sdk.plugin.pureH5.error.reason";
    public static final java.lang.String MIDASPLUGIN_NAME_LAUNCH_ERROR = "sdk.plugin.launch.error";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS = "sdk.plugin.init.getFileListFromAssets.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_INIT = "timename.init";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_INIT_KERNEL = "sdk.plugin.init.kernel.totaltime";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_INIT_TOTALTIME = "sdk.plugin.init.totaltime";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS = "sdk.plugin.init.installFromAssets.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL = "sdk.plugin.init.installFromLocal.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE = "sdk.plugin.init.isNeedAssetsUpdate.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_IS_NEED_LOCAL_UPDATE = "sdk.plugin.init.isNeedLocalUpdate.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHABILITY = "timename.launchability";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHINFO = "timename.launchinfo";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHNET = "timename.launchnet";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHPAY = "timename.launchpay";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT = "sdk.plugin.launchPay.wait.init.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LAUNCHWEB = "timename.launchweb";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_LOAD_DEX = "sdk.plugin.init.loadDex.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_PLUGIN_VALID = "sdk.plugin.init.pluginvalid.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_READ_FILE_FROM_ASSETS = "sdk.plugin.init.readFileFromAssets.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_UNZIP_SO = "sdk.plugin.init.unzip.so.time";
    public static final java.lang.String MIDASPLUGIN_TIMENAME_WRITE_FILE_TO_DATA = "sdk.plugin.init.writeFileToData.time";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_BACK = "sdk.plugin.webpage.back";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_CLOSE = "sdk.plugin.webpage.close";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_HEAD_INIT = "sdk.plugin.webpage.head.init";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_INIT = "sdk.plugin.webpage.init";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_KEYBACK = "sdk.plugin.webpage.keyback";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_REFRESH = "sdk.plugin.webpage.refresh";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_SYSTEM = "sdk.plugin.webpage.system";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_WEBCLOSE = "sdk.plugin.webpage.webclose";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5 = "sdk.plugin.webpage.x5";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5_BACK = "sdk.plugin.webpage.x5.back";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5_CLOSE = "sdk.plugin.webpage.x5.close";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5_HEAD_INIT = "sdk.plugin.webpage.x5.head.init";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5_KEYBACK = "sdk.plugin.webpage.x5.keyback";
    public static final java.lang.String MIDASPLUGIN_WEBPAGE_X5_REFRESH = "sdk.plugin.webpage.x5.refresh";
    public static final java.lang.String MIDASPLUGIN_X5_INIT = "sdk.plugin.x5.init";
    public static final java.lang.String MIDASPLUGIN_X5_INIT_FAIL = "sdk.plugin.x5.init.fail";
    public static final java.lang.String MIDASPLUGIN_X5_INIT_SUCCESS = "sdk.plugin.x5.init.success";
    private static com.tencent.midas.data.APPluginReportManager gInstance;
    java.util.ArrayList initDataReport;
    java.util.ArrayList payDataReport;

    private static class SingletonHolder {
        private static com.tencent.midas.data.APPluginReportManager instance = new com.tencent.midas.data.APPluginReportManager();

        private SingletonHolder() {
        }
    }

    private APPluginReportManager() {
        this.initDataReport = null;
        this.payDataReport = null;
        this.initDataReport = new java.util.ArrayList();
        this.payDataReport = new java.util.ArrayList();
    }

    private java.lang.String constructTimeReport(java.lang.String str, long j) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("name=");
        stringBuffer.append(str);
        stringBuffer.append("&");
        stringBuffer.append("times=");
        stringBuffer.append(j);
        stringBuffer.append("&");
        return stringBuffer.toString();
    }

    private java.lang.String getAllReportRecord(java.util.ArrayList arrayList) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i++;
            stringBuffer.append("record" + i2 + "=");
            stringBuffer.append(reportParams2Str((com.tencent.midas.data.APClickStreamParams) arrayList.get(i2)));
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        stringBuffer2.append("num=");
        stringBuffer2.append(i);
        stringBuffer2.append("&");
        stringBuffer2.append(stringBuffer.toString());
        stringBuffer.setLength(0);
        return stringBuffer2.toString();
    }

    public static com.tencent.midas.data.APPluginReportManager getInstance() {
        return com.tencent.midas.data.APPluginReportManager.SingletonHolder.instance;
    }

    public static void initDataRelease() {
        try {
            if (getInstance() != null) {
                getInstance().initDataReport.clear();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private void insertOneRecord(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        java.util.ArrayList arrayList;
        com.tencent.midas.data.APClickStreamParams aPClickStreamParams = new com.tencent.midas.data.APClickStreamParams();
        aPClickStreamParams.device = "android_v" + com.tencent.midas.api.APMidasPayAPI.getMidasPluginVersion();
        aPClickStreamParams.openid = com.tencent.midas.data.APPluginDataInterface.singleton().getOpenId();
        aPClickStreamParams.format = str2;
        aPClickStreamParams.from = str3;
        aPClickStreamParams.offerid = com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId();
        aPClickStreamParams.pf = com.tencent.midas.data.APPluginDataInterface.singleton().getPf();
        aPClickStreamParams.SessionId = com.tencent.midas.data.APPluginDataInterface.singleton().getSessionId();
        aPClickStreamParams.SessionType = com.tencent.midas.data.APPluginDataInterface.singleton().getSessionType();
        if (!android.text.TextUtils.isEmpty(str4)) {
            aPClickStreamParams.extend = com.pay.tool.APMidasTools.urlEncode(str4, 3);
        }
        switch (com.tencent.midas.data.APPluginDataInterface.singleton().getSaveType()) {
            case 0:
            default:
                str5 = "game";
                break;
            case 1:
                str5 = "goods";
                break;
            case 2:
            case 3:
                str5 = "acct";
                break;
            case 4:
                str5 = "month";
                break;
            case 5:
                str5 = "subscribe";
                break;
        }
        aPClickStreamParams.savetype = str5;
        aPClickStreamParams.currentTimeMillis = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        if (str.equals("init")) {
            com.tencent.midas.data.APInitData.singleton();
            aPClickStreamParams.dataId = com.tencent.midas.data.APInitData.getInitdataCount();
            aPClickStreamParams.VipFlags = com.tencent.midas.data.APInitData.singleton().getInitGUID();
            arrayList = this.initDataReport;
        } else {
            aPClickStreamParams.dataId = com.tencent.midas.data.APDataId.getDataId();
            com.tencent.midas.data.APMultiProcessData processData = com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData();
            if (processData != null) {
                aPClickStreamParams.VipFlags = processData.getGuid();
            }
            arrayList = this.payDataReport;
        }
        arrayList.add(aPClickStreamParams);
    }

    private void invokeAPKReportManager(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method declaredMethod;
        java.lang.Object objInvoke;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.pay.data.report.APDataReportManager");
            if (cls != null) {
                java.lang.reflect.Method method = null;
                try {
                    declaredMethod = cls.getDeclaredMethod("getInstance", new java.lang.Class[0]);
                } catch (java.lang.NoSuchMethodException e) {
                    com.tencent.midas.comm.APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e.toString());
                    declaredMethod = null;
                }
                try {
                    objInvoke = declaredMethod.invoke(null, new java.lang.Object[0]);
                } catch (java.lang.Exception e2) {
                    com.tencent.midas.comm.APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e2.toString());
                    objInvoke = null;
                }
                try {
                    method = cls.getMethod("insertData", java.lang.String.class, java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class);
                } catch (java.lang.NoSuchMethodException e3) {
                    com.tencent.midas.comm.APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e3.toString());
                }
                try {
                    method.invoke(objInvoke, str, java.lang.Integer.valueOf(i), str2, str3, str4, str5);
                } catch (java.lang.Exception e4) {
                    com.tencent.midas.comm.APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e4.toString());
                }
            }
        } catch (java.lang.Exception e5) {
            com.tencent.midas.comm.APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e5.toString());
        }
    }

    public static void payDataRelease() {
        try {
            if (getInstance() != null) {
                getInstance().payDataReport.clear();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private java.lang.StringBuffer reportParams2Str(com.tencent.midas.data.APClickStreamParams aPClickStreamParams) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("3=" + aPClickStreamParams.openid);
        stringBuffer.append("|7=0");
        stringBuffer.append("|13=" + aPClickStreamParams.dataId);
        stringBuffer.append("|24=" + aPClickStreamParams.offerid);
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.payid)) {
            stringBuffer.append("|4=" + aPClickStreamParams.payid);
        }
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.isBindQQ)) {
            stringBuffer.append("|55=" + aPClickStreamParams.isBindQQ);
        }
        stringBuffer.append("|21=" + aPClickStreamParams.format);
        stringBuffer.append("|26=" + aPClickStreamParams.pf);
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.token)) {
            stringBuffer.append("[REDACTED]" + aPClickStreamParams.token);
        }
        com.tencent.midas.comm.APLog.i("getLogRecord extend pre", aPClickStreamParams.extend);
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.extend)) {
            stringBuffer.append("|8=" + aPClickStreamParams.extend);
        }
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.from)) {
            stringBuffer.append("|20=" + aPClickStreamParams.from);
        }
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.savetype)) {
            stringBuffer.append("|47=" + aPClickStreamParams.savetype);
        }
        stringBuffer.append("|29=" + aPClickStreamParams.guid);
        stringBuffer.append("|31=" + aPClickStreamParams.device);
        stringBuffer.append("|38=" + aPClickStreamParams.currentTimeMillis);
        stringBuffer.append("|34=" + aPClickStreamParams.uinTypeFromSvr);
        stringBuffer.append("|35=" + aPClickStreamParams.uinFromSvr);
        stringBuffer.append("|37=" + aPClickStreamParams.SessionId);
        stringBuffer.append("|43=" + aPClickStreamParams.SessionType);
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.PayLevel)) {
            stringBuffer.append("|54=" + aPClickStreamParams.PayLevel);
        }
        if (!android.text.TextUtils.isEmpty(aPClickStreamParams.VipFlags)) {
            stringBuffer.append("|53=" + aPClickStreamParams.VipFlags);
        }
        return stringBuffer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void dataReport(java.lang.String str) {
        java.lang.String allReportRecord = getAllReportRecord(str.equals("init") ? this.initDataReport : this.payDataReport);
        if (android.text.TextUtils.isEmpty(allReportRecord)) {
            return;
        }
        com.pay.http.APNetworkManager.getInstance().dataReport(allReportRecord, new com.pay.http.IAPHttpAnsObserver() { // from class: com.tencent.midas.data.APPluginReportManager.2
            @Override // com.pay.http.IAPHttpAnsObserver
            public void onError(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onFinish(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onStop(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }
        });
    }

    public void initInterfaceInit(java.lang.String str, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        com.tencent.midas.data.APInitData.init();
        com.tencent.midas.data.APInitData.singleton().setInitGUID(com.pay.tool.APMidasTools.getUUID());
        com.tencent.midas.data.APInitData.singleton().setInitInterfaceTime(java.lang.System.currentTimeMillis());
        com.tencent.midas.data.APPluginDataInterface.init();
        com.tencent.midas.data.APPluginDataInterface.singleton().setLaunchInterface(str);
        com.tencent.midas.data.APMidasAnalyzeParams.getInstance().AnalyzeParams(aPMidasBaseRequest);
    }

    public void insertData(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.tencent.midas.comm.APLog.i("insertTimeData interfaceName=", str + " format=" + str2 + " action=" + str3 + " extend=" + str4);
        insertOneRecord(str, str2, str3, str4);
    }

    public void insertTimeData(java.lang.String str, java.lang.String str2) {
        java.lang.String strConstructTimeReport;
        com.tencent.midas.comm.APLog.i("insertTimeData interfaceName=", str);
        com.tencent.midas.comm.APLog.i("insertTimeData timeName=", str2);
        if (android.text.TextUtils.isEmpty(com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        if (str == "init") {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.tencent.midas.data.APInitData.singleton().getInitInterfaceTime();
            com.tencent.midas.comm.APLog.i("时耗", "insertTimeData timeName=" + str2 + ",initTime:" + jCurrentTimeMillis);
            strConstructTimeReport = constructTimeReport(str2, jCurrentTimeMillis);
        } else {
            long jCurrentTimeMillis2 = 0;
            if (com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData() != null) {
                jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData().getPayInterfaceTime();
            }
            com.tencent.midas.comm.APLog.i("时耗", "insertTimeData timeName=" + str2 + ",payTime:" + jCurrentTimeMillis2);
            strConstructTimeReport = constructTimeReport(str2, jCurrentTimeMillis2);
        }
        insertOneRecord(str, MIDASPLUGIN_FORMAT_TIME, "", strConstructTimeReport);
    }

    public void insertTimeData(java.lang.String str, java.lang.String str2, long j) {
        com.tencent.midas.comm.APLog.d("insertTimeData interfaceName=", str + " timeName=" + str2 + " time=" + java.lang.String.valueOf(j));
        if (android.text.TextUtils.isEmpty(com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        insertOneRecord(str, MIDASPLUGIN_FORMAT_TIME, "", constructTimeReport(str2, j));
    }

    public void insertTimeDataEx(java.lang.String str, java.lang.String str2, long j) {
        long timeInterval = com.pay.tool.APMidasTools.getTimeInterval(j, java.lang.System.currentTimeMillis());
        com.tencent.midas.comm.APLog.d("insertTimeDataEx", "timeName:" + str2 + ",time" + timeInterval);
        insertTimeData(str, str2, timeInterval);
    }

    public void payInterfaceInit(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, java.lang.String str) {
        com.tencent.midas.data.APPluginDataInterface.init();
        com.tencent.midas.data.APPluginDataInterface.singleton().setLaunchInterface(str);
        com.tencent.midas.data.APMultiProcessData aPMultiProcessData = new com.tencent.midas.data.APMultiProcessData();
        aPMultiProcessData.setGuid(com.pay.tool.APMidasTools.getUUID());
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.midas.comm.APLog.i("showFirstPageInsertDB=====", "all:" + jCurrentTimeMillis);
        aPMultiProcessData.setPayInterfaceTime(jCurrentTimeMillis);
        if (com.tencent.midas.data.APInitData.singleton().getInitInterfaceTime() < 1) {
            aPMultiProcessData.setIntervalTime(0);
        } else {
            aPMultiProcessData.setIntervalTime((int) (java.lang.System.currentTimeMillis() - com.tencent.midas.data.APInitData.singleton().getInitInterfaceTime()));
        }
        com.tencent.midas.data.APPluginDataInterface.singleton().setProcessData(aPMultiProcessData);
        com.tencent.midas.data.APMidasAnalyzeParams.getInstance().setSaveType(aPMidasBaseRequest);
        com.tencent.midas.data.APMidasAnalyzeParams.getInstance().AnalyzeParams(aPMidasBaseRequest);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x00cb  */
    public void reportImmediatelyOneRecord(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        java.lang.String guid;
        java.lang.String allReportRecord;
        com.tencent.midas.data.APClickStreamParams aPClickStreamParams = new com.tencent.midas.data.APClickStreamParams();
        aPClickStreamParams.device = "android_v" + com.tencent.midas.api.APMidasPayAPI.getMidasPluginVersion();
        aPClickStreamParams.openid = com.tencent.midas.data.APPluginDataInterface.singleton().getOpenId();
        aPClickStreamParams.format = str2;
        aPClickStreamParams.from = "";
        aPClickStreamParams.offerid = com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId();
        aPClickStreamParams.pf = com.tencent.midas.data.APPluginDataInterface.singleton().getPf();
        aPClickStreamParams.SessionId = com.tencent.midas.data.APPluginDataInterface.singleton().getSessionId();
        aPClickStreamParams.SessionType = com.tencent.midas.data.APPluginDataInterface.singleton().getSessionType();
        if (!android.text.TextUtils.isEmpty(str3)) {
            aPClickStreamParams.extend = com.pay.tool.APMidasTools.urlEncode(str3, 3);
        }
        switch (com.tencent.midas.data.APPluginDataInterface.singleton().getSaveType()) {
            case 0:
            default:
                str4 = "game";
                break;
            case 1:
                str4 = "goods";
                break;
            case 2:
            case 3:
                str4 = "acct";
                break;
            case 4:
                str4 = "month";
                break;
            case 5:
                str4 = "subscribe";
                break;
        }
        aPClickStreamParams.savetype = str4;
        aPClickStreamParams.currentTimeMillis = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        if (!str.equals("init")) {
            aPClickStreamParams.dataId = com.tencent.midas.data.APDataId.getDataId();
            com.tencent.midas.data.APMultiProcessData processData = com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData();
            if (processData != null) {
                guid = processData.getGuid();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(aPClickStreamParams);
            allReportRecord = getAllReportRecord(arrayList);
            if (android.text.TextUtils.isEmpty(allReportRecord)) {
                return;
            }
            com.pay.http.APNetworkManager.getInstance().dataReport(allReportRecord, new com.pay.http.IAPHttpAnsObserver() { // from class: com.tencent.midas.data.APPluginReportManager.1
                @Override // com.pay.http.IAPHttpAnsObserver
                public void onError(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
                }

                @Override // com.pay.http.IAPHttpAnsObserver
                public void onFinish(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
                }

                @Override // com.pay.http.IAPHttpAnsObserver
                public void onStop(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
                }
            });
        }
        com.tencent.midas.data.APInitData.singleton();
        aPClickStreamParams.dataId = com.tencent.midas.data.APInitData.getInitdataCount();
        guid = com.tencent.midas.data.APInitData.singleton().getInitGUID();
        aPClickStreamParams.VipFlags = guid;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(aPClickStreamParams);
        allReportRecord = getAllReportRecord(arrayList2);
        if (android.text.TextUtils.isEmpty(allReportRecord)) {
            return;
        }
        com.pay.http.APNetworkManager.getInstance().dataReport(allReportRecord, new com.pay.http.IAPHttpAnsObserver() { // from class: com.tencent.midas.data.APPluginReportManager.1
            @Override // com.pay.http.IAPHttpAnsObserver
            public void onError(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onFinish(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onStop(com.pay.http.APBaseHttpAns aPBaseHttpAns) {
            }
        });
    }
}
