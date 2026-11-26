package com.tencent.ysdk.shell.module.user.impl.freelogin.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CloudGameFreeloginResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    public static final java.lang.String HTTP_RESP_PARAM_BODY_CODE = "ret";
    public static final java.lang.String HTTP_RESP_PARAM_BODY_ERR_MSG = "errmsg";
    public static final java.lang.String HTTP_RESP_PARAM_DATA = "data";
    public static final java.lang.String HTTP_RESP_PARAM_ERR_MSG = "errmsg";
    public static final java.lang.String HTTP_RESP_PARAM_RET = "code";
    public static final java.lang.String HTTP_RESP_PARAM_SUBCODE = "subcode";
    public java.lang.String dataErrMsg;
    public int dataRet;
    public org.json.JSONObject mDataJson;

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("parseJson:");
        sb.append(safeJSONObject != null ? safeJSONObject.toString() : "");
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.LOG_TAG, sb.toString());
        if (safeJSONObject != null) {
            try {
                this.ret = safeJSONObject.getInt("code");
                this.msg = safeJSONObject.optString("errmsg");
                this.mDataJson = safeJSONObject.getJSONObject(HTTP_RESP_PARAM_DATA);
                this.dataRet = this.mDataJson.getInt("ret");
                this.dataErrMsg = this.mDataJson.getString("errmsg");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        return "CloudGameFreeloginResponse{dataRet=" + this.dataRet + ", dataErrMsg='" + this.dataErrMsg + "', mDataJson=" + this.mDataJson + ", ret=" + this.ret + ", flag=" + this.flag + ", msg='" + this.msg + "'}";
    }
}
