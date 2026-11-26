package com.tencent.safecloud.device.openlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface SCInter {
    int checkAuthentDevice(android.content.Context context, java.lang.String str);

    void clearCache(android.content.Context context, com.tencent.safecloud.device.openlib.SCCallback sCCallback);

    int generatorToken(android.content.Context context, com.tencent.safecloud.device.openlib.SCCallback sCCallback);

    int generatorToken(android.content.Context context, com.tencent.safecloud.device.openlib.SCCallback sCCallback, long j);

    int getDeviceId(android.content.Context context, com.tencent.safecloud.device.openlib.IVendorCallback iVendorCallback);

    java.lang.String getIP();

    java.lang.String getSDKVersion();

    java.lang.String getToken();

    int requestDeviceId(android.content.Context context, java.lang.String str, com.tencent.safecloud.device.openlib.SCFPCallback sCFPCallback);

    void setDeviceUrl(java.lang.String str);

    void setDomains(android.content.Context context, java.lang.String... strArr);

    void setDomains(java.lang.String... strArr);

    void setServerUrl(java.lang.String str);

    void setTouchEvent(android.view.View view, android.view.MotionEvent motionEvent, android.content.Context context);

    void startSensorListen(android.content.Context context);

    int startWithAppId(android.content.Context context, java.lang.String str);
}
