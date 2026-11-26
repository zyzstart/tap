package com.tencent.ysdk.shell.module.report.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class HaboReportModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.report.ReportInterface {
    public static final java.lang.String APP_ID_FOR_YSDK = "1000344";
    private static final int MSG_REPORT_CGI = 1;
    private static final int MSG_REPORT_HTTP = 2;
    public static final java.lang.String REPORT_CGI = "report_cgi";
    public static final int REPORT_FREQUENCY_FAILED = 100;
    public static final int REPORT_FREQUENCY_SUCCESS = 100;
    public static final int REPORT_MAX = 5;
    private static final java.lang.String SDK_HEADER = "YSDK_AND_";
    private static final java.lang.String TAG = "YSDK_Report";
    public static final java.lang.String URL_REPORT_CGI = "https://wspeed.qq.com/w.cgi";
    protected java.util.List<java.io.Serializable> mCgiList;
    protected java.util.Random mRand;
    protected android.os.HandlerThread mHandlerThread = null;
    private android.os.Handler mBgHandler = null;
    private int mRealReportFrequency = 0;
    private int mRealReportMAX = 0;
    private int reportTimes = 1;
    private boolean reportSucc = false;

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 1:
                    if (message.obj == null || !(message.obj instanceof com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportParaClass)) {
                        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.TAG, "doReportCgi para is bad");
                    } else {
                        try {
                            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.TAG, "doReportCgi");
                            com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.reportCgiAsync((com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportParaClass) message.obj);
                        } catch (java.lang.Exception e) {
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                            return;
                        }
                    }
                    break;
                case 2:
                    com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.doReportCgiOnce();
                    break;
            }
        }
    }

    private class ReportHttpRequestHandler extends com.tencent.ysdk.shell.framework.request.HTTPRequestHandler {
        private ReportHttpRequestHandler() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HTTPRequestHandler
        public void onFailure(int i, java.lang.String str) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.TAG, "fail:" + i + ";error:" + str);
            com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.doReportWithRetry();
        }

        @Override // com.tencent.ysdk.shell.framework.request.HTTPRequestHandler
        public void onSuccess(int i, java.lang.String str) {
            if (200 != i) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.TAG, "succ:" + i);
                com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.doReportWithRetry();
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.TAG, "succ:" + i);
            com.tencent.ysdk.shell.module.report.impl.db.ReportTableModel.clearReportItem("report_cgi");
            com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.mCgiList.clear();
            com.tencent.ysdk.shell.module.report.impl.HaboReportModule.this.reportTimes = 1;
        }
    }

    private class ReportParaClass {
        public java.lang.String command;
        public java.lang.String detail;
        public long reqSize;
        public int resultCode;
        public long rspSize;
        public long startTime;
        public boolean timely;

        private ReportParaClass() {
            this.command = "";
            this.startTime = 0L;
            this.reqSize = 0L;
            this.rspSize = 0L;
            this.resultCode = 0;
            this.detail = "";
            this.timely = true;
        }
    }

    public HaboReportModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REPORT;
    }

    private static void appendStringArray(java.lang.StringBuilder sb, java.lang.String str, java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                sb.append(java.net.URLEncoder.encode(str));
                sb.append("=");
                sb.append(java.net.URLEncoder.encode(strArr[i]));
            } else {
                sb.append(java.net.URLEncoder.encode("," + strArr[i]));
            }
        }
        sb.append("&");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReportWithRetry() {
        if (this.reportTimes <= 3) {
            doReportCgiOnce();
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "reportTimes more, save");
        com.tencent.ysdk.shell.module.report.impl.db.ReportTableModel.saveReportItemToDB("report_cgi", this.mCgiList);
        this.mCgiList.clear();
        this.reportTimes = 1;
    }

    public static java.lang.String encodeUrl(android.os.Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : bundle.keySet()) {
            java.lang.Object obj = bundle.get(str);
            if (obj instanceof java.lang.String) {
                sb.append(java.net.URLEncoder.encode(str));
                sb.append("=");
                sb.append(java.net.URLEncoder.encode(bundle.getString(str)));
                sb.append("&");
            } else if (obj instanceof java.lang.String[]) {
                appendStringArray(sb, str, (java.lang.String[]) obj);
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void reportCgi(java.lang.String str, long j, long j2, long j3, int i, java.lang.String str2, boolean z) {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        }
        if (availableFrequency(i) || z) {
            com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportParaClass reportParaClass = new com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportParaClass();
            reportParaClass.command = str;
            reportParaClass.startTime = j;
            reportParaClass.reqSize = j2;
            reportParaClass.rspSize = j3;
            reportParaClass.resultCode = i;
            reportParaClass.detail = str2;
            reportParaClass.timely = z;
            android.os.Message message = new android.os.Message();
            message.what = 1;
            message.obj = reportParaClass;
            this.mBgHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCgiAsync(com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportParaClass reportParaClass) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - reportParaClass.startTime;
        android.os.Bundle bundle = new android.os.Bundle();
        java.lang.String apnName = com.tencent.ysdk.shell.libware.device.APNUtil.getApnName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        bundle.putString("apn", apnName);
        bundle.putString("appid", APP_ID_FOR_YSDK);
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.COMMAND_ID, reportParaClass.command);
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, reportParaClass.detail);
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, "network=" + apnName + "&sdcard=" + (android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0) + "&wifi=" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(1);
        sb.append("");
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.FREQUENCY, sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(reportParaClass.reqSize);
        sb2.append("");
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.REQUEST_SIZE, sb2.toString());
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.RESULT_CODE, reportParaClass.resultCode + "");
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.RESPONSE_SIZE, reportParaClass.rspSize + "");
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.TIME_COST, jCurrentTimeMillis + "");
        bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.TO_UIN, "1000");
        this.mCgiList.add(new com.tencent.ysdk.shell.module.report.impl.BaseData(bundle));
        int size = this.mCgiList.size();
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "dataSize:" + size);
        if (availableCount(size) || reportParaClass.timely) {
            doReportWithRetry();
        }
    }

    private void retryReport() {
    }

    private void startReport() {
    }

    protected boolean availableCount(int i) {
        int i2 = this.mRealReportMAX;
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "-->availableCount, | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected boolean availableFrequency(int i) {
        android.util.Log.d(TAG, "-->availableFrequency, result: " + i);
        int frequency = getFrequency(i);
        boolean z = this.mRand.nextInt(100) < frequency;
        android.util.Log.d(TAG, "-->availableFrequency, result: " + z + " | frequency: " + frequency);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReportCgiOnce() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "reportTimes:" + this.reportTimes);
        try {
            this.reportTimes++;
            android.os.Bundle bundlePrepareCgiData = prepareCgiData();
            if (bundlePrepareCgiData == null) {
                return;
            }
            byte[] bytesUTF8 = com.tencent.ysdk.shell.libware.util.YSDKTextUtils.getBytesUTF8(encodeUrl(bundlePrepareCgiData));
            com.tencent.ysdk.shell.framework.request.HttpRequest httpRequest = new com.tencent.ysdk.shell.framework.request.HttpRequest(null) { // from class: com.tencent.ysdk.shell.module.report.impl.HaboReportModule.1
                @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
                public java.lang.String getOriginHostName() {
                    return "wspeed.qq.com";
                }

                @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
                protected java.lang.String getUrl() {
                    return com.tencent.ysdk.shell.module.report.impl.HaboReportModule.URL_REPORT_CGI;
                }

                @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
                protected void onRequestFailure(int i, java.lang.String str) {
                }

                @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
                protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
                }
            };
            httpRequest.data = bytesUTF8;
            httpRequest.mHttpResponseHandler = new com.tencent.ysdk.shell.module.report.impl.HaboReportModule.ReportHttpRequestHandler();
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(httpRequest);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    protected int getFrequency(int i) {
        if (i == 0) {
            return this.mRealReportFrequency;
        }
        return 100;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "HaboReportModule init start");
        this.mRand = new java.util.Random();
        this.mCgiList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.mHandlerThread = new android.os.HandlerThread("YSDK_TEMP");
        this.mHandlerThread.start();
        this.mBgHandler = new com.tencent.ysdk.shell.module.report.impl.HaboReportModule.HandlerInBG(this.mHandlerThread.getLooper());
        this.mRealReportFrequency = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_REPORT_FREQUENCY_SUCCESS, 100);
        this.mRealReportMAX = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_REPORT_CACHE_MAX, 5);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "HaboReportModule init end");
    }

    protected android.os.Bundle prepareCgiData() {
        if (this.mCgiList.size() == 0) {
            return null;
        }
        com.tencent.ysdk.shell.module.report.impl.BaseData baseData = (com.tencent.ysdk.shell.module.report.impl.BaseData) this.mCgiList.get(0);
        if (baseData == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        java.lang.String str = baseData.attrs.get("appid");
        java.util.List<java.io.Serializable> reportItemFromDB = com.tencent.ysdk.shell.module.report.impl.db.ReportTableModel.getReportItemFromDB("report_cgi");
        if (reportItemFromDB != null) {
            this.mCgiList.clear();
            this.mCgiList.addAll(reportItemFromDB);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "-->prepareCgiData, mCgiList size: " + this.mCgiList.size());
        if (this.mCgiList.size() == 0) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.SDK_VERSION, SDK_HEADER + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, android.os.Build.DEVICE);
            bundle.putString(com.tencent.ysdk.shell.module.report.impl.ReportComm.QUA, SDK_HEADER + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.mCgiList.size(); i++) {
                com.tencent.ysdk.shell.module.report.impl.BaseData baseData2 = (com.tencent.ysdk.shell.module.report.impl.BaseData) this.mCgiList.get(i);
                bundle.putString(i + "_1", baseData2.attrs.get("apn"));
                bundle.putString(i + "_2", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.FREQUENCY));
                bundle.putString(i + "_3", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.COMMAND_ID));
                bundle.putString(i + "_4", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.RESULT_CODE));
                bundle.putString(i + "_5", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.TIME_COST));
                bundle.putString(i + "_6", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.REQUEST_SIZE));
                bundle.putString(i + "_7", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.RESPONSE_SIZE));
                bundle.putString(i + "_8", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL));
                bundle.putString(i + "_9", baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.TO_UIN));
                bundle.putString(i + "_10", com.tencent.ysdk.shell.libware.device.DeviceUtils.getDeviceinfoForCgiReport(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()) + "&" + baseData2.attrs.get(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE_INFO));
            }
            return bundle;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            return null;
        }
    }

    @Override // com.tencent.ysdk.shell.module.report.ReportInterface
    public void reportCgiRealTime(java.lang.String str, long j, long j2, long j3, int i) {
        reportCgi(str, j, j2, j3, i, "", true);
    }
}
