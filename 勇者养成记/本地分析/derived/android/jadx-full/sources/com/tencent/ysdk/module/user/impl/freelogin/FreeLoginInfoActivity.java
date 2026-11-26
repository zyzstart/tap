package com.tencent.ysdk.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FreeLoginInfoActivity extends android.app.Activity {
    public static final int REQ_CODE_LOGIN_INFO = 0;
    public static final int RES_CODE_GET_LOGIN_INFO_FAILED = 200;
    public static final int RES_CODE_GET_LOGIN_INFO_SUCC = 100;

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        java.lang.StringBuilder sb;
        super.onCreate(bundle);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN", "FreeLoginInfoActivity>>>onCreate");
        android.content.Intent intent = getIntent();
        android.net.Uri data = intent.getData();
        try {
            com.tencent.ysdk.module.user.impl.freelogin.FreeLoginUserApi.getInstance().setLoginInfo(data.getQueryParameter(com.tencent.pipe.IPipeInterface.KEY_LOGIN_INFO));
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN", "login info:" + com.tencent.ysdk.module.user.impl.freelogin.FreeLoginUserApi.getInstance().getLoginInfo());
            if (com.tencent.ysdk.innerapi.DynamicInnerApi.isDebugVersion()) {
                setResult(100, intent);
            } else {
                setResult(100);
            }
            sb = new java.lang.StringBuilder();
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("wrong parse,data:");
            sb2.append(data != null ? data.toString() : "");
            sb2.append(",exception:");
            sb2.append(android.util.Log.getStackTraceString(e));
            com.tencent.ysdk.libware.file.Logger.w("YSDK_LOGIN", sb2.toString());
            setResult(200);
            sb = new java.lang.StringBuilder();
        } finally {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN", "parase data end, finish activity, cost=" + ((java.lang.System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0f) + "s");
            finish();
        }
        sb.append("parase data end, finish activity, cost=");
        sb.append((java.lang.System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0f);
        sb.append("s");
        java.lang.String string = sb.toString();
    }
}
