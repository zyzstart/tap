package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class HttpResponse {
    public static final java.lang.String HTTP_RESP_PARAM_CODE = "errcode";
    public static final java.lang.String HTTP_RESP_PARAM_MSG = "msg";
    public static final java.lang.String HTTP_RESP_PARAM_RET = "ret";
    public static final java.lang.String TAG = "YSDK_RSP";
    public int flag;
    public java.lang.String msg;
    public int ret;

    public HttpResponse() {
        this.ret = 1;
    }

    public HttpResponse(int i, int i2, java.lang.String str) {
        this.ret = 1;
        this.ret = i;
        this.flag = i2;
        this.msg = str;
    }

    public void parseBaseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            int i = safeJSONObject.getInt("ret");
            this.msg = safeJSONObject.getString("msg");
            if (i == 0) {
                this.ret = 0;
                if (safeJSONObject.has(HTTP_RESP_PARAM_CODE)) {
                    this.flag = safeJSONObject.getInt(HTTP_RESP_PARAM_CODE);
                    return;
                } else {
                    this.flag = 0;
                    return;
                }
            }
            this.ret = 1;
            if (safeJSONObject.has(HTTP_RESP_PARAM_CODE)) {
                this.flag = safeJSONObject.getInt(HTTP_RESP_PARAM_CODE);
            } else {
                this.flag = i;
            }
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "=======================================");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, getClass().getName());
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "YSDK Server Error,ret:" + i + ";flag:" + this.flag + ";msg:" + this.msg);
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "=======================================");
            if (-2 == i) {
                com.tencent.ysdk.shell.framework.verification.UserTips.showNoPermissionTips();
            }
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "Response JSONException : " + safeJSONObject.toString());
            this.ret = 1;
            this.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_RESP_PARSE_ERROR;
            this.msg = "Response JsonException:" + e.getMessage();
        }
    }

    public void parseFailureResponse(int i, java.lang.String str) {
        this.ret = 1;
        this.flag = i;
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        this.msg = str;
    }

    public abstract void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject);

    public void parseSuccessResponse(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        if (safeJSONObject != null) {
            parseJson(safeJSONObject);
            return;
        }
        this.ret = 1;
        this.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.HTTP_RESP_NULL;
        this.msg = "msg body is null, statusCode:" + i;
        com.tencent.ysdk.shell.libware.file.Logger.e(this.msg);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ret=" + this.ret);
        sb.append("&flag=" + this.flag);
        sb.append("&msg=" + this.msg);
        return sb.toString();
    }
}
