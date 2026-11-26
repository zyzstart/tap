package com.tencent.ysdk.shell.module.cloud.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PullConfigResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_CONFIG_INFO = "sdk_conf";
    private static final java.lang.String PARAM_DEX_INFO = "dex_info";
    private static final java.lang.String PARAM_PATCH_INFO = "patch_info";
    private static final java.lang.String PARAM_RESULT = "data";
    private static final java.lang.String PARAM_TIME_STAMP = "time";
    private static final java.lang.String UNION_MONITOR = "union_monitor";
    public java.lang.String mPatchInfo = "";
    public java.lang.String mConfigInfo = "";
    public java.lang.String mLastTime = "";
    public java.lang.String mDexInfo = "";

    private void parsePullConfigResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            this.mLastTime = safeJSONObject.getString("time");
            if (!safeJSONObject.has("data")) {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, safeJSONObject.toString());
                return;
            }
            com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject2 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(safeJSONObject.getJSONObject("data"));
            this.mPatchInfo = safeJSONObject2.optString(PARAM_PATCH_INFO, "");
            this.mConfigInfo = safeJSONObject2.optString(PARAM_CONFIG_INFO, "");
            com.tencent.ysdk.shell.module.hades.HadesApi.checkEnv();
            if (safeJSONObject2.has(PARAM_DEX_INFO)) {
                this.mDexInfo = safeJSONObject2.optString(PARAM_DEX_INFO, "");
                com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject3 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(this.mDexInfo);
                java.lang.String strOptString = safeJSONObject3.optString("main", "");
                java.lang.String strOptString2 = safeJSONObject3.optString("md5", "");
                java.lang.String strOptString3 = safeJSONObject3.optString("url", "");
                if (android.text.TextUtils.isEmpty(strOptString) || android.text.TextUtils.isEmpty(strOptString2) || android.text.TextUtils.isEmpty(strOptString3)) {
                    return;
                }
                com.tencent.ysdk.shell.module.hades.HadesApi.getInstance(strOptString3, strOptString2, strOptString);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "error=" + e.getMessage());
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parsePullConfigResponseJson(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, safeJSONObject.toString());
        }
    }
}
