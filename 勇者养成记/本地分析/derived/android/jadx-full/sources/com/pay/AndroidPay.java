package com.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AndroidPay {
    public static final int LANDSCAPE = 0;
    public static final int PORTRAINT = 1;
    private static volatile com.pay.AndroidPay gInstance;
    public android.app.Activity fromActivity;
    public java.lang.String offerId;
    public com.pay.api.APPayResponseInfo payResponseInfo;
    public byte[] resdata;
    public android.content.Context applicationContext = null;
    public java.lang.String unit = "";
    public boolean isShowNum = true;
    public boolean isShowListOtherNum = true;

    private AndroidPay() {
        this.payResponseInfo = null;
        this.payResponseInfo = new com.pay.api.APPayResponseInfo();
    }

    public static void Destory() {
    }

    public static java.lang.String getPaySDKVersion(android.app.Activity activity) {
        return com.tencent.midas.api.APMidasPayAPI.getMidasSDKVersion(activity);
    }

    public static void setCustomUrlParam(java.lang.String str) {
    }

    public static void setElseNumberVisible(boolean z) {
        gInstance.isShowListOtherNum = z;
    }

    public static void setEnv(java.lang.String str) {
        com.tencent.midas.api.APMidasPayAPI.setEnv(str);
    }

    public static void setIsShowSaveNum(boolean z) {
        gInstance.isShowNum = z;
    }

    public static void setLogEnable(boolean z) {
        com.tencent.midas.api.APMidasPayAPI.setLogEnable(z);
    }

    public static void setNumberVisible(boolean z) {
        setIsShowSaveNum(z);
    }

    public static void setOfferId(java.lang.String str) {
        gInstance.offerId = str;
    }

    public static void setPropUnit(java.lang.String str) {
        gInstance.unit = str;
    }

    public static void setResData(byte[] bArr) {
        gInstance.resdata = bArr;
    }

    public static void setScreenType(int i) {
    }

    public static void setWechatAppId(java.lang.String str) {
    }

    public static com.pay.AndroidPay singleton() {
        if (gInstance == null) {
            synchronized (com.pay.AndroidPay.class) {
                if (gInstance == null) {
                    gInstance = new com.pay.AndroidPay();
                }
            }
        }
        return gInstance;
    }

    public android.content.Context getContext() {
        return this.applicationContext;
    }
}
