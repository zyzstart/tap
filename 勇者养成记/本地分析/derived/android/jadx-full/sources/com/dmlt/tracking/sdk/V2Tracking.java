package com.dmlt.tracking.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class V2Tracking {
    private static final int CONNECT_TIMEOUT = 1000;
    private static final int READ_TIMEOUT = 1000;
    private static com.dmlt.tracking.sdk.DodAdReportCallback mDodAdReportCallback;
    private static final com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack requestCallBack = new com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.V2Tracking.1
        @Override // com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack
        public void onError(java.lang.String str) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "onError: " + str);
        }

        @Override // com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack
        public void onSuccess(java.lang.String str) {
            android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, "onSuccess: " + str);
        }
    };
    private java.lang.String aid;
    private java.lang.String appKey;
    public android.content.Context applicationContext;
    private java.lang.String channel;
    private java.lang.String cid;
    private java.lang.String oaid;
    private java.lang.String subchannel;
    private java.lang.String url;
    private java.lang.String uuid;

    public interface OnRequestCallBack {
        void onError(java.lang.String str);

        void onSuccess(java.lang.String str);
    }

    public static class SingletonHolder {
        private static final com.dmlt.tracking.sdk.V2Tracking SINGLETON = new com.dmlt.tracking.sdk.V2Tracking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:66:0x0104 A[Catch: IOException -> 0x0100, TRY_LEAVE, TryCatch #6 {IOException -> 0x0100, blocks: (B:62:0x00fc, B:66:0x0104), top: B:73:0x00fc }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void doRequest(java.lang.String str, com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack onRequestCallBack) throws java.lang.Throwable {
        java.lang.String message;
        ?? inputStream;
        ?? r2;
        ?? r3;
        java.lang.String message2;
        ?? r9;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        boolean z = false;
        try {
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
                    httpURLConnection.setConnectTimeout(1000);
                    httpURLConnection.setReadTimeout(1000);
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    httpURLConnection.getContentLength();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                java.lang.String string = byteArrayOutputStream2.toString();
                                android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, "result:" + string);
                                message = string;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                z = true;
                                r9 = inputStream;
                            } catch (java.net.MalformedURLException e) {
                                r3 = inputStream;
                                e = e;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (r3 != 0) {
                                    r3.close();
                                }
                                message = message2;
                            } catch (java.io.IOException e2) {
                                r2 = inputStream;
                                e = e2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (r2 != 0) {
                                    r2.close();
                                }
                                message = message2;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        if (inputStream != 0) {
                                            inputStream.close();
                                        }
                                    } catch (java.io.IOException e3) {
                                        e3.getMessage();
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else if (inputStream != 0) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (java.net.MalformedURLException e4) {
                            r3 = inputStream;
                            e = e4;
                        } catch (java.io.IOException e5) {
                            r2 = inputStream;
                            e = e5;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } else {
                        message = "请求失败 code:" + httpURLConnection.getResponseCode();
                        r9 = 0;
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (r9 != 0) {
                        r9.close();
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    inputStream = message;
                }
            } catch (java.net.MalformedURLException e6) {
                e = e6;
                r3 = 0;
            } catch (java.io.IOException e7) {
                e = e7;
                r2 = 0;
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = 0;
            }
        } catch (java.io.IOException e8) {
            message = e8.getMessage();
            e8.printStackTrace();
        }
        if (z) {
            onRequestCallBack.onSuccess(message);
        } else {
            onRequestCallBack.onError(message);
        }
    }

    public static java.lang.String getAndroid(android.content.Context context) {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
    }

    public static com.dmlt.tracking.sdk.V2Tracking getInstance() {
        return com.dmlt.tracking.sdk.V2Tracking.SingletonHolder.SINGLETON;
    }

    public static void isAdReportOdds(final int i) {
        com.dmlt.tracking.util.HttpUtil.get((com.dmlt.tracking.config.ConstConfig.getUrl() + com.dmlt.tracking.config.ConstConfig.AD_REPORT_ODDS) + ("[REDACTED]" + getInstance().getAppKey() + "[REDACTED]" + getInstance().getChannel() + "[REDACTED]" + getInstance().getCid() + "[REDACTED]" + i), new com.dmlt.tracking.util.HttpUtil.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.V2Tracking.4
            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onError(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.e("onError: " + str);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("amount", i);
                    jSONObject.put(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, true);
                    jSONObject.put("message", "");
                    if (com.dmlt.tracking.sdk.V2Tracking.mDodAdReportCallback != null) {
                        com.dmlt.tracking.sdk.V2Tracking.mDodAdReportCallback.onReportSuccess(jSONObject.toString());
                    }
                } catch (java.lang.Exception unused) {
                }
            }

            @Override // com.dmlt.tracking.util.HttpUtil.OnRequestCallBack
            public void onSuccess(java.lang.String str) {
                com.dmlt.tracking.util.LogUtil.i("onSuccess: " + str);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    jSONObject.put("amount", i);
                    if (com.dmlt.tracking.sdk.V2Tracking.mDodAdReportCallback != null) {
                        com.dmlt.tracking.sdk.V2Tracking.mDodAdReportCallback.onReportSuccess(jSONObject.toString());
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        });
    }

    public static void setAdReportCallback(com.dmlt.tracking.sdk.DodAdReportCallback dodAdReportCallback) {
        mDodAdReportCallback = dodAdReportCallback;
    }

    public java.lang.String DMAdBaseParam(boolean z) {
        if (this.applicationContext == null || isEmpty(this.appKey)) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[REDACTED]");
        sb.append(this.appKey);
        sb.append("&selfchannel=");
        sb.append(this.channel);
        sb.append("&selfsubchannel=");
        sb.append(this.subchannel);
        sb.append("&selfaid=");
        sb.append(this.aid);
        sb.append("&selfcid=");
        sb.append(this.cid);
        sb.append("&uuid=");
        sb.append(this.uuid);
        sb.append("&idfa=");
        sb.append("");
        sb.append("&oaid=");
        sb.append(this.oaid);
        sb.append("&imei=");
        sb.append(getImei(getApplicationContext()));
        sb.append("&android=");
        sb.append(getAndroid(getApplicationContext()));
        sb.append("&mac=");
        sb.append(getMac(getApplicationContext()));
        sb.append("&os=android");
        sb.append("&phone_model=");
        sb.append(android.os.Build.MODEL);
        sb.append("&phone_carrier=");
        sb.append(android.os.Build.BRAND);
        sb.append("&phone_model_version=");
        sb.append(android.os.Build.VERSION.RELEASE);
        if (z) {
            try {
                return java.net.URLEncoder.encode(sb.toString(), com.unisound.b.f.b);
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public java.lang.String getAid() {
        return this.aid;
    }

    public java.lang.String getAppKey() {
        return this.appKey;
    }

    public android.content.Context getApplicationContext() {
        return this.applicationContext;
    }

    public java.lang.String getChannel() {
        return this.channel;
    }

    public java.lang.String getCid() {
        return this.cid;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public java.lang.String getImei(android.content.Context context) {
        java.lang.String deviceId = "";
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    deviceId = telephonyManager.getImei();
                } else {
                    deviceId = android.os.Build.VERSION.SDK_INT >= 23 ? telephonyManager.getDeviceId() : telephonyManager.getDeviceId();
                }
            }
        } catch (java.lang.Exception e) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "getImei: ", e);
        }
        return deviceId;
    }

    public java.lang.String getMac(android.content.Context context) {
        java.lang.String macAddress1 = getMacAddress1();
        if (!isEmpty(macAddress1)) {
            return macAddress1;
        }
        java.lang.String macAddress3 = getMacAddress3();
        return !isEmpty(macAddress3) ? macAddress3 : getMacAddress2();
    }

    public java.lang.String getMacAddress1() {
        byte[] hardwareAddress;
        java.lang.String str = null;
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    java.lang.String string = sb.toString();
                    if (networkInterfaceNextElement.getName().equals("wlan0")) {
                        str = string;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "getMacAddress1: ", e);
        }
        return str;
    }

    public java.lang.String getMacAddress2() {
        java.lang.String strTrim = "";
        java.lang.String line = "";
        try {
            java.io.LineNumberReader lineNumberReader = new java.io.LineNumberReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
            while (line != null) {
                line = lineNumberReader.readLine();
                if (line != null) {
                    strTrim = line.trim();
                    break;
                }
            }
            return !isEmpty(strTrim) ? strTrim : loadFileAsString("/sys/class/net/eth0/address").toUpperCase(java.util.Locale.getDefault()).substring(0, 17);
        } catch (java.lang.Exception e) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "getMacAddress2: ", e);
            return "";
        }
    }

    public java.lang.String getMacAddress3() {
        try {
            java.net.NetworkInterface byName = java.net.NetworkInterface.getByName("wlan0");
            if (byName == null) {
                return null;
            }
            return new java.lang.String(byName.getHardwareAddress());
        } catch (java.lang.Exception e) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "getMacAddress3: ", e);
            return null;
        }
    }

    public java.lang.String getOaid() {
        return this.oaid;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.dmlt.tracking.sdk.V2Tracking$3] */
    public void getRequest(java.lang.String str, java.lang.String str2, final com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack onRequestCallBack) {
        if (!str2.startsWith(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START)) {
            android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "requestUrl: ", new java.lang.Error("param is not '?' startWith"));
            return;
        }
        final java.lang.String str3 = new java.lang.String(getUrl() + str + str2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("requestUrl: ");
        sb.append(str3);
        android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, sb.toString());
        new java.lang.Thread() { // from class: com.dmlt.tracking.sdk.V2Tracking.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.dmlt.tracking.sdk.V2Tracking.this.doRequest(str3, onRequestCallBack);
            }
        }.start();
    }

    public java.lang.String getSubchannel() {
        return this.subchannel;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.lang.String getUuid() {
        return this.uuid;
    }

    public void init(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z) {
        setApplicationContext(context);
        setUrl(z ? com.dmlt.tracking.config.ConstConfig.DEBUG_URL : com.dmlt.tracking.config.ConstConfig.AD_URL);
        this.appKey = str;
        this.channel = str2;
        this.subchannel = str3;
        this.aid = str4;
        this.cid = str5;
        this.uuid = new com.dmlt.tracking.sdk.DeviceUuidFactory(getApplicationContext()).getDodUuid();
        new com.dmlt.tracking.sdk.MiitHelper(new com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater() { // from class: com.dmlt.tracking.sdk.V2Tracking.2
            @Override // com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater
            public void OnIdsAvalid(@androidx.annotation.NonNull java.lang.String str6) {
                android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, "ids=======>" + str6);
            }

            @Override // com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater
            public void OnIdsOAID(@androidx.annotation.NonNull java.lang.String str6) {
                com.dmlt.tracking.sdk.V2Tracking.this.setOaid(str6);
                com.dmlt.tracking.sdk.V2Tracking.this.getRequest(com.dmlt.tracking.config.ConstConfig.STARTUP_SERVICE, com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + com.dmlt.tracking.sdk.V2Tracking.this.DMAdBaseParam(false), new com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack() { // from class: com.dmlt.tracking.sdk.V2Tracking.2.1
                    @Override // com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack
                    public void onError(java.lang.String str7) {
                        android.util.Log.e(com.dmlt.tracking.config.ConstConfig.TAG, "startup onError: ", new java.lang.Error(str7));
                    }

                    @Override // com.dmlt.tracking.sdk.V2Tracking.OnRequestCallBack
                    public void onSuccess(java.lang.String str7) {
                        android.util.Log.i(com.dmlt.tracking.config.ConstConfig.TAG, "startup onSuccess: " + str7);
                    }
                });
            }
        }).getDeviceIds(getApplicationContext());
    }

    public boolean isEmpty(java.lang.Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof java.lang.String) && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && java.lang.reflect.Array.getLength(obj) == 0) {
            return true;
        }
        if ((obj instanceof java.util.Collection) && ((java.util.Collection) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof java.util.Map) && ((java.util.Map) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof android.util.SparseArray) && ((android.util.SparseArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof android.util.SparseBooleanArray) && ((android.util.SparseBooleanArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof android.util.SparseIntArray) && ((android.util.SparseIntArray) obj).size() == 0) {
            return true;
        }
        return android.os.Build.VERSION.SDK_INT >= 18 && (obj instanceof android.util.SparseLongArray) && ((android.util.SparseLongArray) obj).size() == 0;
    }

    public java.lang.String loadFileAsString(java.lang.String str) throws java.lang.Exception {
        java.io.FileReader fileReader = new java.io.FileReader(str);
        java.lang.String strLoadReaderAsString = loadReaderAsString(fileReader);
        fileReader.close();
        return strLoadReaderAsString;
    }

    public java.lang.String loadReaderAsString(java.io.Reader reader) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char[] cArr = new char[4096];
        while (true) {
            int i = reader.read(cArr);
            if (i < 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, i);
        }
    }

    public void setAid(java.lang.String str) {
        this.aid = str;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public void setApplicationContext(android.content.Context context) {
        this.applicationContext = context;
    }

    public void setChannel(java.lang.String str) {
        this.channel = str;
    }

    public void setCid(java.lang.String str) {
        this.cid = str;
    }

    public void setOaid(java.lang.String str) {
        this.oaid = str;
    }

    public void setSubchannel(java.lang.String str) {
        this.subchannel = str;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public void setUuid(java.lang.String str) {
        this.uuid = str;
    }

    public java.lang.String toString() {
        return "[REDACTED]" + this.appKey + "[REDACTED]" + this.channel + "[REDACTED]" + this.subchannel + "[REDACTED]" + this.aid + "[REDACTED]" + this.cid + "[REDACTED]" + this.uuid + "[REDACTED]" + this.oaid + "[REDACTED]";
    }
}
