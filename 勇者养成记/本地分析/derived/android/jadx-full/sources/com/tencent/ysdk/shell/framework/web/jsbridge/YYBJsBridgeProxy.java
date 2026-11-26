package com.tencent.ysdk.shell.framework.web.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YYBJsBridgeProxy extends com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy {
    private static final java.lang.String TAG = "YSDKJsBridgeProxy";
    public static final java.lang.String VERSION_NAME = "1.1.0";
    private com.tencent.ysdk.shell.module.share.ShareApiImpl shareApiImpl;
    private com.tencent.ysdk.shell.module.share.impl.ShareManagerBBS shareManagerBBS;

    private static class QueryController {
        public static final java.lang.String QUERY_FIELDS = "queryfields";
        public static final java.lang.String QUERY_FIELDS_SPLIT = "\\|";
        public static final int QUERY_TYPE_ALL = 0;
        public static final int QUERY_TYPE_PART = 1;
        public java.lang.String[] queryFields;
        public int queryType;

        public QueryController(android.net.Uri uri) {
            this.queryType = 0;
            if (uri != null) {
                java.lang.String queryParameter = uri.getQueryParameter(QUERY_FIELDS);
                if (queryParameter != null) {
                    this.queryFields = queryParameter.split(QUERY_FIELDS_SPLIT);
                }
                java.lang.String[] strArr = this.queryFields;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                this.queryType = 1;
            }
        }

        public boolean canQuery(java.lang.String str) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
                return false;
            }
            if (this.queryType == 0) {
                return true;
            }
            if (this.queryFields != null) {
                int i = 0;
                while (true) {
                    java.lang.String[] strArr = this.queryFields;
                    if (i >= strArr.length) {
                        break;
                    }
                    if (str.equalsIgnoreCase(strArr[i])) {
                        return true;
                    }
                    i++;
                }
            }
            return false;
        }
    }

    public YYBJsBridgeProxy(com.tencent.smtt.sdk.WebView webView, android.content.Context context) {
        super(webView, context);
    }

    public YYBJsBridgeProxy(com.tencent.smtt.sdk.WebView webView, android.content.Context context, int i) {
        super(webView, context, i);
    }

    public void checkAppInstalled(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String queryParameter = uri.getQueryParameter("packageName");
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                this.mJsBridge.responseFail(str2, i, str, -1);
            }
            android.content.pm.PackageInfo packageInfoCheckAppInstalled = com.tencent.ysdk.shell.libware.apk.APKListUtils.checkAppInstalled(this.mContext, queryParameter);
            if (packageInfoCheckAppInstalled != null) {
                jSONObject.put("installed", true);
                jSONObject.put("packageName", packageInfoCheckAppInstalled.packageName);
                jSONObject.put("versionName", packageInfoCheckAppInstalled.versionName);
                jSONObject.put("versionCode", packageInfoCheckAppInstalled.versionCode);
            } else {
                jSONObject.put("installed", false);
            }
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(e.getMessage());
        }
        this.mJsBridge.response(str2, i, str, jSONObject.toString());
    }

    public void getMobileInfo(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.QueryController queryController = new com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.QueryController(uri);
        try {
            if (queryController.canQuery("osVer")) {
                jSONObject.put("osVer", android.os.Build.VERSION.SDK_INT);
            }
            if (queryController.canQuery("resolution")) {
                jSONObject.put("resolution", com.tencent.ysdk.shell.libware.device.DeviceUtils.getResolution(this.mContext));
            }
            if (queryController.canQuery("network")) {
                jSONObject.put("network", com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeHelper.getNetInfo(this.mContext));
            }
            if (queryController.canQuery("extSDAvailable")) {
                jSONObject.put("extSDAvailable", com.tencent.ysdk.shell.libware.file.ExternalStorage.isAvailable() ? 1 : 0);
            }
            this.mJsBridge.response(str2, i, str, jSONObject.toString());
        } catch (java.lang.Exception unused) {
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void getPrivateMobileInfo(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        android.util.Log.d("imei", "调用了getPrivateMobileInfo==========");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("androidId", com.tencent.ysdk.shell.libware.device.DeviceUtils.getAndroidIdInPhone(this.mContext));
            jSONObject2.put("androidIdSdCard", com.tencent.ysdk.shell.libware.device.DeviceUtils.getAndroidIdInSdCard(this.mContext));
            jSONObject2.put("imei", com.tencent.ysdk.shell.libware.device.DeviceUtils.getImei(this.mContext));
            jSONObject2.put("imsi", com.tencent.ysdk.shell.libware.device.DeviceUtils.getImsi(this.mContext));
            jSONObject2.put("macAdress", com.tencent.ysdk.shell.libware.device.DeviceUtils.getLocalMacAddress(this.mContext));
            jSONObject.put("terminal", jSONObject2);
            jSONObject.put("groupNetType", com.tencent.ysdk.shell.libware.device.APNUtil.getGroupNetType(this.mContext));
            jSONObject.put(com.tencent.ysdk.shell.framework.channel.ApkChannelTool.CHANNEL_ID, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            jSONObject.put("realChannelId", com.tencent.ysdk.shell.module.user.UserApi.getInstance().getRegisterChannelId());
            jSONObject.put("versionName", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionName());
            jSONObject.put("versionCode", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameVersionCode());
            jSONObject.put("mark", android.os.Build.MANUFACTURER + "_" + android.os.Build.MODEL);
            jSONObject.put("qimei", com.tencent.beacon.event.UserAction.getQIMEI());
            jSONObject.put("qimei36", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36());
            com.tencent.ysdk.shell.libware.device.NetInfo netInfo = com.tencent.ysdk.shell.libware.device.APNUtil.getNetInfo(this.mContext);
            if (netInfo.apn == com.tencent.ysdk.shell.libware.device.APN.UN_DETECT) {
                com.tencent.ysdk.shell.libware.device.APNUtil.refreshNetwork(this.mContext);
            }
            jSONObject.put("wifiBssid", netInfo.bssid);
            this.mJsBridge.response(str2, i, str, jSONObject.toString());
        } catch (java.lang.Exception unused) {
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void getSharePicBase64(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        android.util.Log.d("jsb", "getSharePicBase64");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (this.shareManagerBBS != null) {
                java.io.File file = this.shareManagerBBS.getmFile();
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bArr = new byte[(int) file.length()];
                int i2 = fileInputStream.read(bArr);
                fileInputStream.close();
                jSONObject.put("imageFile", android.util.Base64.encodeToString(bArr, 0, i2, 0));
                jSONObject.put("title", this.shareManagerBBS.getTitle());
                jSONObject.put("des", this.shareManagerBBS.getDescription());
            }
            this.mJsBridge.response(str2, i, str, jSONObject.toString());
        } catch (java.lang.Exception unused) {
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void getdeviceInfo(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, new org.json.JSONObject(com.tencent.ysdk.shell.module.stat.StatCommonParam.normalParam(new java.util.HashMap())).toString());
    }

    public void notifyLaunchGift(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        android.util.Log.d("jsb", "notifyLaunchGift");
        try {
            com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftDataEntity launchGiftDataEntity = new com.tencent.ysdk.shell.module.launchgift.impl.LaunchGiftDataEntity();
            launchGiftDataEntity.conf = uri.getQueryParameter("conf");
            launchGiftDataEntity.sig = uri.getQueryParameter(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG);
            launchGiftDataEntity.ts = java.lang.Long.parseLong(uri.getQueryParameter("ts"));
            com.tencent.ysdk.shell.module.launchgift.LaunchGiftInnerApi.notifyLaunchGift(launchGiftDataEntity);
            this.mJsBridge.response(str2, i, str, "");
        } catch (java.lang.Exception unused) {
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void regShareManagerBBS(com.tencent.ysdk.shell.module.share.impl.ShareManagerBBS shareManagerBBS) {
        this.shareManagerBBS = shareManagerBBS;
    }

    public void reportH5BeaconData(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        java.lang.String queryParameter = uri.getQueryParameter("retFlag");
        java.lang.String queryParameter2 = uri.getQueryParameter("eventStartTime");
        java.lang.String queryParameter3 = uri.getQueryParameter("isRealTime");
        int i2 = !android.text.TextUtils.isEmpty(queryParameter) ? java.lang.Integer.parseInt(queryParameter) : 0;
        boolean z = !android.text.TextUtils.isEmpty(queryParameter3) ? java.lang.Boolean.parseBoolean(queryParameter3) : false;
        long j = !android.text.TextUtils.isEmpty(queryParameter2) ? java.lang.Long.parseLong(queryParameter2) : java.lang.System.currentTimeMillis();
        java.lang.String queryParameter4 = uri.getQueryParameter("eventParams");
        java.util.HashMap map = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(queryParameter4)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(queryParameter4);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    if (!android.text.TextUtils.isEmpty(next)) {
                        map.put(next, jSONObject.getString(next));
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(uri.getQueryParameter("eventName"), i2, uri.getQueryParameter("retDetail"), map, j, z);
        this.mJsBridge.response(str2, i, str, "report success");
    }

    public void requestAutoLogin(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestAutoLogin(this.mJsBridge, uri, i, str, str2);
    }

    public void requestBuyItem(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestBuyItem(this.mJsBridge, uri, i, str, str2);
    }

    public void requestBuyItemURL(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestBuyItemURL(this.mJsBridge, uri, i, str, str2);
    }

    public void requestCharge(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestCharge(this.mJsBridge, uri, i, str, str2);
    }

    public void requestLogout(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestLogout(this.mJsBridge, uri, i, str, str2);
    }

    public void requestQQLogin(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestQQLogin(this.mJsBridge, uri, i, str, str2);
    }

    public void requestUserInfo(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestUserInfo(this.mJsBridge, uri, i, str, str2);
    }

    public void requestVersion(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, com.tencent.ysdk.api.YSDKApi.getVersion());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        this.mJsBridge.response(str2, i, str, jSONObject.toString());
    }

    public void requestWXLogin(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.h5game.H5GameJSSDKManager.getInstance().requestWXLogin(this.mJsBridge, uri, i, str, str2);
    }

    public void shareCallBack(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        android.util.Log.d("jsb", "shareCallBack");
        try {
            if (this.shareManagerBBS != null) {
                if ("SUCCESS".equals(uri.getQueryParameter("result"))) {
                    this.shareManagerBBS.getShareCallBack().onSuccess();
                } else if ("CANCEL".equals(uri.getQueryParameter("result"))) {
                    this.shareManagerBBS.getShareCallBack().onCancel();
                } else {
                    this.shareManagerBBS.getShareCallBack().onFail(uri.getQueryParameter("code"), uri.getQueryParameter("msg"));
                }
            }
            this.mJsBridge.response(str2, i, str, "");
        } catch (java.lang.Exception unused) {
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void shareURLToQQFriend(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.getInstance().shareURLToQQFriend(this.mJsBridge, uri, i, str, str2);
    }

    public void shareURLToQZone(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.getInstance().shareURLToQZone(this.mJsBridge, uri, i, str, str2);
    }

    public void shareURLToWXFriend(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.getInstance().shareURLToWXFriend(this.mJsBridge, uri, i, str, str2);
    }

    public void shareURLToWXTimeline(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.getInstance().shareURLToWXTimeline(this.mJsBridge, uri, i, str, str2);
    }

    public void showPics(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d(uri.toString());
        final int i2 = java.lang.Integer.parseInt(uri.getQueryParameter(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_EVENT_PARAM_POSITION));
        java.lang.String queryParameter = uri.getQueryParameter("urls");
        final java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(queryParameter);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(e.toString());
        }
        if (i2 < 0 || i2 > arrayList.size()) {
            i2 = 0;
        }
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity()).showPic(arrayList, i2);
                }
            });
        } else {
            com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity()).showPic(arrayList, i2);
        }
    }
}
