package com.tencent.mm.opensdk.openapi;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXAPIFactory {
    private static final java.lang.String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        throw new java.lang.RuntimeException(com.tencent.mm.opensdk.openapi.WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    }

    public static com.tencent.mm.opensdk.openapi.IWXAPI createWXAPI(android.content.Context context, java.lang.String str) {
        return createWXAPI(context, str, true);
    }

    public static com.tencent.mm.opensdk.openapi.IWXAPI createWXAPI(android.content.Context context, java.lang.String str, boolean z) {
        com.tencent.mm.opensdk.utils.Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        return new com.tencent.mm.opensdk.openapi.WXApiImplV10(context, str, z);
    }
}
