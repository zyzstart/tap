package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class HttpRequest {
    public static final java.lang.String DURATION_TIME = "duration_time";
    public static final java.lang.String ENCRYPT_TYPE_DEFAULT_VAL = "default";
    protected static java.lang.String HTTP_DOMAIN = "";
    protected static java.lang.String HTTP_ORIGIN_HOST = "";
    public static final java.lang.String HTTP_REQ_ENTITY_JOIN = "&";
    public static final java.lang.String HTTP_REQ_ENTITY_MERGE = "=";
    private static final java.lang.String LOG_TAG = "YSDK_REQUEST";
    public static final java.lang.String PARAM_ANDROID = "pay_os";
    public static final java.lang.String PARAM_ANTIADDICT_SWITCH = "anti_hope_switch";
    public static final java.lang.String PARAM_APN = "apn";
    public static final java.lang.String PARAM_APPID = "appid";
    public static final java.lang.String PARAM_APP_NAME = "app_name";
    public static final java.lang.String PARAM_APP_VERSION = "app_version";
    public static final java.lang.String PARAM_BRAND = "pay_brand";
    public static final java.lang.String PARAM_CHANNEL_ID = "channel_id";
    public static final java.lang.String PARAM_ENCRYPT_TYPE = "sk";
    public static final java.lang.String PARAM_ENCRYPT_VAL = "sf";
    public static final java.lang.String PARAM_IMEI = "imei";
    public static final java.lang.String PARAM_IMEI2 = "imei2";
    public static final java.lang.String PARAM_MODEL = "pay_model";
    public static final java.lang.String PARAM_OFFERID = "offerid";
    public static final java.lang.String PARAM_OPENID = "openid";
    public static final java.lang.String PARAM_OPERATOR = "operator";
    public static final java.lang.String PARAM_ORIENTATION = "orientation";
    public static final java.lang.String PARAM_PLATFORM_LOGIN = "loginplatform";
    public static final java.lang.String PARAM_QIMEI = "qimei";
    public static final java.lang.String PARAM_QIMEI36 = "qimei36";
    public static final java.lang.String PARAM_QQ_APPID = "qq_appid";
    public static final java.lang.String PARAM_RESOULUTION = "resolution";
    public static final java.lang.String PARAM_SIG = "sig";
    public static final java.lang.String PARAM_TIMESTAMP = "timestamp";
    public static final java.lang.String PARAM_VERSION = "version";
    public static final java.lang.String PARAM_WX_APPID = "wx_appid";
    public static final java.lang.String PARAM_YYB_APP = "yyb_app";
    public static final java.lang.String PARAM_YYB_INSTALL = "yyb_install";
    public static final java.lang.String PARAM_YYB_NAME = "yyb_vername";
    public static final java.lang.String PARAM_YYB_VER = "yyb_vercode";
    protected java.lang.String path;
    protected long requestTime = 0;
    public byte[] data = null;
    public java.util.HashMap<java.lang.String, java.lang.String> cookieInfo = new java.util.HashMap<>();
    protected boolean reportIMEI = true;
    public com.tencent.ysdk.shell.framework.request.HTTPRequestHandler mHttpResponseHandler = new com.tencent.ysdk.shell.framework.request.HTTPRequestHandler() { // from class: com.tencent.ysdk.shell.framework.request.HttpRequest.1
        @Override // com.tencent.ysdk.shell.framework.request.HTTPRequestHandler
        public void onFailure(int i, java.lang.String str) {
            int i2 = 100000;
            if (i != 0 && i > 300) {
                i2 = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_STATUS_ERROR;
            }
            com.tencent.ysdk.shell.framework.request.HttpRequest.this.onRequestFailure(i2, str + " statusCode=" + i);
            reportHttpRequestEvent(i, -1, "http request failed", i2);
        }

        @Override // com.tencent.ysdk.shell.framework.request.HTTPRequestHandler
        public void onSuccess(int i, java.lang.String str) {
            int i2;
            try {
                if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
                    com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", "responseBody is null");
                    reportHttpRequestEvent(i, 0, "responseBody is null", com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_RESP_NULL);
                    return;
                }
                try {
                    com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(str);
                    int i3 = safeJSONObject.getInt("ret");
                    i2 = safeJSONObject.has(com.tencent.ysdk.shell.framework.request.HttpResponse.HTTP_RESP_PARAM_CODE) ? safeJSONObject.getInt(com.tencent.ysdk.shell.framework.request.HttpResponse.HTTP_RESP_PARAM_CODE) : i3;
                    safeJSONObject.put(com.tencent.ysdk.shell.framework.request.HttpRequest.DURATION_TIME, java.lang.System.currentTimeMillis() - com.tencent.ysdk.shell.framework.request.HttpRequest.this.requestTime);
                    com.tencent.ysdk.shell.framework.request.HttpRequest.this.onRequestSuccess(i3, safeJSONObject);
                } catch (org.json.JSONException unused) {
                    i2 = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_RESP_PARSE_ERROR;
                    com.tencent.ysdk.shell.framework.request.HttpRequest.this.onRequestFailure(com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_RESP_PARSE_ERROR, str);
                }
                reportHttpRequestEvent(i, 0, "http request success", i2);
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
                com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", e);
            }
        }

        public void reportHttpRequestEvent(int i, int i2, java.lang.String str, int i3) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("path", com.tencent.ysdk.shell.framework.request.HttpRequest.this.path);
            map.put("requestCost", java.lang.String.valueOf(java.lang.System.currentTimeMillis() - com.tencent.ysdk.shell.framework.request.HttpRequest.this.requestTime));
            map.put("statusCode", java.lang.String.valueOf(i));
            map.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, java.lang.String.valueOf(i3));
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_HTTP_REQUEST, i2, str, map, com.tencent.ysdk.shell.framework.request.HttpRequest.this.requestTime, true);
        }
    };

    protected HttpRequest(java.lang.String str) {
        this.path = "";
        if (!android.text.TextUtils.isEmpty(str)) {
            this.path = str;
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_REQUEST", "path is null");
            this.path = "";
        }
    }

    private java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str2.startsWith("&")) {
            str2 = str2.substring(1);
        }
        return android.text.TextUtils.isEmpty(str2) ? "" : com.tencent.ysdk.shell.framework.request.encrypt.HttpRequestEncryptFactory.getHttpRequestEncrypt().encrypt(str, str2);
    }

    private java.lang.String getAppIdByPlatform(com.tencent.ysdk.framework.common.ePlatform eplatform) throws java.lang.Exception {
        java.lang.String qQAppId;
        if (eplatform.val() == com.tencent.ysdk.framework.common.ePlatform.WX.val()) {
            qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId();
            if (android.text.TextUtils.isEmpty(qQAppId) || !qQAppId.startsWith(com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_WX)) {
                throw new java.lang.RuntimeException("应用WXAppid配置错误，请检查YSDKConfig.ini");
            }
        } else {
            qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
            if (android.text.TextUtils.isEmpty(qQAppId) || java.lang.Long.parseLong(qQAppId) <= 0) {
                throw new java.lang.RuntimeException("应用QQAppid配置错误，请检查YSDKConfig.ini");
            }
        }
        return qQAppId;
    }

    private java.lang.String getBaseParams(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private java.lang.String getDomain() {
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(HTTP_DOMAIN)) {
            return com.tencent.ysdk.shell.framework.request.HttpDNSManager.getInstance().getHttpDns(HTTP_DOMAIN);
        }
        HTTP_DOMAIN = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getDomain();
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(HTTP_DOMAIN)) {
            return com.tencent.ysdk.shell.framework.request.HttpDNSManager.getInstance().getHttpDns(HTTP_DOMAIN);
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", "Domain is not found in config file");
        return "";
    }

    protected java.util.Map<java.lang.String, java.lang.Object> generateBaseParams(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str) throws java.lang.Exception {
        java.util.HashMap map = new java.util.HashMap();
        com.tencent.ysdk.framework.common.ePlatform eplatform2 = (com.tencent.ysdk.framework.common.ePlatform.QQ == eplatform || com.tencent.ysdk.framework.common.ePlatform.WX == eplatform) ? eplatform : com.tencent.ysdk.framework.common.ePlatform.QQ;
        java.lang.String strE = "";
        java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        map.put("timestamp", strValueOf);
        map.put("appid", getAppIdByPlatform(eplatform2));
        try {
            strE = com.tencent.ysdk.shell.framework.request.encrypt.SigEncryptHelper.e(strValueOf, getAppIdByPlatform(eplatform2), str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", e);
        }
        map.put(PARAM_SIG, strE);
        map.put(PARAM_VERSION, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion()));
        map.put("openid", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(str));
        map.put(PARAM_PLATFORM_LOGIN, java.lang.Integer.valueOf(eplatform.val()));
        map.put(PARAM_ANDROID, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        try {
            android.content.pm.PackageInfo installedYYBInfo = com.tencent.ysdk.shell.libware.apk.YYBUtils.getInstalledYYBInfo();
            if (installedYYBInfo != null) {
                map.put(PARAM_YYB_INSTALL, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(1)));
                map.put(PARAM_YYB_NAME, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(installedYYBInfo.versionName)));
                map.put(PARAM_YYB_VER, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(installedYYBInfo.versionCode)));
                map.put(PARAM_YYB_APP, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(installedYYBInfo.applicationInfo.loadLabel(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageManager()))));
            } else {
                map.put(PARAM_YYB_INSTALL, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(0)));
            }
            map.put(PARAM_ANTIADDICT_SWITCH, java.lang.Integer.valueOf(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAntiAddictionSwitch()));
        } catch (java.lang.Exception unused) {
            map.put(PARAM_YYB_INSTALL, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(0)));
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", "get YYBInstallInfo err");
        }
        map.put("app_name", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        map.put("app_version", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppVersionName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        map.put(PARAM_QQ_APPID, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId()));
        map.put(PARAM_WX_APPID, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId()));
        map.put("offerid", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId()));
        map.put("channel_id", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId()));
        map.put(PARAM_ORIENTATION, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()))));
        map.put("resolution", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.DeviceUtils.getResolution(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        map.put(PARAM_ANTIADDICT_SWITCH, java.lang.Integer.valueOf(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getAntiAddictionSwitch()));
        return map;
    }

    protected java.util.Map<java.lang.String, java.lang.Object> generateEncryptMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.HashMap map2 = new java.util.HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        if (!android.text.TextUtils.isEmpty(android.os.Build.BRAND)) {
            map2.put(PARAM_BRAND, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(android.os.Build.BRAND));
        }
        if (!android.text.TextUtils.isEmpty(android.os.Build.MODEL)) {
            map2.put(PARAM_MODEL, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(android.os.Build.MODEL));
        }
        if (this.reportIMEI) {
            map2.put("imei", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.DeviceUtils.getImei(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
            map2.put("qimei", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei()));
            map2.put("imei2", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.DeviceUtils.buildImei2WithOAID(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        }
        map2.put("qimei36", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36()));
        map2.put(PARAM_OPERATOR, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.APNUtil.getSimOperator(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        map2.put("apn", com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.libware.device.APNUtil.getNetworkType(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext())));
        return map2;
    }

    protected java.lang.String getBaseParams(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str) throws java.lang.Exception {
        return getBaseParams(eplatform, str, null);
    }

    protected java.lang.String getBaseParams(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) throws java.lang.Exception {
        java.util.Map<java.lang.String, java.lang.Object> mapGenerateBaseParams = generateBaseParams(eplatform, str);
        java.util.Map<java.lang.String, java.lang.Object> mapGenerateEncryptMap = generateEncryptMap(map);
        return getBaseParams(mapGenerateBaseParams) + "&" + getEncryptParams((java.lang.String) mapGenerateBaseParams.get("timestamp"), mapGenerateEncryptMap);
    }

    protected java.lang.String getBaseUrl() {
        return getDomain() + this.path;
    }

    protected java.lang.String getEncryptParams(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (map == null || map.isEmpty()) {
            return "";
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return "sk=default&sf=" + encrypt(str, sb.toString());
    }

    public java.lang.String getOriginHostName() {
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(HTTP_ORIGIN_HOST)) {
            return HTTP_ORIGIN_HOST;
        }
        HTTP_ORIGIN_HOST = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getDomain().replace("https://", "").replace("http://", "");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(HTTP_ORIGIN_HOST)) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", "OriginHostName is not found in config file");
            return "";
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_REQUEST", "OriginHostName=" + HTTP_ORIGIN_HOST);
        return HTTP_ORIGIN_HOST;
    }

    protected abstract java.lang.String getUrl();

    protected abstract void onRequestFailure(int i, java.lang.String str);

    protected abstract void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject);

    public void setURLConnectionCustomParam(java.net.HttpURLConnection httpURLConnection) {
    }
}
