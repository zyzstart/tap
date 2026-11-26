package com.tencent.mobileqq.openpay.data.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseApi {
    public java.lang.String appId;
    protected final java.lang.String sdkVersion = com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.VERSION_NAME;
    protected final java.lang.String appType = "native";
    protected java.lang.String appName = "native";

    public abstract boolean checkParams();

    public void fromBundle(android.os.Bundle bundle) {
        this.appId = bundle.getString("_mqqpay_baseapi_appid");
        this.appName = bundle.getString("_mqqpay_baseapi_appname");
    }

    public abstract int getApiMark();

    public abstract java.lang.String getApiName();

    public void toBundle(android.os.Bundle bundle) {
        bundle.putString("_mqqpay_baseapi_appid", this.appId);
        bundle.putString("_mqqpay_baseapi_appname", this.appName);
        bundle.putString("_mqqpay_baseapi_apptype", "native");
        bundle.putString("_mqqpay_baseapi_sdkversion", com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.VERSION_NAME);
        bundle.putString("_mqqpay_baseapi_apiname", getApiName());
        bundle.putInt("_mqqpay_baseapi_apimark", getApiMark());
    }
}
